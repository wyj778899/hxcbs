package chinaPress.common.upload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

@RestController
public class UploadController {
	private String PATH_LINE = "/";

	/**
	 * 上传图片
	 *
	 * @param request
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "upload")
	public Result uploadPicture(HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile multipartFile) {
		String savePath = "";
		// 判断windows或是linux
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		if (os != null && os.toLowerCase().indexOf("linux") > -1) {
			savePath = "/data/";
		} else if (os != null && os.toLowerCase().indexOf("windows") > -1) {
			savePath = "c:/ecloud_file/";
		}
		// 文件路径
		String saveUrl = PATH_LINE + "uploaded" + PATH_LINE;

		if (!ServletFileUpload.isMultipartContent(request)) {
			return ResultUtil.custom(-1, "请选择文件");
		}
		// 检查目录
		File uploadDir = new File(savePath);
		if (!uploadDir.isDirectory()) {
			uploadDir.mkdirs();
//			return ResultUtil.custom(-2, "上传目录不存在");
		}
		// 检查目录写权限
		if (!uploadDir.canWrite()) {
			return ResultUtil.custom(-3, "上传目录没有写权限");
		}
		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
		// 定义允许上传的文件扩展名
		Map<String, String> extMap = new HashMap<String, String>();
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,mp4,3gp,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,pptx,htm,html,xml,txt,zip,rar,gz,bz2");
		if (!extMap.containsKey(dirName)) {
			return ResultUtil.custom(-3, "目录名不正确");
		}
		// 创建文件夹
		savePath = savePath + dirName + PATH_LINE;
		saveUrl += dirName + PATH_LINE;
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += ymd + PATH_LINE;
		saveUrl += ymd + PATH_LINE;
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		// 最大文件大小
//		long maxSize = 5242880;
		String fileName = multipartFile.getOriginalFilename();

		// 检查文件大小
//		if (multipartFile.getSize() > maxSize * 2) {
//			return ResultUtil.custom(-5, "上传文件大小不得超过5MB");
//		}
		// 检查扩展名
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)) {
			return ResultUtil.custom(-6, "上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式");
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
		try {
			File uploadedFile = new File(savePath, newFileName);
			// 写入文件
			FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), uploadedFile);
			Map<String, String> data = new HashMap<String, String>();
			data.put("src", saveUrl + newFileName);
			data.put("title", fileName);
			return ResultUtil.custom(1, "上传文件成功", data);
		} catch (Exception e) {
			return ResultUtil.custom(0, "上传文件失败");
		}
	}

	/**
	 * 文件上传
	 *
	 * @param request
	 * @param response
	 * @param imgFile
	 * @throws FileUploadException
	 * @throws IOException 
	 */
	@RequestMapping("kindeditor/upload")
	public void uploadFile(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "file") MultipartFile[] file)
			throws FileUploadException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			// 文件保存本地目录路径
			String savePath = "";
			// 判断windows或是linux
			Properties prop = System.getProperties();
			String os = prop.getProperty("os.name");
			if (os != null && os.toLowerCase().indexOf("linux") > -1) {
				savePath = "/data/";
			} else if (os != null && os.toLowerCase().indexOf("windows") > -1) {
				savePath = "c:/ecloud_file/";
			}

			// 文件保存目录URL
			// 文件路径
			String saveUrl = PATH_LINE + "upload" + PATH_LINE;

			if (!ServletFileUpload.isMultipartContent(request)) {
				out.print(getError("请选择文件。"));
				out.close();
				return;
			}
			// 检查目录
			File uploadDir = new File(savePath);
			if (!uploadDir.isDirectory()) {
				out.print(getError("上传目录不存在。"));
				out.close();
				return;
			}
			// 检查目录写权限
			if (!uploadDir.canWrite()) {
				out.print(getError("上传目录没有写权限。"));
				out.close();
				return;
			}

			String dirName = request.getParameter("dir");
			if (dirName == null) {
				dirName = "image";
			}

			// 定义允许上传的文件扩展名
			Map<String, String> extMap = new HashMap<String, String>();
			extMap.put("image", "gif,jpg,jpeg,png,bmp");
			extMap.put("flash", "swf,flv");
			extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
			extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,xml,txt,zip,rar,gz,bz2");

			if (!extMap.containsKey(dirName)) {
				out.print(getError("目录名不正确。"));
				out.close();
				return;
			}
			// 创建文件夹
			savePath += dirName + PATH_LINE;
			saveUrl += dirName + PATH_LINE;
			File saveDirFile = new File(savePath);
			if (!saveDirFile.exists()) {
				saveDirFile.mkdirs();
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String ymd = sdf.format(new Date());
			savePath += ymd + PATH_LINE;
			saveUrl += ymd + PATH_LINE;
			File dirFile = new File(savePath);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}

			// 最大文件大小
//			long maxSize = 1000000;

			// 保存文件
			for (MultipartFile iFile : file) {
				String fileName = iFile.getOriginalFilename();

//				// 检查文件大小
//				if (iFile.getSize() > maxSize) {
//					out.print(getError("上传文件大小超过限制。"));
//					out.close();
//					return;
//				}
				// 检查扩展名
				String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
				if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)) {
					// return getError("上传文件扩展名是不允许的扩展名。\n只允许" +
					// extMap.get(dirName) + "格式。");
					out.print(getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。"));
					out.close();
					return;
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
				try {
					File uploadedFile = new File(savePath, newFileName);

					// 写入文件
					FileUtils.copyInputStreamToFile(iFile.getInputStream(), uploadedFile);
				} catch (Exception e) {
					out.print(getError("上传文件失败。"));
					out.close();
					return;
				}
				out.print(getSuccess(saveUrl + newFileName));
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(getError("上传文件失败。"));
			out.close();
		}
	}

	/**
	 * 文件空间
	 *
	 * @param request  {@link HttpServletRequest}
	 * @param response {@link HttpServletResponse}
	 * @return json
	 */
	@RequestMapping(value = "fileManager", method = RequestMethod.GET)
	public void fileManager(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 文件保存本地目录路径
			String rootPath = "";
			// 判断windows或是linux
			Properties prop = System.getProperties();
			String os = prop.getProperty("os.name");
			if (os != null && os.toLowerCase().indexOf("linux") > -1) {
				rootPath = "/home/ecloud_file/";
			} else if (os != null && os.toLowerCase().indexOf("windows") > -1) {
				rootPath = "c:/ecloud_file/";
			}
			// 文件保存目录URL
			String rootUrl = PATH_LINE + "uploaded" + PATH_LINE;

			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();

			// 图片扩展名
			String[] fileTypes = new String[] { "gif", "jpg", "jpeg", "png", "bmp" };

			String dirName = request.getParameter("dir");
			if (dirName != null) {
				if (!Arrays.<String>asList(new String[] { "image", "flash", "media", "file" }).contains(dirName)) {
					out.print("无效的文件夹。");
					out.close();
					return;
				}
				rootPath += dirName + PATH_LINE;
				rootUrl += dirName + PATH_LINE;
				File saveDirFile = new File(rootPath);
				if (!saveDirFile.exists()) {
					saveDirFile.mkdirs();
				}
			}
			// 根据path参数，设置各路径和URL
			String path = request.getParameter("path") != null ? request.getParameter("path") : "";
			String currentPath = rootPath + path;
			String currentUrl = rootUrl + path;
			String currentDirPath = path;
			String moveupDirPath = "";
			if (!"".equals(path)) {
				String str = currentDirPath.substring(0, currentDirPath.length() - 1);
				moveupDirPath = str.lastIndexOf(PATH_LINE) >= 0 ? str.substring(0, str.lastIndexOf(PATH_LINE) + 1) : "";
			}

			// 排序形式，name or size or type
			String order = request.getParameter("order") != null ? request.getParameter("order").toLowerCase() : "name";

			// 不允许使用..移动到上一级目录
			if (path.indexOf("..") >= 0) {
				out.print("访问权限拒绝。");
				out.close();
				return;
			}
			// 最后一个字符不是/
			if (!"".equals(path) && !path.endsWith(PATH_LINE)) {
				out.print("无效的访问参数验证。");
				out.close();
				return;
			}
			// 目录不存在或不是目录
			File currentPathFile = new File(currentPath);
			if (!currentPathFile.isDirectory()) {
				out.print("文件夹不存在。");
				out.close();
				return;
			}

			// 遍历目录取的文件信息
			List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();
			if (currentPathFile.listFiles() != null) {
				for (File file : currentPathFile.listFiles()) {
					Hashtable<String, Object> hash = new Hashtable<String, Object>();
					String fileName = file.getName();
					if (file.isDirectory()) {
						hash.put("is_dir", true);
						hash.put("has_file", (file.listFiles() != null));
						hash.put("filesize", 0L);
						hash.put("is_photo", false);
						hash.put("filetype", "");
					} else if (file.isFile()) {
						String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
						hash.put("is_dir", false);
						hash.put("has_file", false);
						hash.put("filesize", file.length());
						hash.put("is_photo", Arrays.<String>asList(fileTypes).contains(fileExt));
						hash.put("filetype", fileExt);
					}
					hash.put("filename", fileName);
					hash.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
					fileList.add(hash);
				}
			}

			if ("size".equals(order)) {
				Collections.sort(fileList, new SizeComparator());
			} else if ("type".equals(order)) {
				Collections.sort(fileList, new TypeComparator());
			} else {
				Collections.sort(fileList, new NameComparator());
			}

			JSONObject result = new JSONObject();
			result.put("moveup_dir_path", moveupDirPath);
			result.put("current_dir_path", currentDirPath);
			result.put("current_url", currentUrl);
			result.put("total_count", fileList.size());
			result.put("file_list", fileList);

			out.println(result.toString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class NameComparator implements Comparator<Map<String, Object>> {
		@Override
		public int compare(Map<String, Object> hashA, Map<String, Object> hashB) {
			if (((Boolean) hashA.get("is_dir")) && !((Boolean) hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean) hashA.get("is_dir")) && ((Boolean) hashB.get("is_dir"))) {
				return 1;
			} else {
				return ((String) hashA.get("filename")).compareTo((String) hashB.get("filename"));
			}
		}
	}

	private class SizeComparator implements Comparator<Map<String, Object>> {
		@Override
		public int compare(Map<String, Object> hashA, Map<String, Object> hashB) {
			if (((Boolean) hashA.get("is_dir")) && !((Boolean) hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean) hashA.get("is_dir")) && ((Boolean) hashB.get("is_dir"))) {
				return 1;
			} else {
				if (((Long) hashA.get("filesize")) > ((Long) hashB.get("filesize"))) {
					return 1;
				} else if (((Long) hashA.get("filesize")) < ((Long) hashB.get("filesize"))) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}

	private class TypeComparator implements Comparator<Map<String, Object>> {
		@Override
		public int compare(Map<String, Object> hashA, Map<String, Object> hashB) {
			if (((Boolean) hashA.get("is_dir")) && !((Boolean) hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean) hashA.get("is_dir")) && ((Boolean) hashB.get("is_dir"))) {
				return 1;
			} else {
				return ((String) hashA.get("filetype")).compareTo((String) hashB.get("filetype"));
			}
		}
	}

	private String getSuccess(String url) {
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put("url", url);
		return obj.toString();
	}

	private String getError(String message) throws UnsupportedEncodingException {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toString();
	}

	/**
	 * 删除单个文件
	 *
	 * @param fileName 要删除的文件的文件名
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	@RequestMapping(value = "deleteFile", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteFile(HttpServletRequest request, String fileName) {
		Map<String, Object> map = new HashMap<>();
		String path = request.getSession().getServletContext().getRealPath(fileName); // 文件存储位置
		System.out.println(path);
		File file = new File(path);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				map.put("code", 1);
				map.put("message", "删除成功");
			} else {
				map.put("code", -1);
				map.put("message", "删除失败");
			}
		} else {
			map.put("code", -2);
			map.put("message", "该文件不存在");
		}
		return map;
	}

	/**
	 * 根据文件路径下载文件
	 * 
	 * @param request
	 * @param response
	 * @param file_url
	 * @param fileName
	 * @throws IOException
	 */
	@RequestMapping("downloadFile")
	@ResponseBody
	public void downloadFile(HttpServletRequest req, HttpServletResponse res, String fileUrl, String fileName)
			throws IOException {
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		String realPath = "";
		if (os != null && os.toLowerCase().indexOf("linux") > -1) {
			realPath = "/home/ecloud_file";
		} else if (os != null && os.toLowerCase().indexOf("windows") > -1) {
			realPath = "c:/ecloud_file";
		}

		/**
		 * 1. 接受前端页面发送过来的文件名字 获取到前端页面发送过来的要下载的文件的名字
		 */
		/**
		 * 2. 获取到ServletContext域对象 后面将调用此对象的一系列方法，用于获取文件路径、文件MimeType、文件输出类型
		 */
		ServletContext servletContext = req.getServletContext();
		/**
		 * 3. 获取指定文件在web项目中的路径
		 * 通过获取到ServletContext域对象的getRealPath()方法，读取download目录下文件的绝对路径
		 * download目录必须放在webContent目录下面，否则可能会找不到，导致报异常，
		 * 在读取资源的时候，项目demo会直接去查找webContent下面的文件和文件夹
		 */
		String filePath = realPath + fileUrl.substring(7);
		/**
		 * 4. 获取到文件MimeType 通过获取到的ServletContext域对象的getMimeType()方法，获取到文件MimeType MIME
		 * (Multipurpose Internet Mail Extensions) 是描述消息内容类型的因特网标准。 MIME 协议指示 MIME
		 * 用户代理如何显示附加的文件。 MIME 参考手册：http://www.w3school.com.cn/media/media_mimeref.asp
		 */
		String mimeType = servletContext.getMimeType(fileName);
		/**
		 * 5. 设置文件的输出类型 Response域对象的setContentType()方法，设置文件的输出类型
		 */
		res.setContentType(mimeType);
		/**
		 * 6. 设置响应头，确定文件是内嵌或弹出下载框 通过 Response 域对象的
		 * setHeader("Content-Disposition","attachment;filename="+filename) 方法设置响应头，
		 * Content-Disposition(内容处置/处理) : 是 MIME 协议的扩展，Content-Disposition
		 * 可以控制用户请求所得的内容存为一个文件的时候提供一个默认的文件名， inline 和 attachment ：
		 * 文件直接在浏览器上显示或者在访问时弹出文件下载对话框。 inline
		 * 表示：内嵌显示，文本和图片都可以解析，但对于文件或者视频会自动去调用成attachment，因此可以直接使用inline attachment：弹出下载框
		 * URLEncoder 对象，将在响应回去的头，里面所代码filename的编码格式，转换为与客户端的一致的编码格式
		 * URLEncoder.encode(filenameValue,"utf-8");
		 * 将Response响应到浏览器客户端为filenameValue的文件名，转变为utf-8的编码格式
		 */
		res.setHeader("Content-Disposition",
				"attachment;filename=" + URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "%20"));
		/**
		 * 7. 输出文件(下载文件) 7.1 通过 new，创建字节输入流 FileInputStream，读取文件 7.2
		 * 通过Response域，创建Servlet的输出流，输出文件
		 */
		FileInputStream fileInputStream = new FileInputStream(filePath);
		ServletOutputStream outputStream = res.getOutputStream();
		int b = 0;
		byte[] by = new byte[1024 * 8];
		while ((b = fileInputStream.read(by)) != -1) {
			outputStream.write(by, 0, b);
		}
		outputStream.flush();
		fileInputStream.close();
		// 关流，response获得流会自动关闭，因此也可以不用手动关
		outputStream.close();
	}

	/**
	 * base64转图片
	 * 
	 * @param imgData     base64图片编码
	 * @param imgFilePath 存放路径
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "uplodImgBase64")
	public Result uplodImgBase64(HttpServletRequest request,
			@RequestParam(value = "imageBase64", required = false) String imageBase64) throws IOException { // 对字节数组字符串进行Base64解码并生成图片
		String savePath = "";
		// 判断windows或是linux
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		if (os != null && os.toLowerCase().indexOf("linux") > -1) {
			savePath = "/home/ecloud_file/";
		} else if (os != null && os.toLowerCase().indexOf("windows") > -1) {
			savePath = "c:/ecloud_file/";
		}
		// 文件路径
		String saveUrl = PATH_LINE + "uploaded" + PATH_LINE;

		if (!ServletFileUpload.isMultipartContent(request)) {
			return ResultUtil.custom(-1, "请选择文件");
		}
		// 检查目录
		File uploadDir = new File(savePath);
		if (!uploadDir.isDirectory()) {
			uploadDir.mkdirs();
//			return ResultUtil.custom(-2, "上传目录不存在");
		}
		// 检查目录写权限
		if (!uploadDir.canWrite()) {
			return ResultUtil.custom(-3, "上传目录没有写权限");
		}
		String dirName = request.getParameter("dir");
		if (dirName == null) {
			dirName = "image";
		}
//		// 定义允许上传的文件扩展名
//		Map<String, String> extMap = new HashMap<String, String>();
//		extMap.put("image", "gif,jpg,jpeg,png,bmp");
//		extMap.put("flash", "swf,flv");
//		extMap.put("media", "swf,flv,mp3,mp4,3gp,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
//		extMap.put("file", "doc,docx,xls,xlsx,ppt,pptx,htm,html,xml,txt,zip,rar,gz,bz2");
//		if (!extMap.containsKey(dirName)) {
//			return ResultUtil.custom(-3, "目录名不正确");
//		}
		// 创建文件夹
		savePath = savePath + dirName + PATH_LINE;
		saveUrl += dirName + PATH_LINE;
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += ymd + PATH_LINE;
		saveUrl += ymd + PATH_LINE;
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
//		// 获取图片大小
//		long maxSize = 5242880;
//		//1.找到等号，把等号也去掉(=用来填充base64字符串长度用)
//		Integer equalIndex= imageBase64.indexOf("=");
//		if(imageBase64.indexOf("=")>0) {
//			imageBase64=imageBase64.substring(0, equalIndex);
//		}
//		//2.原来的字符流大小，单位为字节
//		Integer strLength=imageBase64.length();
//		//3.计算后得到的文件流大小，单位为字节
//		Integer size=strLength-(strLength/8)*2;
//		// 最大文件大小
//
//		// 检查文件大小
//		if (size > maxSize * 2) {
//			return ResultUtil.custom(-5, "上传文件大小不得超过5MB");
//		}
//		// 检查扩展名
//		if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(imageExt)) {
//			return ResultUtil.custom(-6, "上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式");
//		}

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + ".jpg";
		// 写入
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			OutputStream out = new FileOutputStream(savePath + newFileName);
			// Base64解码
			byte[] b = decoder.decodeBuffer(imageBase64);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			out.write(b);
			out.flush();
			out.close();
			Map<String, String> data = new HashMap<String, String>();
			data.put("src", saveUrl + newFileName);
			return ResultUtil.custom(1, "上传文件成功", data);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.custom(0, "上传文件失败");
		}
	}

	private static String FILENAME = "";

	@Value("${xdja.upload.file.path}")
	private String decryptFilePath;

	@Value("${xdja.upload.file.path.temp}")
	private String decryptFilePathTemp;

	/**
	 * 上传文件
	 *
	 * @param param
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	@PostMapping(value = "/fileUpload")
	public Result fileUpload(HttpServletRequest request,
			@RequestParam(value = "file", required = false) MultipartFile file, Integer chunks, Integer chunk,
			String name, String guid) throws IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			if (file == null) {
				ResultUtil.error();
			}
			System.out.println("guid:" + guid);
			if (chunks == null && chunk == null) {
				chunk = 0;
			}
			File outFile = new File(decryptFilePathTemp + File.separator + guid, chunk + ".part");
			if ("".equals(FILENAME)) {
				FILENAME = name;
			}
			InputStream inputStream = file.getInputStream();
			FileUtils.copyInputStreamToFile(inputStream, outFile);
		}
		return ResultUtil.ok();
	}

	/**
	 * 合并所有分片
	 *
	 * @throws Exception Exception
	 */
	@GetMapping("/merge")
	public void byteMergeAll(String guid) throws Exception {
		System.out.println("merge:" + guid);
		File file = new File(decryptFilePathTemp + File.separator + guid);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files != null && files.length > 0) {
				File partFile = new File(decryptFilePath + File.separator + FILENAME);
				for (int i = 0; i < files.length; i++) {
					File s = new File(decryptFilePathTemp + File.separator + guid, i + ".part");
					FileOutputStream destTempfos = new FileOutputStream(partFile, true);
					FileUtils.copyFile(s, destTempfos);
					destTempfos.close();
				}
				FileUtils.deleteDirectory(file);
				FILENAME = "";
			}
		}
	}
}

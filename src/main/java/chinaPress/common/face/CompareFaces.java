package chinaPress.common.face;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.cloudauth.model.v20190307.CompareFacesRequest;
import com.aliyuncs.cloudauth.model.v20190307.CompareFacesResponse;
import com.aliyuncs.cloudauth.model.v20190307.CompareFacesResponse.Data;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;

public class CompareFaces {

	private static final String ACCESS_KEY_ID = "LTAI4FzmUwt4fyWxiJGFtVby";

	private static final String ACCESS_KEY_SECRET = "hid1ZwsL7aMMwmr7O8UjvksU9mxhU3";

	public static Result compareFaces(String imageURLA, String imageURLB) {
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
		IAcsClient client = new DefaultAcsClient(profile);

		CompareFacesRequest request = new CompareFacesRequest();
		request.setRegionId("cn-hangzhou");
		request.setTargetImageType("IDPic");
		request.setTargetImageValue(imageURLA);
		request.setSourceImageType("FacePic");
		request.setSourceImageValue(imageURLB);

		try {
			CompareFacesResponse response = client.getAcsResponse(request);
			if (response.getSuccess()) {
				Data data = response.getData();
				// 相似度 1 ~ 100
				Float confidence = data.getSimilarityScore();
				if (confidence > 80) {
					return ResultUtil.custom(0, "识别通过");
				} else {
					return ResultUtil.custom(-1, "识别度太低");
				}
			} else {
				return ResultUtil.custom(-2, "识别失败");
			}
		} catch (ServerException e) {
			e.printStackTrace();
			return ResultUtil.custom(-4, "服务端异常", e);
		} catch (ClientException e) {
			System.out.println("ErrCode:" + e.getErrCode());
			System.out.println("ErrMsg:" + e.getErrMsg());
			System.out.println("RequestId:" + e.getRequestId());
			return ResultUtil.custom(-4, "客户端异常", e);
		}
	}

	/*
	 * 人脸人体-人脸比对
	 */
//	public static void main(String[] args) {
//		DefaultProfile profile = DefaultProfile.getProfile("cn-shanghai", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
//		IAcsClient client = new DefaultAcsClient(profile);
//
//		CompareFaceRequest request = new CompareFaceRequest();
//		request.setRegionId("cn-shanghai");
//		request.set.setImageURLA(
//				"http://explorer-image.oss-cn-shanghai.aliyuncs.com/1455274160764180/photo.jpg?OSSAccessKeyId=LTAI4Fk9FstqSEYnqKJ5Dpeo&Expires=1599030793&Signature=Ficenx7Le4RHFqfya2W%2FvylRIk4%3D");
//		request.setImageURLB(
//				"http://explorer-image.oss-cn-shanghai.aliyuncs.com/1455274160764180/photo.jpg?OSSAccessKeyId=LTAI4Fk9FstqSEYnqKJ5Dpeo&Expires=1599030016&Signature=BXKgHs6Lqi5o84YQqJn58SM3pDA%3D");
//
//		try {
//			CompareFaceResponse response = client.getAcsResponse(request);
//			System.out.println(new Gson().toJson(response));
//		} catch (ClientException e) {
//			System.out.println("ErrCode:" + e.getErrCode());
//			System.out.println("ErrMsg:" + e.getErrMsg());
//			System.out.println("RequestId:" + e.getRequestId());
//		}
//	}

	/*
	 * 实人认证-人脸比对
	 */
	public static void main(String[] args) {
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
		IAcsClient client = new DefaultAcsClient(profile);

		CompareFacesRequest request = new CompareFacesRequest();
		request.setRegionId("cn-hangzhou");
		request.setTargetImageType("IDPic");
		request.setSourceImageType("FacePic");
		request.setSourceImageValue("http://zryuxiang.com/uploaded/photo.jpg");
		request.setTargetImageValue("http://zryuxiang.com/uploaded/id_card1.jpg");

		try {
			CompareFacesResponse response = client.getAcsResponse(request);
			System.out.println(new Gson().toJson(response));
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			System.out.println("ErrCode:" + e.getErrCode());
			System.out.println("ErrMsg:" + e.getErrMsg());
			System.out.println("RequestId:" + e.getRequestId());
		}

	}

}

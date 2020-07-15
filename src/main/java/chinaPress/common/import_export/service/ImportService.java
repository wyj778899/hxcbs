package chinaPress.common.import_export.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.math.BigDecimal;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ExcelUtil;
import chinaPress.common.util.Md5Util;
import chinaPress.common.util.ResultUtil;
import chinaPress.role.member.dao.CertificateInfoMapper;
import chinaPress.role.member.dao.MemberInfoMapper;
import chinaPress.role.member.dao.PractitionerInfoMapper;
import chinaPress.role.member.model.CertificateInfo;
import chinaPress.role.member.model.MemberInfo;
import chinaPress.role.member.model.PractitionerInfo;
import chinaPress.role.teacher.dao.RoleTeacherArchivesMapper;

@Service
public class ImportService {

	@Autowired
	private RoleTeacherArchivesMapper roleTeacherArchivesMapper;

	@Autowired
	private CertificateInfoMapper certificateInfoMapper;
	
	@Autowired
	private PractitionerInfoMapper practitionerInfoMapper;
	
	@Autowired
	private MemberInfoMapper memberInfoMapper;

	@Transactional
	public Result importExcel(String path) {
//		path = "D:\\客户\\华夏出版社\\Excel导入\\aaaa.xls";
		File file = new File(path);
		// 文件名
		String fname = file.getName();
		String prefix = fname.substring(fname.lastIndexOf(".") + 1);
		Workbook workbook = null;
		// 老师数量
		try {
			workbook = create(new FileInputStream(file));
//			if (prefix.equals("xls")) {
//				workbook = new XSSFWorkbook(new FileInputStream(file));
//			} else if (prefix.equals("xlsx")) {
//				workbook = new HSSFWorkbook(new FileInputStream(file));
//			}

			Sheet sheet = workbook.getSheetAt(0);
			
			for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
				sheet = workbook.getSheetAt(numSheet);
				if (sheet == null) {
					continue;
				}
				if (sheet.getLastRowNum() == 0) {
					continue;
				}

				for (int rowNum = 2; rowNum < sheet.getLastRowNum(); rowNum++) {
					Row row = sheet.getRow(rowNum);
					if (row != null) {

						String name = row.getCell(1).getStringCellValue(); // 姓名
						String tempSex = ExcelUtil.formatCell6((XSSFCell) row.getCell(2));; // 性别
//						if (cell2.getCellType() == Cell.CELL_TYPE_STRING) {
//							tempSex = row.getCell(2).getStringCellValue();
//						} else if (cell2.getCellType() == Cell.CELL_TYPE_NUMERIC) {
//							tempSex = String.valueOf(row.getCell(2).getNumericCellValue());
//						}
						
						Integer sex = null;
						String idCard = row.getCell(3).getStringCellValue(); // 身份证
						if (idCard == null || idCard.equals("")) {
							continue;
						}
						// 如果性别为null，采用身份证判断性别，身份证第17位标识男女，男单女双
						if (tempSex == null || tempSex.equals("")) {
							if (idCard != null && !idCard.trim().equals("") && idCard.length() == 18) {
								if (Integer.parseInt(idCard.substring(16, 17)) % 2 == 0) {
									sex = 2;
								} else {
									sex = 1;
								}
							}
						} else {
							sex = Integer.parseInt(tempSex);
						}

						String code = row.getCell(4).getStringCellValue(); // 证书编码
						String workAddress = row.getCell(5).getStringCellValue();// 工作单位
						String education = row.getCell(6).getStringCellValue(); // 学历
						String position = row.getCell(7).getStringCellValue();// 职务
						String address = row.getCell(8).getStringCellValue();// 地址
						String tellPhone = ExcelUtil.formatCell6((XSSFCell) row.getCell(9)); // 电话
						String grade = ExcelUtil.formatCell6((XSSFCell) row.getCell(12));  // 分数

						PractitionerInfo info = new PractitionerInfo();
						int infoIndex = 0;
						
						PractitionerInfo infoModel = practitionerInfoMapper.selectByCertificate(idCard);
						if (infoModel == null) {
							if (name != null && !name.equals("")) {
								info.setName(name); // 姓名
								info.setUserName(name);
							}
							if (idCard != null && !idCard.equals("")) {
								info.setCertificateNumber(idCard); // 身份证
							}
							info.setSex(sex); // 性别
							if (workAddress != null && !workAddress.equals("")) {
								info.setInstitutionAddress(workAddress);// 工作单位
							}
							if (education != null && !education.equals("")) {
								info.setEducation(education); // 学历
							}
							if (position != null && !position.equals("")) {
								info.setPost(position); // 职务
							}
							if (address != null && !address.equals("")) {
								info.setAddress(address); // 地址
							}
							if (tellPhone != null && !tellPhone.equals("")) {
								info.setTellPhone(tellPhone); // 电话
							}
							info.setPassword(Md5Util.getEncryptedPwd("123456"));
							infoIndex = practitionerInfoMapper.insertSelective(info);
						} else {
							info.setId(infoModel.getId());
							if (name != null && !name.equals("")) {
								info.setName(name); // 姓名
								info.setUserName(name);
							}
							if (idCard != null && !idCard.equals("")) {
								info.setCertificateNumber(idCard); // 身份证
							}
							info.setSex(sex); // 性别
							if (workAddress != null && !workAddress.equals("")) {
								info.setInstitutionAddress(workAddress);// 工作单位
							}
							if (education != null && !education.equals("")) {
								info.setEducation(education); // 学历
							}
							if (position != null && !position.equals("")) {
								info.setPost(position); // 职务
							}
							if (address != null && !address.equals("")) {
								info.setAddress(address); // 地址
							}
							if (tellPhone != null && !tellPhone.equals("")) {
								info.setTellPhone(tellPhone); // 电话
							}
							infoIndex = practitionerInfoMapper.updateByPrimaryKeySelective(info);
						}
						if (infoIndex > 0) {
							// 员工操作
							MemberInfo memberModel = memberInfoMapper.selectByPrimaryKey(new MemberInfo(info.getId(), 4));
							MemberInfo member = new MemberInfo();
							if (memberModel == null) {
								if (name != null && !name.equals("")) {
									member.setName(name); // 姓名
									member.setUserName(name); // 用户名
								}
								member.setSex(sex); // 性别
								if (address != null && !address.equals("")) {
									member.setAddress(address); // 地址
								}
								if (tellPhone != null && !tellPhone.equals("")) {
									member.setTellPhone(tellPhone); // 电话
								}
								member.setPassword(Md5Util.getEncryptedPwd("123456"));
								member.setState(2);
								member.setIsStart(1);
								member.setRoleType(4);
								member.setRoleId(info.getId());
								memberInfoMapper.insertSelective(member);
							} else {
								member.setId(memberModel.getId());
								if (name != null && !name.equals("")) {
									member.setName(name); // 姓名
									member.setUserName(name); // 用户名
								}
								member.setSex(sex); // 性别
								if (address != null && !address.equals("")) {
									member.setAddress(address); // 地址
								}
								if (tellPhone != null && !tellPhone.equals("")) {
									member.setTellPhone(tellPhone); // 电话
								}
								member.setRoleType(4);
								memberInfoMapper.updateByPrimaryKeySelective(member);
							}
							
							if (code == null || code.equals("")) {
								continue;
							}
							// 证书操作
							CertificateInfo cert = new CertificateInfo();
							CertificateInfo certModel = certificateInfoMapper.selectByCode(code);
							if (certModel == null) {
								cert.setRoleType(3);
								cert.setCertificateType(1);
								cert.setRoleId(info.getId());
								cert.setCode(code);
								cert.setAuditStatus(2);
								if (workAddress != null && !workAddress.equals("")) {
									cert.setTestAddress(workAddress); // 考试地址
								}
								if (grade != null && !grade.equals("")) {
									cert.setGrade(new BigDecimal(grade));
								}
								certificateInfoMapper.insertSelective(cert);
							} else {
								cert.setId(certModel.getId());
								cert.setRoleType(3);
								cert.setCertificateType(1);
								cert.setRoleId(info.getId());
								cert.setCode(code);
								cert.setAuditStatus(2);
								if (workAddress != null && !workAddress.equals("")) {
									cert.setTestAddress(workAddress); // 考试地址
								}
								if (grade != null && !grade.equals("")) {
									cert.setGrade(new BigDecimal(grade));
								}
								certificateInfoMapper.updateByPrimaryKeySelective(cert);
							}

						}

					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return ResultUtil.custom(-1, "模板导入异常，请检查档案模板");
		}
		return ResultUtil.ok();
	}

	private Workbook create(InputStream in) throws IOException, InvalidFormatException {
		if (!in.markSupported()) {
			in = new PushbackInputStream(in, 8);
		}
		if (POIFSFileSystem.hasPOIFSHeader(in)) {
			return new HSSFWorkbook(in);
		}
		if (POIXMLDocument.hasOOXMLHeader(in)) {
			return new XSSFWorkbook(OPCPackage.open(in));
		}
		throw new IllegalArgumentException("你的excel版本目前poi解析不了");

	}

}

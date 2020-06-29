package chinaPress.role.member.service;


import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.common.sms.service.SMSService;
import chinaPress.common.util.ExcelUtil;
import chinaPress.common.util.Md5Util;
import chinaPress.role.member.dao.MemberInfoMapper;
import chinaPress.role.member.dao.PractitionerInfoMapper;
import chinaPress.role.member.dao.TrainInstitutionInfoMapper;
import chinaPress.role.member.dao.UserInfoMapper;
import chinaPress.role.member.model.MemberInfo;
import chinaPress.role.member.model.PractitionerInfo;
import chinaPress.role.member.model.TrainInstitutionInfo;
import chinaPress.role.member.model.UserInfo;
import chinaPress.role.member.vo.MemberCouponInfo;
import chinaPress.role.member.vo.MemberInfoVo;
import chinaPress.role.member.vo.PractitionerEmps;
import chinaPress.role.member.vo.PractitionerParent;
import chinaPress.role.member.vo.UserAndCerVo;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
@Transactional
public class MemberInfoService {

	/**
	 * 员工信息
	 */
	@Autowired
	private MemberInfoMapper memberInfoMapper;

	/**
	 * 家长从业者
	 */
	@Autowired
	private PractitionerInfoMapper practitionerInfoMapper;

	/**
	 * 培训机构
	 */
	@Autowired
	private TrainInstitutionInfoMapper trainInstitutionInfoMapper;

	/**
	 * 注册用户
	 */
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	/**
	 * 注入jedisPool  用户验证redis中的验证码
	 */
	@Autowired
    private JedisPool jedisPool;
	
	/**
	 * 发送验证码的service
	 */
	@Autowired
	private SMSService smsService;

	/**
	 * 添加培训机构信息
	 * @param trainInstitutionInfo
	 * @return Result  code状态码     mes提示信息       data数据信息
	 */
	public Result addInstitution(TrainInstitutionInfo trainInstitutionInfo) {
		//判断用户名
		MemberInfo nameParam = new MemberInfo(); 
		String userName = trainInstitutionInfo.getUserName();
		nameParam.setUserName(userName);
		if(memberInfoMapper.selectByPrimaryKey(nameParam)!=null) {
			return new Result(-1,"用户名已注册","");
		}
		//判断手机号
		MemberInfo tellParam = new MemberInfo();
		String tellPhone = trainInstitutionInfo.getRegisterTell();
		tellParam.setTellPhone(tellPhone);
		if(memberInfoMapper.selectByPrimaryKey(tellParam)!=null) {
			return new Result(-1,"手机号已注册","");
		}
		Jedis jedis = jedisPool.getResource();
		String value = jedis.get("register_".concat(tellPhone));
		//校验验证码是否正确
		if(value.equals(trainInstitutionInfo.getVerificationCode())) {
			//状态默认为有效
			trainInstitutionInfo.setState(1);
			//审核状态默认为未审核
			trainInstitutionInfo.setAuditStatus(1);
			try {
				trainInstitutionInfo.setPassword(Md5Util.getEncryptedPwd(trainInstitutionInfo.getPassword()));
			} catch (Exception e) {
				return new Result(-2,"密码不合法","");
			} 
			int count = trainInstitutionInfoMapper.insertSelective(trainInstitutionInfo);
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setPassword(trainInstitutionInfo.getPassword());
			memberInfo.setName(trainInstitutionInfo.getName());
			memberInfo.setTellPhone(trainInstitutionInfo.getRegisterTell());
			memberInfo.setProvice(trainInstitutionInfo.getBusinessProvice());
			memberInfo.setCity(trainInstitutionInfo.getBusinessCity());
			memberInfo.setArea(trainInstitutionInfo.getBusinessArea());
			memberInfo.setAddress(trainInstitutionInfo.getBusinessAddress());
			memberInfo.setUserName(trainInstitutionInfo.getUserName());
			memberInfo.setState(1);
			memberInfo.setIsStart(1);
			memberInfo.setRoleId(trainInstitutionInfo.getId());
			memberInfo.setRoleType(2);
			count += memberInfoMapper.insertSelective(memberInfo);
			if(count>1) {
//				smsService.sendFinishSMS(tellPhone,"恭喜您注册华夏云课堂！！！");
				return new Result(0,"添加成功","");
			}else {
				return new Result(-3,"数据库错误","");
			}
		}else {
			return new Result(-4,"验证码错误","");
		}
		
	}

	/**
	 * 通过id查询培训机构信息 
	 * @param id
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findInstitution(Integer id) {
		TrainInstitutionInfo trainInstitutionInfo = trainInstitutionInfoMapper.selectByPrimaryKey(id);
		if(trainInstitutionInfo!=null) {
			return new Result(0,"查询成功",trainInstitutionInfo);
		}else {
			return new Result(-1,"查询失败","");
		}
	}

	/**
	 * 更新培训机构信息
	 * @param trainInstitutionInfo
	 * @return
	 */
	public Result setInstitution(TrainInstitutionInfo trainInstitutionInfo) {
		//通过用户名和密码到员工表查询用户信息     获取员工id更新员工操作
		MemberInfo param = new MemberInfo();
		param.setUserName(trainInstitutionInfo.getUserName());
		MemberInfo m= memberInfoMapper.selectByPrimaryKey(param);
		if(m==null) {
			MemberInfo param1 = new MemberInfo();
			param1.setTellPhone(trainInstitutionInfo.getRegisterTell());
			m= memberInfoMapper.selectByPrimaryKey(param1);
		}
		if(m==null) {
			return new Result(-5,"用户信息不存在","");
		}
		//先判断用户名和手机号不符合之间返回
		//判断用户名
		MemberInfo nameParam = new MemberInfo(); 
		String userName = trainInstitutionInfo.getUserName();
		Integer id = m.getId();
		nameParam.setUserName(userName);
		nameParam.setId(id);
		if(memberInfoMapper.selectUserAndTellPhone(nameParam)>0) {
			return new Result(-1,"用户名已注册","");
		}
		//判断手机号
		MemberInfo tellParam = new MemberInfo();
		String tellPhone = trainInstitutionInfo.getRegisterTell();
		tellParam.setTellPhone(tellPhone);
		tellParam.setId(id);
		if(memberInfoMapper.selectUserAndTellPhone(tellParam)>0) {
			return new Result(-1,"手机号已注册","");
		}
		//创建员工对象
		MemberInfo memberInfo = new MemberInfo();
		//获取用户的原始密码
		TrainInstitutionInfo t= trainInstitutionInfoMapper.selectByPrimaryKey(trainInstitutionInfo.getId());
		String password = t.getPassword();
		//是否修改密码
		if(trainInstitutionInfo.getPassword()!=null&&trainInstitutionInfo.getPassword()!=""&&!password.equals(trainInstitutionInfo.getPassword())) {
			try {
				Jedis jedis = jedisPool.getResource();
				String value = jedis.get("forget_password_".concat(trainInstitutionInfo.getUserName()));
				if(value.equals(trainInstitutionInfo.getVerificationCode())) {
					//重新赋值培训机构密码
					trainInstitutionInfo.setPassword(Md5Util.getEncryptedPwd(trainInstitutionInfo.getPassword()));
					//重新赋值员工密码
					memberInfo.setPassword(Md5Util.getEncryptedPwd(trainInstitutionInfo.getPassword()));
				}else {
					return new Result(-4, "验证码错误", "");
				}
			} catch (Exception e) {
				return new Result(-2, "密码不合法", "");
			} 
		}else {
			memberInfo.setPassword(trainInstitutionInfo.getPassword());
		}
		memberInfo.setName(trainInstitutionInfo.getName());
		memberInfo.setTellPhone(trainInstitutionInfo.getRegisterTell());
		memberInfo.setProvice(trainInstitutionInfo.getBusinessProvice());
		memberInfo.setCity(trainInstitutionInfo.getBusinessCity());
		memberInfo.setArea(trainInstitutionInfo.getBusinessArea());
		memberInfo.setAddress(trainInstitutionInfo.getBusinessAddress());
		memberInfo.setUserName(trainInstitutionInfo.getUserName());
		//更新培训机构信息
		int i = trainInstitutionInfoMapper.updateByPrimaryKeySelective(trainInstitutionInfo);
		//更新员工信息
		memberInfo.setId(m.getId());
		i += memberInfoMapper.updateByPrimaryKeySelective(memberInfo);
		if(i>1) {
			return new Result(0, "修改成功", "");
		}else {
			return new Result(-3, "数据库错误", "");
		}
	}

	/**
	 * 添加注册用户信息     添加成功后向员工表添加数据
	 * @param userInfo
	 * @return
	 */
	public Result addUserInfo(UserInfo userInfo) {
		MemberInfo nameParam = new MemberInfo(); 
		String userName = userInfo.getUserName();
		nameParam.setUserName(userName);
		if(memberInfoMapper.selectByPrimaryKey(nameParam)!=null) {
			return new Result(-1,"用户名已注册","");
		}
		//判断手机号
		MemberInfo tellParam = new MemberInfo();
		String tellPhone = userInfo.getTellPhone();
		tellParam.setTellPhone(tellPhone);
		if(memberInfoMapper.selectByPrimaryKey(tellParam)!=null) {
			return new Result(-1,"手机号已注册","");
		}
		Jedis jedis = jedisPool.getResource();
		String value = jedis.get("register_".concat(tellPhone));
		if(value.equals(userInfo.getVerificationCode())) {
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setUserName(userName);
			memberInfo.setTellPhone(tellPhone);
			try {
				memberInfo.setPassword(Md5Util.getEncryptedPwd(userInfo.getPassword()));
				userInfo.setPassword(Md5Util.getEncryptedPwd(userInfo.getPassword()));
			} catch (Exception e) {
				return new Result(-2, "密码不合法", "");
			}
			userInfo.setState(1);
			int i = userInfoMapper.insertSelective(userInfo);
			memberInfo.setIsStart(1);
			memberInfo.setState(2);
			memberInfo.setRoleId(userInfo.getId());
			memberInfo.setRoleType(5);
			i+= memberInfoMapper.insertSelective(memberInfo);
			if(i>1) {
//				smsService.sendFinishSMS(tellPhone,"恭喜您注册华夏云课堂！！！");
				return new Result(0, "添加成功", "");
			}else {
				return new Result(-3, "数据库错误", "");
			}
		}else {
			return new Result(-4, "验证码错误", "");
		}
	}

	/**
	 * 通过id查询用户信息
	 * @param id
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findUserInfo(Integer id) {
		UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
		if(userInfo!=null) {
			return new Result(0,"查询成功",userInfo);
		}else {
			return new Result(-1, "查询失败", "");
		}

	}

	/**
	 * 更新用户信息 ，更新成功后同时更新员工信息表对应的数据
	 * @param userInfo
	 * @return
	 */
	public Result setUserInfo(UserInfo userInfo) {
		//通过用户名和手机号查询用户信息
		MemberInfo param = new MemberInfo();
		param.setUserName(userInfo.getUserName());
		MemberInfo m = memberInfoMapper.selectByPrimaryKey(param);
		//用户名不存在查询手机号
		if(m==null) {
			MemberInfo param1 = new MemberInfo();
			param1.setTellPhone(userInfo.getTellPhone());
			m = memberInfoMapper.selectByPrimaryKey(param1);
		}
		//手机号还不存在直接返回
		if(m==null) {
			return new Result(-5,"用户信息不存在","");
		}
		//判断用户名
		MemberInfo nameParam = new MemberInfo(); 
		String userName = userInfo.getUserName();
		Integer id = m.getId();
		nameParam.setUserName(userName);
		nameParam.setId(id);
		if(memberInfoMapper.selectUserAndTellPhone(nameParam)>0) {
			return new Result(-1,"用户名已注册","");
		}
		//判断手机号
		MemberInfo tellParam = new MemberInfo();
		String tellPhone = userInfo.getTellPhone();
		tellParam.setTellPhone(tellPhone);
		tellParam.setId(id);
		if(memberInfoMapper.selectUserAndTellPhone(tellParam)>0) {
			return new Result(-1,"手机号已注册","");
		}
		UserInfo u = userInfoMapper.selectByPrimaryKey(userInfo.getId());
		//原始密码是否修改,修改后重复赋值
		if(userInfo.getPassword()!=null&&userInfo.getPassword()!=""&&!u.getPassword().equals(userInfo.getPassword())) {
			Jedis jedis = jedisPool.getResource();
			String value = jedis.get("forget_password_".concat(userInfo.getUserName()));
			if(value.equals(userInfo.getVerificationCode())) {
				try {
					userInfo.setPassword(Md5Util.getEncryptedPwd(userInfo.getPassword()));
				} catch (Exception e) {
					e.printStackTrace();
					return new Result(-2,"密码不合法","");
				}
			}else {
				return new Result(-4,"验证码错误","");
			}
		}
		int i = userInfoMapper.updateByPrimaryKeySelective(userInfo);
		m.setUserName(userInfo.getUserName());
		m.setPassword(userInfo.getPassword());
		i+= memberInfoMapper.updateByPrimaryKeySelective(m);
		if(i>1) {
			return new Result(0, "修改成功", "");
		}else {
			return new Result(-3, "数据库错误", "");
		}
	}

	/**
	 * 家长和从业者添加
	 * @param practitionerInfo
	 * @return
	 */
	public Result addPractitionerInfo(PractitionerInfo practitionerInfo) {
		//判断用户名
		MemberInfo nameParam = new MemberInfo(); 
		String userName = practitionerInfo.getUserName();
		nameParam.setUserName(userName);
		if(memberInfoMapper.selectByPrimaryKey(nameParam)!=null) {
			return new Result(-1,"用户名已注册","");
		}
		//判断手机号
		MemberInfo tellParam = new MemberInfo();
		String tellPhone = practitionerInfo.getTellPhone();
		tellParam.setTellPhone(tellPhone);
		if(memberInfoMapper.selectByPrimaryKey(tellParam)!=null) {
			return new Result(-1,"手机号已注册","");
		}
		Jedis jedis = jedisPool.getResource();
		String value = jedis.get("register_".concat(tellPhone));
		if(value.equals(practitionerInfo.getVerificationCode())) {
			try {
				practitionerInfo.setPassword(Md5Util.getEncryptedPwd(practitionerInfo.getPassword()));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(-2, "密码不合法", "");
			} 
			practitionerInfo.setState(1);
			int i = practitionerInfoMapper.insertSelective(practitionerInfo);
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setUserName(practitionerInfo.getUserName());
			memberInfo.setPassword(practitionerInfo.getPassword());
			memberInfo.setName(practitionerInfo.getName());
			memberInfo.setAddress(practitionerInfo.getAddress());
			memberInfo.setTellPhone(practitionerInfo.getTellPhone());
			memberInfo.setSex(practitionerInfo.getSex());
			memberInfo.setProvice(practitionerInfo.getProvice());
			memberInfo.setCity(practitionerInfo.getCity());
			memberInfo.setArea(practitionerInfo.getArea());
			memberInfo.setAddress(practitionerInfo.getAddress());
			memberInfo.setEmail(practitionerInfo.getEmail());
			memberInfo.setIsStart(1);
			memberInfo.setState(2);
			memberInfo.setRoleId(practitionerInfo.getId());
			//状态有值进行操作
			if(1==practitionerInfo.getType()) {
				memberInfo.setRoleType(3);
			}
			if(2==practitionerInfo.getType()) {
				memberInfo.setRoleType(4);
			}
			i+=memberInfoMapper.insertSelective(memberInfo);
			if(i>1) {
//				smsService.sendFinishSMS(tellPhone,"恭喜您注册华夏云课堂！！！");
				return new Result(0, "添加成功", "");
			}else {
				return new Result(-3, "数据库错误", "");
			}
		}else{
			return new Result(-4, "验证码错误", "");
		}
	}


	/**
	 * 通过id查询家长/从业者
	 * @param id
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findPractitionerInfo(Integer id) {
		PractitionerInfo practitionerInfo = practitionerInfoMapper.selectByPrimaryKey(id);
		if(practitionerInfo!=null) {
			return new Result(0,"查询成功",practitionerInfo);
		}else {
			return new Result(-1, "查询失败", "");
		}

	}

	/**
	 * 家长/从业者修改信息
	 * @param practitionerInfo
	 * @return
	 */
	public Result setpractitionerInfo(PractitionerInfo practitionerInfo) {
		MemberInfo param = new MemberInfo();
		param.setUserName(practitionerInfo.getUserName());
		MemberInfo memberInfo = memberInfoMapper.selectByPrimaryKey(param);
		if(memberInfo==null) {
			MemberInfo param1 = new MemberInfo();
			param1.setTellPhone(practitionerInfo.getTellPhone());
			memberInfo = memberInfoMapper.selectByPrimaryKey(param1);
		}
		if(memberInfo==null) {
			return new Result(-5, "用户不存在", "");
		}
		//判断用户名
		MemberInfo nameParam = new MemberInfo(); 
		String userName = practitionerInfo.getUserName();
		Integer id = memberInfo.getId();
		nameParam.setUserName(userName);
		nameParam.setId(id);
		if(memberInfoMapper.selectUserAndTellPhone(nameParam)>0) {
			return new Result(-1,"用户名已注册","");
		}
		//判断手机号
		MemberInfo tellParam = new MemberInfo();
		String tellPhone = practitionerInfo.getTellPhone();
		tellParam.setTellPhone(tellPhone);
		tellParam.setId(id);
		if(memberInfoMapper.selectUserAndTellPhone(tellParam)>0) {
			return new Result(-1,"手机号已注册","");
		}
		String password = practitionerInfoMapper.selectByPrimaryKey(practitionerInfo.getId()).getPassword();
		//校验密码
		if(practitionerInfo.getPassword()!=null&&practitionerInfo.getPassword()!=""&&!password.equals(practitionerInfo.getPassword())) {
			Jedis jedis = jedisPool.getResource();
			String value = jedis.get("forget_password_".concat(practitionerInfo.getUserName()));
			if(value.equals(practitionerInfo.getVerificationCode())) {
				try {
					practitionerInfo.setPassword(Md5Util.getEncryptedPwd(practitionerInfo.getPassword()));
				} catch (Exception e) {
					e.printStackTrace();
					return new Result(-2, "密码不合法", "");
				} 
			}else{
				return new Result(-4, "验证码错误", "");
			}
		}
		int i = practitionerInfoMapper.updateByPrimaryKeySelective(practitionerInfo);
		memberInfo.setUserName(practitionerInfo.getUserName());
		memberInfo.setPassword(practitionerInfo.getPassword());
		memberInfo.setName(practitionerInfo.getName());
		memberInfo.setAddress(practitionerInfo.getAddress());
		memberInfo.setTellPhone(practitionerInfo.getTellPhone());
		memberInfo.setSex(practitionerInfo.getSex());
		memberInfo.setProvice(practitionerInfo.getProvice());
		memberInfo.setCity(practitionerInfo.getCity());
		memberInfo.setArea(practitionerInfo.getArea());
		memberInfo.setAddress(practitionerInfo.getAddress());
		memberInfo.setRoleId(practitionerInfo.getId());
		//状态有值进行操作
		if(1==practitionerInfo.getType()) {
			memberInfo.setRoleType(3);
		}
		if(2==practitionerInfo.getType()) {
			memberInfo.setRoleType(4);
		}
		i+=memberInfoMapper.updateByPrimaryKeySelective(memberInfo);
		if(i>1) {
			return new Result(0, "修改成功", "");
		}else {
			return new Result(-3, "数据库错误", "");
		}
	}

	/**
	 * 通过用户名判断用户是否存在
	 * MD5校验密码是否正确
	 * @param userName
	 * @param password
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findNameAndPassword(String userName,String password) {
		MemberInfoVo memberInfo = new MemberInfoVo();
		//判断用户名
		MemberInfo nameParam = new MemberInfo(); 
		nameParam.setUserName(userName);
		MemberInfo m = memberInfoMapper.selectByPrimaryKey(nameParam);
		//如果用户名没有查询到再查看手机号信息
		if(m==null) {
			MemberInfo tellParam = new MemberInfo(); 
			tellParam.setTellPhone(userName);
			m = memberInfoMapper.selectByPrimaryKey(tellParam);
		}
		//如果m还等于null则返回
		if(m==null) {
			return new Result(-2, "用户或密码错误", "");
		}
		//员工类型为从业者并且状态没有审核
		if(m.getRoleType()==2 && m.getState()!=2) {
			return new Result(-4, "该账号正在审核中...", "");
		}
		try {
			if(Md5Util.validPassword(password,m.getPassword())) {
				memberInfo.setRoleId(m.getRoleId());
				memberInfo.setName(m.getName());
				memberInfo.setPhoto(m.getPhoto());
				memberInfo.setRoleType(m.getRoleType());
				return new Result(0, "登陆成功", memberInfo);
			}else {
				return new Result(-3, "密码错误", "");
			}
		} catch (Exception e) {
			return new Result(-2, "用户或密码错误", "");
		} 
	}

	
	/**
	 * 更新员工信息
	 * @param memberInfo
	 * @return
	 */
	public Result setMemberInfo(MemberInfo memberInfo) {
		//判断用户名
		MemberInfo nameParam = new MemberInfo(); 
		String userName = memberInfo.getUserName();
		Integer id = memberInfo.getId();
		nameParam.setUserName(userName);
		nameParam.setId(id);
		if(memberInfoMapper.selectUserAndTellPhone(nameParam)>0) {
			return new Result(-1,"用户名已注册","");
		}
		//判断手机号
		MemberInfo tellParam = new MemberInfo();
		String tellPhone = memberInfo.getTellPhone();
		tellParam.setTellPhone(tellPhone);
		nameParam.setId(id);
		if(memberInfoMapper.selectUserAndTellPhone(tellParam)>0) {
			return new Result(-1,"手机号已注册","");
		}
		MemberInfo param = new MemberInfo();
		param.setId(memberInfo.getId());
		String password = memberInfoMapper.selectByPrimaryKey(param).getPassword();
		if(memberInfo.getPassword()!=null&&memberInfo.getPassword()!=""&&!password.equals(memberInfo.getPassword())) {
			Jedis jedis = jedisPool.getResource();
			String value = jedis.get("forget_password_".concat(memberInfo.getUserName()));
			if(value.equals(memberInfo.getVerificationCode())) {
				try {
					memberInfo.setPassword(Md5Util.getEncryptedPwd(memberInfo.getPassword()));
				} catch (Exception e) {
					e.printStackTrace();
					return new Result(-2,"密码不合法","");
				} 
			}else {
				return new Result(-4,"验证码错误","");
			}
		}
		int i = memberInfoMapper.updateByPrimaryKeySelective(memberInfo);
		if(i>0) {
			return new Result(0,"更新成功", "");
		}else {
			return new Result(-1,"数据库错误","");
		}
	}


	/**
	 * 根据id查询显示员工信息
	 * @param id
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findMemberById(Integer id) {
		MemberInfo m = new MemberInfo();
		m.setId(id);
		m = memberInfoMapper.selectByPrimaryKey(m);
		if(m!=null) {
			return new Result(0,"查询成功",m);
		}else {
			return new Result(-1, "查询失败", "");
		}
	}

	/**
	 * 添加员工信息
	 * @param memberInfo
	 * @return
	 */
	public Result addMemberInfo(MemberInfo memberInfo) {
		MemberInfo param = new MemberInfo();
		param.setUserName(memberInfo.getUserName());
		if(memberInfoMapper.selectByPrimaryKey(param)!=null) {
			return new Result(-1,"手机号已注册", "");
		}
		Jedis jedis = jedisPool.getResource();
		String value = jedis.get("register_".concat(memberInfo.getUserName()));
		if(value.equals(memberInfo.getVerificationCode())) {
			try {
				memberInfo.setPassword(Md5Util.getEncryptedPwd(memberInfo.getPassword()));
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(-2,"密码不合法", "");
			}
			memberInfo.setIsStart(1);
			memberInfo.setState(2);
			memberInfo.setRoleType(1);
			int i = memberInfoMapper.insertSelective(memberInfo);
			if(i>0) {
				return new Result(0,"添加成功", "");
			}else {
				return new Result(-3,"数据库错误","");
			}
		}else {
			return new Result(-4,"验证码错误","");
		}
	}
	
	/**
	 * 查看家长/从业者信息
	 * @param practitioner
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findPractitionerAll(PractitionerInfo practitioner) {
		if(1==practitioner.getType()) {
			List<PractitionerParent> list = practitionerInfoMapper.selectPractitionerParents(practitioner);
			if(list!=null) {
				return new Result(0, "查询成功", list);
			}else {
				return new Result(-1, "查询失败", "");
			}
		}else if(2==practitioner.getType()){
			List<PractitionerEmps> list = practitionerInfoMapper.selectPractitionerEmps(practitioner);
			if(list!=null) {
				return new Result(0, "查询成功", list);
			}else {
				return new Result(-1, "查询失败", "");
			}
		}
		return new Result(-1, "请选择家长或者从业者", "");
	}
	
	/**
	 * 
	 * 查看家长/从业者信息   分页展示查询总个数
	 * @param practitioner
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findPractitionerCount(PractitionerInfo practitioner) {
		int count = practitionerInfoMapper.selectCount(practitioner);
		if(count>0) {
			return new Result(0, "查询成功", count);
		}else {
			return new Result(-1, "查询失败", "");
		}
	}
	
	/**
	 * 通过公司名称，企业编码，企业法人，注册人手机号，开始页数，每页显示的条数显示培训机构信息
	 * @param trainInstitutionInfo
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findTrainInstitutionAll(TrainInstitutionInfo trainInstitutionInfo) {
		List<TrainInstitutionInfo> list = trainInstitutionInfoMapper.selectTrainInstitutionAll(trainInstitutionInfo);
		if(list!=null) {
			return new Result(0, "查询成功", list);
		}else {
			return new Result(-1, "查询失败", "");
		}
	}

	/**
	 * 通过公司名称，企业编码，企业法人，注册人手机号，开始页数，每页显示的条数显示培训机构信息   显示条件查询的个数
	 * @param trainInstitutionInfo
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findTrainInstitutionCount(TrainInstitutionInfo trainInstitutionInfo) {
		int count = trainInstitutionInfoMapper.selectCount(trainInstitutionInfo);
		if(count>0) {
			return new Result(0, "查询成功", count);
		}else {
			return new Result(-1, "查询失败", 0);
		}
	}
	
	/**
	 * 培训机构和家长/从业者数据导入
	 * @param workbook
	 * @param type 1为培训机构     2为家长/从业者
	 * @return
	 */
	public Result ExcelImport(XSSFWorkbook workbook,Integer type) {
		//成功信息
		StringBuffer sbOk = new StringBuffer();
		//错误信息
		StringBuffer sb = new StringBuffer();
		//工作表
		XSSFSheet sheet = null;
		//行信息
		XSSFRow row = null;
		//第一行
		int firstRowNum = 0;
		//最后一行
		int lastRowNum = 0;	
		//参数对象
		MemberInfo param = new MemberInfo(); 
		//返回信息
		String result = "";
		//循环获取表格  
		for(int i=0;i<workbook.getNumberOfSheets();i++) {
			sheet = workbook.getSheetAt(i);
			firstRowNum = sheet.getFirstRowNum();
			lastRowNum = sheet.getLastRowNum();
			//获取表格每行的信息   第一行是标题，从第二行开始循环
			for(int j=firstRowNum+1;j<=lastRowNum;j++) {
				row = sheet.getRow(j);
				MemberInfo memberInfo = new MemberInfo();
				//判断创建哪个对象
				if(type == 1) {
					TrainInstitutionInfo trainInstitutionInfo = new TrainInstitutionInfo();
					//公司名称
					String name = ExcelUtil.formatCell4(row.getCell(0)).trim();
					if(name==null || name=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写公司名称信息,");
						continue;
					}else {
						trainInstitutionInfo.setName(name);
						memberInfo.setName(name);
					}
					//公司编码
					String code = ExcelUtil.formatCell4(row.getCell(1)).trim();
					if(code==null || code=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写公司编码信息,");
						continue;
					}else {
						trainInstitutionInfo.setCode(code);
					}
					//法人
					String legalPerson = ExcelUtil.formatCell4(row.getCell(2)).trim();
					if(legalPerson==null || legalPerson=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写法人信息,");
						continue;
					}else {
						trainInstitutionInfo.setLegalPerson(legalPerson);
					}
					//证件号码
					String certificateNumber = ExcelUtil.formatCell4(row.getCell(3)).trim();
					if(certificateNumber==null || certificateNumber=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写证件号码信息,");
						continue;
					}else {
						trainInstitutionInfo.setCertificateNumber(certificateNumber);
					}
					//注册人姓名
					String registerName = ExcelUtil.formatCell4(row.getCell(4)).trim();
					if(registerName==null || registerName=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写注册人姓名信息,");
						continue;
					}else {
						trainInstitutionInfo.setRegisterName(registerName);
					}
					//注册人手机号
					String registerTell = ExcelUtil.formatCell4(row.getCell(5)).trim();
					if(registerTell==null || registerTell=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写注册人手机号信息,");
						continue;
					}else {
						trainInstitutionInfo.setRegisterTell(registerTell);
						memberInfo.setTellPhone(registerTell);
					}
					//注册人证件号
					String registerCertificate = ExcelUtil.formatCell4(row.getCell(6)).trim();
					if(registerCertificate==null || registerCertificate=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写注册人证件号信息,");
						continue;
					}else {
						trainInstitutionInfo.setRegisterCertificate(registerCertificate);
					}
					//注册省
					String registerProvice = ExcelUtil.formatCell4(row.getCell(7)).trim();
					if(registerProvice==null || registerProvice=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写注册省信息,");
						continue;
					}else {
						trainInstitutionInfo.setRegisterProvice(registerProvice);
					}
					//注册市
					String registerCity = ExcelUtil.formatCell4(row.getCell(8)).trim();
					if(registerCity==null || registerCity=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写注册市信息,");
						continue;
					}else {
						trainInstitutionInfo.setRegisterCity(registerCity);
					}
					//注册区
					String registerArea = ExcelUtil.formatCell4(row.getCell(9)).trim();
					if(registerArea==null || registerArea=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写注册区信息,");
						continue;
					}else {
						trainInstitutionInfo.setRegisterArea(registerArea);
					}
					//注册详细地址
					String registerAddress = ExcelUtil.formatCell4(row.getCell(10)).trim();
					if(registerAddress==null || registerAddress=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写注册详细地址信息,");
						continue;
					}else {
						trainInstitutionInfo.setRegisterAddress(registerAddress);
					}
					//办公省
					String businessProvice = ExcelUtil.formatCell4(row.getCell(11)).trim();
					if(businessProvice==null || businessProvice=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写办公省信息,");
						continue;
					}else {
						trainInstitutionInfo.setBusinessProvice(businessProvice);
						memberInfo.setProvice(businessProvice);
					}
					//办公市
					String businessCity = ExcelUtil.formatCell4(row.getCell(12)).trim();
					if(businessCity==null || businessCity=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写办公市信息,");
						continue;
					}else {
						trainInstitutionInfo.setBusinessCity(businessCity);
						memberInfo.setCity(businessCity);
					}
					//办公区
					String businessArea = ExcelUtil.formatCell4(row.getCell(13)).trim();
					if(businessArea==null || businessArea=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写办公区信息,");
						continue;
					}else {
						trainInstitutionInfo.setBusinessArea(businessArea);
						memberInfo.setArea(businessArea);
					}
					//办公详细地址
					String businessAddress = ExcelUtil.formatCell4(row.getCell(14)).trim();
					if(businessAddress==null || businessAddress=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写办公详细地址信息,");
						continue;
					}else {
						trainInstitutionInfo.setBusinessAddress(businessAddress);
						memberInfo.setAddress(businessAddress);
					}
					//用户名
					String userName = ExcelUtil.formatCell4(row.getCell(15)).trim();
					if(userName==null || userName=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写用户名信息,");
						continue;
					}else {
						param.setUserName(userName);
						MemberInfo m= memberInfoMapper.selectByPrimaryKey(param);
						if(m!=null) {
							sb.append("第"+(j+1)+"行信息出错：用户名已存在,");
							continue;
						}else {
							trainInstitutionInfo.setUserName(userName);
							memberInfo.setUserName(userName);
						}
					}
					//密码
					String password = ExcelUtil.formatCell4(row.getCell(16)).trim();
					if(password==null || password=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写密码信息,");
						continue;
					}else {
						try {
							trainInstitutionInfo.setPassword(Md5Util.getEncryptedPwd(password));
							memberInfo.setPassword(trainInstitutionInfo.getPassword());
						}catch(Exception e) {
							sb.append("第"+(j+1)+"行信息出错：密码不合法,");
							continue;
						}
					}
					//企业编码
					String enterpriseCode = ExcelUtil.formatCell4(row.getCell(17)).trim();
					if(enterpriseCode==null || enterpriseCode=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写企业编码信息,");
						continue;
					}else {
						trainInstitutionInfo.setEnterpriseCode(enterpriseCode);
					}
					//审核状态和状态excel导入都赋值为有效
					trainInstitutionInfo.setState(1);
					trainInstitutionInfo.setAuditStatus(2);
					trainInstitutionInfoMapper.insertSelective(trainInstitutionInfo);
					memberInfo.setIsStart(1);//默认启用
					memberInfo.setState(2);//默认已审核
					memberInfo.setRoleId(trainInstitutionInfo.getId());//培训机构的id
					memberInfo.setRoleType(2);//用户类型
					memberInfoMapper.insertSelective(memberInfo);
					sbOk.append((j+1)+",");
				}else if(type == 2){
					PractitionerInfo practitionerInfo = new PractitionerInfo();
					//用户名
					String userName = ExcelUtil.formatCell4(row.getCell(0)).trim();
					if(userName==null || userName=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写用户名信息,");
						continue;
					}else {
						param.setUserName(userName);
						MemberInfo m= memberInfoMapper.selectByPrimaryKey(param);
						if(m!=null) {
							sb.append("第"+(j+1)+"行信息出错：用户名已存在,");
							continue;
						}else {
							practitionerInfo.setUserName(userName);
							memberInfo.setUserName(userName);
						}
					}
					//密码
					String password = ExcelUtil.formatCell4(row.getCell(1)).trim();
					if(password==null || password=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写密码信息,");
						continue;
					}else {
						try {
							practitionerInfo.setPassword(Md5Util.getEncryptedPwd(password));
							memberInfo.setPassword(practitionerInfo.getPassword());
						}catch(Exception e) {
							sb.append("第"+(j+1)+"行信息出错：密码不合法,");
							continue;
						}
					}
					//姓名
					String name = ExcelUtil.formatCell4(row.getCell(2)).trim();
					if(name==null || name=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写姓名信息,");
						continue;
					}else {
						practitionerInfo.setName(name);
						memberInfo.setName(name);
					}
					//手机号
					String tellPhone = ExcelUtil.formatCell4(row.getCell(3)).trim();
					if(tellPhone==null || tellPhone=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写手机号信息,");
						continue;
					}else {
						practitionerInfo.setTellPhone(tellPhone);
						memberInfo.setTellPhone(tellPhone);
					}
					//邮箱
					String email = ExcelUtil.formatCell4(row.getCell(4)).trim();
					if(email==null || email=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写邮箱信息,");
						continue;
					}else {
						practitionerInfo.setEmail(email);
						memberInfo.setEmail(email);
					}
					//证件号码
					String certificateNumber = ExcelUtil.formatCell4(row.getCell(5)).trim();
					if(certificateNumber==null || certificateNumber=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写证件号码信息,");
						continue;
					}else {
						practitionerInfo.setCertificateNumber(certificateNumber);
					}
					//性别
					String sex = ExcelUtil.formatCell4(row.getCell(6)).trim();
					if(certificateNumber==null || certificateNumber=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写性别信息,");
						continue;
					}else {
						practitionerInfo.setSex(Integer.parseInt(sex));
						memberInfo.setSex(Integer.parseInt(sex));
					}
					//省
					String provice = ExcelUtil.formatCell4(row.getCell(7)).trim();
					if(provice==null || provice=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写省信息,");
						continue;
					}else {
						practitionerInfo.setProvice(provice);
						memberInfo.setProvice(provice);
					}
					//市
					String city = ExcelUtil.formatCell4(row.getCell(8)).trim();
					if(provice==null || provice=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写市信息,");
						continue;
					}else {
						practitionerInfo.setCity(city);
						memberInfo.setCity(city);
					}
					//区
					String area = ExcelUtil.formatCell4(row.getCell(9)).trim();
					if(area==null || area=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写区信息,");
						continue;
					}else {
						practitionerInfo.setArea(area);
						memberInfo.setArea(area);
					}
					//详细地址
					String address = ExcelUtil.formatCell4(row.getCell(10)).trim();
					if(address==null || address=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写详细地址信息,");
						continue;
					}else {
						practitionerInfo.setAddress(address);
						memberInfo.setAddress(address);
					}
					//家长/从业者
					String state = ExcelUtil.formatCell4(row.getCell(11)).trim();
					if(state==null || state=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写家长/从业者信息,");
						continue;
					}else {
						practitionerInfo.setType(Integer.parseInt(state));
						if("1".equals(state)) {
							memberInfo.setRoleType(3);
						}else if("2".equals(state)){
							memberInfo.setRoleType(4);
						}
					}
					//是否是个人
					String isIndividual = ExcelUtil.formatCell4(row.getCell(12)).trim();
					if(isIndividual==null || isIndividual=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写是否是个人信息,");
						continue;
					}else {
						practitionerInfo.setIsIndividual(Integer.parseInt(isIndividual));
					}
					//所属单位
					String institutionId = ExcelUtil.formatCell4(row.getCell(13)).trim();
					if(institutionId==null || institutionId=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写所属单位信息,");
						continue;
					}else {
						practitionerInfo.setInstitutionId(Integer.parseInt(institutionId));
					}
					//企业编码
					String enterpriseCode = ExcelUtil.formatCell4(row.getCell(14)).trim();
					if(enterpriseCode==null || enterpriseCode=="") {
						sb.append("第"+(j+1)+"行信息出错：请填写企业编码信息,");
						continue;
					}else {
						practitionerInfo.setEnterpriseCode(enterpriseCode);
					}
					practitionerInfo.setState(1);
					practitionerInfoMapper.insertSelective(practitionerInfo);
					memberInfo.setIsStart(1);//默认启用
					memberInfo.setState(2);//默认已审核
					memberInfo.setRoleId(practitionerInfo.getId());//家长/从业者的id
					memberInfoMapper.insertSelective(memberInfo);
					sbOk.append((j+1)+",");
				}
			}
		}
		if(sbOk.length()>0) {
			result += "成功行号信息："+sbOk.substring(0, sbOk.length()-1)+";";
		}
		if(sb.length()>0) {
			result +="失败行号信息："+sb.substring(0,sb.length()-1);
		}
		if(sbOk.length()==0&&sb.length()==0) {
			return new Result(-1,"文件格式不正确","");
		}else {
			return new Result(0,result,"");
		}
	}
	
	/**
	 * 查询用户信息，用户名，手机号，状态
	 * @param memberInfo
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findMemberNameAndTell(MemberInfo memberInfo) {
		List<MemberCouponInfo> list = memberInfoMapper.selectNameAndTell(memberInfo);
		if(list.size()>0) {
			return new Result(0,"查询成功",list);
		}else {
			return new Result(-1,"查询失败","");
		}
	}
	
	/**
	 * 查询用户信息  返回总个数
	 * @param memberInfo
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findMemberCount(MemberInfo memberInfo) {
		int count = memberInfoMapper.selectNameAndTellCount(memberInfo);
		if(count>0) {
			return new Result(0,"查询成功",count);
		}else {
			return new Result(-1,"查询失败",0);
		}
	}
	
	
	/**
	 * 
	 * @param roleId
	 * @param roleId
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findUserAndCers(Integer roleId,Integer roleType) {
		List<UserAndCerVo> list = memberInfoMapper.selectUserAndCers(roleId, roleType);
		if(list.size()>0) {
			return new Result(0,"查询成功",list);
		}else {
			return new Result(-1,"查询失败",0);
		}
	}
	
	
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findUserAndCerCounts(Integer roleId,Integer roleType) {
		int count  = memberInfoMapper.selectUserAndCerCounts(roleId, roleType);
		if(count>0) {
			return new Result(0,"查询成功",count);
		}else {
			return new Result(-1,"查询失败",0);
		}
	}
}

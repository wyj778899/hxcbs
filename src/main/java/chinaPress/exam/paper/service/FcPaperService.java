package chinaPress.exam.paper.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.DateUtil;
import chinaPress.common.util.ResultUtil;
import chinaPress.exam.exam.dao.FcExamMapper;
import chinaPress.exam.exam.model.FcExam;
import chinaPress.exam.exam_option.dao.FcExamOptionMapper;
import chinaPress.exam.exam_option.vo.ExamStemOption;
import chinaPress.exam.exam_record.dao.FcExamRecordMapper;
import chinaPress.exam.exam_record.model.FcExamRecord;
import chinaPress.exam.paper.dao.FcPaperMapper;
import chinaPress.exam.paper.dao.FcPaperStemMapper;
import chinaPress.exam.paper.model.FcPaper;
import chinaPress.exam.paper.model.FcPaperStem;
import chinaPress.exam.paper.vo.ExamCommentVo;
import chinaPress.exam.paper.vo.PaperQuestionStem;
import chinaPress.exam.paper.vo.PaperStemVo;
import chinaPress.exam.paper.vo.PaperVo;
import chinaPress.exam.paper.vo.PreviewPaperVo;
import chinaPress.fc.question.dao.FcQuestionStemMapper;
import chinaPress.fc.question.model.FcQuestionOption;
import chinaPress.fc.question.vo.QuestionNameVo;
import chinaPress.fc.question.vo.QuestionVo;


@Service
public class FcPaperService {

	/**
	 * 试卷试题关联dao
	 */
	@Autowired
	private FcPaperStemMapper fcPaperStemMapper;
	
	
	/**
	 * 试卷dao
	 */
	@Autowired
	private FcPaperMapper fcPaperMapper;
	
	/**
	 * 试题dao
	 */
	@Autowired
	private FcQuestionStemMapper fcQuestionStemMapper;
	
	/**
	 * 考试考生报名信息
	 */
	@Autowired
	private FcExamRecordMapper fcExamRecordMapper;
	
	/**
	 * 考生考试信息记录表
	 */
	@Autowired
	private FcExamOptionMapper fcExamOptionMapper;
	
	/**
	 * 考试的dao
	 */
	@Autowired 
	private FcExamMapper fcExamMapper;
	
	
	/**
	 * 预览试卷                   试卷信息封装试卷抽取配置信息和试卷的试题信息
	 * 1:用户未创建试卷的情况下预览试卷/用户已经创建试卷的情况下预览试卷
	 * 2:用户id为null随机生成试卷
	 * 3:用户id不为null判断用户的试卷抽取试题配置是否发生改变   改变就重新生成试题,不改变就查库获取原有试题
	 * @param fcPaper
	 * @return
	 */
	@Transactional
	public Result previewPaper(FcPaper fcPaper) {
		//判断预览是由有id   有id的话获取原有数据
		Integer id = fcPaper.getId();
		//试卷名称
		String paperName = fcPaper.getPaperName();
		if(StringUtils.isAllBlank(paperName)) {
			return new Result(0,"试卷名称不能为空","");
		}
		//查询所有试题信息
		List<QuestionVo> fcQuestionStems = null;
		//随机生成的所有试题信息
		List<QuestionVo> resultQuestions = new ArrayList<QuestionVo>();
		//返回抽取试题
		List<QuestionVo> extractResult = null;
		//提交的试卷试题配置信息/数据库试卷试题配置信息
		List<PaperVo> papers =null;
		//每次抽取的试题信息,有不符合的试题信息直接返回
		Result result = null;
		//原来的试卷信息
		FcPaper paper = null;
		//预览的试卷封装对象 
		PreviewPaperVo preview = new PreviewPaperVo();
		try {
			//用户id存在的情况下代表用户已经生成试卷，试卷抽取参数不改变的情况下不生成新的试卷,继续预览原有试卷,改变则生成新的试卷
			if(id!=null) {
				paper = fcPaperMapper.selectByPaperId(id);
			}
			//获取用户的原有参数
			if(paper !=null) {
				//数据库试卷抽取配置信息
				papers = paper.getPapers();
				//数据库试题信息
				extractResult = paper.getQuestions();
				for(PaperVo vo:papers) {
					//根据试题分类，试题难度，试题类型查询试题个数       给抽取个数赋值
					vo.setCount((int)extractResult.stream().filter(stem ->stem.getCatalogId()==vo.getCatalogId() && stem.getQuestionType()==vo.getQuestionType() && stem.getTaskDifficulty()==vo.getTaskDifficulty()).count());
				}
				//比较两个list的属性是否相同  数据发生改变true，没有发生改变false    需要取反
				if(!papers.retainAll(fcPaper.getPapers())) {
					//相同取原有数据
					preview.setGrade(paper.getPaperGrade());
					preview.setRadioQuestions(paper.getQuestions().stream().filter(stem->stem.getQuestionType()==1).collect(Collectors.toList()));
					preview.setRadioGrade(preview.getRadioQuestions().stream().mapToInt(stem->Integer.parseInt(stem.getGrade())).summaryStatistics().getSum()+"");
					preview.setCheckboxQuestions(paper.getQuestions().stream().filter(stem->stem.getQuestionType()==2).collect(Collectors.toList()));
					preview.setCheckboxGrade(preview.getCheckboxQuestions().stream().mapToInt(stem->Integer.parseInt(stem.getGrade())).summaryStatistics().getSum()+"");
					preview.setJudgeQuestions(paper.getQuestions().stream().filter(stem->stem.getQuestionType()==3).collect(Collectors.toList()));
					preview.setJudgeGrade(preview.getJudgeQuestions().stream().mapToInt(stem->Integer.parseInt(stem.getGrade())).summaryStatistics().getSum()+"");
					
					return new Result(1,"ok",preview);
				}
				
			}
			if(fcPaperMapper.selectByPaperName(id, paperName)>0) {
				return new Result(0,"试卷名称不可重复","");
			}
			fcQuestionStems = fcQuestionStemMapper.selectQuestionAll();
			if(fcQuestionStems.size()<1) {
				return new Result(0,"试题无数据","");
			}
			papers = fcPaper.getPapers();
			if(papers!=null && papers.size()>0) {
				for(PaperVo p:papers) {
					if(p.getCatalogId()==null) {
						return new Result(0,"试卷必须关联试题分类","");
					}
					if(p.getTaskDifficulty()==null) {
						return new Result(0,"试卷必须关联试题难度","");
					}
					if(p.getQuestionType()==null) {
						return new Result(0,"试卷必须关联试题类型","");
					}
					if(p.getCount()==null) {
						return new Result(0,"试卷必须关联试题个数","");
					}
					if(p.getGrade()==null) {
						return new Result(0,"试卷必须关联试题分数","");
					}
					//根据条件返回试题信息
					result = getRandomQuestion(fcQuestionStems,p.getCatalogId(),p.getTaskDifficulty(),p.getQuestionType(),p.getCount(),p.getGrade());
					if(result.getCode() == 1) {
						//根据抽取条件给出试题信息
						extractResult = (List<QuestionVo>) result.getData();
						resultQuestions.addAll(extractResult);
					}else {
						return result;
					}
				}
				if(resultQuestions.size()>0) {
					//分数赋值
					preview.setGrade(resultQuestions.stream().mapToInt((s) -> Integer.parseInt(s.getGrade())).summaryStatistics().getSum()+"");
					preview.setRadioQuestions(resultQuestions.stream().filter(stem->stem.getQuestionType()==1).collect(Collectors.toList()));
					preview.setRadioGrade(preview.getRadioQuestions().stream().mapToInt(stem->Integer.parseInt(stem.getGrade())).summaryStatistics().getSum()+"");
					preview.setCheckboxQuestions(resultQuestions.stream().filter(stem->stem.getQuestionType()==2).collect(Collectors.toList()));
					preview.setCheckboxGrade(preview.getCheckboxQuestions().stream().mapToInt(stem->Integer.parseInt(stem.getGrade())).summaryStatistics().getSum()+"");
					preview.setJudgeQuestions(resultQuestions.stream().filter(stem->stem.getQuestionType()==3).collect(Collectors.toList()));
					preview.setJudgeGrade(preview.getJudgeQuestions().stream().mapToInt(stem->Integer.parseInt(stem.getGrade())).summaryStatistics().getSum()+"");
					return ResultUtil.ok(preview);
				}else{
					return ResultUtil.error("试卷预览失败");
				}
			}else {
				return new Result(0,"试卷必须关联试题","");
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	/**
	 * 随机抽取试题    参数不可为null
	 * @param list            所有试题
	 * @param catalogId       试题分类 
	 * @param taskDifficulty  试题难度 1.简单2.一般3.困难
	 * @param questionType    试题类型 1.单选2.多选3.判断
	 * @param count           个数
	 * @return
	 */
	 @Transactional
	 private Result getRandomQuestion(List<QuestionVo> list,Integer catalogId,Integer taskDifficulty,Integer questionType,Integer count,String grade){
		 if(count == 0) {
			 return new Result(0,"试题抽取个数不能为0","");
		 }
		 //返回的试题
		 List<QuestionVo> result = new ArrayList<QuestionVo>();
		 QuestionNameVo vo = fcQuestionStemMapper.selectQuestionNameInfo(catalogId, questionType, taskDifficulty);
    	 if(vo==null) {
    		 return new Result(0,"无试题信息",""); 
    	 }
    	 //例子:考试分类下试题难度为简单类型,试题类型为单选题类型的试题个数不足,最大抽取范围为10
    	 String str = vo.getCatalogName()+"分类下试题难度为"+vo.getTaskDifficultyName()+"类型，试题类型为"+vo.getQuestionTypeName()+"题类型的试题个数不足，最大抽取范围为"+vo.getCount();
		 //满足抽取条件的试题
		 List<QuestionVo> questions =list.stream().filter(stem->stem.getCatalogId()==catalogId && stem.getTaskDifficulty()==taskDifficulty && stem.getQuestionType()==questionType).collect(Collectors.toList());
	     if(count>questions.size()) {
	    	 return new Result(0,str,""); 
	     }  
	     Random random = new Random();
	     for (int i = 0; i < count; i++) {
    	 	//随机数的范围为0-list.size()-1
            int target = random.nextInt(questions.size());
            questions.get(target).setGrade(grade);//分数赋值
            result.add(questions.get(target));
            questions.remove(target);
	     }	
		 return new Result(1,"组卷成功",result);
	 }
	
	/**
	 * 试卷添加               
	 * 1:试卷不预览的情况可以生成试卷      试卷没有预览没有生成试卷试题关联数据             
	 * 	  需要校验前台传来的试题关联信息List<PaperVo> papers 试题分类，试题难度，试题类型，试题分数，抽取个数
	 * 2:试卷预览的情况下也可以生成试卷    此时的试题信息已经生成，校验 List<QuestionVo> questions   试题id，试题名称，试题难度，试题类型，试题分类，试题分数
	 * @param fcPaper
	 * @return
	 */
	@Transactional
	public Result addPaper(FcPaper fcPaper) {
		//查询所有试题信息
		List<QuestionVo> fcQuestionStems = null;
		//试卷名称
		String paperName = fcPaper.getPaperName();
		List<QuestionVo> questions = null;//试题信息
		List<PaperVo> papers = null;//试题关联试卷信息
		//所有抽取的试题汇总
		List<QuestionVo> resultQuestions = new ArrayList<QuestionVo>();
		//返回抽取试题
		List<QuestionVo> extractResult = null;
		Result result = new Result();
		if(StringUtils.isAllBlank(paperName)) {
			return new Result(0,"试卷名称不能为空","");
		}
		try {
			if(fcPaperMapper.selectByPaperName(null, paperName)>0) {
				return new Result(0,"试卷名称不可重复","");
			}
			//获取试题信息
			questions = fcPaper.getQuestions();
			if(questions!=null && questions.size()>0) {
				// 试题个数赋值
				fcPaper.setCount(questions.size());
				//分数赋值
				fcPaper.setPaperGrade(questions.stream().mapToInt((s) -> Integer.parseInt(s.getGrade())).summaryStatistics().getSum()+"");
				fcPaperMapper.insertSelective(fcPaper);
				for(QuestionVo vo:questions) {
					FcPaperStem stem  = new FcPaperStem();
					stem.setStemId(vo.getId());//试题id
					stem.setPaperId(fcPaper.getId());//试卷id
					stem.setUseGrade(vo.getGrade());//试题分数
					fcPaperStemMapper.insertSelective(stem);
				}
				return new Result(1,"试卷添加成功","");
			}else {//此时没有生成试题信息需要生成试题信息执行添加操作
				//获取所有试题
				fcQuestionStems = fcQuestionStemMapper.selectQuestionAll();
				if(fcQuestionStems.size()<1) {
					return new Result(0,"试题无数据","");
				}
				//试卷试题关联信息
				papers = fcPaper.getPapers();
				if(papers!=null && papers.size()>0) {
					for(PaperVo p:papers) {
						if(p.getCatalogId()==null) {
							return new Result(0,"试卷必须关联试题分类","");
						}
						if(p.getTaskDifficulty()==null) {
							return new Result(0,"试卷必须关联试题难度","");
						}
						if(p.getQuestionType()==null) {
							return new Result(0,"试卷必须关联试题类型","");
						}
						if(p.getCount()==null) {
							return new Result(0,"试卷必须关联试题个数","");
						}
						if(p.getGrade()==null) {
							return new Result(0,"试卷必须关联试题分数","");
						}
						//根据条件返回试题信息
						result = getRandomQuestion(fcQuestionStems,p.getCatalogId(),p.getTaskDifficulty(),p.getQuestionType(),p.getCount(),p.getGrade());
						if(result.getCode() == 1) {
							//根据抽取条件给出试题信息
							extractResult = (List<QuestionVo>) result.getData();
							resultQuestions.addAll(extractResult);
						}else {
							return result;
						}
					}
					// 试题个数赋值
					fcPaper.setCount(fcQuestionStems.size());
					//分数赋值
					fcPaper.setPaperGrade(resultQuestions.stream().mapToInt((s) -> Integer.parseInt(s.getGrade())).summaryStatistics().getSum()+"");
					fcPaperMapper.insertSelective(fcPaper);
					for(QuestionVo v :resultQuestions) {
						FcPaperStem paperStem  = new FcPaperStem();
						paperStem.setStemId(v.getId());//试题id
						paperStem.setPaperId(fcPaper.getId());//试卷id
						paperStem.setUseGrade(v.getGrade());//试题分数
						fcPaperStemMapper.insertSelective(paperStem);
					}
					return new Result(1,"试卷添加成功","");
				}else {
					return new Result(0,"试卷必须关联试题","");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	} 
	
	/**
	 * 更新试卷
	 * @param fcPaper
	 * @return
	 */
	public Result setPaper(FcPaper fcPaper) {
		//试卷id
		Integer id = fcPaper.getId();
		if(id == null) {
			return new Result(0,"试卷信息有误","");
		}
		String paperName = fcPaper.getPaperName();//试卷名称
		List<QuestionVo> questions = null;//试题信息
		List<PaperVo> pv = null;//试卷的抽取信息
		FcPaper paper = null;//数据库的试卷对象
		//查询所有试题信息
		List<QuestionVo> fcQuestionStems = null;
		//所有抽取的试题汇总
		List<QuestionVo> resultQuestions = null;
		Result result = null;
		try{
			//有考试引用就不可以修改
			if(fcPaperMapper.selectExamPaperId(id)>0) {
				return new Result(0,"此试卷已关联考试,不可以修改","");
			}
			if(StringUtils.isAllBlank(paperName)) {
				return new Result(0,"试卷名称不能为空","");
			}
			if(StringUtils.isAllBlank(paperName) && fcPaperMapper.selectByPaperName(id, paperName)>0) {
				return new Result(0,"试卷名称不可重复","");
			}
			paper = fcPaperMapper.selectByPaperId(id);//数据库的试卷信息
			if(paper == null) {
				return new Result(0,"试卷信息更新出错","");
			}
			pv = paper.getPapers();//数据库试卷抽取配置信息
			questions = paper.getQuestions();//数据库试卷试题信息
			if(pv==null || pv.size()==0) {
				return new Result(0,"试卷关联试题信息出错","");
			}
			for(PaperVo vo:pv) {
				//根据试题分类，试题难度，试题类型查询试题个数       给抽取个数赋值
				vo.setCount((int)questions.stream().filter(stem ->stem.getCatalogId()==vo.getCatalogId() && stem.getQuestionType()==vo.getQuestionType() && stem.getTaskDifficulty()==vo.getTaskDifficulty()).count());
			}
			//如果试卷的抽取规则没有改变就只修改试卷的信息
			if(fcPaper.getPapers()!=null && !pv.retainAll(fcPaper.getPapers())) {
				fcPaperMapper.updateByPrimaryKeySelective(fcPaper);
				return new Result(1,"修改成功","");
			}
			//此时二次给试题信息赋值,是前台传过来的试题信息
			questions = fcPaper.getQuestions();
			//试题信息不为空直接更新  代表预览后保存
			if(questions!=null && questions.size()>0) {
				// 试题个数赋值
				fcPaper.setCount(questions.size());
				//试卷分数赋值
				fcPaper.setPaperGrade(questions.stream().mapToInt((s) -> Integer.parseInt(s.getGrade())).summaryStatistics().getSum()+"");
				//试卷更新
				//删除试卷试题关联
				fcPaperStemMapper.deleteByPaperId(id);
				//试卷试题关联更新
				if(questions!=null && questions.size()>0) {
					for(QuestionVo vo:questions) {
						FcPaperStem stem  = new FcPaperStem();
						stem.setStemId(vo.getId());//试题id
						stem.setPaperId(fcPaper.getId());//试卷id
						stem.setUseGrade(vo.getGrade());//试题分数
						fcPaperStemMapper.insertSelective(stem);
					}
				}
				fcPaperMapper.updateByPrimaryKeySelective(fcPaper);
				return new Result(1,"试卷修改成功","");
			}else {
				resultQuestions = new ArrayList<QuestionVo>();
				//试题信息为空重新生成试题
				fcQuestionStems = fcQuestionStemMapper.selectQuestionAll();//所有试题信息
				pv = fcPaper.getPapers();//前端页面传来的试卷抽取配置
				for(PaperVo p:pv) {
					result = getRandomQuestion(fcQuestionStems,p.getCatalogId(),p.getTaskDifficulty(),p.getQuestionType(),p.getCount(),p.getGrade());
					if(result.getCode() == 1) {
						//根据抽取条件给出试题信息
						resultQuestions.addAll((List<QuestionVo>) result.getData());
					}else {
						return result;
					}
				}
				//每次更新试卷试题关联时删除原有关联创建新关联
				fcPaperStemMapper.deleteByPaperId(id);
				for(QuestionVo vo:resultQuestions) {
					FcPaperStem stem  = new FcPaperStem();
					stem.setStemId(vo.getId());//试题id
					stem.setPaperId(fcPaper.getId());//试卷id
					stem.setUseGrade(vo.getGrade());//试题分数
					fcPaperStemMapper.insertSelective(stem);
				}
				// 试题个数赋值
				fcPaper.setCount(resultQuestions.size());
				fcPaperMapper.updateByPrimaryKeySelective(fcPaper);
				return new Result(1,"试卷修改成功","");
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	/**
	 * 删除试卷信息
	 * @param fcPaper
	 * @return
	 */
	public Result deletePaper(Integer id) {
		if(id==null) {
			return new Result(0,"试卷信息出错","");
		}
		FcPaper fcPaper = new FcPaper();
		try {
			//有考试引用就不可以修改
			if(fcPaperMapper.selectExamPaperId(id)>0) {
				return new Result(0,"此试卷已关联考试,不可以修改","");
			}
			fcPaper = fcPaperMapper.selectByPaperId(id);
			if(fcPaper==null) {
				return new Result(0,"试卷信息出错","");
			}
			//试卷试题关联删除
			fcPaperStemMapper.deleteByPaperId(id);
			//试卷删除
			fcPaperMapper.deleteByPrimaryKey(id);
			return new Result(1,"试卷删除成功","");
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	
	/**
	 * 试卷id查询试卷信息          
	 * @param id
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findById(Integer id) {
		try {
			FcPaper fcPaper = fcPaperMapper.selectByPaperId(id);
			if(fcPaper!=null) {
				//试卷抽取配置信息
				List<PaperVo> papers = fcPaper.getPapers();
				//试题信息
				List<QuestionVo> questions = fcPaper.getQuestions();
				fcPaper.setCount(questions.size());//试题个数赋值
				for(PaperVo vo:papers) {
					//根据试题分类，试题难度，试题类型查询试题个数       给抽取个数赋值
					vo.setCount((int)questions.stream().filter(stem ->stem.getCatalogId()==vo.getCatalogId() && stem.getQuestionType()==vo.getQuestionType() && stem.getTaskDifficulty()==vo.getTaskDifficulty()).count());
				}
				return new Result(1,"查询成功",fcPaper);
			}else {
				return new Result(0,"试卷信息出错","");
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	
	/**
	 * 试卷信息
	 * @param paperName
	 * @param page
	 * @param limit
	 * @return
	 */
	public Result findPaperLikeName(String paperName,Integer paperCatalog,Integer page,Integer limit) {
		try {
			List<PaperStemVo> paperStems = fcPaperMapper.selectPaperLikeName(paperName,paperCatalog, page, limit);
			return new Result(1,"ok",paperStems);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	
	/**
	 * 试卷信息个数
	 * @param paperName
	 * @return
	 */
	public Result findPaperLikeNameCount(String paperName,Integer paperCatalog) {
		try {
			int count = fcPaperMapper.selectPaperLikeNameCount(paperName,paperCatalog);
			return new Result(1,"ok",count);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	
	/**
	 * 查询考试信息 
	 * @param examId
	 * @param userId
	 * @param flag    是否显示答案
	 * @return
	 * -2:考试已结束
	 * -1:系统错误
	 * 0:无数据
	 * 1:返回考试试卷信息
	 * 2:考试未开始返回考试开始秒数
	 * 
	 * 获取考试信息流程
	 * 1:考试id判断考试是否已结束
	 * 2:用户id判断用户已经答过的试题再次登录进行回显
	 */
	public Result findByExamId(Integer examId,Integer userId,Integer flag) {
		if(examId == null) {
			return new Result(0,"考试信息出错","");
		}
		try {
			PaperQuestionStem stem = fcPaperMapper.selectExamById(examId, flag);
			if(stem!=null) {
					//计算考试开始到当前时间还有多少秒
					long time = DateUtil.getDatePoorMinute(stem.getStartTime(),new Date(),Calendar.SECOND);
					if(time<0) {
						return new Result(2,"ok",time);
					}
					//计算考试一共需要多少秒
					long stamp = DateUtil.getDatePoorMinute(stem.getStartTime(),stem.getEndTime(),Calendar.SECOND);
					//如果当前时间减去考试开始时间还是大于考试时间代表考试已结束
					if(time>stamp) {
						return new Result(-2,"考试已结束","");
					}
					if(stem.getType()!=null && stem.getType().intValue()==2) {
						Collections.shuffle(stem.getQuestions());
					}
					stem.setRadioQuestions(stem.getQuestions().stream().filter(q->q.getQuestionType()==1).collect(Collectors.toList()));
					stem.setCheckboxQuestions(stem.getQuestions().stream().filter(q->q.getQuestionType()==2).collect(Collectors.toList()));
					stem.setJudgeQuestions(stem.getQuestions().stream().filter(q->q.getQuestionType()==3).collect(Collectors.toList()));
					stem.setRadioGrade(stem.getRadioQuestions().stream().mapToInt(q->Integer.parseInt(q.getGrade())).summaryStatistics().getSum()+"");
					stem.setCheckboxGrade(stem.getCheckboxQuestions().stream().mapToInt(q->Integer.parseInt(q.getGrade())).summaryStatistics().getSum()+"");
					stem.setJudgeGrade(stem.getJudgeQuestions().stream().mapToInt(q->Integer.parseInt(q.getGrade())).summaryStatistics().getSum()+"");
					//判断用户是否中断考试，回显已保存的考试信息
					if(userId!=null) {
						List<ExamStemOption> stemOption = fcExamOptionMapper.selectExamStemOption(examId, userId);
						if(stemOption!=null && stemOption.size()>0) {
							for(ExamStemOption item:stemOption) {//考试已经答过的试题信息
								//单选
								for(QuestionVo vo:stem.getRadioQuestions()) {//考试展示的试题信息
									if(item.getStemId().intValue()==vo.getId().intValue()) {//匹配id
										for(FcQuestionOption option:vo.getOptions()) {//答案信息
											for(String s:item.getOptionId().split(",")) {//已选的答案信息
												if(s!=null && s!="") {//已选择的答案信息不为null
													if(s.equals(option.getId()+"")) {//并且等于答案的id
														option.setState(1);//给state赋值代表此试题已选择
													}
												}
											}
										}
									}
								}
								//多选
								for(QuestionVo vo:stem.getCheckboxQuestions()) {//考试展示的试题信息
									if(item.getStemId().intValue()==vo.getId().intValue()) {//匹配id
										for(FcQuestionOption option:vo.getOptions()) {//答案信息
											for(String s:item.getOptionId().split(",")) {//已选的答案信息
												if(s!=null && s!="") {//已选择的答案信息不为null
													if(s.equals(option.getId()+"")) {//并且等于答案的id
														option.setState(1);//给state赋值代表此试题已选择
													}
												}
											}
										}
									}
								}
								//判断
								for(QuestionVo vo:stem.getJudgeQuestions()) {//考试展示的试题信息
									if(item.getStemId().intValue()==vo.getId().intValue()) {//匹配id
										for(FcQuestionOption option:vo.getOptions()) {//答案信息
											for(String s:item.getOptionId().split(",")) {//已选的答案信息
												if(s!=null && s!="") {//已选择的答案信息不为null
													if(s.equals(option.getId()+"")) {//并且等于答案的id
														option.setState(1);//给state赋值代表此试题已选择
													}
												}
											}
										}
									}
								}
							}
						}
					}
					//计算当前时间距离考试结束还有多长时间
					long countDown = DateUtil.getDatePoorMinute(new Date(),stem.getEndTime(),Calendar.SECOND);
					stem.setCountDown(countDown);
					return new Result(1,"ok",stem);
			}else {
				return new Result(0,"无数据","");
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(-1,"系统错误","");
		}
	}
	
	/**
	 * @param examId考试id
	 * @return
	 * 流程:
	 * 1:考试id获取考试及格分数
	 * 2:考试id和考生id获取考生的考试答题记录
	 * 3:通过考生的答案记录表计算考生分数信息
	 */
	public Result findStemOptions(Integer examId,Integer signupId,Integer signupAreaId,Integer signupUserId) {
		FcExam exam = null;//考试信息
		ExamCommentVo comment = null;//评语信息
		int grade = 0;//考生得分
		FcExamRecord rdcord = new FcExamRecord(); //返回信息
		try {
			//查询考试信息
			exam = fcExamMapper.selectByPrimaryKey(examId);
			grade = fcExamOptionMapper.selectExamGrade(examId, signupUserId);
			comment = new ExamCommentVo();
			if(grade>=Integer.parseInt(exam.getGrade())) {
				comment.setComment(exam.getPassComment());
			}else {
				comment.setComment(exam.getFailComment());
			}
			comment.setGrade(grade+"");
			rdcord.setExamId(examId);
			rdcord.setExamSignupId(signupId);
			rdcord.setExamSignupAreaId(signupAreaId);
			rdcord.setGrade(new BigDecimal(grade));
			rdcord.setSignupUserId(signupUserId);
			rdcord.setCompleteTime(new Date());
			//添加考生考试记录表
			fcExamRecordMapper.insertSelective(rdcord);
			return new Result(1,"ok",comment);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
}

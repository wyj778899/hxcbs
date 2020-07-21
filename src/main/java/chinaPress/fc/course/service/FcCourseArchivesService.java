package chinaPress.fc.course.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.util.DateUtil;
import chinaPress.common.util.JacksonUtil;
import chinaPress.fc.book.dao.FcCourseBookMapper;
import chinaPress.fc.book.vo.FcCourseBookVo;
import chinaPress.fc.course.dao.FcCourseArchivesMapper;
import chinaPress.fc.course.model.FcCourseArchives;
import chinaPress.fc.course.util.FcCourseSectionTreeUtil;
import chinaPress.fc.course.vo.CourseArchivesNewVo;
import chinaPress.fc.course.vo.CourseArchivesParam;
import chinaPress.fc.course.vo.CourseArchivesVo;
import chinaPress.fc.course.vo.PageIndexCourseVo;
import chinaPress.fc.course_section.dao.FcCourseHourMapper;
import chinaPress.fc.course_section.dao.FcCourseSectionMapper;
import chinaPress.fc.course_section.model.FcCourseHour;
import chinaPress.fc.course_section.model.FcCourseSection;
import chinaPress.fc.course_section.vo.FcCourseHourVo;
import chinaPress.fc.course_section.vo.FcCourseSectionVo;
import chinaPress.fc.order.dao.FcOrderMapper;
import chinaPress.fc.order.dao.FcOrderPersonHourMapper;
import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.model.FcOrderPersonHour;
import chinaPress.fc.order.service.FcOrderPersonService;
import chinaPress.fc.question.dao.FcQuestionOptionMapper;
import chinaPress.fc.question.dao.FcQuestionStemMapper;
import chinaPress.fc.question.model.FcQuestionOption;
import chinaPress.fc.question.model.FcQuestionStem;

@Service
public class FcCourseArchivesService {
	@Autowired
	private FcCourseArchivesMapper fcCourseArchivesMapper;
	@Autowired
	private FcCourseSectionMapper fcCourseSectionMapper;
	@Autowired
	private FcCourseHourMapper fcCourseHourMapper;
	@Autowired
	private FcQuestionStemMapper fcQuestionStemMapper;
	@Autowired
	private FcQuestionOptionMapper fcQuestionOptionMapper;
	@Autowired
	private FcCourseBookMapper fcCourseBookMapper;
	@Autowired
	private FcOrderPersonHourMapper fcOrderPersonHourMapper;
	@Autowired
	private FcOrderMapper fcOrderMapper;
	@Autowired
	private FcOrderPersonService fcOrderPersonService;

	/**
	 * 根据分类id查询关联课程
	 * 
	 * @param categoryId 课程分类id
	 * @param roleId     角色id
	 * @param roleType   角色类型
	 * @return
	 */
	public List<CourseArchivesNewVo> selectCourseByCategoryId(Integer categoryId, Integer roleId, Integer roleType) {
		List<CourseArchivesNewVo> data = fcCourseArchivesMapper.selectCourseByCategoryId(categoryId);
		if (data.size() > 0) {
			for (CourseArchivesNewVo item : data) {
				int count = fcCourseHourMapper.selectCourseHourCountByCOurseId(item.getId());
				if (count > 0) {
					item.setCourseCount(count);
				} else {
					item.setCourseCount(0);
				}
				// 判断当前这个课程当前报名人是否正在学习中
				if (roleId != null && roleType != null && (roleType == 3 || roleType == 4)) {
					FcOrder fcOrder = fcOrderMapper.selectCourseIsLearning(roleId,
							roleType == 3 ? 1 : (roleType == 4 ? 2 : 0), item.getId());
					if (fcOrder != null) {
						item.setIsLearning(1);
					} else {
						item.setIsLearning(0);
					}
					// 判断当前这个课程当前报名人正在学习中的课时id
					Integer fcOrderPersonHour = fcOrderPersonHourMapper.selectTheNewestHour(item.getId(), roleId,
							roleType == 3 ? 1 : (roleType == 4 ? 2 : 0));
					item.setLearningHourId(fcOrderPersonHour);
				} else {
					item.setIsLearning(0);
				}
			}
		}
		return data;
	}

	/**
	 * 查询课程详情
	 * 
	 * @param id       课程id
	 * @param roleId   当前登录角色id
	 * @param roleType 当前登录角色类型
	 * @return
	 */
	public CourseArchivesNewVo selectCourseArchivesById(Integer id, Integer roleId, Integer roleType) {
		CourseArchivesNewVo data = fcCourseArchivesMapper.selectCourseArchivesById(id);
		if (data != null) {
			int count = fcCourseHourMapper.selectCourseHourCountByCOurseId(id);
			if (count > 0) {
				data.setCourseCount(count);
			} else {
				data.setCourseCount(0);
			}
			List<FcCourseSectionVo> list = fcCourseSectionMapper.selectCourseSectionList(data.getId());
			if (list.size() > 0) {
				for (FcCourseSectionVo fcCourseSectionVo : list) {
					// 该章节视频是否看过
					if (roleId != null && roleType != null && (roleType == 3 || roleType == 4)) {
						List<FcCourseHourVo> courseSectionHourList = fcCourseHourMapper
								.selectCourseHourListBySectionId(fcCourseSectionVo.getId());
						if (courseSectionHourList.size() > 0) {
							// 查询 当前角色 针对于当前课程的选择的课时是否看过/考过
							int index = fcOrderPersonService.findPersonHourIsPass(roleId,
									roleType == 3 ? 1 : (roleType == 4 ? 2 : null), id,
									courseSectionHourList.get(0).getId());
							// 看完视频且通过小节测试了
							if (index == 1) {
								fcCourseSectionVo.setIsWatch(1);
							}
							// 看完视频但未通过小节测试
							else if (index == 2) {
								fcCourseSectionVo.setIsWatch(1);
							}
							// 视频还未看完，正在学习
							else if (index == 0) {
								fcCourseSectionVo.setIsWatch(0);
							}
							// 看完视频从未考过小节测试
							else if (index == 3) {
								fcCourseSectionVo.setIsWatch(1);
							}
							// 暂无视频
							else {
								fcCourseSectionVo.setIsWatch(0);
							}
						} else {
							fcCourseSectionVo.setIsWatch(0);
						}
					}
					// 该章节视频是否有小节题目
					List<FcQuestionStem> fcQuestionStemList = fcQuestionStemMapper.selectIsHaveStem(id,
							fcCourseSectionVo.getId());
					if (fcQuestionStemList.size() > 0) {
						fcCourseSectionVo.setIsHaveQuestion(1);
					} else {
						fcCourseSectionVo.setIsHaveQuestion(0);
					}
				}
				data.setSectionList(FcCourseSectionTreeUtil.buildByRecursive(list));
			}
			// 查询相关推荐书籍
			List<FcCourseBookVo> bookList = fcCourseBookMapper.selectFcCourseAboutBook(id);
			data.setBookList(bookList);
			// 查询该课程学习进度
			Date firstPassTime = fcOrderPersonHourMapper.selectCourseFirstPassTime(id, roleId, roleType == 3 ? 1 : (roleType == 4 ? 2 : 0));
			if (firstPassTime == null) {
				data.setStudyDay(0);
			} else {
				data.setStudyDay(DateUtil.getLongOfTwoDate(firstPassTime, new Date()));
			}
			// 判断当前这个课程当前报名人是否正在学习中
			if (roleId != null && roleType != null  && (roleType == 3 || roleType == 4)) {
				FcOrder fcOrder = fcOrderMapper.selectCourseIsLearning(roleId,
						roleType == 3 ? 1 : (roleType == 4 ? 2 : 0), id);
				if (fcOrder != null) {
					data.setIsLearning(1);
				} else {
					data.setIsLearning(0);
				}
			} else {
				data.setIsLearning(0);
			}
			// 判断当前这个课程当前报名人正在学习中的课时id
			if (roleId != null && roleType != null && (roleType == 3 || roleType == 4)) {
				Integer fcOrderPersonHour = fcOrderPersonHourMapper.selectTheNewestHour(id, roleId,
						roleType == 3 ? 1 : (roleType == 4 ? 2 : 0));
				data.setLearningHourId(fcOrderPersonHour);
			}
		}
		return data;
	}

	/**
	 * 查询首页随机5条课程
	 * 
	 * @return
	 */
	public List<PageIndexCourseVo> selectPageIndexCourse() {
		return fcCourseArchivesMapper.selectPageIndexCourse();
	}

	/**
	 * 查询课程列表
	 * 
	 * @param record
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<CourseArchivesVo> selectCOurseArchivesList(CourseArchivesParam record, Integer pageNumber,
			Integer pageSize) {
		return fcCourseArchivesMapper.selectCOurseArchivesList(record, pageNumber * pageSize - pageSize, pageSize);
	}

	/**
	 * 查询课程数量
	 * 
	 * @param record
	 * @return
	 */
	public int selectCourseArchivesCount(CourseArchivesParam record) {
		return fcCourseArchivesMapper.selectCourseArchivesCount(record);
	}

	/**
	 * 新增课程
	 * 
	 * @param record
	 * @param section
	 * @param hour
	 * @return
	 */
	@Transactional
	public int insertCourseArchives(FcCourseArchives record, String section) {
		// 新增课程
		int index = fcCourseArchivesMapper.insertSelective(record);
		if (index > 0) {
			List<FcCourseSection> sectionList = JacksonUtil.fromJSONList(section, FcCourseSection.class);
			if (sectionList.size() > 0) {
				for (FcCourseSection item : sectionList) {
					item.setCourseId(record.getId());
					// 新增课程章节
					int indexs = fcCourseSectionMapper.insertSelective(item);
					if (indexs > 0) {
						if (item.getSectionList().size() > 0) {
							for (FcCourseSection items : item.getSectionList()) {
								items.setPid(item.getId());
								item.setCourseId(record.getId());
								// 新增章节
								int indexss = fcCourseSectionMapper.insertSelective(items);
								if (indexss > 0) {
									if (items.getHourList().size() > 0) {
										for (FcCourseHour hour : items.getHourList()) {
											hour.setSectionId(items.getId());
											// 新增课时
											int indexHour = fcCourseHourMapper.insertSelective(hour);
											if (indexHour > 0) {
												if (hour.getStemList().size() > 0) {
													for (FcQuestionStem stem : hour.getStemList()) {
														stem.setCourseId(record.getId());
														stem.setHourId(hour.getId());
														// 新增课时关联题干
														int stemIndex = fcQuestionStemMapper.insertSelective(stem);
														if (stemIndex > 0) {
															if (stem.getOptionList().size() > 0) {
																for (FcQuestionOption option : stem.getOptionList()) {
																	option.setStemId(stem.getId());
																	// 新增题干关联选项
																	fcQuestionOptionMapper.insertSelective(option);
																}
															}
														}
													}
												}
											}
										}
									}
								}

							}
						}
					}
				}
			}
		}
		return index;
	}

	/**
	 * 上下架
	 * 
	 * @param record
	 * @return
	 */
	public int updateCourseArchivesStatus(FcCourseArchives record) {
		return fcCourseArchivesMapper.updateByPrimaryKeySelective(record);
	}

}

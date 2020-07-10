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
import chinaPress.fc.course_section.vo.FcCourseSectionVo;
import chinaPress.fc.order.dao.FcOrderPersonHourMapper;
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

	/**
	 * 根据分类id查询关联课程
	 * 
	 * @param categoryId
	 * @return
	 */
	public List<CourseArchivesNewVo> selectCourseByCategoryId(Integer categoryId) {
		List<CourseArchivesNewVo> data = fcCourseArchivesMapper.selectCourseByCategoryId(categoryId);
		if (data.size() > 0) {
			for (CourseArchivesNewVo item : data) {
				int count = fcCourseHourMapper.selectCourseHourCountByCOurseId(item.getId());
				if (count > 0) {
					item.setCourseCount(count);
				} else {
					item.setCourseCount(0);
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
					List<FcQuestionStem> fcQuestionStemList = fcQuestionStemMapper.selectIsHaveStem(id, fcCourseSectionVo.getId());
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
			Date firstPassTime = fcOrderPersonHourMapper.selectCourseFirstPassTime(id, roleId, roleType);
			if (firstPassTime == null) {
				data.setStudyDay(0);
			} else {
				data.setStudyDay(DateUtil.getLongOfTwoDate(firstPassTime, new Date()));
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

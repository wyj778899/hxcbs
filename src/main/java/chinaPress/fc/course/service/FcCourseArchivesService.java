package chinaPress.fc.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.util.JacksonUtil;
import chinaPress.fc.course.dao.FcCourseArchivesMapper;
import chinaPress.fc.course.model.FcCourseArchives;
import chinaPress.fc.course.vo.CourseArchivesParam;
import chinaPress.fc.course.vo.CourseArchivesVo;
import chinaPress.fc.course_section.dao.FcCourseHourMapper;
import chinaPress.fc.course_section.dao.FcCourseSectionMapper;
import chinaPress.fc.course_section.model.FcCourseHour;
import chinaPress.fc.course_section.model.FcCourseSection;
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
	/**
	 * 查询课程列表
	 * @param record
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public List<CourseArchivesVo> selectCOurseArchivesList(CourseArchivesParam record,Integer pageNumber,
			Integer pageSize){
		return fcCourseArchivesMapper.selectCOurseArchivesList(record, pageNumber * pageSize -pageSize, pageSize);
	}
	
	/**
	 * 查询课程数量
	 * @param record
	 * @return
	 */
	public int selectCourseArchivesCount(CourseArchivesParam record) {
		return fcCourseArchivesMapper.selectCourseArchivesCount(record);
	}
	
	/**
	 * 新增课程
	 * @param record
	 * @param section
	 * @param hour
	 * @return
	 */
	@Transactional
	public int insertCourseArchives(FcCourseArchives record,String section) {
		//新增课程
		int index = fcCourseArchivesMapper.insertSelective(record);
		if(index>0) {
			List<FcCourseSection> sectionList = JacksonUtil.fromJSONList(section, FcCourseSection.class);
			if(sectionList.size()>0) {
				for (FcCourseSection item : sectionList) {
					item.setCourseId(record.getId());
					//新增课程章节
					int indexs = fcCourseSectionMapper.insertSelective(item);
					if(indexs>0) {
						if(item.getSectionList().size()>0) {
							for (FcCourseSection items : item.getSectionList()) {
								items.setPid(item.getId());
								item.setCourseId(record.getId());
								//新增章节
								int indexss = fcCourseSectionMapper.insertSelective(items);
								if(indexss>0) {
									if(items.getHourList().size()>0) {
										for (FcCourseHour hour : items.getHourList()) {
											hour.setSectionId(items.getId());
											//新增课时
											int indexHour = fcCourseHourMapper.insertSelective(hour);
											if(indexHour>0) {
												if(hour.getStemList().size()>0) {
													for (FcQuestionStem stem : hour.getStemList()) {
														stem.setCourseId(record.getId());
														stem.setHourId(hour.getId());
														//新增课时关联题干
														int stemIndex = fcQuestionStemMapper.insertSelective(stem);
														if(stemIndex>0) {
															if(stem.getOptionList().size()>0) {
																for (FcQuestionOption option : stem.getOptionList()) {
																	option.setStemId(stem.getId());
																	//新增题干关联选项
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
	 * @param record
	 * @return
	 */
	public int updateCourseArchivesStatus(FcCourseArchives record) {
		return fcCourseArchivesMapper.updateByPrimaryKeySelective(record);
	}

}

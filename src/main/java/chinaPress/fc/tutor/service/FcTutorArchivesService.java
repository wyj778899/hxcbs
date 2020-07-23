package chinaPress.fc.tutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.tutor.dao.FcTutorArchivesMapper;
import chinaPress.fc.tutor.model.FcTutorArchives;
import chinaPress.fc.tutor.vo.FcTurorArchivesManageDetailVo;
import chinaPress.fc.tutor.vo.FcTurorArchivesManageListVo;

@Service
public class FcTutorArchivesService {
	@Autowired
	private FcTutorArchivesMapper fcTutorArchivesMapper;

	/**
	 * 查询导师档案个数
	 * 
	 * @author maguoliang
	 * @param name 导师姓名
	 * @return
	 */
	public int selectFcTutorArchivesCount(String name) {
		return fcTutorArchivesMapper.selectFcTutorArchivesCount(name);
	}

	/**
	 * 查询导师档案列表
	 * 
	 * @author maguoliang
	 * @param name       导师姓名
	 * @param pageNumber 第几页
	 * @param pageSize   每页查询多少条
	 * @return
	 */
	public List<FcTurorArchivesManageListVo> selectFcTutorArchivesList(String name, Integer pageNumber,
			Integer pageSize) {
		return fcTutorArchivesMapper.selectFcTutorArchivesList(name, pageNumber * pageSize - pageSize, pageSize);
	}

	/**
	 * 新增教师档案
	 * 
	 * @author maguoliang
	 * @param record
	 * @return
	 */
	public int addFcTutorArchives(FcTutorArchives record) {
		return fcTutorArchivesMapper.insertSelective(record);
	}

	/**
	 * 修改教师档案
	 * 
	 * @author maguoliang
	 * @param record
	 * @return
	 */
	public int updateFcTutorArchives(FcTutorArchives record) {
		return fcTutorArchivesMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 查询详情
	 * 
	 * @author maguoliang
	 * @param id
	 * @return
	 */
	public FcTurorArchivesManageDetailVo selectFcTutorArchivesDetail(Integer id) {
		return fcTutorArchivesMapper.selectFcTutorArchivesDetail(id);
	}
}

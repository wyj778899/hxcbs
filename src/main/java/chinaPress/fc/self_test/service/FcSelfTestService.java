package chinaPress.fc.self_test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.util.JacksonUtil;
import chinaPress.fc.self_test.dao.FcSelfTestMapper;
import chinaPress.fc.self_test.dao.FcSelfTestStemMapper;
import chinaPress.fc.self_test.dao.FcSelfTestStemOptionMapper;
import chinaPress.fc.self_test.model.FcSelfTest;
import chinaPress.fc.self_test.model.FcSelfTestStem;
import chinaPress.fc.self_test.vo.FcSelfTestDetailVo;
import chinaPress.fc.self_test.vo.FcSelfTestListParam;
import chinaPress.fc.self_test.vo.FcSelfTestListVo;
import chinaPress.fc.self_test.vo.FcSelfTestStemInsertParam;

@Service
public class FcSelfTestService {

	@Autowired
	private FcSelfTestMapper fcSelfTestMapper;

	@Autowired
	private FcSelfTestStemMapper fcSelfTestStemMapper;

	@Autowired
	private FcSelfTestStemOptionMapper fcSelfTestStemOptionMapper;

	/**
	 * 新增
	 * 
	 * @param record
	 * @param stemJson
	 * @return
	 */
	@Transactional
	public int insert(FcSelfTest record, String stemJson) {
		// 新增自测
		int index = fcSelfTestMapper.insertSelective(record);
		if (index > 0) {
			// 自测题干集合
			List<FcSelfTestStemInsertParam> stemList = JacksonUtil.fromJSONList(stemJson,
					FcSelfTestStemInsertParam.class);
			for (FcSelfTestStemInsertParam item : stemList) {
				FcSelfTestStem stem = new FcSelfTestStem();
				stem.setTestId(record.getId());
				stem.setStemId(item.getStemId());
				// 新增自测题干
				int stemIndex = fcSelfTestStemMapper.insertSelective(stem);
				if (stemIndex > 0) {
					// 新增自测题干选项
					fcSelfTestStemOptionMapper.batchInsert(stem.getId(), item.getOptionList());
				}
			}
		}
		return index;
	}

	/**
	 * 详情
	 * 
	 * @param id
	 * @return
	 */
	public FcSelfTestDetailVo detail(Integer id) {
		return fcSelfTestMapper.detail(id);
	}

	/**
	 * 数据数量
	 * 
	 * @param param
	 * @return
	 */
	public int count(FcSelfTestListParam param) {
		return fcSelfTestMapper.count(param);
	}

	/**
	 * 数据集合
	 * 
	 * @param param
	 * @return
	 */
	public List<FcSelfTestListVo> list(FcSelfTestListParam param) {
		return fcSelfTestMapper.list(param);
	}
}

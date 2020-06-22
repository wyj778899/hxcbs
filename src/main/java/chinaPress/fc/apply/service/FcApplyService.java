package chinaPress.fc.apply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.common.util.JacksonUtil;
import chinaPress.fc.apply.dao.FcApplyMapper;
import chinaPress.fc.apply.dao.FcApplyPersonMapper;
import chinaPress.fc.apply.model.FcApply;
import chinaPress.fc.apply.model.FcApplyPerson;

@Service
public class FcApplyService {
	
	@Autowired
	private FcApplyMapper fcApplyMapper;
	
	@Autowired
	private FcApplyPersonMapper fcApplyPersonMapper;
	
	public int insert(FcApply record, String personJson) {
		int index = fcApplyMapper.insertSelective(record);
		if (index > 0) {
			if (record.getApplyType().intValue() == 1) {
				List<FcApplyPerson> personList = JacksonUtil.fromJSONList(personJson, FcApplyPerson.class);
				for (FcApplyPerson item : personList) {
					item.setApplyId(record.getId());
					item.setCreateId(record.getCreateId());
					fcApplyPersonMapper.insertSelective(item);
				}
			} else {
				FcApplyPerson person = new FcApplyPerson();
				person.setApplyId(record.getId());
				person.setRoleId(record.getApplyId());
				person.setRoleType(record.getApplyType());
				person.setCreateId(record.getCreateId());
				fcApplyPersonMapper.insertSelective(person);
			}
		}
		return index;
	}
}

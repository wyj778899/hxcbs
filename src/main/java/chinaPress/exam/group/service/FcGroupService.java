package chinaPress.exam.group.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.exam.group.dao.FcGroupMapper;

@Service
public class FcGroupService {
	@Autowired
	private FcGroupMapper fcGroupMapper;
	
}

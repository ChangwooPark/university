package com.capstone.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.testDAO;
import com.capstone.service.testService;

@Service("testService")
public class testServiceImpl implements testService {

	@Autowired
	testDAO testdao;

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return testdao.selectAll();
	}
}

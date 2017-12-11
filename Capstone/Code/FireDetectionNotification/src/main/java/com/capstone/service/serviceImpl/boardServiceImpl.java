package com.capstone.service.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.boardDAO;
import com.capstone.service.boardService;

@Service("boardService")
public class boardServiceImpl implements boardService {

	@Autowired
	boardDAO boardDAO;
	@Override
	public List AllSelectSensor() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void DeleteSensor(Map map) {
		// TODO Auto-generated method stub

	}
	@Override
	public void InsertSensor(Map map) {
		// TODO Auto-generated method stub

	}
	@Override
	public Map SelectSensor(Map map) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void UpdateSensor(Map map) {
		// TODO Auto-generated method stub

	}

}

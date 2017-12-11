package com.capstone.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.sensorDAO;
import com.capstone.service.sensorService;

@Service("sensorService")
public class sensorServiceImpl implements sensorService {
	@Autowired
	sensorDAO sensorDAO;

}

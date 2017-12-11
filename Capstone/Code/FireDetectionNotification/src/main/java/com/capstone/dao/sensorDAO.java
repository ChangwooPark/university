package com.capstone.dao;

import java.util.List;
import java.util.Map;

public interface sensorDAO {
	public void InsertSensor(Map map);

	public void DeleteSensor(Map map);

	public void UpdateSensor(Map map);

	public Map SelectSensor(Map map);

	public List AllSelectSensor();
}

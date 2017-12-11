package com.capstone.service;

import java.util.List;
import java.util.Map;

public interface warehouseService {
	public List warehouseSelectAll();
	public void Save(List<Map> listMap);
	public List<Map> warehouseAdmin(int adminidx); 
}

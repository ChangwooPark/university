package com.capstone.dao;

import java.util.List;
import java.util.Map;

public interface warehouseDAO {
	public void InsertWarehouse(Map map);

	public void DeleteWarehouse(Map map);

	public void UpdateWarehouse(Map map);

	public Map SelectWarehouse(Map map);

	public List warehouseSelectAll();
	
	public List<Map> warehouseAdmin(int adminidx);
}

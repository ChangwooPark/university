package com.capstone.dao;

import java.util.List;
import java.util.Map;

public interface userDAO {
	public void InsertUser(Map map);

	public void DeleteUser(Map map);

	public void UpdateUser(Map map);

	public Map SelectUser(Map map);

	public List SelectUserAll();

	public String SelectAdminUser(int idx);

	public String SelectAdminIdx(String user_id);
	
	public Map SelectSession(String name);
}

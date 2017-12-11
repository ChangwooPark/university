package com.capstone.service;

import java.util.List;
import java.util.Map;

public interface userService {
	public boolean Login(Map map);
	public String SelectAdminUser(int idx);
	public void Save(List<Map> list);
	public String SelectAdminIdx(String user_id);
	public List SelectUserAll();
	public Map SelectSession(String name);
}

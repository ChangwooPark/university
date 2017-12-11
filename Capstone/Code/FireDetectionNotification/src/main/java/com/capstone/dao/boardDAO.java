package com.capstone.dao;

import java.util.List;
import java.util.Map;

public interface boardDAO {
	public void InsertBoard(Map map);

	public void DeleteBoard(Map map);

	public void UpdateBoard(Map map);

	public Map SelectBoard(Map map);

	public List AllSelectBoard();
}

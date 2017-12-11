package com.capstone.service.serviceImpl;

import java.util.List;
import java.util.Map;

import com.capstone.Model.JqGrid.JqGridData;
import com.capstone.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.service.userService;

@Service("userService")
public class userServiceImpl implements userService {

	@Autowired
	userDAO userDAO;

	@Override
	public List SelectUserAll() {
		// TODO Auto-generated method stub
		return userDAO.SelectUserAll();
	}

	@Override
	public boolean Login(Map map) {
		// TODO Auto-generated method stub
		Map resultMap = null;

		System.out.println("userServiceImpl id : " + map.get("ID"));
		resultMap = userDAO.SelectUser(map);

		if (resultMap != null) {
			System.out.println("로그인 성공");
			return true;

		} else {
			System.out.println("로그인 실패");
			return false;
		}
	}

	@Override
	public String SelectAdminUser(int idx) {
		// TODO Auto-generated method stub

		return userDAO.SelectAdminUser(idx);
	}

	@Override
	public void Save(List<Map> listMap) {

		for (int i = 0; i < listMap.size(); i++) {
			// memberDAO.InsertMember();
			Map<String, Object> map = listMap.get(i);
			String status = map.get("flag").toString();
			if (status.equals(JqGridData.STATUS_INSERT)) {
				userDAO.InsertUser(map);
			} else if (status.equals(JqGridData.STATUS_UPDATE)) {
				userDAO.UpdateUser(map);
			} else if (status.equals(JqGridData.STATUS_DELETE)) {
				System.out.println("D " + map.get(i));
				userDAO.DeleteUser(map);
			}
		}
	}

	@Override
	public String SelectAdminIdx(String user_id) {
		// TODO Auto-generated method stub
		return userDAO.SelectAdminIdx(user_id);
	}

	@Override
	public Map SelectSession(String name) {
		// TODO Auto-generated method stub
		return userDAO.SelectSession(name);
	}
}

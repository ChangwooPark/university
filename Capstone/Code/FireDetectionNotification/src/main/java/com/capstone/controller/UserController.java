package com.capstone.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.Model.JqGrid.JqGridData;
import com.capstone.service.userService;
import com.capstone.service.warehouseService;

@Controller
public class UserController {
	@Autowired
	userService userservice;

	@Autowired
	warehouseService warehouseservice;
	@RequestMapping(value = "/loginUi.do", method = RequestMethod.POST)
	@ResponseBody
	public boolean LoginUi(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) {

		System.out.println(paramMap.size());

		System.out.println(paramMap.get("PW"));
		System.out.println(paramMap.get("ID"));

		if (userservice.Login(paramMap)) {
			if (paramMap.get("ID") != null || paramMap.get("PW") != null) {

				request.getSession().setAttribute("admin", paramMap);
				return true;
			}
		}
		return false;
	}
	@RequestMapping(value = "/mainUi.do", method = RequestMethod.GET)
	public ModelAndView mainUi(@RequestParam Map<String, Object> paramMap, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("main/mainUi");
		return mav;
	}

	@RequestMapping(value = "sensor/UserList.do", method = RequestMethod.GET)
	public ModelAndView arehouseList() {
		ModelAndView mav = new ModelAndView("/sensor/UserListUi");
		return mav;
	}

	@RequestMapping(value = "/User/SelectAll.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String SelectAll(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) {
		// TODO Auto-generated catch block

		List<Map<String, Object>> rows = userservice.SelectUserAll();
		System.out.println(rows.toString() + " rows!");

		JqGridData gridData = new JqGridData(paramMap, rows);
		// gridData.setRows(rows);
		System.out.println(gridData.getJsonString());
		return gridData.getJsonString();
	}

	@RequestMapping(value = "/User/Save.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String Save(@RequestBody List<Map> paramMap) {

		System.out.println(paramMap.toString());
		userservice.Save(paramMap);
		return null;
	}
	@RequestMapping(value = "/User/SessionValue.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Map> SelectSession(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) {
		// TODO Auto-generated catch block
		String name = paramMap.get("name").toString();
		Map<String, Object> map = userservice.SelectSession(name);

		System.out.println(map.toString());
		// System.out.println(map.get("idx"));
		// System.out.println(st);
		int adminidx = (Integer) map.get("idx");
		List<Map> returnmap = warehouseservice.warehouseAdmin(adminidx);
		System.out.println(returnmap.toString());
		return returnmap;
	}
}

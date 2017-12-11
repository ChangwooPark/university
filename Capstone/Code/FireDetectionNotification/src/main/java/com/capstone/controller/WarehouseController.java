package com.capstone.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.Model.JqGrid.JqGridData;
import com.capstone.service.userService;
import com.capstone.service.warehouseService;

@Controller
public class WarehouseController {

	@Autowired
	warehouseService warehouseService;

	@Autowired
	userService userService;

	@RequestMapping(value = "/warehouse/SelectAll.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String SelectAll(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) {
		// TODO Auto-generated catch block

		List<Map<String, Object>> rows = warehouseService.warehouseSelectAll();
		System.out.println(rows.toString() + " rows!");
		for (int i = 0; i < rows.size(); i++) {
			int admin_idx = Integer.parseInt(rows.get(i).get("adminidx").toString());
			String admin_id = userService.SelectAdminUser(admin_idx);
			rows.get(i).put("admin_id", admin_id);
		}
		JqGridData gridData = new JqGridData(paramMap, rows);
		// gridData.setRows(rows);

		return gridData.getJsonString();
	}

	@RequestMapping(value = "/warehouse/Save.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String Save(@RequestBody List<Map> paramMap) {
		for (int i = 0; i < paramMap.size(); i++) {
			if (!(paramMap.get(i).get("flag").equals(""))) {
				String admin_id = paramMap.get(i).get("admin_id").toString();
				String admin_idx = userService.SelectAdminIdx(admin_id);
				paramMap.get(i).put("adminidx", admin_idx);
			}
		}
		System.out.println(paramMap.toString());
		warehouseService.Save(paramMap);
		return null;
	}
}

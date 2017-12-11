package com.capstone.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.sensordata.SensorData;
import com.capstone.service.userService;

@Controller
public class AndroidController {

	@Autowired
	userService userservice;

	SensorData sensordata = SensorData.getInstance();

	@RequestMapping(value = "/test/Android.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ModelAndView TestAndroid(HttpServletRequest request) {
		// request.setCharacterEncoding("euc-kr");
		ModelAndView mav = new ModelAndView("test");
		System.out.println("controller");
		String name = request.getParameter("name");
		System.out.println("controller request name : " + name);
		request.setAttribute("name", name);
		return mav;

	}

	@RequestMapping(value = "/Android/Login.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ModelAndView LoginCheck(HttpServletRequest request) {
		// request.setCharacterEncoding("euc-kr");
		ModelAndView mav = new ModelAndView("Android/login");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("controller request id : " + id + " pw : " + pw);

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ID", id);
		paramMap.put("PW", pw);

		System.out.println("paramMap get : " + paramMap.get("ID") + " pw : " + paramMap.get("PW"));
		if (!paramMap.get("ID").equals(null) || !paramMap.get("PW").equals(null)) {
			if (userservice.Login(paramMap)) {

				request.setAttribute("logincheck", "success");
			} else {
				request.setAttribute("logincheck", "fail");
			}
		}
		return mav;

	}

	@RequestMapping(value = "/Android/Temperature.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ModelAndView TemperatureAndroid(HttpServletRequest request) {
		// request.setCharacterEncoding("euc-kr");
		ModelAndView mav = new ModelAndView("Android/TemperatureList");

		ArrayList temperature = new ArrayList();

		// temperature = sensordata.setSensorData(temperature);
		temperature = sensordata.TemperatureList;

		request.setAttribute("temperature", temperature);
		// request.setAttribute("temperature", "hong");
		return mav;

	}
	@RequestMapping(value = "/Android/Flame.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ModelAndView FlameAndroid(HttpServletRequest request) {
		// request.setCharacterEncoding("euc-kr");
		ModelAndView mav = new ModelAndView("Android/FlameList");

		ArrayList flame = new ArrayList();

		// temperature = sensordata.setSensorData(temperature);
		flame = sensordata.FlameList;

		request.setAttribute("flame", flame);
		// request.setAttribute("temperature", "hong");
		return mav;

	}
	@RequestMapping(value = "/Android/Humidity.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ModelAndView HumidityAndroid(HttpServletRequest request) {
		// request.setCharacterEncoding("euc-kr");
		ModelAndView mav = new ModelAndView("Android/HumidityList");

		ArrayList Humidity = new ArrayList();

		// temperature = sensordata.setSensorData(temperature);
		Humidity = sensordata.HumidityList;

		request.setAttribute("humidity", Humidity);
		// request.setAttribute("temperature", "hong");
		return mav;

	}
	@RequestMapping(value = "/Android/Smoke.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ModelAndView SmokeAndroid(HttpServletRequest request) {
		// request.setCharacterEncoding("euc-kr");
		ModelAndView mav = new ModelAndView("Android/SmokeList");

		ArrayList smoke = new ArrayList();

		// temperature = sensordata.setSensorData(temperature);
		smoke = sensordata.SmokeList;

		request.setAttribute("smoke", smoke);
		// request.setAttribute("temperature", "hong");
		return mav;

	}

	@RequestMapping(value = "/Android/Sensing.do", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public ModelAndView SensingAndroid(HttpServletRequest request) {
		// request.setCharacterEncoding("euc-kr");
		ModelAndView mav = new ModelAndView("Android/Sensing");

		if (sensordata.Temperature != "") {
			if (Float.parseFloat(sensordata.Temperature) >= 30.0) {
				request.setAttribute("check", "sensing");

			} else {
				request.setAttribute("check", "nonono");
			}
		}

		// request.setAttribute("temperature", "hong");
		return mav;

	}

}

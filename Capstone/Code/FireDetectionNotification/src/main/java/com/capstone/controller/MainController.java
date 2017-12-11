package com.capstone.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.data.LineGraphData.GraphLine;
import com.capstone.data.LineGraphData.GraphLineData;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {

	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView test(Locale locale, Model model, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("main/loginUi");
		// int port = 1234;
		// try {
		// socketserver = new socketServer(port);
		// socketserver.startSocket();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// System.out.println("");
		// e.printStackTrace();
		// }
		// WebServer server = new WebServer(port);
//		String name = request.getParameter("name");

	//	System.out.println(name + "!!!!");
		return mav;
	}
	@RequestMapping(value = "/home.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView test(Locale locale) {
		ModelAndView mav = new ModelAndView("main/home_Ui");
		// int port = 1234;
		// try {
		// socketserver = new socketServer(port);
		// socketserver.startSocket();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// System.out.println("");
		// e.printStackTrace();
		// }
		// WebServer server = new WebServer(port);
//		String name = request.getParameter("name");

	//	System.out.println(name + "!!!!");
		return mav;
	}

}

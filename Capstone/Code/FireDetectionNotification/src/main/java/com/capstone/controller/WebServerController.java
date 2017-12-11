package com.capstone.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.sensordata.SensorData;

@Controller
public class WebServerController {
	String smoke = null;
	String flame = null;
	String humid = null;
	String temperature = null;
	SensorData sensorData;

	@RequestMapping(value = "/Server/Data.do", method = {RequestMethod.POST, RequestMethod.GET})
	public void ServerData(HttpServletRequest request) {

		if (request != null) {
			smoke = request.getParameter("smoke");
			flame = request.getParameter("flame");
			humid = request.getParameter("humid");
			temperature = request.getParameter("temperature");
		}

		if (smoke != null && flame != null && humid != null && temperature != null) {

			sensorData = SensorData.getInstance();

			sensorData.Smoke = smoke;
			sensorData.Flame = flame;
			sensorData.Temperature = temperature;
			sensorData.Humid = humid;
			sensorData.setSensorData(sensorData.TemperatureList, sensorData.Temperature);
			sensorData.setSensorData(sensorData.HumidityList, sensorData.Humid);
			sensorData.setSensorData(sensorData.FlameList, sensorData.Flame);
			sensorData.setSensorData(sensorData.SmokeList, sensorData.Smoke);
		}

		String fileName;

		// GregorianCalendar gc = new GregorianCalendar();
		// String today = "\\" + String.valueOf(gc.get(gc.YEAR));
		// today += String.valueOf(gc.get(gc.MONTH) + 1);
		// today += String.valueOf(gc.get(gc.DAY_OF_MONTH));

		SimpleDateFormat formatterToday = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		Date currentTime = new Date();
		String today = formatterToday.format(currentTime);

		SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
		String time = formatterTime.format(currentTime);

		String path = "C:\\Users\\Administrator\\Desktop\\Capstone\\Code\\FireDetectionNotification\\src\\main\\webapp\\resources\\datafile";
		fileName = path + "\\" + today + ".txt";
		// String path =
		// request.getSession().getServletContext().getRealPath("/");
		// path += "\\resources\\datafile";
		// fileName = path + "\\" + today + ".txt";
		try {
			// File file = new File(fileName);
			//
			// if (file.isFile()) {
			// } else {
			// System.out.println("파일 없음");
			// }

			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);

			// 파일안에 문자열 쓰기
			bw.write(today + time + " " + temperature + "," + humid + "," + flame + "," + smoke);
			bw.newLine();

			// 객체 닫기
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
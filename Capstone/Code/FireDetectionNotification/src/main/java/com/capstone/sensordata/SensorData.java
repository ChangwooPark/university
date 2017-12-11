package com.capstone.sensordata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class SensorData {
	public static SensorData instance;

	public static ArrayList<String> TemperatureList = new ArrayList<String>();
	public static ArrayList<String> HumidityList = new ArrayList<String>();
	public static ArrayList<String> SmokeList = new ArrayList<String>();
	public static ArrayList<String> FlameList = new ArrayList<String>();

	public static String Temperature = "";
	public static String Humid = "";
	public static String Smoke = "";
	public static String Flame = "";

	public static SensorData getInstance() {
		if (instance == null)
			instance = new SensorData();
		return instance;
	}

	public SensorData() {
		// TODO Auto-generated constructor stub
		TemperatureList = InitSensorData(TemperatureList);
		HumidityList = InitSensorData(HumidityList);
		SmokeList = InitSensorData(SmokeList);
		FlameList = InitSensorData(FlameList);
		// ArrayList<String> labels = new ArrayList<String>();
	}

	public ArrayList InitSensorData(ArrayList list) {
		for (int i = 0; i < 20; i++) {
			list.add(0);
		}
		return list;
	}
	public ArrayList setSensorData(ArrayList list, String value) {

		// int a = (int) (Math.random() * 20);
		list.remove(0);
		list.add(value);
		return list;
	}
	// public ArrayList InitTimeData(ArrayList list) {
	// SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss");
	// Calendar init_cal = Calendar.getInstance();
	// Calendar cal = Calendar.getInstance();
	// init_cal.setTime(new Date());
	// cal.setTime(new Date());
	//
	// for (int i = 0; i < 20; i++) {
	// init_cal.add(Calendar.SECOND, -3);
	// list.add(currentTime.format(init_cal.getTime()));
	//
	// }
	// Collections.reverse(list);
	// return list;
	// }
	public ArrayList setTimeData() {
		ArrayList<String> labels = new ArrayList<String>();
		SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		labels.clear();
		for (int i = 0; i < 20; i++) {
			cal.add(Calendar.SECOND, -3);
			labels.add(currentTime.format(cal.getTime()));

		}
		Collections.reverse(labels);
		return labels;
	}
}

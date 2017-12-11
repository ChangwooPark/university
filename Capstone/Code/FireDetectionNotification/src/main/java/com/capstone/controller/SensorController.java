package com.capstone.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.Model.JqGrid.JqGridData;
import com.capstone.data.LineGraphData.GraphLine;
import com.capstone.data.LineGraphData.GraphLineData;
import com.capstone.sensordata.SensorData;

@Controller
public class SensorController {

	// double[] testValues = {20.5, 20.8, 21.0, 21.3, 21.7, 22.0, 22.4, 22.7,
	// 23.1, 24.0, 24.5, 24.9, 25.2, 25.8, 26.3, 26.9, 27.0, 27.3, 27.9, 28.2};
	// public static int TemperatureCount = 1;
	// public static int HumidityCount = 1;
	// public static int SmokeCount = 1;
	// public static int SparkCount = 1;
	// public static ArrayList<Double> TemperatureList = new
	// ArrayList<Double>();
	// public static ArrayList<Double> HumidityList = new ArrayList<Double>();
	// public static ArrayList<Double> SmokeList = new ArrayList<Double>();
	// public static ArrayList<Double> SparkList = new ArrayList<Double>();
	JqGridData gridData;
	SensorData sensorData = SensorData.getInstance();
	@RequestMapping(value = "/sensor/sensorTotalUi.do", method = RequestMethod.GET)
	public ModelAndView sensorTotalUi() {
		ModelAndView mav = new ModelAndView("/sensor/sensorTotalUi");
		return mav;
	}

	@RequestMapping(value = "sensor/RealTimeSensorUi.do", method = RequestMethod.GET)
	public ModelAndView RealTimeSensorUi() {
		ModelAndView mav = new ModelAndView("/sensor/RealTimeSensorUi");
		return mav;
	}

	@RequestMapping(value = "sensor/WarehouseList.do", method = RequestMethod.GET)
	public ModelAndView arehouseList() {
		ModelAndView mav = new ModelAndView("/sensor/WarehouseListUi");
		return mav;
	}

	@RequestMapping(value = "sensor/BeforeSensorUi.do", method = RequestMethod.GET)
	public ModelAndView BeforeSensorUi() {
		ModelAndView mav = new ModelAndView("/sensor/BeforeSensorUi");
		return mav;
	}

	@RequestMapping(value = "/sensor/TemperatureChart.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, List> TemperatureChart() {
		HashMap<String, List> returnMap = new HashMap<String, List>();

		// ArrayList<String> labels = new ArrayList<String>();
		// labels = sensorData.getTimeData(labels);
		// TemperatureList = sensorData.getSensorData(TemperatureList,
		// TemperatureCount);
		// SensorData sensorData = SensorData.getInstance();
		// TemperatureCount++;
		returnMap.put("labels", sensorData.setTimeData());
		returnMap.put("data", sensorData.TemperatureList);
		return returnMap;
	}

	@RequestMapping(value = "/sensor/HumidityChart.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, List> HumidityChart() {

		HashMap<String, List> returnMap = new HashMap<String, List>();

		// SensorData sensorData = new SensorData();
		// ArrayList<String> labels = new ArrayList<String>();
		// labels = sensorData.getTimeData(labels);
		// HumidityList = sensorData.getSensorData(HumidityList, HumidityCount);
		// HumidityCount++;
		returnMap.put("labels", sensorData.setTimeData());
		returnMap.put("data", sensorData.HumidityList);
		return returnMap;
	}

	@RequestMapping(value = "/sensor/SmokeChart.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, List> SmokeChart() {
		HashMap<String, List> returnMap = new HashMap<String, List>();

		// SensorData sensorData = new SensorData();
		// ArrayList<String> labels = new ArrayList<String>();
		// labels = sensorData.getTimeData(labels);
		// SmokeList = sensorData.getSensorData(SmokeList, SmokeCount);
		// SmokeCount++;
		returnMap.put("labels", sensorData.setTimeData());
		returnMap.put("data", sensorData.SmokeList);

		return returnMap;
	}

	@RequestMapping(value = "/sensor/SparkChart.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, List> SparkChart() {

		HashMap<String, List> returnMap = new HashMap<String, List>();

		// SensorData sensorData = new SensorData();
		// ArrayList<String> labels = new ArrayList<String>();
		// labels = sensorData.getTimeData(labels);
		// SparkList = sensorData.getSensorData(SparkList, SparkCount);
		// SparkCount++;
		returnMap.put("labels", sensorData.setTimeData());
		returnMap.put("data", sensorData.FlameList);
		return returnMap;
	}

	// List<Map> summerList = new ArrayList<Map>();
	// List<Map> springfallList = new ArrayList<Map>();
	// List<Map> winterList = new ArrayList<Map>();
	//
	// Map<String, String> summerDay = new HashMap<String, String>();
	// Map<String, String> summerNight = new HashMap<String, String>();
	// Map<String, String> springfallDay = new HashMap<String, String>();
	// Map<String, String> springfallNight = new HashMap<String, String>();
	// Map<String, String> winterDay = new HashMap<String, String>();
	// Map<String, String> winterNight = new HashMap<String, String>();

	// public List<Map> listInit()

	@RequestMapping(value = "/sensor/ColorChange.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> ColorChange() {
		sensorData = SensorData.getInstance();
		HashMap<String, String> returnMap = new HashMap<String, String>();
		String[] DangerSolidity = {"white", "yellow", "red"};
		Map<String, String> map = new HashMap<String, String>();
		
		if (sensorData.Temperature != null && sensorData.Humid != null && sensorData.Flame != null && sensorData.Smoke != null) {
			// if (Float.parseFloat(sensorData.Temperature) >= 30.0) {
			// System.out.println("true");
			// return "true";
			//
			// } else {
			// return "false";
			//
			// }
			if (sensorData.SmokeList.get(10) != "0" && sensorData.FlameList.get(10) != "0") {
				if (Double.parseDouble(sensorData.Humid) <= 35.0) {
					if (Integer.parseInt(sensorData.Smoke) > 1800) {
						if (Double.parseDouble(sensorData.FlameList.get(10)) > Double.parseDouble(sensorData.FlameList.get(sensorData.FlameList
								.size() - 1))) {
							if (Double.parseDouble(sensorData.TemperatureList.get(sensorData.TemperatureList.size() - 2)) < Double
									.parseDouble(sensorData.TemperatureList.get(sensorData.TemperatureList.size() - 1))) {
								System.out.println(DangerSolidity[2]);
								map.clear();
								map.put("data", "red");
								return map;
							} else {
								System.out.println(DangerSolidity[2]);
								map.clear();
								map.put("data", "red");
								return map;
							}
						} else {
							System.out.println(DangerSolidity[1]);
							map.clear();
							map.put("data", "yellow");
							return map;
						}
					} else {
						System.out.println(DangerSolidity[1]);
						map.clear();
						map.put("data", "yellow");
						return map;
					}
				} else {
					if (Integer.parseInt(sensorData.Smoke) > 1800) {
						if (Double.parseDouble(sensorData.FlameList.get(10)) > Double.parseDouble(sensorData.FlameList.get(sensorData.FlameList
								.size() - 1))) {
							if (Double.parseDouble(sensorData.TemperatureList.get(sensorData.TemperatureList.size() - 2)) < Double
									.parseDouble(sensorData.TemperatureList.get(sensorData.TemperatureList.size() - 1))) {
								System.out.println(DangerSolidity[2]);
								map.clear();
								map.put("data", "red");
								return map;
							} else {
								System.out.println(DangerSolidity[1]);
								map.clear();
								map.put("data", "yellow");
								return map;
							}
						} else {
							System.out.println(DangerSolidity[1]);
							map.clear();
							map.put("data", "yellow");
							return map;
						}
					} else {
						System.out.println(DangerSolidity[0]);
						map.clear();
						map.put("data", "white");
						return map;
					}
				}
			}

		}
		System.out.println("return null");
		return null;
	}
	@RequestMapping(value = "/sensor/beforeDate.do", method = RequestMethod.POST)
	@ResponseBody
	public List<Map> beforeDate(HttpServletRequest request) {
		List<Map> returnMap = new ArrayList<Map>();
		Map<String, String> map = new HashMap<String, String>();

		// String path =
		// request.getSession().getServletContext().getRealPath("/");
		// path += "\\resources\\datafile";
		String path = "C:\\Users\\Administrator\\Desktop\\Capstone\\Code\\FireDetectionNotification\\src\\main\\webapp\\resources\\datafile";
		// fileName = path +"\\"+ today + ".txt";
		File file = new File(path);
		String[] fileList = file.list();
		String temp_filename;
		String[] filename;
		for (int i = 0; i < fileList.length; i++) {
			temp_filename = fileList[i];
			filename = temp_filename.split("\\.");

			map.put(String.valueOf(i), filename[0].toString());
			returnMap.add(map);
			// map.clear();
		}
		return returnMap;
	}

	@RequestMapping(value = "/sensor/beforeSensorData.do", method = RequestMethod.POST)
	@ResponseBody
	public String beforeSensorData(@RequestBody Map<String, Object> paramMap, HttpServletRequest request) {
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();

		try {
			// String path =
			// request.getSession().getServletContext().getRealPath("/");
			// path += "\\resources\\datafile\\";
			String path = "C:\\Users\\Administrator\\Desktop\\Capstone\\Code\\FireDetectionNotification\\src\\main\\webapp\\resources\\datafile";
			String filename = "\\" + paramMap.get("datecombo").toString() + ".txt";
			BufferedReader in = new BufferedReader(new FileReader(path + filename));

			String line;
			String[] Time;
			String[] SensorData;

			while ((line = in.readLine()) != null) {

				Map<String, Object> map = new HashMap<String, Object>();
				Time = line.split(" ");
				SensorData = Time[1].split(",");
				map.put("time", Time[0]);
				map.put("temperature", SensorData[0]);
				map.put("humid", SensorData[1]);
				map.put("flame", SensorData[2]);
				map.put("smoke", SensorData[3]);
				rows.add(map);

			}
			gridData = new JqGridData(paramMap, rows);
			in.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		return gridData.getJsonString();
	}
}

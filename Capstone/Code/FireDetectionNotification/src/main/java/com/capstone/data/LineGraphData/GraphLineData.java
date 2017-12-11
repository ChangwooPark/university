package com.capstone.data.LineGraphData;

import java.util.HashMap;
import java.util.List;

public class GraphLineData {

	public static String defaults ="rgb(255,255,0.5)";
	public static String LightCyan = "rgb(224,255,255)";
	String fillColor;
	String pointStrokeColor;
	String pointColor;
	List<Integer> data;
	
	public GraphLineData(String fillColor, String pointStrokeColor,
			String pointColor, List<Integer> data) {
		super();
		this.fillColor = fillColor;
		this.pointStrokeColor = pointStrokeColor;
		this.pointColor = pointColor;
		this.data = data;
	}

	public HashMap<String,Object> GetGraphLineDataMap(){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("fillColor", fillColor);
		returnMap.put("pointStrokeColor", pointStrokeColor);
		returnMap.put("pointColor", pointColor);
		returnMap.put("data", data);
		return returnMap;
		
		
	}
	
}

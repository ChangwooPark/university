package com.capstone.data.LineGraphData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphLine {
	
	
	public  static HashMap<String,Object> GraphLineData(List<GraphLineData> graphLineData, List<String> labels){
		
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		ArrayList<HashMap<String, Object>> datasets = new ArrayList<HashMap<String,Object>>(); 
		for(int i=0; i<graphLineData.size(); i++){
			datasets.add(graphLineData.get(i).GetGraphLineDataMap());
		}
		returnMap.put("datasets", datasets);
		returnMap.put("labels", labels);
		
		return returnMap;
	}
}

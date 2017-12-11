package com.capstone.controller;

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
import com.capstone.service.testService;

/**
 * Handles requests for the application home page.
 */
/*@Controller
public class HomeController {

	@Autowired
	testService testservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView test(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView("main/loginUi");
		List<Map> list = testservice.selectAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		mav.addObject("list", list);
		System.out.println("�샇異�!!!!");
		return mav;
	}

	@RequestMapping(value = "/test/json2.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> json2() {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();

		// ///////////////////////////////////////////////////////////////////
		ArrayList<String> labels = new ArrayList<String>();

		SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());

		for (int i = 0; i < 5; i++) {

			cal.add(Calendar.MINUTE, -10);
			labels.add(currentTime.format(cal.getTime()));
		}
		// /////////////////////////////////////////////////////////////////////

		ArrayList<HashMap<String, Object>> dataSets = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> dataset = new HashMap<String, Object>();
		dataset.put("fillColor", "rgba(220,220,0.5");
		dataset.put("pointStrokeColor", "#fff");
		dataset.put("strokeColor", "rgba(220,220,220,1)");
		dataset.put("pointColor", "rgba(220,220,220,1)");
		ArrayList<Integer> subList = new ArrayList<Integer>();
		for (int i = 1; i <= 6; i++) {
			subList.add(i * 10);
		}
		dataset.put("data", subList);

		dataSets.add(dataset);

		HashMap<String, Object> dataset2 = new HashMap<String, Object>();
		dataset2.put("fillColor", "rgba(220,220,0.5");
		dataset2.put("pointStrokeColor", "#fff");
		dataset2.put("strokeColor", "rgba(220,220,220,1)");
		dataset2.put("pointColor", "rgba(220,220,220,1)");
		dataset2.put("data", subList);

		dataSets.add(dataset2);

		returnMap.put("datasets", dataSets);
		returnMap.put("labels", labels);

		return returnMap;

	}

	@RequestMapping(value = "/test/json3.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> json3() {
		ArrayList<Integer> subList = new ArrayList<Integer>();
		for (int i = 1; i <= 6; i++) {
			subList.add(i * 10);
		}

		GraphLineData d1 = new GraphLineData(GraphLineData.defaults,
				GraphLineData.defaults, GraphLineData.defaults, subList);
		GraphLineData d2 = new GraphLineData(GraphLineData.defaults,
				GraphLineData.defaults, GraphLineData.defaults, subList);
		ArrayList<GraphLineData> list = new ArrayList<GraphLineData>();
		list.add(d1);
		list.add(d2);

		ArrayList<String> labels = new ArrayList<String>();

		SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());

		for (int i = 0; i < 5; i++) {

			cal.add(Calendar.MINUTE, -10);
			labels.add(currentTime.format(cal.getTime()));
		}

		return GraphLine.GraphLineData(list, labels);

	}
	
	@RequestMapping(value = "/test/Android.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public ModelAndView TestAndroid(HttpServletRequest request){
		//request.setCharacterEncoding("euc-kr");
		ModelAndView mav = new ModelAndView("test");
		System.out.println("controller �샇異�!!!");
//		String name = request.getParameter("name");
//		System.out.println("controller request name : " + name);
//		request.setAttribute("name", name);
		return mav;
	//String recvMessage = request.getParameter("msg");
	   //珥덇린 �꽑�뼵
//		JSONObject jsonMain = new JSONObject();
//		JSONArray jArray = new JSONArray();
//		
//		JSONObject jObject1 = new JSONObject();
//		JSONObject jObject2 = new JSONObject();
//		JSONObject jObject3 = new JSONObject();
//
//	        // �븞�뱶濡쒖씠�뱶濡� 蹂대궪 硫붿떆吏�瑜� 留뚮벉
//		//jObject1.put("msg1", recvMessage);
//		jObject1.put("msg2", "硫붿떆吏�2!");
//		jObject1.put("msg3", "3踰덉㎏ 硫붿떆吏�!");
//		
//	        // �쐞�뿉�꽌 留뚮뱺 媛곴컖�쓽 媛앹껜瑜� �븯�굹�쓽 諛곗뿴 �삎�깭濡� 留뚮벉
//		jArray.add(0, jObject1);
//		jArray.add(0, jObject2);
//		jArray.add(0, jObject3);
//
//	        // 理쒖쥌�쟻�쑝濡� 諛곗뿴�쓣 �븯�굹濡� 臾띠쓬
//		jsonMain.put("List", jArray);
//		
	        // �븞�뱶濡쒖씠�뱶�뿉 蹂대궪 �뜲�씠�꽣瑜� 異쒕젰
	//	out.println(jsonMain.toJSONString());
		
//		String recvMessage = request.getParameter("msg");
			
			
	}
	
}
*/
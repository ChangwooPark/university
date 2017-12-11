<%@page import="java.util.ArrayList"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	ArrayList temperaturelist = (ArrayList) request.getAttribute("temperature");
	JSONObject jsonMain = new JSONObject();
	jsonMain.put("temperaturelist", temperaturelist);
	out.print(jsonMain.toJSONString());
%>

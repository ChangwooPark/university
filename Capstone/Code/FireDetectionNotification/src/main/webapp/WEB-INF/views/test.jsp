<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%> 
<%
String name = request.getAttribute("logincheck").toString();
System.out.println("jsp request name : " + name);

JSONObject jsonMain = new JSONObject();
jsonMain.put("name", name);
System.out.println("안드로이드에 보낼 데이터 : " + jsonMain.toJSONString());
out.print(jsonMain.toJSONString());
%>

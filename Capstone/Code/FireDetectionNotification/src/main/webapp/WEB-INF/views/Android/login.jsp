<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%> 
<%
String login_check = request.getAttribute("logincheck").toString();
System.out.println("jsp request login_check : " + login_check);

JSONObject jsonMain = new JSONObject();
jsonMain.put("login_check", login_check);
System.out.println("안드로이드에 보낼 데이터 : " + jsonMain.toJSONString());
out.print(jsonMain.toJSONString());
%>

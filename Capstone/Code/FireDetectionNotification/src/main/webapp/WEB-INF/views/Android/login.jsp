<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%> 
<%
String login_check = request.getAttribute("logincheck").toString();
System.out.println("jsp request login_check : " + login_check);

JSONObject jsonMain = new JSONObject();
jsonMain.put("login_check", login_check);
System.out.println("�ȵ���̵忡 ���� ������ : " + jsonMain.toJSONString());
out.print(jsonMain.toJSONString());
%>

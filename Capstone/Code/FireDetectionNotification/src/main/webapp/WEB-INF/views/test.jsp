<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%> 
<%
String name = request.getAttribute("logincheck").toString();
System.out.println("jsp request name : " + name);

JSONObject jsonMain = new JSONObject();
jsonMain.put("name", name);
System.out.println("�ȵ���̵忡 ���� ������ : " + jsonMain.toJSONString());
out.print(jsonMain.toJSONString());
%>

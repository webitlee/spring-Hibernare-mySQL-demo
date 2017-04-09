<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@page import="org.springframework.context.ApplicationContext" %>
<%@page import="springWEB.SayHello" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试基于spring的web应用</title>
</head>
<body>
	<%
		//从application域对象中得到IOC容器的实例
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);
		//从IOC容器中得到bean
		SayHello sayHello = ac.getBean("hello", SayHello.class);
		//使用bean
		sayHello.springWEBHello();
	%>
</body>
</html>
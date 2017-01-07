<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="diyTag" uri="http://www.lyn.cn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>jstl测试</title>
</head>
<body>
	<c:if test="${!empty requestScope.emp}">
		<p>ID:${requestScope.emp.id}</p>
		<p>姓名：${requestScope.emp.name}</p>
		<p>月薪：${requestScope.emp.salary }</p>
		<p>年龄：${requestScope.emp.age}</p>
	</c:if>
	
	<c:if test="${requestScope.emp.age > 50 }">
		<c:out value="老年"></c:out>
	</c:if>
	<c:if test="${requestScope.emp.age <= 50 }">
		<c:out value="中青年"></c:out>
	</c:if>
	<c:out value="结果是：${fn:contains('Hello World', 'H')}"></c:out><br/>
	<c:out value="结果是：${fn:containsIgnoreCase('Hello World', 'hello')}"></c:out><br/>
	<c:if test="true" var="result"></c:if>
	<c:out value="${result }"></c:out><br/>
	<c:out value="${fn:escapeXml('<p>haha</p>') }"></c:out><br/>
	<p>自定义标签测试</p>
</body>
</html>
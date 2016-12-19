<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*, entity.Employees, dao.Query"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>显示所有员工信息</title>
<script src="/gitRepository/html/jquery/jquery-3.0.0.min.js"></script>
<style>
	table{
		border-collapse:collapse;
		border-spacing:0;
	}
	td{
		border:1px solid #000;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>月薪</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
			<%
				List<Employees> emp = (List<Employees>)request.getAttribute("empList");
				System.out.println(emp);
				for(int i = 0; i < emp.size(); i++){
					int id = emp.get(i).getId();
					String name = emp.get(i).getName();
					float salary = emp.get(i).getSalary();
					int age = emp.get(i).getAge();
					%>
					<tr>
					<td><%= id %></td>
					<td><%= name %></td>
					<td><%= salary %></td>
					<td><%= age %></td>
					<td>
						<a id="delete" href="/gitRepository/delete?id=<%= id %>">删除</a>
						<br/>
						<a id="modified" href="/gitRepository/showDetail?id=<%= id %>">修改</a>
					</td>
					</tr>
					<%
				}
			%>
	</table>
	<a href="/gitRepository/html/add.html">添加</a>
</body>
<script>
</script>
</html>
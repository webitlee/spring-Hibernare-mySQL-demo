package web;


import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Query;
import entity.Employees;

public class EmployeeServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			String str = "<table border='1'><tr><th>编号</th><th>姓名</th><th>月薪</th><th>年龄</th><th>操作</th></tr>";
			List<Employees> data = Query.findAll("lyn-bd");
			System.out.println(data);
			for(Employees emp : data){
				int id = emp.getId();
				String name = emp.getName();
				float salary = emp.getSalary();
				int age = emp.getAge();
				str += "<tr>"
						+ "<td>"+id+"</td>"
						+ "<td>"+name+"</td>"
						+ "<td>"+salary+"</td>"
						+ "<td>"+age+"</td>"
						+ "<td>"
						+ "<a href='modified'>修改</a>"
						+ "<a href='delete'>删除</a>"
						+ "<a href='add'>添加</a>"
						+ "</td>"
						+ "</tr>";
			}
			str += "</table>";
			pw.println(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

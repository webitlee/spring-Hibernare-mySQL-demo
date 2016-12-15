package web;


import java.io.PrintWriter;
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
			List<Employees> data = Query.findAll("employee");
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
						+ "<a href='/gitRepository/modified' data-id='"+id+"' class='modified'>修改</a><br/>"
						+ "<a href='/gitRepository/delete' data-id='"+id+"' class=delete>删除</a><br/>"
						+ "</td>"
						+ "</tr>";
			}
			str += "</table>";
			str += "<a href='/gitRepository/html/add.html'>添加</a><br/>";
			pw.println(str);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

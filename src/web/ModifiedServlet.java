package web;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Modified;

public class ModifiedServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			float salary = Float.parseFloat(request.getParameter("salary"));
			int age = Integer.parseInt(request.getParameter("age"));
			Modified.modifiedById("employee", id, name, salary, age);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

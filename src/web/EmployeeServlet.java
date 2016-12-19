package web;


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
			List<Employees> data = Query.findAll("employee");
			request.setAttribute("empList", data);
			request.getRequestDispatcher("/jsp/list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new Exception(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}
}

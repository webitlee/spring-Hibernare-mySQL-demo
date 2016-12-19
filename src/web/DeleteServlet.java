package web;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Delete;

public class DeleteServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			int id = Integer.parseInt(request.getParameter("id"));
			Delete.deleteOne("employee", id);
			response.sendRedirect("/gitRepository/list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

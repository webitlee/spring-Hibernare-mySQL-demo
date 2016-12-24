package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Query;
import entity.Admin;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String authCode = request.getParameter("authCode");
		HttpSession s = request.getSession();
		String realCode = (String)s.getAttribute("authCode");
		if(realCode != null && !authCode.toLowerCase().equals(realCode.toLowerCase())){
			request.setAttribute("hint", "ÑéÖ¤Âë´íÎó");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
		Admin adm = Query.findByAccount("admin", account);
		if(account.equals(adm.getAccount()) && password.equals(adm.getPassword())){
			s = request.getSession();
			s.setAttribute("login", adm);
			response.sendRedirect("/gitRepository/list");
		}else{
			response.sendRedirect("/gitRepository/jsp/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

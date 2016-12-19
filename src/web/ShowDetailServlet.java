package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Query;
import entity.Employees;

/**
 * Servlet implementation class ShowDetailServlet
 */
@WebServlet("/showDetail")
public class ShowDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tableName = "employee";
		int id = Integer.parseInt(request.getParameter("id"));
		Employees emp = Query.findById(tableName, id);
		request.setAttribute("showDetail", emp);
		request.getRequestDispatcher("/jsp/modified.jsp").forward(request, response);
	}

}

package web;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OtherErrors.FormError;
import dao.Insert;

public class AddServlet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String name = request.getParameter("name");
			if(name == null){
				throw new FormError("姓名未填写");
			}
			float salary = Float.parseFloat(request.getParameter("salary"));
			if(salary <= 0){
				throw new FormError("月薪填写错误");
			}
			int age = Integer.parseInt(request.getParameter("age"));
			if(age <=0 || age >= 200){
				throw new FormError("年龄填写错误");
			}
			Insert.addOne("employee", name, salary, age);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

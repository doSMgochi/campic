package controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UserDao;
import model.vo.User;

@WebServlet("/login-handle")
public class LoginHandleController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		try {
			
			UserDao userDao = new UserDao();
			User user = userDao.findById(id);
			
			if(user == null || !user.getPassword().equals(password)) {
				out.println("<script>");
				out.println("window.alert(\"아이디 또는 비밀번호가 일치하지 않습니다.\")");
				out.println("history.go(-1);");
				out.println("</script>");
				
			}else {
				request.getSession().setAttribute("authUser", user);
	
				response.sendRedirect(request.getContextPath() + "/index");
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

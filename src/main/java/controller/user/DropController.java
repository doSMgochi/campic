package controller.user;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.vo.User;

@WebServlet("/drop")
public class DropController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User authUser = (User) request.getSession().getAttribute("authUser");
		if (authUser == null) {
//			 request.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/user/drop.jsp").forward(request, response);
	}
}

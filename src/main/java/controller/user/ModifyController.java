package controller.user;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UserDao;
import model.vo.User;

@WebServlet("/modify")
public class ModifyController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		User authUser = (User) request.getSession().getAttribute("authUser");
		if (authUser == null) {
//			 request.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		UserDao userDao = new UserDao();
		User user = userDao.findById(authUser.getId());
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/user/modify.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

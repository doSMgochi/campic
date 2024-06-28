package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.vo.User;

@WebServlet("/mypage")
public class MyPageController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User authUser = (User) request.getSession().getAttribute("authUser");
			request.setAttribute("authUser", authUser);
			request.getRequestDispatcher("/WEB-INF/view/mypage/mypage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}


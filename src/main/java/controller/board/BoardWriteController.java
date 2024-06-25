package controller.board;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.vo.User;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User authUser = (User) request.getSession().getAttribute("authUser");
		if (authUser == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/board/write.jsp").forward(request, response);
	}
	

}

package controller.camping;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/camp/*")
public class CampController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String uriString = uri.substring(uri.lastIndexOf("/") + 1);
		
		request.getRequestDispatcher("/WEB-INF/view/camping/camp.jsp").forward(request, response);
	}

}

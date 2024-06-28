package controller.camping;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.CampsiteDao;
import model.vo.Campsite;

@WebServlet("/camp-reservation/*")
public class CampReservationWriteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String uri = request.getRequestURI();
			String uriString = uri.substring(uri.lastIndexOf("/") + 1);
			String cabinString = request.getParameter("cabin");
			int cabin = 0;
			if (cabinString != null) {
				if (cabinString.matches("[0-9]+")) {
					cabin = Integer.parseInt(uriString);
				}
			}
			int id = 0;
			if (uriString.matches("[0-9]+")) {
				id = Integer.parseInt(uriString);
			}
			CampsiteDao campsiteDao = new CampsiteDao();
			Campsite campsite = campsiteDao.findById(id);
			request.setAttribute("cabin", cabin);
			request.setAttribute("campsite", campsite);
			request.getRequestDispatcher("/WEB-INF/view/camping/camp-reservation.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

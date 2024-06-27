package controller.camping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.CampsiteDao;
import model.vo.Campsite;

@WebServlet("/search/result")
public class SearchCampingController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String camp = request.getParameter("camp");
			String additionalFacilities = request.getParameter("additionalFacilities");
			CampsiteDao campsiteDao = new CampsiteDao();

			if (camp != null) {
				List<Campsite> campsites = campsiteDao.searchByCampsite(camp);
				if (campsites == null) {
					campsites = new ArrayList<Campsite>();
				}
				int listSize = campsites.size();
				
				request.setAttribute("campsites", campsites);
				request.setAttribute("listSize", listSize);
			}

			if (additionalFacilities.equals("pet")) {
				List<Campsite> campsites = campsiteDao.findByAnimalPossible();
				if (campsites == null) {
					campsites = new ArrayList<Campsite>();
				}
				int listSize = campsites.size();
				request.setAttribute("campsites", campsites);
				request.setAttribute("listSize", listSize);
			}
			
			request.getRequestDispatcher("/WEB-INF/view/camping/search-result.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

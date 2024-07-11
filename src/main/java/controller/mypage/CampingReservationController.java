package controller.mypage;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.CampsiteDao;
import model.dao.UserSessionDao;
import model.vo.Campsite;
import model.vo.User;

@WebServlet("/mypage/reservation")
public class CampingReservationController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserSessionDao userSessionDao = new UserSessionDao();
			String userId = "";
			if (request.getSession().getAttribute("authUser") != null) {
			User authUser = (User) request.getSession().getAttribute("authUser");
			userId = authUser.getId();
			}
			int campsite = userSessionDao.findReservationByUserId(userId);
			boolean own = false;
			if (campsite > 0) {
				CampsiteDao campsiteDao = new CampsiteDao();
				Campsite reservationCampsite = campsiteDao.findById(campsite);
				own = true;
				request.setAttribute("reservationCampsite", reservationCampsite);
				request.setAttribute("own", own);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		request.getRequestDispatcher("/WEB-INF/view/mypage/reservation.jsp").forward(request, response);
	}

}

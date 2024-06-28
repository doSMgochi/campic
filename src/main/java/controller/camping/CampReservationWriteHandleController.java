package controller.camping;

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
import model.vo.UserSession;
@WebServlet("/camp-reservation-handle")
public class CampReservationWriteHandleController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (request.getSession().getAttribute("authUser") == null) {
				response.sendRedirect(request.getContextPath() + "/error");
				return;
			}
			int campsiteId = 0;
			String campsiteIdStr = request.getParameter("campsiteId");
			if (campsiteIdStr != null) {
				campsiteId = Integer.parseInt(campsiteIdStr);
				
			}
			CampsiteDao campsiteDao = new CampsiteDao();
			Campsite campsite = campsiteDao.findById(campsiteId);
			UserSessionDao userSessionDao = new UserSessionDao();
			User authUser = (User) request.getSession().getAttribute("authUser");
			String userId = authUser.getId();
			UserSession userSession = new UserSession(userId, campsite.getId(), -1, null, null, -1);
			boolean r = userSessionDao.save(userSession);
			if (r) {
				response.sendRedirect(request.getContextPath() + "/mypage/reservation");
			}
			else {
				response.sendRedirect(request.getContextPath() + "/error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

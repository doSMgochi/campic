package controller.camping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.CampsiteDao;
import model.vo.Campsite;

@WebServlet("/camp/*")
public class CampController extends HttpServlet {
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
				// ID가 유효할 때만 캠핑장 기록 세션에 저장
				if (id > 0) {
				    CampsiteDao campsiteDao = new CampsiteDao();
				    List<Campsite> recentCamps = (List<Campsite>) request.getSession().getAttribute("recentCamps");

				    if (recentCamps == null) {
				        recentCamps = new LinkedList<>();
				    }

				    Campsite campsite = campsiteDao.findById(id);
				    if (campsite != null) {
				        boolean isDuplicate = false;

				        for (Campsite recentCamp : recentCamps) {
				            if (recentCamp.getId() == campsite.getId()) {
				                isDuplicate = true;
				                break;
				            }
				        }

				        if (!isDuplicate) {
				            recentCamps.add(0, campsite); // 최신 방문한 캠핑장 순서로 추가
				            if (recentCamps.size() > 5) {
				                recentCamps.remove(5); // 최대 5개까지만 저장
				            }
				        }

				        request.getSession().setAttribute("recentCamps", recentCamps);
				    }
				}
			}

			CampsiteDao campsiteDao = new CampsiteDao();
			Campsite campsite = campsiteDao.findById(id);
			request.setAttribute("cabin", cabin);
			request.setAttribute("campsite", campsite);
			request.getRequestDispatcher("/WEB-INF/view/camping/camp.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

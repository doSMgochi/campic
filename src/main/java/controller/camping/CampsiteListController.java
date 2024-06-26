package controller.camping;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.CampsiteDao;
import model.vo.Campsite;

@WebServlet("/exhibition/*")
public class CampsiteListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 파싱하기 전에 if 처리
			String uri = request.getRequestURI();
			String uriString = uri.substring(uri.lastIndexOf("/") + 1);
			int id = 0;
			if (uriString.matches("[0-9]+")) {
				id = Integer.parseInt(uriString);
			}
			CampsiteDao campsiteDao = new CampsiteDao();
			switch (id) {
			case 1 -> {
				List<Campsite> vacances = campsiteDao.findVacance();
				request.setAttribute("vacances", vacances);
			}
			case 2 -> {
				// cabin 에 join해서 뽑아내기.
				// cabin 에 추후 할인율 column을 추가해야 할 수도 있음.
			}
			case 3 -> {
				List<Campsite> kidsZone = campsiteDao.findKidsZone();
				request.setAttribute("kidsZone", kidsZone);
			}
			case 4 -> {
				List<Campsite> pension = campsiteDao.findPension();
				request.setAttribute("pension", pension);
			}
			default -> {
				response.sendRedirect(request.getContextPath() + "/index");
				return;
			}
			}
			request.getRequestDispatcher("/WEB-INF/view/camping/exhibition.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/error");
		}

	}
}

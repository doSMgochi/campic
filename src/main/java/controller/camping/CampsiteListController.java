package controller.camping;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.CampsiteDao;

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
			// 페이징

			CampsiteDao campsiteDao = new CampsiteDao();
			int p = request.getParameter("p") == null ? 1 : Integer.parseInt(request.getParameter("p"));
			int size = 10; // 페이지당 표시할 개수
			int start = size * (p - 1) + 1;
			int end = size * p;
			int count = 0;

			//
			switch (id) {
			case 1 -> {
				count = campsiteDao.countVacance();
				request.setAttribute("vacances", campsiteDao.findVacance(start, end));
			}
			case 2 -> {
				// cabin 에 join해서 뽑아내기.
				// cabin 에 추후 할인율 column을 추가해야 할 수도 있음.
			}
			case 3 -> {
				count = campsiteDao.countKidsZone();
				request.setAttribute("kidsZone", campsiteDao.findKidsZone(start, end));
			}
			case 4 -> {
				count = campsiteDao.countPension();
				request.setAttribute("pension", campsiteDao.findPension(start, end));
			}
			default -> {
				id = 0;
			}
			}

			int totalPages = count / size + (count % size > 0 ? 1 : 0);
			int currentPageGroup = (p - 1) / 10 + 1;
			int startPage = (currentPageGroup - 1) * 10 + 1;
			int endPage = Math.min(currentPageGroup * 10, totalPages);

			request.setAttribute("totalPages", totalPages);
			request.setAttribute("currentPage", p);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.getRequestDispatcher("/WEB-INF/view/camping/exhibition.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/error");
		}

	}
}

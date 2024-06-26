package controller.board;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.BoardDao;
import model.vo.Board;
import model.vo.User;

@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Board found = new Board();
			if (request.getParameter("no") != null) {
				int no = Integer.parseInt(request.getParameter("no"));
				BoardDao boardDao = new BoardDao();
				found = boardDao.findByNo(no);
			}
			String body = found.getBody().replace("\n", "<br/>");
			found.setBody(body);

			request.setAttribute("found", found);
			boolean r = false;

			User authUser = (User) request.getSession().getAttribute("authUser");
			if (authUser != null) {
				String userId = authUser.getId();

				if (found.getWriterId() != null && found.getWriterId().equals(userId)) {
					r = true;

				}
			}
			request.setAttribute("r", r);

			request.getRequestDispatcher("/WEB-INF/view/board/view.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

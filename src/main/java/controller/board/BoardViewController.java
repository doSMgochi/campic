package controller.board;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.BoardDao;
import model.dao.BoardReplyDao;
import model.vo.Board;
import model.vo.BoardReply;
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
				boolean f = boardDao.increaseReadCntByNo(no);
				found = boardDao.findByNo(no);
				
				// 답글 가져오기
                BoardReplyDao boardReplyDao = new BoardReplyDao();
                List<BoardReply> replies = boardReplyDao.findAll(no);
                request.setAttribute("replies", replies); // 답글 리스트를 JSP로 전달
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

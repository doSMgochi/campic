package controller.board;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.BoardDao;
import model.vo.Board;

@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Board found = new Board();
			if (request.getParameter("no") != null) {
                int no = Integer.parseInt(request.getParameter("no"));
                BoardDao boardDao = new BoardDao();
                found = boardDao.findByNo(no);
            }
            request.setAttribute("found", found);
			
            request.getRequestDispatcher("/WEB-INF/view/board/view.jsp").forward(request, response);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}

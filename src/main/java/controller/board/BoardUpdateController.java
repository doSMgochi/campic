package controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.BoardDao;
import model.vo.Board;
import model.vo.User;

@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		try {		
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao boardDao = new BoardDao();
		Board board = boardDao.findByNo(no);
		User authUser = (User)request.getSession().getAttribute("authUser");
		String userId = authUser.getId();
		request.setAttribute("board", board);
		if (board == null || !board.getWriterId().equals(userId)){
			out.println("<script>");
			out.println("window.alert(\"수정권한이 없습니다.\")");
			out.println("history.go(-1);");
			out.println("</script>");
			
		}
		
		 request.getRequestDispatcher("/WEB-INF/view/board/update.jsp").forward(request, response);
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

package controller.board;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.BoardReplyDao;
import model.vo.BoardReply;
import model.vo.User;

@WebServlet("/board/reply")
public class BoardReplyController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int boardId = Integer.parseInt(request.getParameter("boardId"));
            String body = request.getParameter("body");
            User authUser = (User) request.getSession().getAttribute("authUser");
            if (authUser == null) {
            	response.sendRedirect(request.getContextPath() + "/login"); // 로그인 페이지로 리다이렉트
            	return;
            }
			
            BoardReply newReply = new BoardReply();
            BoardReplyDao boardReplyDao = new BoardReplyDao();
            newReply.setNo(boardReplyDao.generateKey()); // 새 답글을 위한 고유 키 생성
            newReply.setWriterId(authUser.getId());
            newReply.setBoardId(boardId);
            newReply.setBody(body);
            newReply.setWritedAt(new Date(System.currentTimeMillis())); // 현재 타임스탬프 설정
            newReply.setFavorite(0); // 기본 즐겨찾기 수 설정

            boardReplyDao.save(newReply);
            

            // 답글 추가 후 게시판 보기 페이지로 리다이렉트
            response.sendRedirect(request.getContextPath() + "/board/view?no=" + boardId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

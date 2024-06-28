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

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		try {
			
		
		User authUser = (User) request.getSession().getAttribute("authUser");
		String userId = authUser.getId();
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDao boardDao = new BoardDao();
		Board found = boardDao.findByNo(no);
		boolean result;
		
		if(found == null || found.getWriterId() == null || !found.getWriterId().equals(userId)) {
			result= false;
		}else {
			result= boardDao.deleteByNo(no);
		}
		
		//=============================================================
		if(result) {
			response.sendRedirect(request.getContextPath()+"/board");
		}else {
			out.println("<script>");
			out.println("window.alert(\"삭제가 되지 않았습니다.\n존재하지 않는 글이거나 삭제 권한이 없습니다.\")");
			out.println("</script>");
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

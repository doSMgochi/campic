package controller.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.BoardDao;
import model.vo.Board;

@WebServlet("/board/update-handle")
public class BoardUpdateHandleController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		try {
			int no = Integer.parseInt(request.getParameter("no"));
			BoardDao boardDao = new BoardDao();
			String title = request.getParameter("title");
			String body = request.getParameter("body"); 
			
			Board one = new Board(no, null, body, null, null, new Date(System.currentTimeMillis()),0, null, title, 0 );
			
			boolean r = boardDao.edit(one);
			if (r) {
				response.sendRedirect(request.getContextPath() + "/board/view?no="+no);
			} else {
				out.println("<script>");
				out.println("window.alert(\"의견을 수정하는데 오류가 발생하였습니다.\")");
				out.println("history.go(-1);");
				out.println("</script>");
				
			}
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

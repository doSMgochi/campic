package controller.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.BoardDao;
import model.vo.Board;

@WebServlet("/board")
// 리스트
public class BoardController extends HttpServlet {
	private static final int TOP_POSTS_LIMIT = 3;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BoardDao boardDao = new BoardDao();
			String category = null;

            if (request.getParameter("home") != null) {
                category = "홈";
            } else if (request.getParameter("campingLog") != null) {
                category = "캠핑로그";
            } else if (request.getParameter("campingPhoto") != null) {
                category = "캠핑한컷";
            } else if (request.getParameter("campingTalk") != null) {
                category = "캠핑톡톡";
            } else if (request.getParameter("questions") != null) {
                category = "궁금해요";
            } else if (request.getParameter("articles") != null) {
                category = "아티클";
            }
            
            if (category == null || category.isEmpty() || "홈".equals(category)) {
                // 홈 카테고리일 경우 각 카테고리별 인기 글 가져오기
                category = "홈";
                String[] categories = {"캠핑로그", "캠핑한컷", "캠핑톡톡", "궁금해요", "아티클"};
                Map<String, List<Board>> topPostsByCategory = new HashMap<>();

                for (String cat : categories) {
                    List<Board> topPosts = boardDao.getTopPostsByCategory(cat, TOP_POSTS_LIMIT);
                    topPostsByCategory.put(cat, topPosts);
                }

                request.setAttribute("topPostsByCategory", topPostsByCategory);
                request.setAttribute("category", category);
                request.setAttribute("categories", categories);
                request.getRequestDispatcher("/WEB-INF/view/board/list.jsp").forward(request, response);
                return;
            }
			
			
			request.setAttribute("category", category);
			
			int p = request.getParameter("p")==null ? 1 : Integer.parseInt(request.getParameter("p"));
			int size = 10;
			int start = size*(p-1) +1;
			int end = p*size;
			
			int count = boardDao.countAll();
			int totalPages = count/size + (count%size > 0 ? 1: 0);
			
			request.setAttribute("boards", boardDao.findByCategory(category,  start, end));
			request.setAttribute("totalPages",totalPages);
			request.setAttribute("currentPage", p);
			
			
			
			
			request.getRequestDispatcher("/WEB-INF/view/board/list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

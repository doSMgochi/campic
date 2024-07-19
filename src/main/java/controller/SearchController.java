package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class SearchController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 최근 본 캠핑장 예시 데이터 설정
    	@SuppressWarnings("unchecked")
		List<String> recentCamps = (List<String>) request.getSession().getAttribute("recentCamps");
        
        request.setAttribute("recentCamps", recentCamps);

        request.getRequestDispatcher("/WEB-INF/view/search.jsp").forward(request, response);
    }
}

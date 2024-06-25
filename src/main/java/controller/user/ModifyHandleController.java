package controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UserDao;
import model.vo.User;

@WebServlet("/modify-handle")
public class ModifyHandleController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
		try {
		User authUser = (User) request.getSession().getAttribute("authUser");
		
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		
		UserDao userDao = new UserDao();
		
		boolean result;
		if(password.isBlank()) {
			User temp = new User( authUser.getId(), null, nickname , null, null, null, null);	
			result = userDao.updateNickname(temp);
			 		
		}else{
			User temp = new User( authUser.getId(), password, nickname , null, null, null, null);	
			result = userDao.updateNicknameAndPassword(temp);
		}
		
		if(result) {
			response.sendRedirect(request.getContextPath() + "/index");
			
		} else {
			out.println("<script>");
			out.println("window.alert(\"정보 수정에 실패하였습니다.\")");
			out.println("history.go(-1);");
			out.println("</script>");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

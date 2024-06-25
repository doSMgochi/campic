package controller.user;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.UserDao;
import model.vo.User;

@WebServlet("/signup-handle")
public class SignupHandleController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String[] birth = request.getParameterValues("birth");

			Date birthDate = null;
			if (birth != null && birth.length == 3) {

				String birthString = birth[0] + "-" + birth[1] + "-" + birth[2];
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date utilDate = sdf.parse(birthString);
				birthDate = new Date(utilDate.getTime());

			}

			UserDao userDao = new UserDao();
			boolean result = false;
			User exist = userDao.findById(id);

			if (exist == null) {
				User one = new User(id, password, nickname, gender, birthDate, email, null);
				result = userDao.save(one);
				request.getSession().setAttribute("authUser", one);
			}

			if (result) {
				response.sendRedirect(request.getContextPath() + "/login");
			} else {
				response.sendRedirect(request.getContextPath() + "/signup?error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

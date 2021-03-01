package blue.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blue.dao.UserDao;

@WebServlet("/home/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UserCreate.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("enter");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username == null || username.isBlank() || password == null || password.isBlank()) {
			String warning = "Invalid Username or Password, please retry";
			request.setAttribute("logwarning", warning);
		} else {

			new UserDao().getLogin(username, password).ifPresent(user -> {

				request.setAttribute("user", user);

			});

		}
		request.getRequestDispatcher("parking.jsp").forward(request, response);
	}

}

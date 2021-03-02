package blue.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blue.dao.User;
import blue.dao.UserDao;


@WebServlet("/credit")
public class CreditUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CreditUpdate.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("called");

		HttpSession session = request.getSession(false);
		if (session != null) {
			User user = (User) session.getAttribute("user");
			String credit = request.getParameter("money");
			Long money = Long.parseLong(credit);
			user.setCredit(money);

			boolean check = new UserDao().update(user);
			if (check) {
				request.setAttribute("message", "User updated");
			} else {
				request.setAttribute("message", "User not updated");
			}
		}
		request.getRequestDispatcher("/logged.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

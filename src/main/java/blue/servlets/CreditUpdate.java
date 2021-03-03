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
			Long currentCredit = user.getCredit();
			Long newCredit = currentCredit + money;
			user.setCredit(newCredit);

			boolean check = new UserDao().update(user);
			if (check) {
				request.setAttribute("message", "Credit updated. Your new credit is " + newCredit + "€");
			} else {
				request.setAttribute("message_2", "Credit not updated");
			}
		}
		request.getRequestDispatcher("/credit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {

			User user = (User) session.getAttribute("user");
			Long currentCredit = user.getCredit();
			request.setAttribute("current", currentCredit);
			;
		}
	}

}

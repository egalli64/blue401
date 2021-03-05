package blue.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blue.dao.User;
import blue.dao.UserDao;

@WebServlet("/confirm")
public class Confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			
			request.setAttribute("tariff",session.getAttribute("tariff"));
			
			request.setAttribute("ora", request.getParameter("value"));
			
					
			User user = (User) session.getAttribute("user");
			long credit = user.getCredit();
			String totalPrice = request.getParameter("prezzo");
			long tot = Long.parseLong(totalPrice);
			if ((credit - tot) > 0) {
				user.setCredit(credit - tot);

				boolean check = new UserDao().update(user);
				if (check) {
					request.setAttribute("message", "Payment done. Your new credit is " + (credit - tot) + "€");
				} else {
					request.setAttribute("message_2", "Sorry, internal error. Please retry");
				}
				request.getRequestDispatcher("/park.jsp").forward(request, response);
			} else {
				request.setAttribute("messageNew", "Not enough credit, please top-up");
				request.getRequestDispatcher("/credit.jsp").forward(request, response);
			}

		}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

package blue.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blue.dao.User;

@WebServlet("/show")
public class ShowData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null) {

			User user = (User) session.getAttribute("user");
			Date current = user.getBirthOfDate();
			LocalDate localDate = convertToLocalDateViaInstant(current);
			/*
			 * String name = user.getFirstName(); String lastName = user.getLastName();
			 * String mail = user.geteMail(); String date =
			 * user.getBirthOfDate().toString(); request.setAttribute("name", name);
			 * request.setAttribute("lastname", lastName); request.setAttribute("mail",
			 * mail); request.setAttribute("date", date);
			 */
			request.setAttribute("user", user);
			request.setAttribute("localdate", localDate);

		}
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}
}

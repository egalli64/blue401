package blue.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blue.dao.ParkingObj;

@WebServlet("/park2")
public class ParkAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {

			ParkingObj parking2 = (ParkingObj) session.getAttribute("parking2");
			request.setAttribute("tariff", parking2.getCost());
			session.setAttribute("tariff", parking2.getCost());
			long zero = 0;
			session.setAttribute("totHours", zero);

		}
		request.getRequestDispatcher("/park.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

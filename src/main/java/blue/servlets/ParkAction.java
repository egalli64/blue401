package blue.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blue.dao.ParkingObj;

@WebServlet("/park1")
public class ParkAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {

			ParkingObj parking1 = (ParkingObj) session.getAttribute("parking1");
			request.setAttribute("tariff", parking1.getCost());
			session.setAttribute("tariff", parking1.getCost());
			//request.setAttribute("ora", "0");
		}
		request.getRequestDispatcher("/park.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

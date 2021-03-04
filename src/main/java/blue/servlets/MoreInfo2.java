package blue.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blue.dao.ParkingDao;
import blue.dao.User;

/**
 * Servlet implementation class MoreInfo2
 */
@WebServlet("/parking2")
public class MoreInfo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {

			User user = (User) session.getAttribute("user");
			long vehicleId = user.getVehicleId();
			String pName = "Crocetta_Parking";

			new ParkingDao().getParkingInfo(vehicleId, pName).ifPresentOrElse(parking -> {
				request.setAttribute("parking2", parking);
				session.setAttribute("parking2", parking);
			}, () -> {
				session.invalidate();
			});
		}
		request.getRequestDispatcher("logged.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

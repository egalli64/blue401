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

@WebServlet("/VehicleUpdate")
public class VehicleUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CreditUpdate.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("called");

		HttpSession session = request.getSession(false);
		if (session != null) {
			@SuppressWarnings("unchecked")
			User user = (User) session.getAttribute("user");
			String vehicle_type = request.getParameter("vehicle_id");
			Long vehicle_id = Long.parseLong(vehicle_type);
			String licensePlate = request.getParameter("license_plate");
			user.setLicensePlate(licensePlate);
			user.setVehicleId(vehicle_id);
			boolean check = new UserDao().update(user);
			if (check) {
				request.setAttribute("message_vehicle", "Vehicle updated with license" + licensePlate);
			} else {
				request.setAttribute("message_vehicle_2", "Vehicle not updated");
			}
		}
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

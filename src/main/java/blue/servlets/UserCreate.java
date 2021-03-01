package blue.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import blue.dao.User;
import blue.dao.UserDao;

@WebServlet("/home/registuser")
public class UserCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UserCreate.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace("enter");
        
        String firstName = request.getParameter("user");
        String lastName = request.getParameter("userlast");
        String password = request.getParameter("pass");
        String date = request.getParameter("data");
        Date dateOfBirth = null;
		try {
			dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			log.error("Bad input date",e);
		}
        String eMail = request.getParameter("mail");
        String vehicle = request.getParameter("vehicle");
        long vehicleId = Long.parseLong(vehicle);
        String licensePlate = request.getParameter("license");
        
        User user = new User(firstName, lastName, password, dateOfBirth, eMail, vehicleId, licensePlate);
        
        boolean check = new UserDao().create(user);
        if (check) {
        	request.setAttribute("user", "User created"); //Modificare user
        } else {
        	request.setAttribute("user", "User not created");
        }
        
        //request.getRequestDispatcher("/coder.jsp").forward(request, response);
        
    } 
}
        
        
        
        
        
        
        
        

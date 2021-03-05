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

import blue.dao.UserDao;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UserCreate.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace("enter");
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            String warning = "Invalid Username or Password, please retry";
            request.setAttribute("logwarning", warning);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        } else {

            new UserDao().getLogin(username, password).ifPresentOrElse(user -> {

                request.setAttribute("user", user);
                session.setAttribute("user", user);

                try {
					request.getRequestDispatcher("logged.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					
					e.printStackTrace();
				}

            }, () ->  {
            	String warning = "Invalid Username or Password, please retry";
                request.setAttribute("logwarning", warning);
                try {
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
				
					e.printStackTrace();
				}
            });

        }
    }

}

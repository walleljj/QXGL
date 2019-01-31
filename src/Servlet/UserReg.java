package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import exception.UserException;
import service.IUserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserReg
 */
@WebServlet("/UserReg")
public class UserReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();
	
    public UserReg() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String name = request.getParameter("username2");
    	String realname = request.getParameter("realname2");
    	String password = request.getParameter("password2");
    	String tel = request.getParameter("phone2");
    	String emal= request.getParameter("email2");
    	User user = new User(0,password,name,realname,tel,emal);
    	try {
    		userService.register(user);
    	} catch (UserException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
	}

}

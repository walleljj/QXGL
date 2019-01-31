package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.IUserDao;
import dao.impl.UserDaoImpl;
import exception.UserException;
import service.IUserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class ChangePassServlet
 */
@WebServlet("/ChangePass")
public class ChangePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();
	private IUserDao userDao = new UserDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");
		String pass= request.getParameter("pass");
		User user = userDao.findByName(name);
		user.setPassword(pass);
		try {
			userService.updateUser(user);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

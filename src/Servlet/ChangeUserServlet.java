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
 * Servlet implementation class ChangeUserServlet
 */
@WebServlet("/ChangeUser")
public class ChangeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();
	private IUserDao userDao = new UserDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");
		String realname = request.getParameter("realname");
		String tel = request.getParameter("tel");
		String emal= request.getParameter("emal");
		User user = userDao.findByName(name);
		user.setName(name);
		user.setRealname(realname);
		user.setTel(tel);
		user.setEmal(emal);
		try {
			userService.updateUser(user);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

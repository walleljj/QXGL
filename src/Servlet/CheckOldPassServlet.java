package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.IUserDao;
import dao.impl.UserDaoImpl;

/**
 * Servlet implementation class CheckOldPassServlet
 */
@WebServlet("/CheckOldPass")
public class CheckOldPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserDao userDao = new UserDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOldPassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String username = request.getParameter("username");
		String oldpass = request.getParameter("oldpass");
		User user = userDao.findByName(username);
		String pass = user.getPassword();
		if(!oldpass.equals(pass)){
			out.print(0);
		}
	}


}

package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.UserException;
import service.IUserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class DeletUser
 */
@WebServlet("/DeletUser")
public class DeletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletUser() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String userID = request.getParameter("userId");
		int msg=0;
		try {
			userService.deletUserById(userID);
			msg=1;
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(msg);
	}

}

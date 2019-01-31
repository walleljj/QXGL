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

@WebServlet("/checkUserName")
public class CheckUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserDao userDao = new UserDaoImpl();
    public CheckUserNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//String username = request.getParameter("username");
		String username = request.getParameter("username");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
       PrintWriter out=response.getWriter();
       User user = userDao.findByName(username);
       if(user==null)
    	   out.print("0");
       else
    	   out.print("1");
        out.flush();
		out.close();
       
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		
	}

}

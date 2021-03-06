package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Role;
import dao.IRoleDao;
import dao.impl.RoleDaoImpl;

/**
 * Servlet implementation class AddRole
 */
@WebServlet("/AddRole")
public class AddRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoleDao roleDao = new RoleDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRole() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String rolename = request.getParameter("rolename");
		Role role=new Role(1,rolename);
		roleDao.addRole(role);
		
	}


}

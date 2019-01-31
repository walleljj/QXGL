package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IRoleDao;
import dao.impl.RoleDaoImpl;

/**
 * Servlet implementation class UpdateRole
 */
@WebServlet("/UpdateRole")
public class UpdateRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoleDao roleDao = new RoleDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRole() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rolename = request.getParameter("rolename");
		String id = request.getParameter("roleID");
		roleDao.updateRole(id,rolename);
	}


}

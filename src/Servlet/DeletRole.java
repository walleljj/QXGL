package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IRoleService;
import service.impl.RoleServiceImpl;

/**
 * Servlet implementation class DeletRole
 */
@WebServlet("/DeletRole")
public class DeletRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IRoleService roleService = new RoleServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletRole() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userID = request.getParameter("userId");
		int msg=0;
		roleService.deletRoleById(userID);
		msg=1;
		out.print(msg);
	}

	

}

package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IPermissionDao;
import dao.impl.PermissionDaoImpl;

/**
 * Servlet implementation class DeletPermission
 */
@WebServlet("/DeletPermission")
public class DeletPermission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IPermissionDao permissionDao = new PermissionDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletPermission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String permissionID = request.getParameter("permissionID");
		int msg=0;
		permissionDao.deletByID(permissionID);
		msg=1;
		out.print(msg);
	}

	
}

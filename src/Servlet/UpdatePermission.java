package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IPermissionDao;
import dao.impl.PermissionDaoImpl;

/**
 * Servlet implementation class UpdatePermission
 */
@WebServlet("/UpdatePermission")
public class UpdatePermission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IPermissionDao permissionDao = new PermissionDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePermission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String pername = request.getParameter("pername");
		String perID = request.getParameter("perID");
		String perdescription = request.getParameter("perdescription");
		permissionDao.updatePermissiom(perID, pername, perdescription);
	}

}

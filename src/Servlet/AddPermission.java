package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Permissions;
import dao.IPermissionDao;
import dao.impl.PermissionDaoImpl;

/**
 * Servlet implementation class AddPermission
 */
@WebServlet("/AddPermission")
public class AddPermission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IPermissionDao permissionDao = new PermissionDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPermission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pername = request.getParameter("pername");
		String description = request.getParameter("perdescription");
		Permissions per = new Permissions(1,pername,description);
		permissionDao.addPer(per);
	}


}

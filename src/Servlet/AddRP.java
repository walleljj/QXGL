package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Permissions;
import dao.IPermissionDao;
import dao.IRPDao;
import dao.impl.PermissionDaoImpl;
import dao.impl.RPDaoImpl;

/**
 * Servlet implementation class AddRP
 */
@WebServlet("/AddRP")
public class AddRP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IRPDao rPDao = new RPDaoImpl();
       private IPermissionDao permissionDao = new PermissionDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int msg = 0;
		String pername = request.getParameter("pername");
		String roleId = request.getParameter("roleId");
		Permissions per = null;
		per = permissionDao.findByName(pername);
		if(per!=null){
			int perId = per.getId();
			rPDao.add(roleId,perId);
			msg=1;
		}
		PrintWriter out = response.getWriter();
		out.print(msg);
	}


}

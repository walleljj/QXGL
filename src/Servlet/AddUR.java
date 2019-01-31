package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Role;
import dao.IRoleDao;
import dao.IURDao;
import dao.impl.RoleDaoImpl;
import dao.impl.URDaoImpl;

/**
 * Servlet implementation class AddUR
 */
@WebServlet("/AddUR")
public class AddUR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IRoleDao roleDao = new RoleDaoImpl();
       private IURDao uRDao = new URDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int msg = 0;
		String rolename = request.getParameter("rolename");
		String userId = request.getParameter("userId");
		Role role = null;
		role = roleDao.findRoleByName(rolename);
		if(role!=null){
			int roleId = role.getId();
			uRDao.add(userId,roleId);
			msg=1;
		}
		PrintWriter out = response.getWriter();
		out.print(msg);
	}

}

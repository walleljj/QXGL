package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Resources;
import dao.IResourcesDao;
import dao.impl.ResourcesDaoImpl;

/**
 * Servlet implementation class AddResources
 */
@WebServlet("/AddResources")
public class AddResources extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IResourcesDao resourcesDao = new ResourcesDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResources() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String resname = request.getParameter("resname");
		String resdescription = request.getParameter("resdescription");
		Resources res = new Resources(1,resname,resdescription);
		resourcesDao.addResources(res);
	}

}

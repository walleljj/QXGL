package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IResourcesDao;
import dao.impl.ResourcesDaoImpl;

/**
 * Servlet implementation class DeletResources
 */
@WebServlet("/DeletResources")
public class DeletResources extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IResourcesDao rescerousDao = new ResourcesDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletResources() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String resourcesID = request.getParameter("resourcesID");
		int msg=0;
		rescerousDao.deletByID(resourcesID);
		msg=1;
		out.print(msg);
	}

}

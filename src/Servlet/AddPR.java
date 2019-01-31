package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Resources;
import dao.IPRDao;
import dao.IResourcesDao;
import dao.impl.PRDaoImpl;
import dao.impl.ResourcesDaoImpl;

/**
 * Servlet implementation class AddPR
 */
@WebServlet("/AddPR")
public class AddPR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IPRDao pRDao = new PRDaoImpl();
       private IResourcesDao resourcesDao = new ResourcesDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int msg = 0;
		String resname = request.getParameter("resname");
		String preId = request.getParameter("perId");
		Resources res = null;
		res = resourcesDao.findByName(resname);
		if(res!=null){
			int resId = res.getId();
			pRDao.add(preId,resId);
			msg=1;
		}
		PrintWriter out = response.getWriter();
		out.print(msg);
	}


}

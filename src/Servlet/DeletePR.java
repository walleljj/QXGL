package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IPRDao;
import dao.impl.PRDaoImpl;

/**
 * Servlet implementation class DeletePR
 */
@WebServlet("/DeletePR")
public class DeletePR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IPRDao pRDao = new PRDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String perId = request.getParameter("perId");
		String resId = request.getParameter("resId");
		int msg=0;
		pRDao.delete(perId,resId);
		msg=1;
		out.print(msg);
	}

}

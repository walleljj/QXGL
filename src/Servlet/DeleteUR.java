package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IURDao;
import dao.impl.URDaoImpl;

/**
 * Servlet implementation class DeleteUR
 */
@WebServlet("/DeleteUR")
public class DeleteUR extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private IURDao uRDao = new URDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String roleId = request.getParameter("roleId");
		int msg=0;
		uRDao.delete(userId,roleId);
		msg=1;
		out.print(msg);
	}


}

package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Resources;
import dao.IPRDao;
import dao.impl.PRDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ListPR
 */
@WebServlet("/ListPR")
public class ListPR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IPRDao pRDao = new PRDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPR() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String perID = request.getParameter("perID");
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Resources> li = null;
		li = pRDao.findByPerID(perID);
		out.print("{\"code\":0,\"msg\":\"\",\"count\":"+li.size()+",\"data\":");
		JSONArray jsonarray = new JSONArray();  
		JSONObject jsonobj = new JSONObject(); 
		 for(int i = 0 ; i<li.size() ; i++){
			Resources res = li.get(i);
			 jsonobj.put("id", res.getId());  
			 jsonobj.put("name", res.getName());  
			 jsonobj.put("description", res.getDescription()); 
			 jsonarray.add(jsonobj); 
		 }
		 out = response.getWriter();                    
		 out.println(jsonarray);
		 out.print("}");
		 out.flush();
		 out.close();
	}


}

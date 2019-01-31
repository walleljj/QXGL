package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Permissions;
import dao.IRPDao;
import dao.impl.RPDaoImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ListRP
 */
@WebServlet("/ListRP")
public class ListRP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IRPDao rPDao = new RPDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListRP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String roleID = request.getParameter("roleID");
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Permissions> li = null;
		li = rPDao.findByRoleID(roleID);
		out.print("{\"code\":0,\"msg\":\"\",\"count\":"+li.size()+",\"data\":");
		JSONArray jsonarray = new JSONArray();  
		JSONObject jsonobj = new JSONObject(); 
		 for(int i = 0 ; i<li.size() ; i++){
			Permissions per = li.get(i);
			 jsonobj.put("id", per.getId());  
			 jsonobj.put("name", per.getName());  
			 jsonobj.put("description", per.getDesceription()); 
			 jsonarray.add(jsonobj); 
		 }
		 out = response.getWriter();                    
		 out.println(jsonarray);
		 out.print("}");
		 out.flush();
		 out.close();
	}


}

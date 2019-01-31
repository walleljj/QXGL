package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Role;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.IRoleService;
import service.impl.RoleServiceImpl;

/**
 * Servlet implementation class ListAllRole
 */
@WebServlet("/ListAllRole")
public class ListAllRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IRoleService roleService = new RoleServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllRole() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<Role> li = null;
		li = roleService.listAllRole();
		out.print("{\"code\":0,\"msg\":\"\",\"count\":"+li.size()+",\"data\":");
		JSONArray jsonarray = new JSONArray();  
		JSONObject jsonobj = new JSONObject(); 
		 for(int i = 0 ; i<li.size() ; i++){
			 Role role = li.get(i);
			 jsonobj.put("id", role.getId());  
			 jsonobj.put("name", role.getName());  
			 jsonarray.add(jsonobj); 
		 }
		 out = response.getWriter();                    
		 out.println(jsonarray);
		 out.print("}");
		 out.flush();
		 out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

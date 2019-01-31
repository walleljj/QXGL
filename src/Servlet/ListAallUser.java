package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.IUserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class ListAallUser
 */
@WebServlet("/ListAllUser")
public class ListAallUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAallUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
		List<User> lu = null;
		lu=userService.listAllUser();
		out.print("{\"code\":0,\"msg\":\"\",\"count\":"+lu.size()+",\"data\":");
		JSONArray jsonarray = new JSONArray();  
		JSONObject jsonobj = new JSONObject(); 
		 for(int i = 0 ; i<lu.size() ; i++){
			 User user = lu.get(i);
			 jsonobj.put("id", user.getId());  
			 jsonobj.put("name", user.getName());  
			 jsonobj.put("realname", user.getRealname());
			 jsonobj.put("tel", user.getTel());  
			 jsonobj.put("emal", user.getEmal());  
			 jsonarray.add(jsonobj); 
		 }
		 out = response.getWriter();                    
		 out.println(jsonarray);
		 out.print("}");
		 out.flush();
		 out.close();
		 }catch (Exception e) { 
			 out.print("get data error!"); 
			 e.printStackTrace();
		}
   
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}

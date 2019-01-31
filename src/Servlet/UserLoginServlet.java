package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Resources;
import bean.User;
import dao.IResourcesDao;
import dao.impl.ResourcesDaoImpl;
import service.IUserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserServiceImpl();
	private IResourcesDao resourcesDao = new ResourcesDaoImpl();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		User user = null;
		String path,msg;
		List<User> lu = null;
		List<Resources> res = null;
		try{
			user = userService.login(name, password);
			if(name.equals("admin")){
				path = "/index2.jsp";
				res = resourcesDao.queryAll();
			}else{
				path = "/index.jsp";
				
				res = resourcesDao.findByUserID(user.getId());
				
			}
				
			msg = "登录成功！";
			lu=userService.listAllUser();
			
		}catch(Exception e){
			e.printStackTrace();
			path = "/login.jsp";
			msg="登录失败："+e.getMessage();
		}
		request.getSession().setAttribute("res", res);
		request.getSession().setAttribute("users", lu);
		request.getSession().setAttribute("msg", msg);
		request.getSession().setAttribute("user", user);
		response.sendRedirect(request.getContextPath()+path);
	}

}

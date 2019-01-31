

import bean.User;
import dao.IUserDao;
import dao.impl.UserDaoImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUserDao userDao = new UserDaoImpl();
		User user = userDao.findByName("admin");
		System.out.println(user);

	}

}

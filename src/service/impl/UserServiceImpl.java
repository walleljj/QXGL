package service.impl;



import java.util.List;


import bean.User;
import dao.IUserDao;
import dao.impl.UserDaoImpl;
import exception.UserException;
import service.IUserService;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();

	@Override
	public void register(User user) throws UserException {
		// TODO Auto-generated method stub
		User u = userDao.findByName(user.getName());
		if(u!=null){
			throw new UserException("用户已存在！");
		}
		userDao.saveUser(user);

	}

	@Override
	public User login(String name, String password) throws UserException {
		User c  =userDao.findByName(name);
		if(c==null)
			throw new UserException("用户不存在！");
		if(!c.getPassword().equals(password))
			throw new UserException("密码错误！");
		return c;
	}

	@Override
	public void updateUser(User user) throws UserException {
		// TODO Auto-generated method stub
		userDao.updateUser(user);

	}

	@Override
	public List<User> listAllUser() {
		List<User> list = null;
		list = userDao.queryAll();
		return list;
	}

	@Override
	public void deletUserById(String id) throws UserException {
		// TODO Auto-generated method stub
		userDao.deletUserByID(id);
		
	}

}

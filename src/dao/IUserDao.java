package dao;

import java.util.List;

import bean.User;

public interface IUserDao {
	/**
	 * 通过name查找
	 * @param name
	 * @return
	 */
	public User findByName(String name);
	/**
	 * 添加用户
	 * @param user
	 */
	public void saveUser(User user);
	/**
	 * 更新用户
	 * @param user
	 */
	public void updateUser(User user);
	public List<User> queryAll();
	public void deletUserByID(String id);
	

}

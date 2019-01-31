package service;

import java.util.List;

import bean.User;
import exception.UserException;

public interface IUserService {
	void register(User user) throws UserException;
	User login(String name,String password) throws UserException;
	void updateUser(User user) throws UserException;
	List<User> listAllUser();
	void deletUserById(String id) throws UserException;

}

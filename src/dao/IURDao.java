package dao;

import java.util.List;

import bean.Role;

public interface IURDao {

	List<Role> findByUID(String userID);

	void delete(String userId, String roleId);

	void add(String userId, int roleId);

}

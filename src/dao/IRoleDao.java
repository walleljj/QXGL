package dao;

import java.util.List;

import bean.Role;

public interface IRoleDao {

	List<Role> queryAll();

	void deletRoleById(String id);

	void addRole(Role role);

	void updateRole(String id, String rolename);

	Role findRoleByName(String rolename);

}

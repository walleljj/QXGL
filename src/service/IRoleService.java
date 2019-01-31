package service;

import java.util.List;

import bean.Role;

public interface IRoleService {

	List<Role> listAllRole();

	void deletRoleById(String id);

}

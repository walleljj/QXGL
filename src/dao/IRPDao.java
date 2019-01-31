package dao;

import java.util.List;

import bean.Permissions;

public interface IRPDao {

	List<Permissions> findByRoleID(String roleID);

	void delet(String roleId, String perId);

	void add(String roleId, int perId);

}

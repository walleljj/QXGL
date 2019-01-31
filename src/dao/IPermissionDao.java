package dao;

import java.util.List;

import bean.Permissions;

public interface IPermissionDao {

	List<Permissions> queryAll();

	void deletByID(String permissionID);

	void updatePermissiom(String id, String pername, String perdescription);

	void addPer(Permissions per);

	Permissions findByName(String pername);

}

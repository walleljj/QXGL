package dao;

import java.util.List;

import bean.Resources;

public interface IResourcesDao {

	List<Resources> queryAll();

	void deletByID(String resourcesID);

	void updateResources(String resID, String resname, String resdescription);

	void addResources(Resources res);

	Resources findByName(String resname);

	List<Resources> findByUserID(int id);

}

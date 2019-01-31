package dao;

import java.util.List;

import bean.Resources;

public interface IPRDao {

	List<Resources> findByPerID(String perID);

	void delete(String perId, String resId);

	void add(String preId, int resId);

}

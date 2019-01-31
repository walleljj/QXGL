package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Resources;
import dao.IPRDao;
import util.JdbcUtils;
import util.ResultSetHandler;

public class PRDaoImpl implements IPRDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Resources> findByPerID(String perID) {
		List<Resources> list = new ArrayList<>();
		String sql="select b.id,b.name,b.description FROM tb_permission_resources AS a,tb_resources AS b WHERE a.permission_id='"+perID+"' and a.resource_id=b.id";
		return  (List<Resources>)JdbcUtils.executeQuery(sql, new ResultSetHandler() {
					
					@Override
					public Object process(ResultSet rs) throws SQLException {
						Resources res = null;
						while (rs.next()){
							res = new Resources(rs.getInt(1),rs.getString(2),rs.getString(3));
							list.add(res);}
						return list;
					}
				});
	}

	@Override
	public void delete(String perId, String resId) {
		// TODO Auto-generated method stub
		String sql = "delete  from tb_permission_resources where permission_id='"+perId+"' and resource_id='"+resId+"'";
		JdbcUtils.excuteDML(sql);
	}

	@Override
	public void add(String preId, int resId) {
		// TODO Auto-generated method stub
		String sql = "insert into tb_permission_resources(permission_id,resource_id) values('"+preId+"','"+resId+"')";
		JdbcUtils.excuteDML(sql);
	}

}

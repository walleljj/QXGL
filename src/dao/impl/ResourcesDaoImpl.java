package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Resources;
import dao.IResourcesDao;
import util.JdbcUtils;
import util.ResultSetHandler;

public class ResourcesDaoImpl implements IResourcesDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Resources> queryAll() {
		List<Resources> list = new ArrayList<>();
		String sql="select * from tb_resources";
		return  (List<Resources>)JdbcUtils.executeQuery(sql, new ResultSetHandler() {
					
					@Override
					public Object process(ResultSet rs) throws SQLException {
						Resources res = null;
						while (rs.next()){
							res = new Resources(rs.getInt(1),rs.getString(2),rs.getString(3));
							list.add(res);
						}
						return list;
					}
				});	
	}

	@Override
	public void deletByID(String resourcesID) {
		// TODO Auto-generated method stub
		String sql = "delete  from tb_resources where id="+resourcesID;
		JdbcUtils.excuteDML(sql);
	}

	@Override
	public void updateResources(String resID, String resname, String resdescription) {
		// TODO Auto-generated method stub
		String sql = "update tb_resources set name='"+resname+"',description='"+resdescription+
				"' where id='"+resID+"'";
		JdbcUtils.excuteDML(sql);
	}

	@Override
	public void addResources(Resources res) {
		// TODO Auto-generated method stub
		String sql = "insert into tb_resources(name,description) values('"+res.getName()+"','"+res.getDescription()+"')";
		JdbcUtils.excuteDML(sql);
	}

	@Override
	public Resources findByName(String resname) {
		String sql = "select * from tb_resources where name='"+resname+"'";
		return (Resources)JdbcUtils.executeQuery(sql, new ResultSetHandler() {
			@Override
			public Object process(ResultSet rs) throws SQLException {
				Resources res = null;
				while(rs.next()){
					res = new Resources(rs.getInt(1),rs.getString(2),rs.getString(3));
				}
				return res;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resources> findByUserID(int id) {
		List<Resources> list = new ArrayList<>();
		String sql="select e.id,e.name,e.description "
		+"from tb_user as a,tb_user_role as b,tb_role_permissions as c,tb_permission_resources as d,tb_resources as e "
				+"where a.id='"+id+"' and a.id=b.user_id and b.role_id=c.role_id and c.permissions_id=d.permission_id and "
		+"d.resource_id=e.id";
		
		return  (List<Resources>)JdbcUtils.executeQuery(sql, new ResultSetHandler() {
					
					@Override
					public Object process(ResultSet rs) throws SQLException {
						Resources res = null;
						while (rs.next()){
							res = new Resources(rs.getInt(1),rs.getString(2),rs.getString(3));
							list.add(res);
						}
						return list;
					}
				});	
	}

}

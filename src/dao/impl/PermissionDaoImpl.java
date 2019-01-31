 package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Permissions;
import dao.IPermissionDao;
import util.JdbcUtils;
import util.ResultSetHandler;

public class PermissionDaoImpl implements IPermissionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Permissions> queryAll() {
		List<Permissions> list = new ArrayList<>();
		String sql="select * from tb_permissions";
		return  (List<Permissions>)JdbcUtils.executeQuery(sql, new ResultSetHandler() {
					
					@Override
					public Object process(ResultSet rs) throws SQLException {
						Permissions per = null;
						while (rs.next()){
							per = new Permissions(rs.getInt(1),rs.getString(2),rs.getString(3));
							list.add(per);
						}
						return list;
					}
				});
	}

	@Override
	public void deletByID(String permissionID) {
		String sql = "delete  from tb_permissions where id="+permissionID;
		JdbcUtils.excuteDML(sql);
		
	}

	@Override
	public void updatePermissiom(String id, String pername, String perdescription) {
		// TODO Auto-generated method stub
		String sql = "update tb_permissions set name='"+pername+"',description='"+perdescription+
				"' where id='"+id+"'";
		JdbcUtils.excuteDML(sql);
	}

	@Override
	public void addPer(Permissions per) {
		// TODO Auto-generated method stub
		String sql = "insert into tb_permissions(name,description) values('"+per.getName()+"','"+per.getDesceription()+"')";
		JdbcUtils.excuteDML(sql);
	}

	@Override
	public Permissions findByName(String pername) {
		String sql = "select * from tb_permissions where name='"+pername+"'";
		return (Permissions)JdbcUtils.executeQuery(sql, new ResultSetHandler() {
			@Override
			public Object process(ResultSet rs) throws SQLException {
				Permissions per = null;
				while(rs.next()){
					per = new Permissions(rs.getInt(1),rs.getString(2),rs.getString(3));
				}
				return per;
			}
		});
	}

}

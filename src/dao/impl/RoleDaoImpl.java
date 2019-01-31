package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Role;
import dao.IRoleDao;
import util.JdbcUtils;
import util.ResultSetHandler;

public class RoleDaoImpl implements IRoleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> queryAll() {
		List<Role> list = new ArrayList<>();
		String sql="select * from tb_role";
		return  (List<Role>)JdbcUtils.executeQuery(sql, new ResultSetHandler() {
					
					@Override
					public Object process(ResultSet rs) throws SQLException {
						Role role = null;
						while (rs.next()){
							role = new Role(rs.getInt(1),rs.getString(2));
							list.add(role);
						}
						return list;
					}
				});	
	}

	@Override
	public void deletRoleById(String id) {
		// TODO Auto-generated method stub
		String sql = "delete  from tb_role where id="+id;
		JdbcUtils.excuteDML(sql);
	}

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		String sql = "insert into tb_role(name) values('"+role.getName()+"')";
		JdbcUtils.excuteDML(sql);
		
	}

	@Override
	public void updateRole(String id, String rolename) {
		// TODO Auto-generated method stub
		String sql = "update tb_role set name='"+rolename+
				"' where id='"+id+"'";
		JdbcUtils.excuteDML(sql);
	}

	@Override
	public Role findRoleByName(String rolename) {
		String sql = "select * from tb_role where name='"+rolename+"'";
		return (Role)JdbcUtils.executeQuery(sql, new ResultSetHandler() {
			@Override
			public Object process(ResultSet rs) throws SQLException {
				Role role = null;
				while(rs.next()){
					role = new Role(rs.getInt(1),rs.getString(2));
				}
				return role;
			}
		});
	}

}

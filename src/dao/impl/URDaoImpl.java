package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Role;
import dao.IURDao;
import util.JdbcUtils;
import util.ResultSetHandler;

public class URDaoImpl implements IURDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findByUID(String userID) {
		List<Role> list = new ArrayList<>();
		String sql="select b.id,b.name FROM tb_user_role AS a,tb_role AS b WHERE a.user_id='"+userID+"' and a.role_id=b.id";
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
	public void delete(String userId, String roleId) {
		// TODO Auto-generated method stub
		String sql = "delete  from tb_user_role where user_id='"+userId+"' and role_id='"+roleId+"'";
		JdbcUtils.excuteDML(sql);
	}

	@Override
	public void add(String userId, int roleId) {
		// TODO Auto-generated method stub
		String sql = "insert into tb_user_role(user_id,role_id) values('"+userId+"','"+roleId+"')";
		JdbcUtils.excuteDML(sql);
	}

}

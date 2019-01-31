package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Permissions;
import dao.IRPDao;
import util.JdbcUtils;
import util.ResultSetHandler;

public class RPDaoImpl implements IRPDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Permissions> findByRoleID(String roleID) {
		List<Permissions> list = new ArrayList<>();
		String sql="select b.id,b.name,b.description FROM tb_role_permissions AS a,tb_permissions AS b WHERE a.role_id='"+roleID+"' and a.permissions_id=b.id";
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
	public void delet(String roleId, String perId) {
		// TODO Auto-generated method stub
		String sql = "delete  from tb_role_permissions where role_id='"+roleId+"' and permissions_id='"+perId+"'";
		JdbcUtils.excuteDML(sql);
	}

	@Override
	public void add(String roleId, int perId) {
		// TODO Auto-generated method stub
		String sql = "insert into tb_role_permissions(role_id,permissions_id) values('"+roleId+"','"+perId+"')";
		JdbcUtils.excuteDML(sql);
	}

}

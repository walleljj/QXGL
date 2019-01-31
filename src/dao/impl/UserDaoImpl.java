package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bean.User;
import dao.IUserDao;
import util.JdbcUtils;
import util.ResultSetHandler;

public class UserDaoImpl implements IUserDao {

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from tb_user where name='"+name+"'";
		return (User)JdbcUtils.executeQuery(sql, new ResultSetHandler() {
			@Override
			public Object process(ResultSet rs) throws SQLException {
				User user = null;
				while(rs.next()){
					user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				}
				return user;
			}
		});
		
	}

	@Override
	public void saveUser(User user) {
		String sql = "insert into tb_user(password,name,realname,tel,emal) values('"+user.getPassword()+
				"','"+user.getName()+"','"+user.getRealname()+"','"+user.getTel()+"','"+user.getEmal()+"')";
		JdbcUtils.excuteDML(sql);

	}

	@Override
	public void updateUser(User user) {
		String sql = "update tb_user set password='"+user.getPassword()+
				"',name='"+user.getName()+"',realname='"+user.getRealname()+
				"',tel='"+user.getTel()+"',emal='"+user.getEmal()+"' where name='"+user.getName()+"'";
		JdbcUtils.excuteDML(sql);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryAll() {
		List<User> list = new ArrayList<>();
		String sql = "select * from tb_user";
		return  (List<User>)JdbcUtils.executeQuery(sql, new ResultSetHandler() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				User user = null;
				while (rs.next()){
					user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
					list.add(user);
				}
				return list;
			}
		});
	}

	@Override
	public void deletUserByID(String id) {
		// TODO Auto-generated method stub
		String sql = "delete  from tb_user where id="+id;
		JdbcUtils.excuteDML(sql);

		
	}

}

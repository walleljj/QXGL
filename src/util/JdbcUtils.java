package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 数据库工具类
 * @author 绘梦
 * @date 2018年7月20日 上午9:34:31
 */
public class JdbcUtils {
	private static String dirverClass = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/db_qxgl";
	private static String userName = "root";
	private static String password = "admin";
	/**
	 * 取得连接
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName(dirverClass);
		Connection conn = 
				DriverManager.getConnection(url,userName , password);
		return conn;
	}
	/**
	 * 关闭连接
	 * @param conn
	 * @param stmt
	 * @param re
	 */
	public static void close(Connection conn ,Statement stmt , ResultSet re){
		
		try{
			if(re!=null)re.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			if(stmt!=null)stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			if(conn!=null)conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	/**
	 * 增删改操作
	 * @param sql
	 */
	public static void excuteDML(String sql){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,stmt,null);
		}
	}
	/**
	 * 查询操作
	 * @param sql
	 * @param handler
	 * @return
	 */
	public static Object executeQuery(String sql,ResultSetHandler handler){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Object obj = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
			//使用handler处理结果集并接收返回值ss
			obj = handler.process(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return obj;

	}
}

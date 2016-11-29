package zhcp.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public final class DbPoolUtil {
	private static DataSource ds;
	private static ThreadLocal<Connection> connLocal = new ThreadLocal<Connection>();

	static {
		try {
			Properties props = new Properties();
			props.load(DbPoolUtil.class.getClassLoader().getResourceAsStream(
					"dbcp.properties"));
			ds = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//获得连接池中的连接
	public synchronized static Connection getConnection(){
	  Connection conn=connLocal.get();
		try {
			if(conn==null){
			conn=ds.getConnection();
			connLocal.set(conn);
			}
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	  }
	//关闭与连接池的连接
	public synchronized static void closeConnection(){
		Connection conn=connLocal.get();
		connLocal.set(null);
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//测试
	public static void main(String[] args){
		System.out.println(getConnection());
		System.out.println(getConnection());
	}
	
  }

package zhcp.dao;

import java.sql.Connection;

import zhcp.util.DbPoolUtil;

/*
 * DAO基础类，创建数据库连接和关闭数据库连接
 * */
public class BaseDAO {
   public Connection getConnection(){
	   return DbPoolUtil.getConnection();
   }
   public void closeConnection(){
	   DbPoolUtil.closeConnection();
   }
}

package zhcp.interceptor;

import zhcp.util.DbPoolUtil;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//拦截器
public class TransactionInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = 1276154887735163303L;

	public String intercept(ActionInvocation invocation) throws Exception {
		try{
			DbPoolUtil.getConnection().setAutoCommit(false);
//			System.out.println("连接数据库，事务开始");
			invocation.invoke();
			DbPoolUtil.getConnection().commit();
//			System.out.println("事务提交");
		}catch(Exception ex){
			ex.printStackTrace();
			DbPoolUtil.getConnection().rollback();
//			System.out.println("事务回滚");
		}finally{
			DbPoolUtil.closeConnection();
//			System.out.println("关闭数据库连接");
		}
		return null;
	}

}

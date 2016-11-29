package zhcp.action;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import zhcp.dao.DAOFactory;
import zhcp.dao.UserDAO;
import zhcp.domain.User;
import zhcp.listener.OnlineUserListener;

public class LoginAction extends BaseAction {
	private User user;

	public String login() {
		UserDAO dao = DAOFactory.getUserDAO();
		try {
			User user2 = dao.findByUserIdAndPwd(user.getUserId(),user.getPassword(),user.getUser_level());
			if (user2!=null) {
				Date date=new Date();
				long loginTime=date.getTime();
				user2.setLoginTime(loginTime);
				
				HttpSession session=request.getSession();
				session.setAttribute("user", user2);
				
				//在线人数
				int activeUserNum=OnlineUserListener.getActiveSessions();
				ServletContext context=session.getServletContext();
				context.setAttribute("activeUserNum", activeUserNum);
				
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "fail";
	}
	
	/**
	 * 注销登录
	 * */
	public String logout(){
		HttpSession session=request.getSession();
		//session.removeAttribute("user");//此句不能执行，不然在线人数统计会出现错误
		session.invalidate();
		
		//在线人数
		int activeUserNum=OnlineUserListener.getActiveSessions();
		ServletContext context=session.getServletContext();
		context.setAttribute("activeUserNum", activeUserNum);
		
		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

package zhcp.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import zhcp.domain.User;

//监听器
public class OnlineUserListener implements HttpSessionListener,
		HttpSessionAttributeListener {
	private static int activeSessions = 0;

	private static Map<String, User> online = new HashMap<String, User>();

	public static Map<String, User> getOnline() {
		return online;
	}

	public static int getActiveSessions() {
		return activeSessions;
	}

	public void attributeAdded(HttpSessionBindingEvent event) {
		if (event.getName().equals("user")) {
			System.out.println("User logged in.");
			User user = (User) event.getSession().getAttribute("user");
			online.put(event.getSession().getId(), user);
			++activeSessions;
			
			System.out.println("在线人数："+getActiveSessions());
		}
	}

	public synchronized void attributeRemoved(HttpSessionBindingEvent event) {
		if (event.getName().equals("user")) {
			System.out.println("User logged out.");
			online.remove(event.getSession().getId());
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {

	}

	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		String sessionId = session.getId();

		System.out.println("有人来了:" + sessionId);
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		String sessionId = session.getId();

		System.out.println("有人走了:" + sessionId);

		Map<String, User> map = getOnline();
		User user = map.get(sessionId);
		if (user != null) {
			System.out.println(user.getUserId() + "注销成功！");
			if (activeSessions > 0) {
				--activeSessions;
			}
		}
	}
}
package zhcp.action.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.util.JSONTokener;
import zhcp.action.BaseAction;
import zhcp.dao.DAOFactory;
import zhcp.dao.ScoreDAO;
import zhcp.dao.UserDAO;
import zhcp.domain.ClassMes;
import zhcp.domain.JSONClass;
import zhcp.domain.User;

public class UserAction extends BaseAction{
    /**
     * ajax生成班级下拉菜单
     * */
	private String jsonClasses;
	
	public String selClasses(){
    	String grade=request.getParameter("grade");
    	UserDAO dao=DAOFactory.getUserDAO();
    	List<ClassMes> classList=new ArrayList<ClassMes>();
    	try {
			classList=dao.findByGrade(grade);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<JSONClass> jsonClass=new ArrayList<JSONClass>();
		Iterator<ClassMes> iter=classList.iterator();
		while(iter.hasNext()){
			ClassMes cm=iter.next();
			String name=cm.getMajor_name()+cm.getClass_name()+"（"+cm.getEdu_bg()+"）";
			JSONClass jc=new JSONClass(name,cm.getClass_abbr());
			jsonClass.add(jc);
		}
		JSONArray jsonObject=JSONArray.fromObject(jsonClass);
		jsonClasses=jsonObject.toString();
    	return "success";
    }

	public String getJsonClasses() {
		return jsonClasses;
	}

	public void setJsonClasses(String jsonClasses) {
		this.jsonClasses = jsonClasses;
	}
	
	/**
	 * 按要求查询用户信息
	 * */
	private List<User> userList;
	
	public String listUser(){
		String level=request.getParameter("level");
		String class_abbr=request.getParameter("class_abbr");
		
		UserDAO dao=DAOFactory.getUserDAO();
		try {
			userList=dao.findUser(level,class_abbr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	/**
	 * 添加用户
	 * */
	private User user;
	
	public String addUser(){
		UserDAO dao=DAOFactory.getUserDAO();
		ScoreDAO sdao=DAOFactory.getScoreDAO();
		boolean flag=false;
		try {
			if("2".equals(user.getUser_level())||"3".equals(user.getUser_level())){
				sdao.insertPeculiar(user.getUserId());
				sdao.insertProgress(user.getUserId());
				sdao.insertDeyu(user.getUserId());
				sdao.insertZhiyu(user.getUserId());
				sdao.insertTiyu(user.getUserId());
			}
			flag=dao.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			return "success";
		}else{
			return "error";
		}
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 批量删除用户信息
	 * */
	private String level;
	private String class_abbr;
	private String jsonString;
	
	public String deleteUser(){
		//System.out.println(jsonString);
		JSONTokener token=new JSONTokener(jsonString);
		JSONArray array=(JSONArray)token.nextValue();
		
		UserDAO dao=DAOFactory.getUserDAO();
		ScoreDAO sdao=DAOFactory.getScoreDAO();
		boolean flag=false;
		try {
			List<String> list=dao.findUserId(array);
//			System.out.println(list.size());
			sdao.delPeculiar(list);
			sdao.delProgress(list);
			sdao.delDeyu(list);
			sdao.delZhiyu(list);
			sdao.delTiyu(list);
			flag=dao.delUseres(array);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			return "success";
		}else{
		    return "error";
		}
	}
    
	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getClass_abbr() {
		return class_abbr;
	}

	public void setClass_abbr(String classAbbr) {
		class_abbr = classAbbr;
	}
	
	/**
	 * 跟新用戶信息
	 * */
	public String updateUser(){
		UserDAO dao=DAOFactory.getUserDAO();
		boolean flag=false;
		try {
			flag=dao.updateUserById(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			return "success";
		}else{
		    return "error";
		}
	}
	
}

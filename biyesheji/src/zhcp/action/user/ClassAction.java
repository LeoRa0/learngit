package zhcp.action.user;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.util.JSONTokener;
import zhcp.action.BaseAction;
import zhcp.dao.DAOFactory;
import zhcp.dao.UserDAO;
import zhcp.domain.ClassMes;

public class ClassAction extends BaseAction{
    /**
     * 添加班级信息
     * */	
	private ClassMes cla;
	
	public String addClass(){
		try {
			request.setCharacterEncoding("utf8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
    	UserDAO dao=DAOFactory.getUserDAO();
    	try {
			dao.insertClass(cla);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "success";
    }

	public ClassMes getCla() {
		return cla;
	}

	public void setCla(ClassMes cla) {
		this.cla = cla;
	}
	
	/**
     * 查询年级所有班级信息
     * */
	private List<ClassMes> listClass=new ArrayList<ClassMes>();
	
	public String listAllClass(){
		String grade=request.getParameter("grade");
//		System.out.println(grade);
		if(grade==null||"".equals(grade)){
			grade="all";
		}
//		System.out.println(grade);
		UserDAO dao=DAOFactory.getUserDAO();
		try {
			listClass=dao.findByGrade(grade);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}

	public List<ClassMes> getListClass() {
		return listClass;
	}

	public void setListClass(List<ClassMes> listClass) {
		this.listClass = listClass;
	}
	
	/**
     * 批量删除班级信息
     * */
	public String deleteClass(){
		String jsonString=request.getParameter("jsonString");
		
		//解析JSON格式的字符串
		JSONTokener token=new JSONTokener(jsonString);
		JSONArray array=(JSONArray)token.nextValue();
//		for(int i=0;i<array.size();i++){
//			JSONObject obj=array.getJSONObject(i);
//			System.out.println(obj.getInt("id"));
//		}
		UserDAO dao=DAOFactory.getUserDAO();
		boolean flag=false;
		try {
			flag = dao.delClasses(array);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(flag){
			return "success";
		}
		return "failed";
	}
	
	/**
	 * 更新班级信息
	 * */
	public String updateClass(){
		try {
			request.setCharacterEncoding("utf8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
    	UserDAO dao=DAOFactory.getUserDAO();
    	try {
			dao.updateClass(cla);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "success";
	}
	
}

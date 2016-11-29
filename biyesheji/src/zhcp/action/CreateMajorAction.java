package zhcp.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import zhcp.dao.DAOFactory;
import zhcp.dao.UserDAO;
import zhcp.domain.Major;

public class CreateMajorAction extends BaseAction{
    private String dataJSON;
	
	public String execute(){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
    	String edu_bg=request.getParameter("edu_bg");
    	UserDAO dao=DAOFactory.getUserDAO();
    	List<Major> majorList=new ArrayList<Major>();
    	try {
			majorList=dao.findByEDU(edu_bg);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	//将List对象转化为JSON对象
    	JSONArray jsonArr=JSONArray.fromObject(majorList);
    	dataJSON=jsonArr.toString();//JSON转为字符串
    	
    	return "success";
    }

	public String getDataJSON() {
		return dataJSON;
	}

	public void setDataJSON(String dataJSON) {
		this.dataJSON = dataJSON;
	}
	
}

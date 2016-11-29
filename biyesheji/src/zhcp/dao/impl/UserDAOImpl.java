package zhcp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import zhcp.dao.BaseDAO;
import zhcp.dao.UserDAO;
import zhcp.domain.ClassMes;
import zhcp.domain.Major;
import zhcp.domain.User;

public class UserDAOImpl extends BaseDAO implements UserDAO{
	private static final String FIND_BY_EDU=
		"select major_ID,major_name from major where edu_bg=?";
    private static final String INSERT_CLA=
    	"insert into class(grade,edu_bg,major_ID,class_name,class_abbr)values(?,?,?,?,?)";
    private static final String FIND_BY_GRADE=
    	"select c.id,c.grade,c.edu_bg,m.major_name,c.class_name,c.class_abbr "
       +" from class c "
       +" join major m "
       +" on c.major_ID=m.major_ID ";
	private static final String DEL_CLASSES=
		"delete from class where id=?";	
	private static final String UPDATE_CLASS=
		"update class set grade=?,edu_bg=?,major_ID=?,class_name=?,class_abbr=? where id=?";
    private static final String FIND_USER=
    	"select u.id,u.userId,u.user_level,u.user_name,u.class_abbr,l.user_identity,c.grade,c.edu_bg,m.major_name,c.class_name "
      +" from user as u "
      +" join level l on u.user_level=l.user_level "
      +" join class c on u.class_abbr=c.class_abbr " 
      +" join major m on c.major_ID=m.major_ID ";
    private static final String FIND_Admin=
    	"select u.id,u.userId,u.user_level,u.user_name,l.user_identity "
      +" from user as u "
      +" join level l on u.user_level=l.user_level ";
	private static final String INSERT_USER=
		"insert into user(userId,password,user_name,class_abbr,user_level)values(?,?,?,?,?)";
	private static final String DEL_USERES=
		"delete from user where id=?";
	private static final String FIND_USERID=
		"select userId,user_level from user where id=?";
	private static final String UPDATE_USER_BY_ID=
		"update user set userId=?,user_name=?,user_level=?,class_abbr=? ";
	
    /*
	 * 根据账号查找登录用户信息
	 * */
    public User findByUserIdAndPwd(String userId,String password,String user_level) throws Exception {
		User user=null;
    	Connection conn=this.getConnection();
    	PreparedStatement pst=null;
    	if(!("0".equals(user_level))){
			pst=conn.prepareStatement(FIND_USER+" where userId=? and password=? and u.user_level=?");
    	}else{
    		pst=conn.prepareStatement(FIND_Admin+" where userId=? and password=? and u.user_level=?");
    	}
    	pst.setString(1, userId);
		pst.setString(2, password);
		pst.setString(3, user_level);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			user=new User();
			user.setId(rs.getInt("id"));
			user.setUserId(rs.getString("userId"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_level(rs.getString("user_level"));
			user.setUser_identity(rs.getString("user_identity"));
			if(!("0".equals(user_level))){
				user.setEdu_bg(rs.getString("edu_bg"));
				user.setGrade(rs.getString("grade"));
				user.setMajor_name(rs.getString("major_name"));
				user.setClass_name(rs.getString("class_name"));
				user.setClass_abbr(rs.getString("class_abbr"));
			}
		}
		//this.closeConnection();
		return user;
	}
    
    /**
     * Ajax生成专业下拉菜单
     * */
	public List<Major> findByEDU(String eduBg) throws Exception {
		List<Major> listMajor=new ArrayList<Major>();
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(FIND_BY_EDU);
		pst.setString(1, eduBg);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			Major mj=new Major();
			mj.setId(rs.getString("major_ID"));
			mj.setName(rs.getString("major_name"));
			listMajor.add(mj);
		}
		//this.closeConnection();
		return listMajor;
	}

	/**
	 * 添加班级信息
	 * */
	public void insertClass(ClassMes cla) throws Exception {
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(INSERT_CLA);
		pst.setString(1, cla.getGrade());
		pst.setString(2, cla.getEdu_bg());
		pst.setString(3, cla.getMajor_ID());
		pst.setString(4, cla.getClass_name());
		pst.setString(5, cla.getClass_abbr());
		pst.executeUpdate();
		//this.closeConnection();
	}
    /**
     * 
     * */
	public List<ClassMes> findByGrade(String grade) throws Exception {
		Connection conn=this.getConnection();
		PreparedStatement pst=null;
		if(grade.equals("all")){
			pst=conn.prepareStatement(FIND_BY_GRADE+" order by c.grade,m.major_name,c.class_abbr");
		}else{
			pst=conn.prepareStatement(FIND_BY_GRADE+" where c.grade=? order by c.grade,m.major_name,c.class_abbr");
			pst.setString(1, grade);
		}
		ResultSet rs=pst.executeQuery();
		List<ClassMes> list=new ArrayList<ClassMes>();
		while(rs.next()){
			ClassMes cm=new ClassMes();
			cm.setId(rs.getInt("id"));
			cm.setGrade(rs.getString("grade"));
			cm.setEdu_bg(rs.getString("edu_bg"));
			cm.setMajor_name(rs.getString("major_name"));
			cm.setClass_name(rs.getString("class_name"));
			cm.setClass_abbr(rs.getString("class_abbr"));
			list.add(cm);
		}
		//this.closeConnection();
		return list;
	}
    /**
     * 批量删除班级信息
     * */
	public boolean delClasses(JSONArray array) throws Exception {
		boolean flag=false;
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(DEL_CLASSES);
		for(int i=0;i<array.size();i++){
			pst.setInt(1,array.getJSONObject(i).getInt("id"));
			pst.addBatch();
		}
		pst.executeBatch();//批量处理
		flag=true;
		//this.closeConnection();
		return flag;
	}
    
	/**
	 * 更新班级信息
	 * */
	public void updateClass(ClassMes cla) throws Exception {
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(UPDATE_CLASS);
		pst.setString(1, cla.getGrade());
		pst.setString(2, cla.getEdu_bg());
		pst.setString(3, cla.getMajor_ID());
		pst.setString(4, cla.getClass_name());
		pst.setString(5, cla.getClass_abbr());
		pst.setInt(6, cla.getId());
		pst.executeUpdate();
		//this.closeConnection();
	}

	public List<User> findUser(String level, String classAbbr)
			throws Exception {
		Connection conn=getConnection();
		PreparedStatement pst=null;
		if(classAbbr==null||"".equals(classAbbr)){
			pst=conn.prepareStatement(FIND_USER+" where u.user_level=? order by u.userId");
			pst.setString(1, level);
		}else{
			pst=conn.prepareStatement(FIND_USER+" where (u.user_level=? or u.user_level='2') and u.class_abbr=? order by u.userId");
			pst.setString(1, level);
			pst.setString(2, classAbbr);
		}
		ResultSet rs=pst.executeQuery();
		List<User> userList=new ArrayList<User>();
		while(rs.next()){
			User user=new User();
			user.setId(rs.getInt("id"));
			user.setUserId(rs.getString("userId"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_level(rs.getString("user_level"));
			user.setUser_identity(rs.getString("user_identity"));
			user.setEdu_bg(rs.getString("edu_bg"));
			user.setGrade(rs.getString("grade"));
			user.setMajor_name(rs.getString("major_name"));
			user.setClass_name(rs.getString("class_name"));
			user.setClass_abbr(rs.getString("class_abbr"));
			
			userList.add(user);
		}
		return userList;
	}

	public boolean insertUser(User user) throws Exception {
		boolean flag=false;
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(INSERT_USER);
		pst.setString(1, user.getUserId());
		pst.setString(2, user.getPassword());
		pst.setString(3, user.getUser_name());
		pst.setString(4, user.getClass_abbr());
		pst.setString(5, user.getUser_level());
		pst.executeUpdate();
		flag=true;
		return flag;
	}

	/**
	 * 批量删除用户
	 * */
	public boolean delUseres(JSONArray array) throws Exception {
		boolean flag=false;
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(DEL_USERES);
		for(int i=0;i<array.size();i++){
			JSONObject obj=array.getJSONObject(i);
            pst.setInt(1, obj.getInt("id"));
            pst.addBatch();
		}
		pst.executeBatch();
		flag=true;
		return flag;
	}

    /**
     * 
     * */	
	public boolean updateUserById(User user) throws Exception {
		boolean flag=false;
		Connection conn=getConnection();
		PreparedStatement pst=null;
		boolean pwd=user.getPassword()==null||"".equals(user.getPassword());
		if(pwd){
			pst=conn.prepareStatement(UPDATE_USER_BY_ID+" where id=?");
		}else{
			pst=conn.prepareStatement(UPDATE_USER_BY_ID+",spassword=? where id=?");
		}
		pst.setString(1, user.getUserId());
		pst.setString(2,user.getUser_name());
		pst.setString(3,user.getUser_identity());
		pst.setString(4, user.getClass_abbr());
		if(pwd){
			pst.setInt(5, user.getId());
		}else{
			pst.setString(5, user.getPassword());
			pst.setInt(6, user.getId());
		}
		pst.executeUpdate();
		flag=true;
		return flag;
	}

	public List<String> findUserId(JSONArray array) throws Exception {
		List<String> list=new ArrayList<String>();
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(FIND_USERID);
		ResultSet rs=null;
		for(int i=0;i<array.size();i++){
			pst.setInt(1,array.getJSONObject(i).getInt("id"));
			rs=pst.executeQuery();
			System.out.println(i);
			if(rs.next()){
				if("2".equals(rs.getString("user_level"))||"3".equals(rs.getString("user_level"))){
				    list.add(rs.getString("userId"));
//				    System.out.println(rs.getString("userId"));
				}
			}
		}
		return list;
	}
   
}

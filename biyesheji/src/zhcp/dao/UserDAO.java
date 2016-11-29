package zhcp.dao;

import java.util.List;

import net.sf.json.JSONArray;

import zhcp.domain.ClassMes;
import zhcp.domain.Major;
import zhcp.domain.User;

public interface UserDAO {
    public User findByUserIdAndPwd(String userId,String password,String user_level)throws Exception;

	public List<Major> findByEDU(String eduBg)throws Exception;

	public void insertClass(ClassMes cla)throws Exception;

	public List<ClassMes> findByGrade(String grade)throws Exception;

	public boolean delClasses(JSONArray array)throws Exception;

	public void updateClass(ClassMes cla)throws Exception;

	public List<User> findUser(String level, String classAbbr)throws Exception;

	public boolean insertUser(User user)throws Exception;

	public boolean delUseres(JSONArray array)throws Exception;

	public boolean updateUserById(User user)throws Exception;

	public List<String> findUserId(JSONArray array)throws Exception;
}

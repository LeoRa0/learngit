package zhcp.domain;


public class User {
	private int id;
	private String userId;
	private String password;
	private String user_name;
	private String user_identity;
	private String user_level;
	private String checkCode;
	private String grade;
	private String edu_bg;
	private String major_name;
	private String class_name;
	private String class_abbr;
	private long loginTime;

	public long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	
	public String getUser_level() {
		return user_level;
	}

	public void setUser_level(String userLevel) {
		user_level = userLevel;
	}

	public String getClass_abbr() {
		return class_abbr;
	}

	public void setClass_abbr(String classAbbr) {
		class_abbr = classAbbr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public String getUser_identity() {
		return user_identity;
	}

	public void setUser_identity(String userIdentity) {
		user_identity = userIdentity;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEdu_bg() {
		return edu_bg;
	}

	public void setEdu_bg(String eduBg) {
		edu_bg = eduBg;
	}

	public String getMajor_name() {
		return major_name;
	}

	public void setMajor_name(String majorName) {
		major_name = majorName;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String className) {
		class_name = className;
	}

}

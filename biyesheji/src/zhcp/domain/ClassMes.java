package zhcp.domain;

public class ClassMes {
	private int id;
    private String grade;
    private String edu_bg;
    private String major_ID;
    private String major_name;
    private String class_name;
    private String class_abbr;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMajor_name() {
		return major_name;
	}
	public void setMajor_name(String majorName) {
		major_name = majorName;
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
	public String getMajor_ID() {
		return major_ID;
	}
	public void setMajor_ID(String majorID) {
		major_ID = majorID;
	}
	public String getClass_abbr() {
		return class_abbr;
	}
	public void setClass_abbr(String classAbbr) {
		class_abbr = classAbbr;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String className) {
		class_name = className;
	}
    
}

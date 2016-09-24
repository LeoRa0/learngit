package com.tarena.elts.entity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tarena.elts.util.Config;

/**
 * 实体数据的管理 软件中的数据管理 
 * 从磁盘（文件）加载用户和考题数据到内存集合中
 * */
public class EntityContext {
	private Config config;

	public EntityContext(Config config) {
		this.config = config;
		loadUsers(config.getString("UserFile"));
		loadQuestions(config.getString("QuestionFile"));
		loadRule(config.getString("RuleFile"));
	}


	/**
	 * users是用来存储所有用户信息的，
	 * 其中key是用户的ID， value是用户实例，
	 * 用户信息从磁盘文件加载
	 * */
	private HashMap<Integer, User> users = 
		new HashMap<Integer, User>();

	/**
	 * 加载并解析用户文件内容到users集合中
	 * 
	 * @param file用户文件名
	 * */
	private void loadUsers(String file) {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(
					   new BufferedInputStream(
							new FileInputStream(file)), "GBK"));
			String row;
			while ((row = in.readLine()) != null) {
				row = row.trim();
				if (row.equals("") || row.startsWith("#")) {
					continue;
				}
				// row=1001:刘苍松:1234:13810381038:liucs@tarena.com.cn
				User user = parseUser(row);
				users.put(user.getId(), user);
			}
			in.close();
		} catch (IOException e) {
//			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private User parseUser(String row) {
		// row=1001:刘苍松:1234:13810381038:liucs@tarena.com.cn
		String[] data = row.split(":");
		User user = new User();
		user.setId(Integer.parseInt(data[0]));
		user.setName(data[1]);
		user.setPasswd(data[2]);
		user.setPhone(data[3]);
		user.setEmail(data[4]);
		return user;
	}

	public User findUserById(int id) {
		return users.get(id);
		//users对象是HashMap类的实例，get（k）返回此映射对于指定键所
		//映射的值，如果该映射对于此键不包含任何映射关系，则返回 null。
	}
	
	/**
	 * 全部试题的集合，key是级别（level），
	 * value是对于level下的所有试题
	 * */
	private Map<Integer,List<Question>> questions=
		new HashMap<Integer,List<Question>>();
	
	public List<Question> findQuestions(int level){
		return new ArrayList<Question>(questions.get(level));
		//将找到的试题按副本返回，起到隔离的作用
	}
	
	/** 解析试题文件到questions集合中*/
	private void loadQuestions(String file) {
		try{
			BufferedReader in=new BufferedReader(
					new InputStreamReader(
							new BufferedInputStream(
									new FileInputStream(file)),"GBK"));
			String str;
			while((str=in.readLine())!=null){
				str=str.trim();
				if(str.equals("")||str.startsWith("#")){
					continue;
				}
				//解析流信息到Question对象
				Question q=parseQuestion(str,in);
				addQuestion(q);//添加到集合中
			}
			in.close();
		}catch(Exception e){
//			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	private void addQuestion(Question q) {
		if(questions.containsKey(q.getLevel())){
			questions.get(q.getLevel()).add(q);
		}else{
			List<Question> list=new ArrayList<Question>();
			list.add(q);
			questions.put(q.getLevel(), list);
		}
	} 
	
	

	private Question parseQuestion(String str, BufferedReader in) 
	    throws IOException{
		String[] data=str.split("[@,][a-z]+=");
		//split从开头切的时候，生成的数组的第一个元素是空串？
		//str:  @answer=2/3,score=5,level=5
		//以上字符串切为如下结果
		//data:{"","2/3","5","5"}
		Question q=new Question();
		q.setAnswers(parseAnswer(data[1]));
		q.setScore(Integer.parseInt(data[2]));
		q.setLevel(Integer.parseInt(data[3]));
		q.setTitle(in.readLine());//读取题干
		List<String> options=new ArrayList<String>();
		options.add(in.readLine());//连续读取四个选项
		options.add(in.readLine());
		options.add(in.readLine());
		options.add(in.readLine());
		q.setOptions(options);
		//q.setType(q.getAnswers().size()==1?0:1);
		//工作中应写成下面的格式
		q.setType(q.getAnswers().size()==1?
				Question.SINGLE_SELECTION:Question.MULTI_SELECTION);
		return q;
	}

	//answer:"2/3"
	private List<Integer> parseAnswer(String answer) {
		List<Integer> list=new ArrayList<Integer>();
		String[] data=answer.split("/");
		for(String s:data){
			list.add(Integer.parseInt(s));
		}
		return list;
	}

//    private List<String> rule=new ArrayList<String>();
//    public List<String> getRule(){
//    	return this.rule;
//    }
	
	private String str="";
	
	public String getStr(){
		return str;
	}
	
	private void loadRule(String file) {
		try{
			BufferedReader in=new BufferedReader(
					new InputStreamReader(
							new BufferedInputStream(
									new FileInputStream(file)),"UTF-8"));
			String s;
		while((s=in.readLine())!=null){
			str+=s+"\n";
		}
		in.close();
		}catch(IOException e){
//			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public int getTimeLimit(){
		return config.getInt("TimeLimit");
	}
	
	public String getTitle(){
		return config.getString("PaperTitle");
	}
}

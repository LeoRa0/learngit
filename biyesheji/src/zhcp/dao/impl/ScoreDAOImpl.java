package zhcp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import zhcp.dao.BaseDAO;
import zhcp.dao.ScoreDAO;
import zhcp.domain.PecScore;
import zhcp.domain.ProScore;

public class ScoreDAOImpl extends BaseDAO implements ScoreDAO {
    private static final String INSERT_PECULIAR=
	   "insert into peculiar(userId)values(?)";
    private static final String INSERT_PROGRESS=
 	   "insert into progress(userId)values(?)";
    private static final String INSERT_DEYU=
 	   "insert into deyu(userId)values(?)";
    private static final String INSERT_ZHIYU=
 	   "insert into zhiyu(userId)values(?)";
    private static final String INSERT_TIYU=
 	   "insert into tiyu(userId)values(?)";
    private static final String DEL_PECULIAR=
		"delete from peculiar where userId=?";
    private static final String DEL_PROGRESS=
		"delete from progress where userId=?";
    private static final String DEL_DEYU=
		"delete from deyu where userId=?";
    private static final String DEL_ZHIYU=
		"delete from zhiyu where userId=?";
    private static final String DEL_TIYU=
		"delete from tiyu where userId=?";
    
    
    private static final String LIST_PECSCORE=
	   "select u.user_name,p.*,(p.score_1+p.score_2+p.score_3+p.score_4+p.score_5) as sum " +
	   " from user u right outer join peculiar p on u.userId=p.userId where u.class_abbr=? " +
	   " order by p.userId";
    private static final String FIND_PSMES=
    	"select * from peculiar where userId=?";
    private static final String ADD_PS=
    	"update peculiar set score_1=?,score_2=?,score_3=?,score_4=?,score_5=? where userId=?";
    private static final String LIST_PRO=
    	"select u.user_name,p.* from user u right outer join progress p " +
    	" on u.userId=p.userId where u.class_abbr=? " +
	    " order by p.userId";
    private static final String FIND_PRO=
    	"select * from progress where userId=?";
    private static final String ADD_PRO=
    	"update progress set score_1=?,score_2=?,score_3=?,score_4=?," +
    	"score_5=?,score_6=?,score_7=?,score_8=?,score_9=?,score_10=? where userId=?";
    
	/**
	 * 特殊加分表添加用户
	 * */
	public void insertPeculiar(String userId) throws Exception {
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(INSERT_PECULIAR);
		pst.setString(1, userId);
		pst.executeUpdate();
	}
	
	/**
	 * 发展素质分数表添加用户
	 * */
	public void insertProgress(String userId) throws Exception {
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(INSERT_PROGRESS);
		pst.setString(1, userId);
		pst.executeUpdate();
	}
	
	/**
	 * 德育分数表添加用户
	 * */
	public void insertDeyu(String userId) throws Exception {
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(INSERT_DEYU);
		pst.setString(1, userId);
		pst.executeUpdate();
	}
	
	/**
	 * 智育分数表添加用户
	 * */
	public void insertZhiyu(String userId) throws Exception {
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(INSERT_ZHIYU);
		pst.setString(1, userId);
		pst.executeUpdate();
	}
	
	/**
	 * 体育分数表添加用户
	 * */
	public void insertTiyu(String userId) throws Exception {
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(INSERT_TIYU);
		pst.setString(1, userId);
		pst.executeUpdate();
	}
	
	/**
	 * 批量删除特殊加分表信息
	 * */
	public void delPeculiar(List<String> list) throws Exception {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(DEL_PECULIAR);
		for(int i=0;i<list.size();i++){
            pst.setString(1, list.get(i));
            pst.addBatch();
		}
		pst.executeBatch();
	}
	
	/**
	 * 批量删除分数表信息
	 * */
	public void delProgress(List<String> list) throws Exception {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(DEL_PROGRESS);
		for(int i=0;i<list.size();i++){
            pst.setString(1, list.get(i));
            pst.addBatch();
		}
		pst.executeBatch();
	}
	/**
	 * 批量删除分数表信息
	 * */
	public void delDeyu(List<String> list) throws Exception {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(DEL_DEYU);
		for(int i=0;i<list.size();i++){
            pst.setString(1, list.get(i));
            pst.addBatch();
		}
		pst.executeBatch();
	}
	
	/**
	 * 批量删除分数表信息
	 * */
	public void delZhiyu(List<String> list) throws Exception {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(DEL_ZHIYU);
		for(int i=0;i<list.size();i++){
            pst.setString(1, list.get(i));
            pst.addBatch();
		}
		pst.executeBatch();
	}
	
	/**
	 * 批量删除分数表信息
	 * */
	public void delTiyu(List<String> list) throws Exception {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(DEL_TIYU);
		for(int i=0;i<list.size();i++){
            pst.setString(1, list.get(i));
            pst.addBatch();
		}
		pst.executeBatch();
	}
	
	
	
	
	/**
	 * 
	 * */
	public List<PecScore> listPecScore(String cla) throws Exception {
		List<PecScore> list=new ArrayList<PecScore>();
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(LIST_PECSCORE);
		pst.setString(1, cla);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			PecScore ps=new PecScore();
			ps.setUserId(rs.getString("userId"));
			ps.setUser_name(rs.getString("user_name"));
			ps.setScore_1(rs.getInt("score_1"));
			ps.setScore_2(rs.getInt("score_2"));
			ps.setScore_3(rs.getInt("score_3"));
			ps.setScore_4(rs.getInt("score_4"));
			ps.setScore_5(rs.getInt("score_5"));
			ps.setSum(rs.getInt("sum"));
			list.add(ps);
		}
		return list;
	}

	/**
	 * 按学号查询学生个人的特殊加分信息
	 * */
	public PecScore findPSMes(String userId) throws Exception {
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(FIND_PSMES);
		pst.setString(1,userId);
		ResultSet rs=pst.executeQuery();
		PecScore ps=null;
		if(rs.next()){
			ps=new PecScore();
			ps.setUserId(rs.getString("userId"));
			ps.setScore_1(rs.getInt("score_1"));
			ps.setScore_2(rs.getInt("score_2"));
			ps.setScore_3(rs.getInt("score_3"));
			ps.setScore_4(rs.getInt("score_4"));
			ps.setScore_5(rs.getInt("score_5"));
		}
		return ps;
	}

	/**
	 * 更新特殊分数表
	 * */
	public void updatePS(PecScore ps) throws Exception {
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(ADD_PS);
		pst.setInt(1, ps.getScore_1());
		pst.setInt(2, ps.getScore_2());
		pst.setInt(3, ps.getScore_3());
		pst.setInt(4, ps.getScore_4());
		pst.setInt(5, ps.getScore_5());
		pst.setString(6, ps.getUserId());
		pst.executeUpdate();
	}

	/**
	 * 班班级查询学生发展素质分
	 * */
	public List<ProScore> listProScore(String cla) throws Exception {
		List<ProScore> list=new ArrayList<ProScore>();
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(LIST_PRO);
		pst.setString(1, cla);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			ProScore ps=new ProScore();
			ps.setUserId(rs.getString("userId"));
			ps.setUser_name(rs.getString("user_name"));
			ps.setScore_1(rs.getInt("score_1"));
			ps.setScore_2(rs.getInt("score_2"));
			ps.setScore_3(rs.getInt("score_3"));
			ps.setScore_4(rs.getInt("score_4"));
			ps.setScore_5(rs.getInt("score_5"));
			ps.setScore_6(rs.getInt("score_6"));
			ps.setScore_7(rs.getInt("score_7"));
			ps.setScore_8(rs.getInt("score_8"));
			ps.setScore_9(rs.getInt("score_9"));
			ps.setScore_10(rs.getInt("score_10"));
			list.add(ps);
		}
		return list;
	}

	/**
	 * 按学号查询学生个人的发展素质分信息
	 * */
	public ProScore findProMes(String userId) throws Exception {
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(FIND_PRO);
		pst.setString(1, userId);
		ResultSet rs=pst.executeQuery();
		ProScore ps=null;
		if(rs.next()){
			ps=new ProScore();
			ps.setUserId(rs.getString("userId"));
			ps.setScore_1(rs.getInt("score_1"));
			ps.setScore_2(rs.getInt("score_2"));
			ps.setScore_3(rs.getInt("score_3"));
			ps.setScore_4(rs.getInt("score_4"));
			ps.setScore_5(rs.getInt("score_5"));
			ps.setScore_6(rs.getInt("score_6"));
			ps.setScore_7(rs.getInt("score_7"));
			ps.setScore_8(rs.getInt("score_8"));
			ps.setScore_9(rs.getInt("score_9"));
			ps.setScore_10(rs.getInt("score_10"));
		}
		return ps;
	}

	/**
	 * 更新个人素质测评信息
	 * */
	public void updatePro(ProScore pro) throws Exception {
		Connection conn=this.getConnection();
		PreparedStatement pst=conn.prepareStatement(ADD_PRO);
		pst.setInt(1, pro.getScore_1());
		pst.setInt(2, pro.getScore_2());
		pst.setInt(3, pro.getScore_3());
		pst.setInt(4, pro.getScore_4());
		pst.setInt(5, pro.getScore_5());
		pst.setInt(6, pro.getScore_6());
		pst.setInt(7, pro.getScore_7());
		pst.setInt(8, pro.getScore_8());
		pst.setInt(9, pro.getScore_9());
		pst.setInt(10, pro.getScore_10());
		pst.setString(11, pro.getUserId());
		pst.executeUpdate();
		
	}

}

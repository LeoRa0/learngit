package zhcp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zhcp.dao.BaseDAO;
import zhcp.dao.BaseScoreDAO;
import zhcp.domain.Deyu;
import zhcp.domain.Tiyu;
import zhcp.domain.Zhiyu;

public class BaseScoreDAOImpl extends BaseDAO implements BaseScoreDAO {
    private static final String LIST_TIYU=
    	"select t.*,u.user_name from user u right outer join tiyu t on u.userId=t.userId " +
    	" where u.class_abbr=? order by t.userId";
	private static final String TIYU_MES=
		"select * from tiyu where userId=?";
    private static final String UPDATE_TIYU=
    	"update tiyu set score_1=?,score_2=?,score_3=?,score_4=?,score_5=?,score_6=?,score_7=? " +
    	" where userId=?";
    private static final String LIST_DEYU=
    	"select d.*,u.user_name from user u right outer join deyu d on u.userId=d.userId " +
    	" where u.class_abbr=? order by d.userId";
	private static final String DEYU_MES=
		"select * from deyu where userId=?";
    private static final String UPDATE_DEYU=
    	"update deyu set score_1=?,score_2=?,score_3=?,score_4=?,score_5=?,score_6=?,score_7=?," +
    	"score_8=?,score_9=?,score_10=?,score_11=?,score_12=?,score_13=?,score_14=?,score_15=?," +
    	"score_16=?,score_17=?,score_18=?,score_19=?,score_20=?,score_21=?,score_22=?,score_23=?," +
    	"score_24=?,score_25=?,score_26=? where userId=?";
    private static final String LIST_ZHIYU=
    	"select z.*,u.user_name from user u right outer join zhiyu z on u.userId=z.userId " +
    	" where u.class_abbr=? order by z.userId";
	private static final String ZHIYU_MES=
		"select * from zhiyu where userId=?";
    private static final String UPDATE_ZHIYU=
    	"update zhiyu set score_1=?,score_2=?,score_3=?,score_4=?,score_5=?,score_6=?,score_7=?," +
    	"score_8=?,score_9=?,score_10=?,score_11=?,score_12=? where userId=?";
    
    
    
    /**
     * 体育素质分
     * */
	public List<Tiyu> listScore_tiyu(String cla) throws Exception {
		List<Tiyu> list=new ArrayList<Tiyu>();
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(LIST_TIYU);
		pst.setString(1, cla);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			Tiyu ty=new Tiyu();
			ty.setUserId(rs.getString("userId"));
			ty.setUser_name(rs.getString("user_name"));
			ty.setScore_1(rs.getInt("score_1"));
			ty.setScore_2(rs.getInt("score_2"));
			ty.setScore_3(rs.getInt("score_3"));
			ty.setScore_4(rs.getInt("score_4"));
			ty.setScore_5(rs.getInt("score_5"));
			ty.setScore_6(rs.getInt("score_6"));
			ty.setScore_7(rs.getInt("score_7"));
			list.add(ty);
		}
		return list;
	}

	/**
	 * 单个学生的体育素质分信息
	 * */
	public Tiyu listMes_tiyu(String userId) throws Exception {
		Tiyu ty=null;
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(TIYU_MES);
		pst.setString(1, userId);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			ty=new Tiyu();
			ty.setUserId(userId);
			ty.setScore_1(rs.getInt("score_1"));
			ty.setScore_2(rs.getInt("score_2"));
			ty.setScore_3(rs.getInt("score_3"));
			ty.setScore_4(rs.getInt("score_4"));
			ty.setScore_5(rs.getInt("score_5"));
			ty.setScore_6(rs.getInt("score_6"));
			ty.setScore_7(rs.getInt("score_7"));
		}
		return ty;
	}

	/**
	 * 跟新学生个人体育素质信息
	 * */
	public void updateTiyu(Tiyu ty) throws Exception {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(UPDATE_TIYU);
		pst.setInt(1, ty.getScore_1());
		pst.setInt(2, ty.getScore_2());
		pst.setInt(3, ty.getScore_3());
		pst.setInt(4, ty.getScore_4());
		pst.setInt(5, ty.getScore_5());
		pst.setInt(6, ty.getScore_6());
		pst.setInt(7, ty.getScore_7());
		pst.setString(8, ty.getUserId());
		pst.executeUpdate();
	}

	 /**
     * 德育素质分
     * */
	public List<Deyu> listScore_deyu(String cla) throws Exception {
		List<Deyu> list=new ArrayList<Deyu>();
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(LIST_DEYU);
		pst.setString(1, cla);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			Deyu dy=new Deyu();
			dy.setUserId(rs.getString("userId"));
			dy.setUser_name(rs.getString("user_name"));
			dy.setScore_1(rs.getInt("score_1"));
			dy.setScore_2(rs.getInt("score_2"));
			dy.setScore_3(rs.getInt("score_3"));
			dy.setScore_4(rs.getInt("score_4"));
			dy.setScore_5(rs.getInt("score_5"));
			dy.setScore_6(rs.getInt("score_6"));
			dy.setScore_7(rs.getInt("score_7"));
			dy.setScore_8(rs.getInt("score_8"));
			dy.setScore_9(rs.getInt("score_9"));
			dy.setScore_10(rs.getInt("score_10"));
			dy.setScore_11(rs.getInt("score_11"));
			dy.setScore_12(rs.getInt("score_12"));
			dy.setScore_13(rs.getInt("score_13"));
			dy.setScore_14(rs.getInt("score_14"));
			dy.setScore_15(rs.getInt("score_15"));
			dy.setScore_16(rs.getInt("score_16"));
			dy.setScore_17(rs.getInt("score_17"));
			dy.setScore_18(rs.getInt("score_18"));
			dy.setScore_19(rs.getInt("score_19"));
			dy.setScore_20(rs.getInt("score_20"));
			dy.setScore_21(rs.getInt("score_21"));
			dy.setScore_22(rs.getInt("score_22"));
			dy.setScore_23(rs.getInt("score_23"));
			dy.setScore_24(rs.getInt("score_24"));
			dy.setScore_25(rs.getInt("score_25"));
			dy.setScore_26(rs.getInt("score_26"));
			list.add(dy);
		}
		return list;
	}
	
	/**
	 * 单个学生的德育素质分信息
	 * */
	public Deyu listMes_deyu(String userId) throws Exception {
		Deyu dy=null;
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(DEYU_MES);
		pst.setString(1, userId);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			dy=new Deyu();
			dy.setUserId(userId);
			dy.setScore_1(rs.getInt("score_1"));
			dy.setScore_2(rs.getInt("score_2"));
			dy.setScore_3(rs.getInt("score_3"));
			dy.setScore_4(rs.getInt("score_4"));
			dy.setScore_5(rs.getInt("score_5"));
			dy.setScore_6(rs.getInt("score_6"));
			dy.setScore_7(rs.getInt("score_7"));
			dy.setScore_8(rs.getInt("score_8"));
			dy.setScore_9(rs.getInt("score_9"));
			dy.setScore_10(rs.getInt("score_10"));
			dy.setScore_11(rs.getInt("score_11"));
			dy.setScore_12(rs.getInt("score_12"));
			dy.setScore_13(rs.getInt("score_13"));
			dy.setScore_14(rs.getInt("score_14"));
			dy.setScore_15(rs.getInt("score_15"));
			dy.setScore_16(rs.getInt("score_16"));
			dy.setScore_17(rs.getInt("score_17"));
			dy.setScore_18(rs.getInt("score_18"));
			dy.setScore_19(rs.getInt("score_19"));
			dy.setScore_20(rs.getInt("score_20"));
			dy.setScore_21(rs.getInt("score_21"));
			dy.setScore_22(rs.getInt("score_22"));
			dy.setScore_23(rs.getInt("score_23"));
			dy.setScore_24(rs.getInt("score_24"));
			dy.setScore_25(rs.getInt("score_25"));
			dy.setScore_26(rs.getInt("score_26"));
		}
		return dy;
	}

	/**
	 * 跟新学生个人德育素质信息
	 * */
	public void updateDeyu(Deyu dy) throws Exception {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(UPDATE_DEYU);
		pst.setInt(1, dy.getScore_1());
		pst.setInt(2, dy.getScore_2());
		pst.setInt(3, dy.getScore_3());
		pst.setInt(4, dy.getScore_4());
		pst.setInt(5, dy.getScore_5());
		pst.setInt(6, dy.getScore_6());
		pst.setInt(7, dy.getScore_7());
		pst.setInt(8, dy.getScore_8());
		pst.setInt(9, dy.getScore_9());
		pst.setInt(10, dy.getScore_10());
		pst.setInt(11, dy.getScore_11());
		pst.setInt(12, dy.getScore_12());
		pst.setInt(13, dy.getScore_13());
		pst.setInt(14, dy.getScore_14());
		pst.setInt(15, dy.getScore_15());
		pst.setInt(16, dy.getScore_16());
		pst.setInt(17, dy.getScore_17());
		pst.setInt(18, dy.getScore_18());
		pst.setInt(19, dy.getScore_19());
		pst.setInt(20, dy.getScore_20());
		pst.setInt(21, dy.getScore_21());
		pst.setInt(22, dy.getScore_22());
		pst.setInt(23, dy.getScore_23());
		pst.setInt(24, dy.getScore_24());
		pst.setInt(25, dy.getScore_25());
		pst.setInt(26, dy.getScore_26());
		pst.setString(27, dy.getUserId());
		pst.executeUpdate();
	}
	
	/**
     * 德育素质分
     * */
	public List<Zhiyu> listScore_zhiyu(String cla) throws Exception {
		List<Zhiyu> list=new ArrayList<Zhiyu>();
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(LIST_ZHIYU);
		pst.setString(1, cla);
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			Zhiyu zy=new Zhiyu();
			zy.setUserId(rs.getString("userId"));
			zy.setUser_name(rs.getString("user_name"));
			zy.setScore_1(rs.getInt("score_1"));
			zy.setScore_2(rs.getInt("score_2"));
			zy.setScore_3(rs.getInt("score_3"));
			zy.setScore_4(rs.getInt("score_4"));
			zy.setScore_5(rs.getInt("score_5"));
			zy.setScore_6(rs.getInt("score_6"));
			zy.setScore_7(rs.getInt("score_7"));
			zy.setScore_8(rs.getInt("score_8"));
			zy.setScore_9(rs.getInt("score_9"));
			zy.setScore_10(rs.getInt("score_10"));
			zy.setScore_11(rs.getInt("score_11"));
			zy.setScore_12(rs.getInt("score_12"));
			list.add(zy);
		}
		return list;
	}
	
	/**
	 * 单个学生的德育素质分信息
	 * */
	public Zhiyu listMes_zhiyu(String userId) throws Exception {
		Zhiyu zy=null;
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(ZHIYU_MES);
		pst.setString(1, userId);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			zy=new Zhiyu();
			zy.setUserId(userId);
			zy.setScore_1(rs.getInt("score_1"));
			zy.setScore_2(rs.getInt("score_2"));
			zy.setScore_3(rs.getInt("score_3"));
			zy.setScore_4(rs.getInt("score_4"));
			zy.setScore_5(rs.getInt("score_5"));
			zy.setScore_6(rs.getInt("score_6"));
			zy.setScore_7(rs.getInt("score_7"));
			zy.setScore_8(rs.getInt("score_8"));
			zy.setScore_9(rs.getInt("score_9"));
			zy.setScore_10(rs.getInt("score_10"));
			zy.setScore_11(rs.getInt("score_11"));
			zy.setScore_12(rs.getInt("score_12"));
		}
		return zy;
	}

	/**
	 * 跟新学生个人德育素质信息
	 * */
	public void updateZhiyu(Zhiyu zy) throws Exception {
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement(UPDATE_ZHIYU);
		pst.setInt(1, zy.getScore_1());
		pst.setInt(2, zy.getScore_2());
		pst.setInt(3, zy.getScore_3());
		pst.setInt(4, zy.getScore_4());
		pst.setInt(5, zy.getScore_5());
		pst.setInt(6, zy.getScore_6());
		pst.setInt(7, zy.getScore_7());
		pst.setInt(8, zy.getScore_8());
		pst.setInt(9, zy.getScore_9());
		pst.setInt(10, zy.getScore_10());
		pst.setInt(11, zy.getScore_11());
		pst.setInt(12, zy.getScore_12());
		pst.setString(13, zy.getUserId());
		pst.executeUpdate();
	}

}

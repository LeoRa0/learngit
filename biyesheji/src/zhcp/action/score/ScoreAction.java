package zhcp.action.score;

import java.util.List;

import zhcp.action.BaseAction;
import zhcp.dao.DAOFactory;
import zhcp.dao.ScoreDAO;
import zhcp.domain.PecScore;
import zhcp.domain.ProScore;
import zhcp.domain.ProSum;
import zhcp.service.ScoreHandle;

public class ScoreAction extends BaseAction {
	private String grade;
	private String cla;
	private List<PecScore> listPS;
	private String userId;
	private PecScore ps;
	private List<ProSum> listProSum;
	private ProScore pro;

	/**
	 * 查询班级所有学生特殊加分信息
	 * */
	public String listPecScore() {
		ScoreDAO sdao = DAOFactory.getScoreDAO();
		try {
			listPS = sdao.listPecScore(cla);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 按学号查询特殊加分详情
	 * */
	public String listPSMes() {
		ScoreDAO sdao = DAOFactory.getScoreDAO();
		try {
			ps = sdao.findPSMes(userId);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 更新特殊加分表
	 * */
	public String addPS() {
		ScoreDAO sdao = DAOFactory.getScoreDAO();
		try {
			sdao.updatePS(ps);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 查询班级所有学生发展素质分数表信息
	 * */
	public String listProScore() {
		ScoreDAO sdao = DAOFactory.getScoreDAO();
		try {
			List<ProScore> listPro = sdao.listProScore(cla);
			listProSum = ScoreHandle.handleProgress(listPro);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 按学号查询发展素质分详情
	 * */
	public String listProMes() {
		ScoreDAO sdao = DAOFactory.getScoreDAO();
		try {
			pro = sdao.findProMes(userId);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * 更新发展素质分
	 * */
	public String addPro() {
		ScoreDAO sdao = DAOFactory.getScoreDAO();
		try {
			sdao.updatePro(pro);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCla() {
		return cla;
	}

	public void setCla(String cla) {
		this.cla = cla;
	}

	public List<PecScore> getListPS() {
		return listPS;
	}

	public void setListPS(List<PecScore> listPS) {
		this.listPS = listPS;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public PecScore getPs() {
		return ps;
	}

	public void setPs(PecScore ps) {
		this.ps = ps;
	}

	public List<ProSum> getListProSum() {
		return listProSum;
	}

	public void setListProSum(List<ProSum> listProSum) {
		this.listProSum = listProSum;
	}

	public ProScore getPro() {
		return pro;
	}

	public void setPro(ProScore pro) {
		this.pro = pro;
	}

}

package zhcp.action.score;

import java.util.List;

import zhcp.action.BaseAction;
import zhcp.dao.BaseScoreDAO;
import zhcp.dao.ScoreDAO;
import zhcp.dao.impl.BaseScoreDAOImpl;
import zhcp.dao.impl.ScoreDAOImpl;
import zhcp.domain.BaseScore;
import zhcp.domain.Deyu;
import zhcp.domain.DeyuSum;
import zhcp.domain.PecScore;
import zhcp.domain.ProScore;
import zhcp.domain.ProSum;
import zhcp.domain.SynScore;
import zhcp.domain.Tiyu;
import zhcp.domain.TiyuSum;
import zhcp.domain.Zhiyu;
import zhcp.domain.ZhiyuSum;
import zhcp.service.ScoreHandle;

public class BaseScoreAction extends BaseAction {
	private String jspTitle;
	private String actionName;
	private String cla;
	private String userId;
	private List<TiyuSum> listty;
	private Tiyu ty;
	private List<DeyuSum> listdy;
	private Deyu dy;
	private List<ZhiyuSum> listzy;
	private Zhiyu zy;
	private List<BaseScore> listBase;
	private List<SynScore> listSyn;
	

	public String tiyu() {
		jspTitle = "体育素质测评";
		actionName = "listScore_tiyu.action";
		return "success";
	}

	public String deyu() {
		jspTitle = "德育素质测评";
		actionName = "listScore_deyu.action";
		return "success";
	}

	public String zhiyu() {
		jspTitle = "智育素质测评";
		actionName = "listScore_zhiyu.action";
		return "success";
	}
	
	public String totalScore() {
		jspTitle = "基础素质测评总分表";
		actionName = "listScore_totalScore.action";
		return "success";
	}
	
	/**
	 *体育 
	 * */
	public String listScore_tiyu() {
        BaseScoreDAO bsdao=new BaseScoreDAOImpl();
        try {
			List<Tiyu> list=bsdao.listScore_tiyu(cla);
			listty=ScoreHandle.handleTiyuScore(list);
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * @throws Exception 
	 * 体育
	 * */
	public String listMes_tiyu() throws Exception{
		BaseScoreDAO bsdao=new BaseScoreDAOImpl();
		ty=bsdao.listMes_tiyu(userId);
		return "success";
	}
	
	/**
	 * 更新某个学生的体育素质分
	 * @throws Exception 
	 * */
	public String addMes_tiyu() throws Exception{
		BaseScoreDAO bsdao=new BaseScoreDAOImpl();
		bsdao.updateTiyu(ty);
		return "success";
	}
	
	/**
	 * 德育
	 * */
	public String listScore_deyu() {
        BaseScoreDAO bsdao=new BaseScoreDAOImpl();
        try {
			List<Deyu> list=bsdao.listScore_deyu(cla);
			listdy=ScoreHandle.handleDeyuScore(list);
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * @throws Exception 
	 * 德育
	 * */
	public String listMes_deyu() throws Exception{
		BaseScoreDAO bsdao=new BaseScoreDAOImpl();
		dy=bsdao.listMes_deyu(userId);
		return "success";
	}
	
	/**
	 * 更新某个学生的德育素质分
	 * @throws Exception 
	 * */
	public String addMes_deyu() throws Exception{
		BaseScoreDAO bsdao=new BaseScoreDAOImpl();
		bsdao.updateDeyu(dy);
		return "success";
	}
	
	/**
	 * 智育
	 * */
	public String listScore_zhiyu() {
        BaseScoreDAO bsdao=new BaseScoreDAOImpl();
        try {
			List<Zhiyu> list=bsdao.listScore_zhiyu(cla);
			listzy=ScoreHandle.handleZhiyuScore(list);
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * @throws Exception 
	 * 智育
	 * */
	public String listMes_zhiyu() throws Exception{
		BaseScoreDAO bsdao=new BaseScoreDAOImpl();
		zy=bsdao.listMes_zhiyu(userId);
		return "success";
	}
	
	/**
	 * 更新某个学生的智育素质分
	 * @throws Exception 
	 * */
	public String addMes_zhiyu() throws Exception{
		BaseScoreDAO bsdao=new BaseScoreDAOImpl();
		bsdao.updateZhiyu(zy);
		return "success";
	}
	
	/**
	 * 基础素质测评总分
	 * */
	public String listScore_totalScore() {
        BaseScoreDAO bsdao=new BaseScoreDAOImpl();
        try {
        	List<Deyu> list=bsdao.listScore_deyu(cla);
			listdy=ScoreHandle.handleDeyuScore(list);
			
        	List<Zhiyu> list2=bsdao.listScore_zhiyu(cla);
			listzy=ScoreHandle.handleZhiyuScore(list2);
			
			List<Tiyu> list3=bsdao.listScore_tiyu(cla);
			listty=ScoreHandle.handleTiyuScore(list3);
			
			listBase=ScoreHandle.handleBaseScore(listdy,listzy,listty);
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 *综合测评综合分数表
	 * */
	public String listScore_syn() {
		BaseScoreDAO bsdao=new BaseScoreDAOImpl();
        ScoreDAO sdao=new ScoreDAOImpl();
        try {
        	List<Deyu> list=bsdao.listScore_deyu(cla);
			listdy=ScoreHandle.handleDeyuScore(list);
			
        	List<Zhiyu> list2=bsdao.listScore_zhiyu(cla);
			listzy=ScoreHandle.handleZhiyuScore(list2);
			
			List<Tiyu> list3=bsdao.listScore_tiyu(cla);
			listty=ScoreHandle.handleTiyuScore(list3);
			
			listBase=ScoreHandle.handleBaseScore(listdy,listzy,listty);
			
			List<ProScore> listPro = sdao.listProScore(cla);
			List<ProSum> listProSum = ScoreHandle.handleProgress(listPro);
			
			List<PecScore> listPS = sdao.listPecScore(cla);
			
			listSyn=ScoreHandle.handleScore(listBase,listProSum,listPS);
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 *综合测评分数详表
	 * */
	public String listScore_detail() {
        BaseScoreDAO bsdao=new BaseScoreDAOImpl();
        ScoreDAO sdao=new ScoreDAOImpl();
        try {
        	List<Deyu> list=bsdao.listScore_deyu(cla);
			listdy=ScoreHandle.handleDeyuScore(list);
			
        	List<Zhiyu> list2=bsdao.listScore_zhiyu(cla);
			listzy=ScoreHandle.handleZhiyuScore(list2);
			
			List<Tiyu> list3=bsdao.listScore_tiyu(cla);
			listty=ScoreHandle.handleTiyuScore(list3);
			
			listBase=ScoreHandle.handleBaseScore(listdy,listzy,listty);
			
			List<ProScore> listPro = sdao.listProScore(cla);
			List<ProSum> listProSum = ScoreHandle.handleProgress(listPro);
			
			List<PecScore> listPS = sdao.listPecScore(cla);
			
			listSyn=ScoreHandle.handleScore(listBase,listProSum,listPS);
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String getJspTitle() {
		return jspTitle;
	}

	public void setJspTitle(String jspTitle) {
		this.jspTitle = jspTitle;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getCla() {
		return cla;
	}

	public void setCla(String cla) {
		this.cla = cla;
	}

	public List<TiyuSum> getListty() {
		return listty;
	}

	public void setListty(List<TiyuSum> listty) {
		this.listty = listty;
	}

	public Tiyu getTy() {
		return ty;
	}

	public void setTy(Tiyu ty) {
		this.ty = ty;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<DeyuSum> getListdy() {
		return listdy;
	}

	public void setListdy(List<DeyuSum> listdy) {
		this.listdy = listdy;
	}

	public Deyu getDy() {
		return dy;
	}

	public void setDy(Deyu dy) {
		this.dy = dy;
	}

	public List<ZhiyuSum> getListzy() {
		return listzy;
	}

	public void setListzy(List<ZhiyuSum> listzy) {
		this.listzy = listzy;
	}

	public Zhiyu getZy() {
		return zy;
	}

	public void setZy(Zhiyu zy) {
		this.zy = zy;
	}

	public List<BaseScore> getListBase() {
		return listBase;
	}

	public void setListBase(List<BaseScore> listBase) {
		this.listBase = listBase;
	}

	public List<SynScore> getListSyn() {
		return listSyn;
	}

	public void setListSyn(List<SynScore> listSyn) {
		this.listSyn = listSyn;
	}
	
}

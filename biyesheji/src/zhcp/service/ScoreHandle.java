package zhcp.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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

/**
 * 处理分数
 * */
public class ScoreHandle {
   private static DecimalFormat df=new DecimalFormat("########0.00" );  //保留两位小数
	/**
	 * 处理发展素质分
	 * */
	public static List<ProSum> handleProgress(List<ProScore> listPro) {
		List<ProSum> list=new ArrayList<ProSum>();
		ProScore ps=null;
		int sum=0;
		for(int i=0;i<listPro.size();i++){
			ProSum pSum=new ProSum();
			ps=listPro.get(i);
			pSum.setUserId(ps.getUserId());
			pSum.setUser_name(ps.getUser_name());
			pSum.setSum_1(ps.getScore_1()>10?10:ps.getScore_1());
			sum=ps.getScore_2()+ps.getScore_3()+ps.getScore_4();
			pSum.setSum_2(sum>25?25:sum);
			pSum.setSum_3(ps.getScore_5()>20?20:ps.getScore_5());
			pSum.setSum_4(ps.getScore_6()>15?15:ps.getScore_6());
			sum=ps.getScore_7()+ps.getScore_8();
			pSum.setSum_5(sum>15?15:sum);
			sum=ps.getScore_9()+ps.getScore_10();
			pSum.setSum_6(sum>15?15:sum);
			sum=pSum.getSum_1()+pSum.getSum_2()+pSum.getSum_3()+pSum.getSum_4()+pSum.getSum_5()+pSum.getSum_6();
			pSum.setTotal(sum);
			pSum.setZhehe_total(Double.parseDouble(df.format(sum*0.15)));
			list.add(pSum);
		}
		return list;
	}

	/**
	 * 处理体育素质分
	 * */
	public static List<TiyuSum> handleTiyuScore(List<Tiyu> list) {
		List<TiyuSum> listty=new ArrayList<TiyuSum>();
		Tiyu ty=null;
		double sum=0.0;
		double sum2=0.0;
		for(int i=0;i<list.size();i++){
			ty=list.get(i);
			TiyuSum tys=new TiyuSum();
			tys.setUserId(ty.getUserId());
			tys.setUser_name(ty.getUser_name());
			
			sum=((ty.getScore_1()+ty.getScore_2())/2.0)*0.85;
			tys.setTiyuSumScore(Double.parseDouble(df.format(sum)));
			
			sum2=(ty.getScore_3()+ty.getScore_4()+ty.getScore_5()-ty.getScore_6()-ty.getScore_7())*0.15;
			sum2=sum2>15?15.00:sum2;
			tys.setTizhiSumScore(Double.parseDouble(df.format(sum2)));
			
			tys.setTiyuTotal(Double.parseDouble(df.format(sum+sum2)));
			
			tys.setZhehe_tiyuTotal(Double.parseDouble(df.format((sum+sum2)*0.07)));
			
			listty.add(tys);
		}
		return listty;
	}

	/**
	 * 处理德育测评分数
	 * */
	public static List<DeyuSum> handleDeyuScore(List<Deyu> list) {
		List<DeyuSum> listdy=new ArrayList<DeyuSum>();
		Deyu dy=null;
		int sum=0;
		for(int i=0;i<list.size();i++){
			dy=list.get(i);
			DeyuSum dys=new DeyuSum();
			dys.setUserId(dy.getUserId());
			dys.setUser_name(dy.getUser_name());
			
			sum=dy.getScore_1()+dy.getScore_2()-dy.getScore_3()-dy.getScore_4();
			dys.setSum_1(sum>20?20:sum);
			
			sum=dy.getScore_5()+dy.getScore_6()+dy.getScore_7()-dy.getScore_8()-dy.getScore_9();
			dys.setSum_2(sum>15?15:sum);
			
			sum=dy.getScore_10()+dy.getScore_11()+dy.getScore_12()+dy.getScore_13()-dy.getScore_14()-dy.getScore_15()-dy.getScore_16()-dy.getScore_17();
			dys.setSum_3(sum>30?30:sum);
			
			sum=dy.getScore_18()+dy.getScore_19()-dy.getScore_20()-dy.getScore_21();
			dys.setSum_4(sum>20?20:sum);
			
			sum=dy.getScore_22()+dy.getScore_23()+dy.getScore_24()-dy.getScore_25()-dy.getScore_26();
			dys.setSum_5(sum>15?15:sum);
			
			sum=dys.getSum_1()+dys.getSum_2()+dys.getSum_3()+dys.getSum_4()+dys.getSum_5();
			dys.setSum_6(sum);
			
			dys.setSum_7(Double.parseDouble(df.format(sum*0.1)));
			
			listdy.add(dys);
		}
		
		return listdy;
	}

	/**
	 * 处理智育测评分数
	 * */
	public static List<ZhiyuSum> handleZhiyuScore(List<Zhiyu> list) {
		List<ZhiyuSum> listzy=new ArrayList<ZhiyuSum>();
		Zhiyu zy=null;
		double avg=0.0;
		double avg2=0.0;
		double promote=0.0;
		double sum=0.0;
		for(int i=0;i<list.size();i++){
			zy=list.get(i);
			ZhiyuSum zys=new ZhiyuSum();
			zys.setZy(zy);
			
			avg=(zy.getScore_1()+zy.getScore_2()+zy.getScore_3()+zy.getScore_4()+zy.getScore_5()+zy.getScore_6())/6.0;
		    zys.setLast_term_avg(Double.parseDouble(df.format(avg)));
		    
		    avg2=(zy.getScore_7()+zy.getScore_8()+zy.getScore_9()+zy.getScore_10()+zy.getScore_11()+zy.getScore_12())/6.0;
		    zys.setNext_term_avg(Double.parseDouble(df.format(avg2)));
		
		    zys.setSchool_year_avg(Double.parseDouble(df.format((avg+avg2)/2)));
		    
		    promote=(avg2-avg)/avg>0.1?5:0;
		    zys.setPromote_score(Double.parseDouble(df.format(promote)));
		    
		    sum=zys.getSchool_year_avg()+zys.getPromote_score();
		    zys.setTotal_score(sum);
		    
		    zys.setZhiyu_score(Double.parseDouble(df.format(sum*0.83)));
		    
		    listzy.add(zys);
		}
		
		return listzy;
	}

	/**
	 * 基础素质测评总分表
	 * */
	public static List<BaseScore> handleBaseScore(List<DeyuSum> listdy,
			List<ZhiyuSum> listzy, List<TiyuSum> listty) {
		List<BaseScore> list=new ArrayList<BaseScore>();
		DeyuSum dys=null;
		ZhiyuSum zys=null;
		TiyuSum tys=null;
		String userId="";
		for(int i=0;i<listdy.size();i++){
			BaseScore bs=new BaseScore();
			
			dys=listdy.get(i);
			bs.setDys(dys);
			userId=bs.getDys().getUserId();
			
			zys=listzy.get(i);
			if(!userId.equals(zys.getZy().getUserId())){
				for(int j=0;j<listzy.size();j++){
					zys=listzy.get(j);
					if(userId.equals(zys.getZy().getUserId())){
						break;
					}
				}
			}
			bs.setZys(zys);
			
			tys=listty.get(i);
			if(!userId.equals(tys.getUserId())){
				for(int j=0;j<listty.size();j++){
					tys=listty.get(j);
					if(userId.equals(tys.getUserId())){
						break;
					}
				}
			}
			bs.setTys(tys);
			
			bs.setTotalScore(Double.parseDouble(df.format(bs.getDys().getSum_7()+bs.getZys().getZhiyu_score()+bs.getTys().getZhehe_tiyuTotal())));
			bs.setZh_totalScore(Double.parseDouble(df.format(bs.getTotalScore()*0.85)));
			
			list.add(bs);
		}
		return list;
	}

	/**
	 * 综合素质测评总分表
	 * */
	public static List<SynScore> handleScore(List<BaseScore> listBase,
			List<ProSum> listProSum, List<PecScore> listPS) {
		List<SynScore> list=new ArrayList<SynScore>();
		String userId="";
		ProSum pro=null;
		PecScore pec=null;
		BaseScore bs=null;
		for(int i=0;i<listBase.size();i++){
			SynScore syn=new SynScore();
			bs=listBase.get(i);
			userId=bs.getDys().getUserId();
			
			syn.setBs(bs);
			
			pro=listProSum.get(i);
			if(!userId.equals(pro.getUserId())){
				for(int j=0;j<listProSum.size();j++){
					pro=listProSum.get(j);
					if(userId.equals(pro.getUserId())){
						break;
					}
				}
			}
			syn.setPs(pro);
			
			pec=listPS.get(i);
			if(!userId.equals(pec.getUserId())){
				for(int j=0;j<listPS.size();j++){
					pec=listPS.get(j);
					if(userId.equals(pec.getUserId())){
						break;
					}
				}
			}
			syn.setPeculiar(pec.getSum());
			
			syn.setTotalScore(Double.parseDouble(df.format(syn.getBs().getZh_totalScore()+syn.getPs().getZhehe_total()+syn.getPeculiar())));
			
			list.add(syn);
		}
		
		return list;
	}
	
}

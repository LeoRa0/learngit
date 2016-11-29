package zhcp.dao;

import java.util.List;

import zhcp.domain.PecScore;
import zhcp.domain.ProScore;

public interface ScoreDAO {

	public void insertPeculiar(String userId)throws Exception;
	
	public void insertProgress(String userId) throws Exception;
	
	public void insertDeyu(String userId) throws Exception;
	
	public void insertZhiyu(String userId) throws Exception;
	
	public void insertTiyu(String userId) throws Exception;

	public List<PecScore> listPecScore(String cla)throws Exception;

	public PecScore findPSMes(String userId)throws Exception;

	public void updatePS(PecScore ps)throws Exception;

	public void delPeculiar(List<String> list)throws Exception;
	
	public void delProgress(List<String> list)throws Exception;
	
	public void delDeyu(List<String> list)throws Exception;
	
	public void delZhiyu(List<String> list)throws Exception;
	
	public void delTiyu(List<String> list)throws Exception;

	public List<ProScore> listProScore(String cla)throws Exception;

	public ProScore findProMes(String userId)throws Exception;

	public void updatePro(ProScore pro)throws Exception;
   
}

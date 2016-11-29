package zhcp.dao;

import java.util.List;

import zhcp.domain.Deyu;
import zhcp.domain.Tiyu;
import zhcp.domain.Zhiyu;


public interface BaseScoreDAO {

	public List<Tiyu> listScore_tiyu(String cla)throws Exception;

	public Tiyu listMes_tiyu(String userId)throws Exception;

	public void updateTiyu(Tiyu ty)throws Exception;

	public List<Deyu> listScore_deyu(String cla)throws Exception;
	
	public Deyu listMes_deyu(String userId) throws Exception;
	
	public void updateDeyu(Deyu dy) throws Exception;

	public List<Zhiyu> listScore_zhiyu(String cla)throws Exception;

    public Zhiyu listMes_zhiyu(String userId) throws Exception;
	
	public void updateZhiyu(Zhiyu zy) throws Exception;

}

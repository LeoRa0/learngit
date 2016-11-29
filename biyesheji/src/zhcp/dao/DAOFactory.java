package zhcp.dao;

import zhcp.dao.impl.ScoreDAOImpl;
import zhcp.dao.impl.UserDAOImpl;

public class DAOFactory {
    public static UserDAO getUserDAO(){
    	return new UserDAOImpl();
    }
    
    public static ScoreDAO getScoreDAO(){
    	return new ScoreDAOImpl();
    }
}

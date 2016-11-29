package zhcp.test;

import zhcp.dao.DAOFactory;
import zhcp.dao.UserDAO;

public class DAOTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		UserDAO dao=DAOFactory.getUserDAO();
		System.out.println(dao.findByEDU("本科").size());
		System.out.println(dao.findByGrade("09").size());
	}

}

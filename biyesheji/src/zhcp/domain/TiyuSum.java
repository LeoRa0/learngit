package zhcp.domain;

public class TiyuSum {
	private String userId;
	private String user_name;
	private double tiyuSumScore;
	private double tizhiSumScore;
	private double tiyuTotal;
	private double zhehe_tiyuTotal;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public double getTiyuSumScore() {
		return tiyuSumScore;
	}

	public void setTiyuSumScore(double tiyuSumScore) {
		this.tiyuSumScore = tiyuSumScore;
	}

	public double getTizhiSumScore() {
		return tizhiSumScore;
	}

	public void setTizhiSumScore(double tizhiSumScore) {
		this.tizhiSumScore = tizhiSumScore;
	}

	public double getTiyuTotal() {
		return tiyuTotal;
	}

	public void setTiyuTotal(double tiyuTotal) {
		this.tiyuTotal = tiyuTotal;
	}

	public double getZhehe_tiyuTotal() {
		return zhehe_tiyuTotal;
	}

	public void setZhehe_tiyuTotal(double zheheTiyuTotal) {
		zhehe_tiyuTotal = zheheTiyuTotal;
	}

}

package zhcp.domain;

public class PecScore {
	private String userId;
	private String user_name;
	private int score_1;
	private int score_2;
	private int score_3;
	private int score_4;
	private int score_5;
	private int sum;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getScore_1() {
		return score_1;
	}

	public void setScore_1(int score_1) {
		this.score_1 = score_1;
	}

	public int getScore_2() {
		return score_2;
	}

	public void setScore_2(int score_2) {
		this.score_2 = score_2;
	}

	public int getScore_3() {
		return score_3;
	}

	public void setScore_3(int score_3) {
		this.score_3 = score_3;
	}

	public int getScore_4() {
		return score_4;
	}

	public void setScore_4(int score_4) {
		this.score_4 = score_4;
	}

	public int getScore_5() {
		return score_5;
	}

	public void setScore_5(int score_5) {
		this.score_5 = score_5;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}

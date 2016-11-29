package zhcp.domain;

public class ZhiyuSum {
	private Zhiyu zy;
	private double last_term_avg;
	private double next_term_avg;
	private double school_year_avg;
	private double promote_score;
	private double total_score;
	private double zhiyu_score;

	public Zhiyu getZy() {
		return zy;
	}

	public void setZy(Zhiyu zy) {
		this.zy = zy;
	}

	public double getLast_term_avg() {
		return last_term_avg;
	}

	public void setLast_term_avg(double lastTermAvg) {
		last_term_avg = lastTermAvg;
	}

	public double getNext_term_avg() {
		return next_term_avg;
	}

	public void setNext_term_avg(double nextTermAvg) {
		next_term_avg = nextTermAvg;
	}

	public double getSchool_year_avg() {
		return school_year_avg;
	}

	public void setSchool_year_avg(double schoolYearAvg) {
		school_year_avg = schoolYearAvg;
	}

	public double getPromote_score() {
		return promote_score;
	}

	public void setPromote_score(double promoteScore) {
		promote_score = promoteScore;
	}

	public double getTotal_score() {
		return total_score;
	}

	public void setTotal_score(double totalScore) {
		total_score = totalScore;
	}

	public double getZhiyu_score() {
		return zhiyu_score;
	}

	public void setZhiyu_score(double zhiyuScore) {
		zhiyu_score = zhiyuScore;
	}

}

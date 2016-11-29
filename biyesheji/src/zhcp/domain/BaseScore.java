package zhcp.domain;

public class BaseScore {
	private DeyuSum dys;
	private ZhiyuSum zys;
	private TiyuSum tys;
	private double totalScore;
	private double zh_totalScore;

	public DeyuSum getDys() {
		return dys;
	}

	public void setDys(DeyuSum dys) {
		this.dys = dys;
	}

	public ZhiyuSum getZys() {
		return zys;
	}

	public void setZys(ZhiyuSum zys) {
		this.zys = zys;
	}

	public TiyuSum getTys() {
		return tys;
	}

	public void setTys(TiyuSum tys) {
		this.tys = tys;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	public double getZh_totalScore() {
		return zh_totalScore;
	}

	public void setZh_totalScore(double zhTotalScore) {
		zh_totalScore = zhTotalScore;
	}

}

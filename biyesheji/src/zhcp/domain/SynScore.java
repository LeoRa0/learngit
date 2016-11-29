package zhcp.domain;

public class SynScore {
	private BaseScore bs;
	private ProSum ps;
	private double peculiar;
	private double totalScore;

	public BaseScore getBs() {
		return bs;
	}

	public void setBs(BaseScore bs) {
		this.bs = bs;
	}

	public ProSum getPs() {
		return ps;
	}

	public void setPs(ProSum ps) {
		this.ps = ps;
	}

	public double getPeculiar() {
		return peculiar;
	}

	public void setPeculiar(double peculiar) {
		this.peculiar = peculiar;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

}

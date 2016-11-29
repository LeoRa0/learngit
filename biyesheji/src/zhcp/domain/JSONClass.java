package zhcp.domain;

public class JSONClass {
	private String name;
	private String abbr;

	public JSONClass() {
		super();
	}

	public JSONClass(String name, String abbr) {
		super();
		this.name = name;
		this.abbr = abbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

}

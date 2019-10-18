package lab5CardLists;

public class Suite {
	private String suites;

	public static Suite valueOf(String s) {
		Suite result = new Suite();
		result.setSuites(s);
		return result;
	}
	public String getSuites() {
		return suites;
	}

	public void setSuites(String suites) {
		this.suites = suites;
	}
	
}

import java.util.ArrayList;


public class Problem {
	int contestNumber;
	String problemName;
	ArrayList<IO> problemTestCases;
	public Problem(String name, ArrayList<IO> io, int contestNumber) {
		this.problemName=name;
		this.problemTestCases=io;
		this.contestNumber=contestNumber;
	}
	
	public String getProblemName() {
		return problemName;
	}
	
	public ArrayList<IO> getProblemTestCases() {
		return problemTestCases;
	}
	public int getContestNumber() {
		return contestNumber;
	}
}

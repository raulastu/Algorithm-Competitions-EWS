package _320;
import java.io.*;
public class _320_B {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"7 "+
		"1 1 5 "+
		"1 5 11 "+
		"2 1 2 "+
		"1 2 9 "+
		"2 1 2 " +
		"1 20 21 " +
		"2 1 4 ";
		runTest(input,
		"NO\n"+
		"YES\n" +
		"NO ");
		
		input=
		"3 "+
		"1 1 5 "+
		"1 4 11 "+
		"2 1 2 ";
		
		runTest(input,
		"YES\n");

		input=
		"5 "+
		"1 2 5 "+
		"1 5 7 " +
		"1 8 10 " +
		"1 1 12 "+
		"2 1 4 ";
		
		runTest(input,
		"YES\n");
	}
	
	public void compare(String rcAnswer, String realAnswer){
		realAnswer=realAnswer.trim();
		rcAnswer=rcAnswer.trim();
		if(realAnswer.equals(rcAnswer)){
			System.out.println("[Passed] Case "+nroCases);
		}else{
			failed=true;
			System.out.println("rChi "+rcAnswer);
			System.out.println("Expected "+realAnswer);
			System.out.println("[Failed] Case "+nroCases);
//			System.exit(0);
		}
		nroCases++;
	}
	
	public void runTest(String input, String output) throws Exception{
		r.in= new ByteArrayInputStream(input.getBytes());
		r.run();
		if(testOutput){
			compare(baos.toString(), output);
		}else{
			System.out.println(baos.toString());
		}
		baos.reset();
//		r.in.
	}
	_320_B_PingPong_Easy_Version r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _320_B_PingPong_Easy_Version();
		r.out = new PrintWriter(baos);
		runTestCases();
		if(testOutput && !failed){
			System.out.println("All test cases [Passed]");
		}
	}
	private String input;
	private int nroCases=1;
	private boolean failed=false;
	public static void main(String[] args) throws Exception {
		new _320_B().init();
	}
	
}


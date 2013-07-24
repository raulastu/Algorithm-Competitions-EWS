package _332;
import java.io.*;
public class _332_C {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"5 3 2 "+
		"5 6 "+
		"5 8 "+
		"1 3 "+
		"4 3 "+
		"4 11 ";
		runTest(input,
		"3 1 2  ");

//		Case 1
		input=
		"5 3 3 "+
		"10 18 "+
		"18 17 "+
		"10 20 "+
		"20 18 "+
		"20 18 ";
		runTest(input,
		"2 4 5  ");

//		Case 1
		input=
		"8 5 3 "+
		"10 1 "+
		"10 2 "+
		"10 3 "+
		"10 1 "+
		"9 3 "+
		"9 2 "+
		"8 1 "+
		"8 1 ";
		runTest(input,
		"2 4 5  ");
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
	_332_C_Students_Revenge r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _332_C_Students_Revenge();
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
		new _332_C().init();
	}
	
}


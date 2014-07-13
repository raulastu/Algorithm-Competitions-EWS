package _430;
import java.io.*;
public class _430_C {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		
//		int a[][]= new int[4000][4000];
		
		input=
		"10 "+
		"2 1 "+
		"3 1 "+
		"4 2 "+
		"5 1 "+
		"6 2 "+
		"7 5 "+
		"8 6 "+
		"9 8 "+
		"10 5 "+
		"1 0 1 1 0 1 0 1 0 1 "+
		"1 0 1 0 0 1 1 1 0 1 ";
		runTest(input,
		"2 "+
		"4 "+
		"7 ");


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
	_430_C_Xortree r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _430_C_Xortree();
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
		new _430_C().init();
	}
	
}


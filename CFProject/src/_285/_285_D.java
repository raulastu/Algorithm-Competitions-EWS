package _285;
import java.io.*;
public class _285_D {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"1 ";
		runTest(input,
		"18 ");
		
		input=
		"2 ";
		runTest(input,
		"18 ");
		
		input=
		"3 ";
		runTest(input,
		"18 ");
		
		input=
		"4 ";
		runTest(input,
		"18 ");

//		Case 1
		input=
		"5 ";
		runTest(input,
		"1800 ");

//		Case 1
		input=
		"6 ";
		runTest(input,
		"1800 ");

//		Case 1 670320
		input=
		"7 ";
		runTest(input,
		"1800 ");
		
//		Case 1 0
		input=
		"8 ";
//		runTest(input,
//		"1800 ");
		
//		Case 1 0
//		input=
//		"9 ";
//		runTest(input,
//		"9 ");
	}
	
	public void compare(String rcAnswer, String realAnswer){
		realAnswer=realAnswer.trim();
		rcAnswer=rcAnswer.trim();
		if(realAnswer.equals(rcAnswer)){
			System.out.println("[Passed] Case "+nroCases+" "+rcAnswer);
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
	_285_D_Permutation_Sum r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _285_D_Permutation_Sum();
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
		new _285_D().init();
	}
	
}


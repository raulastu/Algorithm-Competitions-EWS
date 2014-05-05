package _424;
import java.io.*;
public class _424_C {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"3 "+
		"1 2 3 ";
		runTest(input,
		"3 ");
		
//		Case 0
		input=
		"14 "+
		"1 2 3 4 5 6 7 8 9 10 11 12 13 14 ";
		runTest(input,
		"3 ");
		
//		Case 0
		input=
		"5 "+
		"1 1 1 1 1 ";
		runTest(input,
		"3 ");
		
//		Case 0
		input=
		"5 "+
		"2 2 2 2 2 ";
		runTest(input,
		"3 ");
		


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
	_424_C_Magic_Formulas r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _424_C_Magic_Formulas();
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
		new _424_C().init();
	}
	
}


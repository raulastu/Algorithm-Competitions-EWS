package _285;
import java.io.*;
public class _285_E {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"1 0 ";
		runTest(input,
		"1 ");

//		Case 1
		input=
		"2 1 ";
		runTest(input,
		"0 ");

//		Case 2
		input=
		"3 2 ";
		runTest(input,
		"4 ");

//		Case 3
		input=
		"4 1 ";
		runTest(input,
		"6 ");

//		Case 4
		input=
		"7 4 ";
		runTest(input,
		"328 ");


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
	_285_E_Positions_in_Permutations r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _285_E_Positions_in_Permutations();
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
		new _285_E().init();
	}
	
}


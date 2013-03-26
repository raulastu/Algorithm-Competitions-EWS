package _287;
import java.io.*;
public class _287_C {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"1 ";
		runTest(input,
		"1  ");

//		Case 1
		input=
		"2 ";
		runTest(input,
		"-1 ");

//		Case 2
		input=
		"3 ";
		runTest(input,
		"-1 ");
		
//		Case 2
		input=
		"4 ";
		runTest(input,
		"2 4 1 3  ");

//		Case 3
		input=
		"5 ";
		runTest(input,
		"2 5 3 1 4  ");

//		Case 3
		input=
		"6 ";
		runTest(input,
		"-1  ");
		
//		Case 3
		input=
		"7 ";
		runTest(input,
		"-1 ");

//		Case 3
		input=
		"8 ";
		runTest(input,
		"2 8 4 6 3 5 1 7 ");
		
//		Case 3
		input=
		"9 ";
		runTest(input,
		"2 9 4 7 5 3 6 1 8 "); 
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
	_287_C_Lucky_Permutation r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _287_C_Lucky_Permutation();
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
		new _287_C().init();
	}
	
}


package _284;
import java.io.*;
public class _284_A {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"3 ";
		runTest(input,
		"1 ");

//		Case 1
		input=
		"5 ";
		runTest(input,
		"2 ");


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
	_284_A_Cows_and_Primitive_Roots r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _284_A_Cows_and_Primitive_Roots();
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
		new _284_A().init();
	}
	
}


package _332;
import java.io.*;
public class _332_B {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"5 2 "+
		"3 6 1 1 6 ";
		runTest(input,
		"1 4 ");

//		Case 1
		input=
		"6 2 "+
		"1 1 1 1 1 1 ";
		runTest(input,
		"1 3 ");
		
//		Case 2
		input=
		"6 2 "+
		"1 3 2 1 3 1 ";
		runTest(input,
		"1 3 ");



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
	_332_B_Maximum_Absurdity r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _332_B_Maximum_Absurdity();
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
		new _332_B().init();
	}
	
}


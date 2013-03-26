package _287;
import java.io.*;
public class _287_A {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"#### "+
		".#.. "+
		"#### "+
		".... ";
		runTest(input,
		"YES ");

//		Case 1
		input=
		"#### "+
		".... "+
		"#### "+
		".... ";
		runTest(input,
		"NO ");


//		Case 1
		input=
		"#### "+
		".... "+
		"#### "+
		"...# ";
		runTest(input,
		"YES ");

//		Case 1
		input=
		"##.. "+
		"...# "+
		"...# "+
		"###. ";
		runTest(input,
		"YES ");

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
	_287_A_IQ_Test r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _287_A_IQ_Test();
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
		new _287_A().init();
	}
	
}


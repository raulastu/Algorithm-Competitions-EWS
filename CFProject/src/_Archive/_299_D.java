package _Archive;
import java.io.*;
public class _299_D {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"2 2 4 "+
		"0 0 "+
		"0 0 ";
		runTest(input,
		"48 ");

//		Case 1
		input=
		"2 2 4 "+
		"1 2 "+
		"2 1 ";
		runTest(input,
		"0 ");

//		Case 2
		input=
		"5 6 10 "+
		"0 0 0 0 0 0 "+
		"0 0 0 0 0 0 "+
		"0 0 0 0 0 0 "+
		"0 0 0 0 0 0 "+
		"0 0 0 0 0 0 ";
		runTest(input,
		"3628800 ");

//		Case 3
		input=
		"2 6 10 "+
		"1 2 3 4 5 6 "+
		"0 0 0 0 0 0 ";
		runTest(input,
		"4096 ");


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
	_299_D_Distinct_Paths r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _299_D_Distinct_Paths();
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
		new _299_D().init();
	}
	
}


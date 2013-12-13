package _Archive;
import java.io.*;
public class _361_C {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"4 5 "+
		"1 2 3 1 "+
		"2 1 2 8 "+
		"2 3 4 7 "+
		"1 1 3 3 "+
		"2 3 4 8 ";
		runTest(input,
		"YES "+
		"4 7 4 7 ");

//		Case 1
		input=
		"4 5 "+
		"1 2 3 1 "+
		"2 1 2 8 "+
		"2 3 4 7 "+
		"1 1 3 3 "+
		"2 3 4 13 ";
		runTest(input,
		"NO ");
		
		
//		Case 1
		input=
		"1 1 "+
		"1 1 1 1 ";
		runTest(input,
		"NO ");


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
	_361_C_Levko_and_Array_Recovery r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _361_C_Levko_and_Array_Recovery();
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
		new _361_C().init();
	}
	
}


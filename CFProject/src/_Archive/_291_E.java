package _Archive;
import java.io.*;
public class _291_E {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"7 "+
		"1 ab "+
		"5 bacaba "+
		"1 abacaba "+
		"2 aca "+
		"5 ba "+
		"2 ba "+
		"aba ";
		runTest(input,
		"6 ");

//		Case 1
		input=
		"7 "+
		"1 ab "+
		"5 bacaba "+
		"1 abacaba "+
		"2 aca "+
		"5 ba "+
		"2 ba "+
		"bacaba ";
		runTest(input,
		"4 ");


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
	_291_E_Tree_String_Problem r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _291_E_Tree_String_Problem();
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
		new _291_E().init();
	}
	
}


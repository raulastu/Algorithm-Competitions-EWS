package _366;
import java.io.*;
public class _366_D {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"4 4 "+
		"1 2 1 10 "+
		"2 4 3 5 "+
		"1 3 1 5 "+
		"2 4 2 7 ";
		runTest(input,
		"6 ");

//		Case 1
		input=
		"5 6 "+
		"1 2 1 10 "+
		"2 5 11 20 "+
		"1 4 2 5 "+
		"1 3 10 11 "+
		"3 4 12 10000 "+
		"4 5 6 6 ";
		runTest(input,
		"Nice work, Dima! ");
		
//		Case 1
		input=
		"2 0 ";
		runTest(input,
		"Nice work, Dima! ");
		
//		Case 1
		input=
		"2 2 "+
		"1 2 1 10 "+
		"1 2 1 9 ";
		runTest(input,
		"Nice work, Dima! ");
		
//		Case 1
		input=
		"3 2 "+
		"1 2 2 3 "+
		"2 3 1 9 ";
		runTest(input,
		"2");
		


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
	_366_D_Dima_and_Trap_Graph r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _366_D_Dima_and_Trap_Graph();
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
		new _366_D().init();
	}
	
}


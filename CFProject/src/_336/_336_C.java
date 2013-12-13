package _336;
import java.io.*;
public class _336_C {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"5 "+
		"1 2 3 4 5 ";
		runTest(input,
		"2 "+
		"4 5 ");

//		Case 1
		input=
		"3 "+
		"1 2 4 ";
		runTest(input,
		"1 "+
		"4 ");
		
////		Case 1
//		input=
//		"3 "+
//		"1 3 4 ";
//		runTest(input,
//		"1 "+
//		"4 ");
//		
////		Case 1
//		input=
//		"6 "+
//		"1 3 4 8 10 11 ";
//		runTest(input,
//		"3 "+
//		"8 10 11 ");
//		
////		Case 1
//		input=
//		"7 "+
//		"3 5 7 9 10 11 12 ";
//		runTest(input,
//		"4 "+
//		"9 10 11 12 ");
//
////		Case 1
//		input=
//		"2 "+
//		"2 3 ";
//		runTest(input,
//		"2 "+
//		"2 3 ");
//		
//
////		Case 1
//		input=
//		"3 "+
//		"1 3 5 ";
//		runTest(input,
//		"2 "+
//		"2 3 ");
//		
		input=
		"3 "+
		"2 10 14 ";
		runTest(input,
		"1 "+
		"2 ");
//
		input=
		"2 "+
		"3 10 14 ";
		runTest(input,
		"1 "+
		"10 ");
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
	_336_C_Vasily_the_Bear_and_Sequence r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _336_C_Vasily_the_Bear_and_Sequence();
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
		new _336_C().init();
	}
	
}


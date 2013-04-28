package _298;
import java.io.*;
public class _298_A {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"9 "+
		"..RRLL... ";
		runTest(input,
		"3 4 ");

//		Case 1
		input=
		"11 "+
		".RRRLLLLL.. ";
		runTest(input,
		"7 5 ");
		
		input=
		"8 "+
		".LLLLL.. ";
		runTest(input,
		"6 2 ");

		input=
		"8 "+
		".RRRRR.. ";
		runTest(input,
		"2 6 ");
		
		input=
		"4 "+
		".RLL. ";
		runTest(input,
		"2 3 ");

		input=
		"4 "+
		".RR. ";
		runTest(input,
		"2 3 ");
		
		input=
		"4 "+
		".RRRLLLL. ";
		runTest(input,
		"2 3 ");
		
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
	_298_A_Snow_Footprints r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _298_A_Snow_Footprints();
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
		new _298_A().init();
	}
	
}


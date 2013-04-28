package _Archive;
import java.io.*;
public class _293_A {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"2 "+
		"0111 "+
		"0001 ";
		runTest(input,
		"First ");

//		Case 1
		input=
		"3 "+
		"110110 "+
		"001001 ";
		runTest(input,
		"First ");

//		Case 2
		input=
		"3 "+
		"111000 "+
		"000111 ";
		runTest(input,
		"Draw ");

//		Case 3
		input=
		"4 "+
		"01010110 "+
		"00101101 ";
		runTest(input,
		"First ");

//		Case 4
		input=
		"4 "+
		"01100000 "+
		"10010011 ";
		runTest(input,
		"Second ");


		input=
		"4 "+
		"01100001 "+
		"10010011 ";
		runTest(input,
		"Draw ");

		input=
		"4 "+
		"01100101 "+
		"10010111 ";
		runTest(input,
		"Draw ");
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
	_293_A_Weird_Game r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _293_A_Weird_Game();
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
		new _293_A().init();
	}
	
}


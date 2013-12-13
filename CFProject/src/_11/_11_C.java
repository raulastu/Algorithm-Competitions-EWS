package _11;
import java.io.*;
public class _11_C {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"2 "+
		"8 8 "+
		"00010001 "+
		"00101000 "+
		"01000100 "+
		"10000010 "+
		"01000100 "+
		"00101000 "+
		"11010011 "+
		"11000011 "+
		"10 10 "+
		"1111111000 "+
		"1000001000 "+
		"1011001000 "+
		"1011001010 "+
		"1000001101 "+
		"1001001010 "+
		"1010101000 "+
		"1001001000 "+
		"1000001000 "+
		"1111111000 ";
		runTest(input,
		"1 "+
		"2 ");

//		Case 1
		input=
		"1 "+
		"12 11 "+
		"11111111111 "+
		"10000000001 "+
		"10111111101 "+
		"10100000101 "+
		"10101100101 "+
		"10101100101 "+
		"10100000101 "+
		"10100000101 "+
		"10111111101 "+
		"10000000001 "+
		"11111111111 "+
		"00000000000 ";
		runTest(input,
		"3 ");


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
	_11_C_How_Many_Squares r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _11_C_How_Many_Squares();
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
		new _11_C().init();
	}
	
}


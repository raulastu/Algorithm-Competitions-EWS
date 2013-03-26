package _287;
import java.io.*;
import static java.util.Arrays.fill;
public class _287_B {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"4 3 ";
		runTest(input,
		"2 ");

//		Case 1
		input=
		"5 5 ";
		runTest(input,
		"1 ");

//		Case 2
		input=
		"8 4 ";
		runTest(input,
		"-1 ");

//		Case 2
		char[] x= new char[18];
		fill(x,'0');
		String bil="1"+new String(x);
		input=
		"499999998500000001 1000000000 ";
		runTest(input,
		"1340874132989 ");

//		Case 2
		input=
		"28 10 ";
		runTest(input,
		"4 ");

//		Case 2
		input=
		"33 10 ";
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
	_287_B_Pipeline r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _287_B_Pipeline();
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
		new _287_B().init();
	}
	
}


import java.io.*;
public class _300_A {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"3 "+
		"-1 2 0 ";
		runTest(input,
		"1 -1 "+
		"1 2 "+
		"1 0 ");

//		Case 1
		input=
		"4 "+
		"-1 -2 -3 0 ";
		runTest(input,
		"1 -1 "+
		"2 -3 -2 "+
		"1 0 ");
		
//		Case 1
		input=
		"5 "+
		"-1 -2 -3 0 0 ";
		runTest(input,
		"1 -1 "+
		"2 -3 -2 "+
		"1 0 0");

//		Case 1
		input=
		"6 "+
		"-1 -3 -1 -1 0 2 ";
		runTest(input,
		"1 -1 "+
		"2 -3 -2 "+
		"1 0 0");
		
		input=
		"6 "+
		"-1 -3 -1 -1 0 -1 ";
		runTest(input,
		"1 -1 "+
		"2 -3 -2 "+
		"1 0 0");

		input=
		"4 "+
		"-1 1 1 0 ";
		runTest(input,
		"1 -1 "+
		"2 -3 -2 "+
		"1 0 0");
		
		input=
		"8 "+
		"-1 1 0 0 0 0 0 0 ";
		runTest(input,
		"1 -1 "+
		"2 -3 -2 "+
		"1 0 0");
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
	_300_A_Array r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _300_A_Array();
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
		new _300_A().init();
	}
	
}


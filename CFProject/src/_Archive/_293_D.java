package _Archive;
import java.io.*;
public class _293_D {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"3 "+
		"0 0 "+
		"5 5 "+
		"5 0 ";
		runTest(input,
		"4.6666666667 ");

//		Case 1
		input=
		"4 "+
		"-1 3 "+
		"4 5 "+
		"6 2 "+
		"3 -5 ";
		runTest(input,
		"8.1583333333 ");

//		Case 2
		input=
		"3 "+
		"17 136 "+
		"859 937 "+
		"16 641 ";
		runTest(input,
		"66811.3704155169 ");


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
	_293_D_Ksusha_and_Square r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _293_D_Ksusha_and_Square();
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
		new _293_D().init();
	}
	
}


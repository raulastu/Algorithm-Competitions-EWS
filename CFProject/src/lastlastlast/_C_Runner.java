package lastlastlast;
import java.io.*;
public class _C_Runner {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
		input=
		"5 "+
		"2 1 "+
		"3 "+
		"2 3 "+
		"2 1 "+
		"3 ";
		runTest(input,"0.500000"+
"0.000000"+
"1.500000"+
"1.333333"+
"1.500000");
		input=
		"6 "+
		"2 1 "+
		"1 2 20 "+
		"2 2 "+
		"1 2 -3 "+
		"3 "+
		"3 ";
		runTest(input,"0.500000"+
"20.500000"+
"14.333333"+
"12.333333"+
"17.500000"+
"17.000000");

	}
	
	public void compare(String rcAnswer, String realAnswer){
		realAnswer=realAnswer.trim();
		rcAnswer=rcAnswer.trim();
		if(realAnswer.equals(rcAnswer)){
			System.out.println("Case "+nroCases+" Passed");
		}else{
			failed=true;
			System.out.println("rChi "+rcAnswer);
			System.out.println("Expected "+realAnswer);
			System.out.println("Case "+nroCases+" Failed");
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
	_C r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _C();
		r.out = new PrintWriter(baos);
		runTestCases();
		if(testOutput && !failed){
			System.out.println("All test cases Passed");
		}
	}
	private String input;
	private int nroCases=1;
	private boolean failed=false;
	public static void main(String[] args) throws Exception {
		new _C_Runner().init();
	}
	
}


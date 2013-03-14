import java.io.*;
public class _E_Runner {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
		input=
		"2 "+
		"1 2 ";
		runTest(input,"3");
		input=
		"3 "+
		"1 2 3 ";
		runTest(input,"3");
		input=
		"2 "+
		"1000 1000 ";
		runTest(input,"1000");

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
	_E r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _E();
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
		new _E_Runner().init();
	}
	
}


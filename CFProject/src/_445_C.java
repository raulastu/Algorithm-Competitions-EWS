import java.io.*;
public class _445_C {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"1 0 "+
		"1 ";
		runTest(input,
		"0.000000000000000 ");

//		Case 1
		input=
		"2 1 "+
		"1 2 "+
		"1 2 1 ";
		runTest(input,
		"3.000000000000000 ");

//		Case 2
		input=
		"5 6 "+
		"13 56 73 98 17 "+
		"1 2 56 "+
		"1 3 29 "+
		"1 4 42 "+
		"2 3 95 "+
		"2 4 88 "+
		"3 4 63 ";
		runTest(input,
		"2.965517241379311 ");


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
	_445_C_DZY_Loves_Physics r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _445_C_DZY_Loves_Physics();
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
		new _445_C().init();
	}
	
}


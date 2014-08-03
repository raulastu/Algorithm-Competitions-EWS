import java.io.*;
public class _450_E {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"6 ";
		runTest(input,
		"2 "+
		"6 3 "+
		"2 4 ");

//		Case 1
		input=
		"9 ";
		runTest(input,
		"3 "+
		"9 3 "+
		"2 4 "+
		"6 8 ");

//		Case 2
		input=
		"2 ";
		runTest(input,
		"0 ");


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
	_450_E_Jzzhu_and_Apples r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _450_E_Jzzhu_and_Apples();
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
		new _450_E().init();
	}
	
}


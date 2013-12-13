package _11;
import java.io.*;
public class _11_D {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"4 6 "+
		"1 2 "+
		"1 3 "+
		"1 4 "+
		"2 3 "+
		"2 4 "+
		"3 4 ";
		runTest(input,
		"7 ");
		
//		Case 0
		input=
		"3 3 "+
		"1 2 "+
		"2 3 "+
		"1 3 ";
		runTest(input,
		"1 ");
		
//		Case 0
		input=
		"5 6 "+
		"1 2 "+
		"2 3 "+
		"1 5 "+
		"5 4 "+
		"1 4 "+
		"1 3 ";
		runTest(input,
		"2 ");
		

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
	_11_D_A_Simple_Task r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _11_D_A_Simple_Task();
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
		new _11_D().init();
	}
	
}


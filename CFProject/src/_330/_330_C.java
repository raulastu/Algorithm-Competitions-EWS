package _330;
import java.io.*;
public class _330_C {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"3 "+
		".E. "+
		"E.E "+
		".E. ";
		runTest(input,
		"1 1 "+
		"2 2 "+
		"3 3 ");

//		Case 1
		input=
		"3 "+
		"EEE "+
		"E.. "+
		"E.E ";
		runTest(input,
		"-1 ");

//		Case 2
		input=
		"5 "+
		"EE.EE "+
		"E.EE. "+
		"E...E "+
		".EE.E "+
		"EE.EE ";
		runTest(input,
		"3 3 "+
		"1 3 "+
		"2 2 "+
		"4 4 "+
		"5 3 ");


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
	_330_C_Purification r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _330_C_Purification();
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
		new _330_C().init();
	}
	
}


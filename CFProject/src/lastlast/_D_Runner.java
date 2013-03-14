package lastlast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

public class _D_Runner {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
		//Case N 1
		String input=
		"2 "+
		"1 1 ";
		runTest(input,"BitLGM"); 
		
		//Case N 2
		input=
		"2 "+
		"1 2 ";
		runTest(input,"BitAryo");
		
		//Case N 3
		input=
		"3 "+
		"1 2 1 ";
		runTest(input,"BitLGM");
	}

	public void compare(String realAnswer, String rcAnswer){
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
	_D r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _D();
		r.out = new PrintWriter(baos);
		runTestCases();
		if(testOutput && !failed){
			System.out.println("All test cases Passed");
		}
	}
	int nroCases=1;
	boolean failed=false;
	public static void main(String[] args) throws Exception {
		new _D_Runner().init();
	}
	
}


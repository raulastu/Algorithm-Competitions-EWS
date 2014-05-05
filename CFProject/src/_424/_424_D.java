package _424;
import java.io.*;
public class _424_D {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"6 7 48 "+
		"3 6 2 "+
		"5 4 8 3 3 7 9 "+
		"4 1 6 8 7 1 1 "+
		"1 6 4 6 4 8 6 "+
		"7 2 6 1 6 9 4 "+
		"1 9 8 6 3 9 2 "+
		"4 5 6 8 4 3 7 ";
		runTest(input,
		"4 3 6 7 ");
		
//		Case 0
		input=
		"3 3 12 "+
		"2 6 2 "+
		"5 4 8 "+
		"4 1 6 "+
		"1 6 4 ";
		runTest(input,
		"4 3 6 7 ");


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
	_424_D_Biathlon_Track r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _424_D_Biathlon_Track();
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
		new _424_D().init();
	}
	
}


package _366;
import java.io.*;
public class _366_E {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"4 6 5 7 "+
		"3 1 2 2 3 1 "+
		"3 2 2 2 5 5 "+
		"4 2 2 2 5 3 "+
		"3 2 2 1 4 3 "+
		"2 3 1 4 1 5 1 ";
		runTest(input,
		"8 ");

//		Case 1
		input=
		"4 4 9 5 "+
		"4 7 9 5 "+
		"1 2 1 7 "+
		"8 3 4 9 "+
		"5 7 7 2 "+
		"7 1 9 2 5 ";
		runTest(input,
		"4 ");


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
	_366_E_Dima_and_Magic_Guitar r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _366_E_Dima_and_Magic_Guitar();
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
		new _366_E().init();
	}
	
}


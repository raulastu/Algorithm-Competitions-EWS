import java.io.*;
public class _91_E {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"5 4 "+
		"4 1 "+
		"3 5 "+
		"6 2 "+
		"3 5 "+
		"6 5 "+
		"1 5 2 "+
		"1 3 5 "+
		"1 1 0 "+
		"1 5 0 ";
		runTest(input,
		"5 "+
		"2 "+
		"1 "+
		"5 ");

//		Case 1
		input=
		"5 4 "+
		"6 1 "+
		"5 1 "+
		"2 5 "+
		"4 3 "+
		"6 1 "+
		"2 4 1 "+
		"3 4 5 "+
		"1 4 5 "+
		"1 2 0 ";
		runTest(input,
		"3 "+
		"3 "+
		"3 "+
		"1 ");


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
	_91_E_Igloo_Skyscraper r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _91_E_Igloo_Skyscraper();
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
		new _91_E().init();
	}
	
}


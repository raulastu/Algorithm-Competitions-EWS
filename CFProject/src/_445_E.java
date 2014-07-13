import java.io.*;
public class _445_E {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"3 3 "+
		"1 1 2 4 "+
		"1 2 3 5 "+
		"2 1 3 ";
		runTest(input,
		"8 ");

//		Case 1
		input=
		"3 4 "+
		"1 1 3 4 "+
		"2 1 1 "+
		"2 2 2 "+
		"2 3 3 ";
		runTest(input,
		"3 "+
		"2 "+
		"1 ");

//		Case 2
		input=
		"10 6 "+
		"1 1 5 3 "+
		"1 2 7 9 "+
		"1 10 10 11 "+
		"1 3 8 12 "+
		"1 1 10 3 "+
		"2 1 10 ";
		runTest(input,
		"129 ");


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
	_445_E_DZY_Loves_Colors r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _445_E_DZY_Loves_Colors();
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
		new _445_E().init();
	}
	
}


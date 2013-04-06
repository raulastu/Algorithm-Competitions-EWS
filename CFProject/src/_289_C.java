import java.io.*;
public class _289_C {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"7 4 ";
		runTest(input,
		"ababacd ");

//		Case 1
		input=
		"4 7 ";
		runTest(input,
		"-1 ");

//		Case 2
		input=
		"4 1 ";
		runTest(input,
		"aaaa "); 

//		Case 2
		input=
		"4 2 ";
		runTest(input,
		"abab ");
		
//		Case 2
		input=
		"28 26 ";
		runTest(input,
		"a ");
		
//		Case 2
		input=
		"2 2 ";
		runTest(input,
		"abac ");

//		Case 2
		input=
		"100 1 ";
		runTest(input,
		"abac ");
		
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
	_289_C_Polo_the_Penguin_and_Strings r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _289_C_Polo_the_Penguin_and_Strings();
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
		new _289_C().init();
	}
	
}


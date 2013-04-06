import java.io.*;
public class _289_B {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"2 2 2 "+
		"2 4 "+
		"6 8 ";
		runTest(input,
		"4 ");

//		Case 1
		input=
		"1 2 7 "+
		"6 7 ";
		runTest(input,
		"-1 ");
		
//		Case 1
		input=
		"2 2 7 "+
		"7 1 " +
		"7 7 ";
		runTest(input,
		"-1 ");

//		Case 1
		input=
		"2 2 7 "+
		"1 8 " +
		"1 1 ";
		runTest(input,
		"1 ");
		
//		Case 1
		input=
		"2 2 2 "+
		"1 5 " +
		"1 3 ";
		runTest(input,
		"3 ");

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
	_289_B_Polo_the_Penguin_and_Matrix r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _289_B_Polo_the_Penguin_and_Matrix();
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
		new _289_B().init();
	}
	
}


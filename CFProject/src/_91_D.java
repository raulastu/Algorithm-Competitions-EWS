import java.io.*;
public class _91_D {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"6 "+
		"3 5 6 1 2 4 ";
		runTest(input,
		"2 "+
		"4 "+
		"1 3 6 4  "+
		"3 6 4 1  "+
		"2 "+
		"2 5  "+
		"5 2  ");

//		Case 1
		input=
		"14 "+
		"9 13 11 3 10 7 12 14 1 5 4 6 8 2 ";
		runTest(input,
		"3 "+
		"4 "+
		"2 13 8 14  "+
		"13 8 14 2  "+
		"5 "+
		"6 7 12 5 10  "+
		"7 12 6 10 5  "+
		"5 "+
		"3 11 4 1 9  "+
		"11 4 3 9 1  ");


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
	_91_D_Grocers_Problem r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _91_D_Grocers_Problem();
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
		new _91_D().init();
	}
	
}


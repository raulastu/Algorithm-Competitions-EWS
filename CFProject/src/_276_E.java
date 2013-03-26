import java.io.*;
public class _276_E {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"3 6 "+
		"1 2 "+
		"1 3 "+
		"0 3 1 2 "+
		"0 2 3 1 "+
		"0 1 5 2 "+
		"1 1 "+
		"1 2 "+
		"1 3 ";
		runTest(input,
		"9 "+
		"9 "+
		"6 ");

//		Case 1
		input=
		"6 11 "+
		"1 2 "+
		"2 5 "+
		"5 4 "+
		"1 6 "+
		"1 3 "+
		"0 3 1 3 "+
		"0 3 4 5 "+
		"0 2 1 4 "+
		"0 1 5 5 "+
		"0 4 6 2 "+
		"1 1 "+
		"1 2 "+
		"1 3 "+
		"1 4 "+
		"1 5 "+
		"1 6 ";
		runTest(input,
		"11 "+
		"17 "+
		"11 "+
		"16 "+
		"17 "+
		"11 ");


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
	_276_E_Little_Girl_and_Problem_on_Trees r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _276_E_Little_Girl_and_Problem_on_Trees();
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
		new _276_E().init();
	}
	
}


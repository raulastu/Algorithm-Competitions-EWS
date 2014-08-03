import java.io.*;
public class _450_D {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"5 5 3 "+
		"1 2 1 "+
		"2 3 2 "+
		"1 3 3 "+
		"3 4 4 "+
		"1 5 5 "+
		"3 5 "+
		"4 5 "+
		"5 5 ";
		runTest(input,
		"2 ");

//		Case 1
		input=
		"2 2 3 "+
		"1 2 2 "+
		"2 1 3 "+
		"2 1 "+
		"2 2 "+
		"2 3 ";
		runTest(input,
		"2 ");


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
	_450_D_Jzzhu_and_Cities r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _450_D_Jzzhu_and_Cities();
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
		new _450_D().init();
	}
	
}


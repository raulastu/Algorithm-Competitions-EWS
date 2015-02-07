import java.io.*;
public class _513_513_G2_G2_Inversions_problem {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"3 1 "+
		"1 2 3 ";
		runTest(input,
		"0.833333333333333 ");

//		Case 1
		input=
		"3 4 "+
		"1 3 2 ";
		runTest(input,
		"1.458333333333334 ");


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
	_513_G2_G2_Inversions_problem r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _513_G2_G2_Inversions_problem();
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
		new _513_513_G2_G2_Inversions_problem().init();
	}
	
}


import java.io.*;
public class _369_A {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"3 1 1 "+
		"1 2 1 ";
		runTest(input,
		"1 ");

//		Case 1
		input=
		"4 3 1 "+
		"1 1 1 1 ";
		runTest(input,
		"1 ");

//		Case 2
		input=
		"3 1 2 "+
		"2 2 2 ";
		runTest(input,
		"0 ");

//		Case 3
		input=
		"8 2 2 "+
		"1 2 1 2 1 2 1 2 ";
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
	_369_A_Valera_and_Plates r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _369_A_Valera_and_Plates();
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
		new _369_A().init();
	}
	
}


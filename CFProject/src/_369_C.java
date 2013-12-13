import java.io.*;

import com.sun.tools.javac.code.Type.ForAll;
public class _369_C {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"5 "+
		"1 2 2 "+
		"2 3 2 "+
		"3 4 2 "+
		"4 5 2 ";
		runTest(input,
		"1 "+
		"5  ");

//		Case 1
		input=
		"5 "+
		"1 2 1 "+
		"2 3 2 "+
		"2 4 1 "+
		"4 5 1 ";
		runTest(input,
		"1 "+
		"3  ");

//		Case 2
		input=
		"5 "+
		"1 2 2 "+
		"1 3 2 "+
		"1 4 2 "+
		"1 5 2 ";
		runTest(input,
		"4 "+
		"5 4 3 2  ");
		
//		Case 2
		int N  = 100000;
		StringBuilder sb = new StringBuilder();
		sb.append(N+" ");
		for (int i = 1; i <= N; i++) {
			sb.append(i+" "+(i+1)+" "+(int)(Math.random()*3)+" ");
		}
//		System.err.println(input);
		runTest(sb.toString(),
		"4 "+
		"5 4 3 2  ");


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
	_369_C_Valera_and_Elections r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _369_C_Valera_and_Elections();
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
		new _369_C().init();
	}
	
}


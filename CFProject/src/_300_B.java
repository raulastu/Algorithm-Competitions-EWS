import java.io.*;
public class _300_B {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"3 0 ";
		runTest(input,
		"1 2 3 ");

//		Case 1
		input=
		"6 4 "+
		"1 2 "+
		"2 3 "+
		"3 4 "+
		"5 6 ";
		runTest(input,
		"-1 ");

//		Case 2
		input=
		"3 3 "+
		"1 2 "+
		"2 3 "+
		"1 3 ";
		runTest(input,
		"1 2 3 ");
		
//		Case 2
		input=
		"6 3 "+
		"1 2 "+
		"2 3 "+
		"4 5 ";
		runTest(input,
		"1 2 3 ");
//		Case 2
		input=
		"15 9 "+
		"1 4 "+
		"1 6 "+
		"2 7 "+
		"2 11 "+
		"4 6 "+
		"5 12 "+
		"7 11 "+
		"9 14 "+
		"13 15 ";
		runTest(input,
		"1 2 3 ");
		

		
		input=
		"48 48 "+
		"7 39 "+
		"39 45 "+
		"7 45 "+
		"25 26 "+
		"26 31 "+
		"25 31 "+
		"4 11 "+
		"11 19 "+
		"4 19 "+
		"8 16 "+
		"16 37 "+
		"8 37 "+
		"14 22 "+
		"22 33 "+
		"14 33 "+
		"6 12 " +
		"12 46 "+
		"6 46 "+
		"29 44 "+
		"44 48 "+
		"29 48 "+
		"15 27 "+
		"27 41 "+
		"15 41 "+
		"3 24 "+
		"24 34 "+
		"3 34 "+
		"13 20 "+
		"20 47 "+
		"13 47 "+
		"5 9 "+
		"9 36 "+
		"5 36 "+
		"21 40 "+
		"40 43 "+
		"21 43 "+
		"2 35 " +
		"35 38 " +
		"2 38 " +
		"23 28 " +
		"28 42 " +
		"23 42 " +
		"1 10 " +
		"10 32 " +
		"1 32 " +
		"17 18 " +
		"18 30 " +
		"17 30";
		runTest(input,
		"12  ");


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
	_300_B_Coach r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _300_B_Coach();
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
		new _300_B().init();
	}
	
}


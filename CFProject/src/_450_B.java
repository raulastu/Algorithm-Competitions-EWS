import java.io.*;
public class _450_B {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"2 3 "+
		"3 ";
		runTest(input,
		"1 ");

//		Case 1
		input=
		"0 -1 "+
		"2 ";
		runTest(input,
		"1000000006 ");
		
//		Case 0
		input=
		"1 3 "+
		"12 ";
		runTest(input,
		"1000000006 ");
		
//		Case 0
		input=
		"-10 -10 "+
		"12 ";
		runTest(input,
		"10 ");
		
//		Case 0
		input=
		"0 0 "+
		"12 ";
		runTest(input,
		"0 ");
		
//		Case 0
		input=
		"-1 0 "+
		"12 ";
		runTest(input,
		"1 ");
		
//		Case 0
		input=
		"-1 -10 "+
		"1 ";
		runTest(input,
		"999999997 ");
		
//		Case 0
		input=
		"-1000000000 1000000000 "+
		"1 ";
		runTest(input,
		"1000000000 ");
		
//		Case 0
		input=
		"-1 0 "+
		"123 ";
		runTest(input,
		"1 ");
		
//		Case 0
		input=
		"-1 -1 "+
		"2 ";
		runTest(input,
		"1000000006 ");

//		Case 0
		input=
		"-1000000 -100002 "+
		"2 ";
		runTest(input,
		"999900005 ");

//		Case 0
		input=
		"98546933 69294649 "+
		"1 ";
		runTest(input,
		"0 ");
//		[970747723, 69294649]
		
		for (int i = 0; i < 100000; i++) {
			int x=(int)(Math.random()*100000000) - (int)(Math.random()*100000000);
			int y=(int)(Math.random()*100000000) - (int)(Math.random()*100000000);
			int n=(int)(Math.random()*200000000);
			input=
			x+" "+y+
			" "+n+" ";
			runTest(input,
			"1 ");
		}
////		Case 0
//		input=
//		"0 -100002 "+
//		"2000000000 ";
//		runTest(input,
//		"999900005 ");

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
	_450_B_Jzzhu_and_Sequences r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _450_B_Jzzhu_and_Sequences();
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
		new _450_B().init();
	}
	
}


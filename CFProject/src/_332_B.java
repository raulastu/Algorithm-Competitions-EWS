import java.io.*;
public class _332_B {
	boolean testOutput=true;
	public void runTestCases() throws Exception{
//		Case 0
		input=
		"5 2 "+
		"3 6 1 1 6 ";
		runTest(input,
		"1 4 ");

//		Case 1
		input=
		"6 2 "+
		"1 1 1 1 1 1 ";
		runTest(input,
		"1 3 ");

		input=
		"98 24 "+
	    "91 20 12 75 44 22 22 67 28 100 8 41 31 47 95 87 5 54 7 49 32 46 42 37 45 22 29 15 54 98 46 94 69 47 60 1 15 76 17 82 46 22 32 34 91 37 30 26 92 77 69 11 59 78 24 66 88 15 32 49 46 14 57 20 5 69 53 99 81 70 67 22 54 31 49 52 46 51 46 2 53 59 8 66 28 53 54 5 85 75 15 55 87 16 68 6 36 98 ";
		runTest(input,
		"30 67 ");
				
		

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
	_332_B_Maximum_Absurdity r;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private void init() throws Exception{
		r = new _332_B_Maximum_Absurdity();
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
		new _332_B().init();
	}
	
}


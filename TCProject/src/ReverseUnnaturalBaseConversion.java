import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class ReverseUnnaturalBaseConversion {
   public String convertToBase(int x, int b) {

   }


// BEGIN CUT HERE

	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}
	
	static String tl="";
	private static void printTree() {
		try{
			String[] drawing = new Util.treeDrawing.TreeDrawing().draw(new String[]{tl});
			System.err.println(Arrays.deepToString(drawing).replaceAll("\\[|\\]", "").replaceAll(", ", "\n")+"\n");
		}catch (Exception ex){
			System.err.println("invalid tree>"+tl);
		}	
		tl="";
	}
	private static void tn(Object...o){tl+="("+Arrays.deepToString(o).replaceAll(" |\\[|\\]", "")+")";}
	private static void tb(){tl+="[]";}
	private static void tns(){tl+="[";}
	private static void tne(){tl+="]";}
   

public static void main(String[] args) {
		if (args.length == 0) {
			ReverseUnnaturalBaseConversionHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ReverseUnnaturalBaseConversionHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    
    

// END CUT HERE
}

// BEGIN CUT HERE
class ReverseUnnaturalBaseConversionHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}
		
		int correct = 0, total = 0;
		for (int i=0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100) break;
				continue;
			}
			correct += x;
			++total;
		}
		
		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}
	
	static boolean compareOutput(String expected, String result) { return expected.equals(result); }
	static String formatResult(String res) {
		return String.format("\"%s\"", res);
	}
	
	static int verifyCase(int casenum, String expected, String received) { 
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.println("PASSED");
			return 1;
		} else {
			System.err.println("FAILED");
			System.err.println("    Expected: " + formatResult(expected)); 
			System.err.println("    Received: " + formatResult(received)); 
			return 0;
		}
	}

	static int runTestCase(int casenum__) {
		switch(casenum__) {
		case 0: {
			int x                     = 12345;
			int b                     = 10;
			String expected__         = "12345";

			return verifyCase(casenum__, expected__, new ReverseUnnaturalBaseConversion().convertToBase(x, b));
		}
		case 1: {
			int x                     = 8265;
			int b                     = -10;
			String expected__         = "12345";

			return verifyCase(casenum__, expected__, new ReverseUnnaturalBaseConversion().convertToBase(x, b));
		}
		case 2: {
			int x                     = 1001;
			int b                     = -2;
			String expected__         = "10000111001";

			return verifyCase(casenum__, expected__, new ReverseUnnaturalBaseConversion().convertToBase(x, b));
		}
		case 3: {
			int x                     = -52;
			int b                     = -2;
			String expected__         = "11011100";

			return verifyCase(casenum__, expected__, new ReverseUnnaturalBaseConversion().convertToBase(x, b));
		}
		case 4: {
			int x                     = -38;
			int b                     = 4;
			String expected__         = "-212";

			return verifyCase(casenum__, expected__, new ReverseUnnaturalBaseConversion().convertToBase(x, b));
		}
		case 5: {
			int x                     = -123456789;
			int b                     = -7;
			String expected__         = "3031330536";

			return verifyCase(casenum__, expected__, new ReverseUnnaturalBaseConversion().convertToBase(x, b));
		}
		case 6: {
			int x                     = 0;
			int b                     = 2;
			String expected__         = "0";

			return verifyCase(casenum__, expected__, new ReverseUnnaturalBaseConversion().convertToBase(x, b));
		}

		// custom cases

/*      case 7: {
			int x                     = ;
			int b                     = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new ReverseUnnaturalBaseConversion().convertToBase(x, b));
		}*/
/*      case 8: {
			int x                     = ;
			int b                     = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new ReverseUnnaturalBaseConversion().convertToBase(x, b));
		}*/
/*      case 9: {
			int x                     = ;
			int b                     = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new ReverseUnnaturalBaseConversion().convertToBase(x, b));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE

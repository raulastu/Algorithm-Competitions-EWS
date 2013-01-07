import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class RangeFixer {
   public int[] closestValue(int low, int high, int[] values) {

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
			RangeFixerHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				RangeFixerHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    
    

// END CUT HERE
}

// BEGIN CUT HERE
class RangeFixerHarness {
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
	
	static boolean compareOutput(int[] expected, int[] result) { if (expected.length != result.length) return false; for (int i=0; i<expected.length; ++i) if (expected[i] != result[i]) return false; return true; }

	static String formatResult(int[] res) {
		String ret = "";
		ret += "{";
		for (int i=0; i<res.length; ++i) {
			if (i > 0) ret += ",";
			ret += String.format(" %d", res[i]);
		}
		ret += " }";
		return ret;
	}
	
	static int verifyCase(int casenum, int[] expected, int[] received) { 
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
			int low                   = 101;
			int high                  = 105;
			int[] values              = {71};
			int[] expected__          = {103 };

			return verifyCase(casenum__, expected__, new RangeFixer().closestValue(low, high, values));
		}
		case 1: {
			int low                   = 98;
			int high                  = 304;
			int[] values              = {12, 65, 302, 1, 1000000};
			int[] expected__          = {140, 193, 302, 129, 192 };

			return verifyCase(casenum__, expected__, new RangeFixer().closestValue(low, high, values));
		}
		case 2: {
			int low                   = 16;
			int high                  = 16;
			int[] values              = {1000000};
			int[] expected__          = {16 };

			return verifyCase(casenum__, expected__, new RangeFixer().closestValue(low, high, values));
		}
		case 3: {
			int low                   = 83;
			int high                  = 92;
			int[] values              = {48};
			int[] expected__          = {84 };

			return verifyCase(casenum__, expected__, new RangeFixer().closestValue(low, high, values));
		}
		case 4: {
			int low                   = 1;
			int high                  = 4;
			int[] values              = {5, 6, 7};
			int[] expected__          = {1, 2, 3 };

			return verifyCase(casenum__, expected__, new RangeFixer().closestValue(low, high, values));
		}
		case 5: {
			int low                   = 10000000;
			int high                  = 20000000;
			int[] values              = {50382, 1234, 58126, 13952, 1475, 24, 1560};
			int[] expected__          = {16827598, 16778450, 16835342, 16791168, 16778691, 16777240, 16778776 };

			return verifyCase(casenum__, expected__, new RangeFixer().closestValue(low, high, values));
		}

		// custom cases

/*      case 6: {
			int low                   = ;
			int high                  = ;
			int[] values              = ;
			int[] expected__          = ;

			return verifyCase(casenum__, expected__, new RangeFixer().closestValue(low, high, values));
		}*/
/*      case 7: {
			int low                   = ;
			int high                  = ;
			int[] values              = ;
			int[] expected__          = ;

			return verifyCase(casenum__, expected__, new RangeFixer().closestValue(low, high, values));
		}*/
/*      case 8: {
			int low                   = ;
			int high                  = ;
			int[] values              = ;
			int[] expected__          = ;

			return verifyCase(casenum__, expected__, new RangeFixer().closestValue(low, high, values));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE

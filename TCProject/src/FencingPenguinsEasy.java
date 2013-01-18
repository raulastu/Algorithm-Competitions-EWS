import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class FencingPenguinsEasy {
   public double calculateMinArea(int numPosts, int radius, int[] x, int[] y) {
	   
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
			FencingPenguinsEasyHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				FencingPenguinsEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    
    

// END CUT HERE
}

// BEGIN CUT HERE
class FencingPenguinsEasyHarness {
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
	
	static final double MAX_DOUBLE_ERROR = 1E-9;
	static boolean compareOutput(double expected, double result){ if(Double.isNaN(expected)){ return Double.isNaN(result); }else if(Double.isInfinite(expected)){ if(expected > 0){ return result > 0 && Double.isInfinite(result); }else{ return result < 0 && Double.isInfinite(result); } }else if(Double.isNaN(result) || Double.isInfinite(result)){ return false; }else if(Math.abs(result - expected) < MAX_DOUBLE_ERROR){ return true; }else{ double min = Math.min(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); double max = Math.max(expected * (1.0 - MAX_DOUBLE_ERROR), expected * (1.0 + MAX_DOUBLE_ERROR)); return result > min && result < max; } }
	static double relativeError(double expected, double result) { if (Double.isNaN(expected) || Double.isInfinite(expected) || Double.isNaN(result) || Double.isInfinite(result) || expected == 0) return 0; return Math.abs(result-expected) / Math.abs(expected); }
	
	static String formatResult(double res) {
		return String.format("%.10g", res);
	}
	
	static int verifyCase(int casenum, double expected, double received) { 
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.print("PASSED");
			double rerr = relativeError(expected, received);
			if (rerr > 0) System.err.printf(" (relative error %g)", rerr);
			System.err.println();
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
			int numPosts              = 3;
			int radius                = 5;
			int[] x                   = {-1};
			int[] y                   = {0};
			double expected__         = 32.47595264191645;

			return verifyCase(casenum__, expected__, new FencingPenguinsEasy().calculateMinArea(numPosts, radius, x, y));
		}
		case 1: {
			int numPosts              = 30;
			int radius                = 5;
			int[] x                   = {6};
			int[] y                   = {0};
			double expected__         = -1.0;

			return verifyCase(casenum__, expected__, new FencingPenguinsEasy().calculateMinArea(numPosts, radius, x, y));
		}
		case 2: {
			int numPosts              = 4;
			int radius                = 5;
			int[] x                   = {2};
			int[] y                   = {1};
			double expected__         = 25.0;

			return verifyCase(casenum__, expected__, new FencingPenguinsEasy().calculateMinArea(numPosts, radius, x, y));
		}
		case 3: {
			int numPosts              = 4;
			int radius                = 5;
			int[] x                   = {2,-2};
			int[] y                   = {1,-1};
			double expected__         = 50.0;

			return verifyCase(casenum__, expected__, new FencingPenguinsEasy().calculateMinArea(numPosts, radius, x, y));
		}
		case 4: {
			int numPosts              = 8;
			int radius                = 5;
			int[] x                   = {8};
			int[] y                   = {8};
			double expected__         = -1.0;

			return verifyCase(casenum__, expected__, new FencingPenguinsEasy().calculateMinArea(numPosts, radius, x, y));
		}
		case 5: {
			int numPosts              = 7;
			int radius                = 10;
			int[] x                   = {9};
			int[] y                   = {1};
			double expected__         = 29.436752637711805;

			return verifyCase(casenum__, expected__, new FencingPenguinsEasy().calculateMinArea(numPosts, radius, x, y));
		}
		case 6: {
			int numPosts              = 30;
			int radius                = 800;
			int[] x                   = {8,2,100,120,52,67,19,-36};
			int[] y                   = {-19,12,88,-22,53,66,-140,99} ;
			double expected__         = 384778.74757953023;

			return verifyCase(casenum__, expected__, new FencingPenguinsEasy().calculateMinArea(numPosts, radius, x, y));
		}

		// custom cases

/*      case 7: {
			int numPosts              = ;
			int radius                = ;
			int[] x                   = ;
			int[] y                   = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new FencingPenguinsEasy().calculateMinArea(numPosts, radius, x, y));
		}*/
/*      case 8: {
			int numPosts              = ;
			int radius                = ;
			int[] x                   = ;
			int[] y                   = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new FencingPenguinsEasy().calculateMinArea(numPosts, radius, x, y));
		}*/
/*      case 9: {
			int numPosts              = ;
			int radius                = ;
			int[] x                   = ;
			int[] y                   = ;
			double expected__         = ;

			return verifyCase(casenum__, expected__, new FencingPenguinsEasy().calculateMinArea(numPosts, radius, x, y));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE

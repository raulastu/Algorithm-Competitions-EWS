import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class DivisibleSequence {
   public int count(int N, int H) {

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
			DivisibleSequenceHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				DivisibleSequenceHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    
    

// END CUT HERE
}

// BEGIN CUT HERE
class DivisibleSequenceHarness {
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
	
	static boolean compareOutput(int expected, int result) { return expected == result; }
	static String formatResult(int res) {
		return String.format("%d", res);
	}
	
	static int verifyCase(int casenum, int expected, int received) { 
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
			int N                     = 5;
			int H                     = 3;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new DivisibleSequence().count(N, H));
		}
		case 1: {
			int N                     = 6;
			int H                     = 3;
			int expected__            = 9;

			return verifyCase(casenum__, expected__, new DivisibleSequence().count(N, H));
		}
		case 2: {
			int N                     = 10;
			int H                     = 2;
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new DivisibleSequence().count(N, H));
		}
		case 3: {
			int N                     = 1;
			int H                     = 10000;
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new DivisibleSequence().count(N, H));
		}
		case 4: {
			int N                     = 30;
			int H                     = 4;
			int expected__            = 64;

			return verifyCase(casenum__, expected__, new DivisibleSequence().count(N, H));
		}
		case 5: {
			int N                     = 25883;
			int H                     = 100000;
			int expected__            = 991000009;

			return verifyCase(casenum__, expected__, new DivisibleSequence().count(N, H));
		}

		// custom cases

/*      case 6: {
			int N                     = ;
			int H                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DivisibleSequence().count(N, H));
		}*/
/*      case 7: {
			int N                     = ;
			int H                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DivisibleSequence().count(N, H));
		}*/
/*      case 8: {
			int N                     = ;
			int H                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new DivisibleSequence().count(N, H));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class SurroundingGameEasy {
   public int score(String[] cost, String[] benefit, String[] stone) {

   }


// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			SurroundingGameEasyHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				SurroundingGameEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    private static void print(Object... rs) {
        System.err.println(Arrays.deepToString(rs));
    }

    private static void printm(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.err.println("[" + a[i] + "]");
        }
    }

    private static void printm(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.err.println("[" + new String(a[i]) + "]");
        }
    }
    
    private static void printm(int[][] a) {
    	System.err.println("");
        for (int i = 0; i < a.length; i++) {
        	String line = "";
        	for (int j = 0; j < a[i].length; j++) {
				line+=a[i][j]+" ";
			}
            System.err.println("[" + line.trim() + "]");
        }
        System.err.println("");
    }
    

// END CUT HERE
}

// BEGIN CUT HERE
class SurroundingGameEasyHarness {
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
			String[] cost             = {"21","12"};
			String[] benefit          = {"21","12"};
			String[] stone            = {".o","o."};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new SurroundingGameEasy().score(cost, benefit, stone));
		}
		case 1: {
			String[] cost             = {"99","99"};
			String[] benefit          = {"11","11"};
			String[] stone            = {".o","o."};
			int expected__            = -14;

			return verifyCase(casenum__, expected__, new SurroundingGameEasy().score(cost, benefit, stone));
		}
		case 2: {
			String[] cost             = {"888","888","888"};
			String[] benefit          = {"000","090","000"};
			String[] stone            = {"...",".o.","..."};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new SurroundingGameEasy().score(cost, benefit, stone));
		}
		case 3: {
			String[] cost             = {"4362","4321"};
			String[] benefit          = {"5329","5489"};
			String[] stone            = {"...o","..o."};
			int expected__            = 22;

			return verifyCase(casenum__, expected__, new SurroundingGameEasy().score(cost, benefit, stone));
		}
		case 4: {
			String[] cost             = {"5413","4323","8321","5490"};
			String[] benefit          = {"0432","7291","3901","2310"};
			String[] stone            = {"ooo.","o..o","...o","oooo"};
			int expected__            = -12;

			return verifyCase(casenum__, expected__, new SurroundingGameEasy().score(cost, benefit, stone));
		}

		// custom cases

/*      case 5: {
			String[] cost             = ;
			String[] benefit          = ;
			String[] stone            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SurroundingGameEasy().score(cost, benefit, stone));
		}*/
/*      case 6: {
			String[] cost             = ;
			String[] benefit          = ;
			String[] stone            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SurroundingGameEasy().score(cost, benefit, stone));
		}*/
/*      case 7: {
			String[] cost             = ;
			String[] benefit          = ;
			String[] stone            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SurroundingGameEasy().score(cost, benefit, stone));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE

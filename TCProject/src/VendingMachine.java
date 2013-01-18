import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class VendingMachine {
   public int motorUse(String[] prices, String[] purchases) {

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
			VendingMachineHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				VendingMachineHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    
    

// END CUT HERE
}

// BEGIN CUT HERE
class VendingMachineHarness {
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
			String[] prices           = {"100 100 100"};
			String[] purchases        = {"0,0:0", "0,2:5", "0,1:10"};
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new VendingMachine().motorUse(prices, purchases));
		}
		case 1: {
			String[] prices           = {"100 200 300 400 500 600"};
			String[] purchases        = {"0,2:0", "0,3:5", "0,1:10", "0,4:15"};
			int expected__            = 17;

			return verifyCase(casenum__, expected__, new VendingMachine().motorUse(prices, purchases));
		}
		case 2: {
			String[] prices           = {"100 200 300 400 500 600"};
			String[] purchases        = {"0,2:0", "0,3:4", "0,1:8", "0,4:12"};
			int expected__            = 11;

			return verifyCase(casenum__, expected__, new VendingMachine().motorUse(prices, purchases));
		}
		case 3: {
			String[] prices           = {"100 100 100"};
			String[] purchases        = {"0,0:10", "0,0:11"};
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new VendingMachine().motorUse(prices, purchases));
		}
		case 4: {
			String[] prices           = {"100 200 300",
 "600 500 400"};
			String[] purchases        = {"0,0:0", "1,1:10", "1,2:20",
 "0,1:21", "1,0:22", "0,2:35"};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new VendingMachine().motorUse(prices, purchases));
		}

		// custom cases

/*      case 5: {
			String[] prices           = ;
			String[] purchases        = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new VendingMachine().motorUse(prices, purchases));
		}*/
/*      case 6: {
			String[] prices           = ;
			String[] purchases        = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new VendingMachine().motorUse(prices, purchases));
		}*/
/*      case 7: {
			String[] prices           = ;
			String[] purchases        = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new VendingMachine().motorUse(prices, purchases));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE

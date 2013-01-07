import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class Jewelry {
   public long howMany(int[] values) {

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
			JewelryHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				JewelryHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    
    

// END CUT HERE
}

// BEGIN CUT HERE
class JewelryHarness {
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
	
	static boolean compareOutput(long expected, long result) { return expected == result; }
	static String formatResult(long res) {
		return String.format("%d", res);
	}
	
	static int verifyCase(int casenum, long expected, long received) { 
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
			int[] values              = {1,2,5,3,4,5};
			long expected__           = 9;

			return verifyCase(casenum__, expected__, new Jewelry().howMany(values));
		}
		case 1: {
			int[] values              = {1000,1000,1000,1000,1000, 1000,1000,1000,1000,1000, 1000,1000,1000,1000,1000, 1000,1000,1000,1000,1000, 1000,1000,1000,1000,1000, 1000,1000,1000,1000,1000};
			long expected__           = 18252025766940L;

			return verifyCase(casenum__, expected__, new Jewelry().howMany(values));
		}
		case 2: {
			int[] values              = {1,2,3,4,5};
			long expected__           = 4;

			return verifyCase(casenum__, expected__, new Jewelry().howMany(values));
		}
		case 3: {
			int[] values              = {7,7,8,9,10,11,1,2,2,3,4,5,6};
			long expected__           = 607;

			return verifyCase(casenum__, expected__, new Jewelry().howMany(values));
		}
		case 4: {
			int[] values              = {123,217,661,678,796,964,54,111,417,526,917,923};
			long expected__           = 0;

			return verifyCase(casenum__, expected__, new Jewelry().howMany(values));
		}

		// custom cases

/*      case 5: {
			int[] values              = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new Jewelry().howMany(values));
		}*/
/*      case 6: {
			int[] values              = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new Jewelry().howMany(values));
		}*/
/*      case 7: {
			int[] values              = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new Jewelry().howMany(values));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE

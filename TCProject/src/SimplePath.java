import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class SimplePath {
   public int trouble(String direction, int[] length) {
	   int N = direction.length();
	   int[]x1 = new int[N];
	   int[]x2 = new int[N];
	   int[]y1 = new int[N];
	   int[]y2 = new int[N];
	   
	   int[]x3 = new int[N];
	   int[]x4 = new int[N];
	   int[]y3 = new int[N];
	   int[]y4 = new int[N];
	   for (int i = 0; i < N; i++) {
		   
	   }
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
			SimplePathHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				SimplePathHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    
    

// END CUT HERE
}

// BEGIN CUT HERE
class SimplePathHarness {
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
			String direction          = "NWSEEN";
			int[] length              = {5,5,3,2,5,2};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new SimplePath().trouble(direction, length));
		}
		case 1: {
			String direction          = "NWWS";
			int[] length              = {10,3,7,10};
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new SimplePath().trouble(direction, length));
		}
		case 2: {
			String direction          = "NWES";
			int[] length              = {2,2,1,2};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new SimplePath().trouble(direction, length));
		}
		case 3: {
			String direction          = "NWSE";
			int[] length              = {100,100,100,100};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new SimplePath().trouble(direction, length));
		}
		case 4: {
			String direction          = "EEEEEW";
			int[] length              = {1,1,1,1,1,10};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new SimplePath().trouble(direction, length));
		}

		// custom cases

/*      case 5: {
			String direction          = ;
			int[] length              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SimplePath().trouble(direction, length));
		}*/
/*      case 6: {
			String direction          = ;
			int[] length              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SimplePath().trouble(direction, length));
		}*/
/*      case 7: {
			String direction          = ;
			int[] length              = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new SimplePath().trouble(direction, length));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE

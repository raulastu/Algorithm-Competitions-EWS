import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class Hawaiian {
   public String[] getWords(String sentence) {

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
			HawaiianHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				HawaiianHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    
    

// END CUT HERE
}

// BEGIN CUT HERE
class HawaiianHarness {
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
	
	static boolean compareOutput(String[] expected, String[] result) { if (expected.length != result.length) return false; for (int i=0; i<expected.length; ++i) if (!expected[i].equals(result[i])) return false; return true; }

	static String formatResult(String[] res) {
		String ret = "";
		ret += "{";
		for (int i=0; i<res.length; ++i) {
			if (i > 0) ret += ",";
			ret += String.format(" \"%s\"", res[i]);
		}
		ret += " }";
		return ret;
	}
	
	static int verifyCase(int casenum, String[] expected, String[] received) { 
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
			String sentence           = "Hawaii is an island";
			String[] expected__       = { "Hawaii",  "an" };

			return verifyCase(casenum__, expected__, new Hawaiian().getWords(sentence));
		}
		case 1: {
			String sentence           = "Mauna Kea and Mauna Koa are two mountains";
			String[] expected__       = { "Mauna",  "Kea",  "Mauna",  "Koa" };

			return verifyCase(casenum__, expected__, new Hawaiian().getWords(sentence));
		}
		case 2: {
			String sentence           = "Pineapple grows in Hawaii";
			String[] expected__       = { "Pineapple",  "in",  "Hawaii" };

			return verifyCase(casenum__, expected__, new Hawaiian().getWords(sentence));
		}

		// custom cases

/*      case 3: {
			String sentence           = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new Hawaiian().getWords(sentence));
		}*/
/*      case 4: {
			String sentence           = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new Hawaiian().getWords(sentence));
		}*/
/*      case 5: {
			String sentence           = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new Hawaiian().getWords(sentence));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE

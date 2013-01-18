import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class KLastNonZeroDigits {
	public String getKDigits(int N, int K) {
		long f = 1;
		for (int i = N; i >=1; i--) {
			f *= i;
		}
//		print(f);
		String r = (f + "").replaceAll("[0]+$", "");
//		print("a,b c".split("[ |,]"));
		if (r.length() > K) {
			return r.substring(r.length() - K);
		}
		return r + "";
	}

	// BEGIN CUT HERE

	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}

	static String tl = "";

	private static void printTree() {
		try {
			String[] drawing = new Util.treeDrawing.TreeDrawing()
					.draw(new String[] { tl });
			System.err.println(Arrays.deepToString(drawing)
					.replaceAll("\\[|\\]", "").replaceAll(", ", "\n")
					+ "\n");
		} catch (Exception ex) {
			System.err.println("invalid tree>" + tl);
		}
		tl = "";
	}

	private static void tn(Object... o) {
		tl += "(" + Arrays.deepToString(o).replaceAll(" |\\[|\\]", "") + ")";
	}

	private static void tb() {
		tl += "[]";
	}

	private static void tns() {
		tl += "[";
	}

	private static void tne() {
		tl += "]";
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			KLastNonZeroDigitsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				KLastNonZeroDigitsHarness.run_test(Integer.valueOf(args[i]));
		}
	}

	// END CUT HERE
}

// BEGIN CUT HERE
class KLastNonZeroDigitsHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum
						+ " does not exist.");
			return;
		}

		int correct = 0, total = 0;
		for (int i = 0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100)
					break;
				continue;
			}
			correct += x;
			++total;
		}

		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of "
					+ total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}

	static boolean compareOutput(String expected, String result) {
		return expected.equals(result);
	}

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
		switch (casenum__) {
		case 0: {
			int N = 10;
			int K = 3;
			String expected__ = "288";

			return verifyCase(casenum__, expected__,
					new KLastNonZeroDigits().getKDigits(N, K));
		}
		case 1: {
			int N = 6;
			int K = 1;
			String expected__ = "2";

			return verifyCase(casenum__, expected__,
					new KLastNonZeroDigits().getKDigits(N, K));
		}
		case 2: {
			int N = 6;
			int K = 3;
			String expected__ = "72";

			return verifyCase(casenum__, expected__,
					new KLastNonZeroDigits().getKDigits(N, K));
		}
		case 3: {
			int N = 7;
			int K = 2;
			String expected__ = "04";

			return verifyCase(casenum__, expected__,
					new KLastNonZeroDigits().getKDigits(N, K));
		}
		case 4: {
			int N = 20;
			int K = 9;
			String expected__ = "200817664";

			return verifyCase(casenum__, expected__,
					new KLastNonZeroDigits().getKDigits(N, K));
		}
		case 5: {
			int N = 1;
			int K = 1;
			String expected__ = "1";

			return verifyCase(casenum__, expected__,
					new KLastNonZeroDigits().getKDigits(N, K));
		}
		case 6: {
			int N = 20;
			int K = 9;
			String expected__ = "1";

			return verifyCase(casenum__, expected__,
					new KLastNonZeroDigits().getKDigits(N, K));
		}
		case 7: {
			int N = 30;
			int K = 9;
			String expected__ = "1";

			return verifyCase(casenum__, expected__,
					new KLastNonZeroDigits().getKDigits(N, K));
		}
		// custom cases

		/*
		 * case 6: { int N = ; int K = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * KLastNonZeroDigits().getKDigits(N, K)); }
		 */
		/*
		 * case 7: { int N = ; int K = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * KLastNonZeroDigits().getKDigits(N, K)); }
		 */
		/*
		 * case 8: { int N = ; int K = ; String expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * KLastNonZeroDigits().getKDigits(N, K)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE

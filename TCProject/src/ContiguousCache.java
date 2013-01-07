import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class ContiguousCache {
	public long minimumReads(int n, int k, int[] addresses) {
//		int cached[] = new int[n];
		int N = addresses.length;
		long cache [] = new long[N];
		sort(addresses);
		
		long res = k;
		cache[0]=k;
		for (int i = 1; i < cache.length; i++) {
			if(cache[i-1]>addresses[i]-k){
				cache[i]=max(addresses[i],cache[i-1]);
				res+=(max(addresses[i],cache[i-1])-cache[i-1]);
			}else{
				cache[i]=addresses[i]+k;
				res+=k;
			}
			print(cache, res);
		}
		
		return res;
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
			ContiguousCacheHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				ContiguousCacheHarness.run_test(Integer.valueOf(args[i]));
		}
	}

	// END CUT HERE
}

// BEGIN CUT HERE
class ContiguousCacheHarness {
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

	static boolean compareOutput(long expected, long result) {
		return expected == result;
	}

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
		switch (casenum__) {
		case 0: {
			int n = 100;
			int k = 3;
			int[] addresses = { 0, 2, 16, 13 };
			long expected__ = 7;

			return verifyCase(casenum__, expected__,
					new ContiguousCache().minimumReads(n, k, addresses));
		}
		case 1: {
			int n = 100;
			int k = 10;
			int[] addresses = { 1, 10, 19, 28, 30, 37 };
			long expected__ = 29;

			return verifyCase(casenum__, expected__,
					new ContiguousCache().minimumReads(n, k, addresses));
		}
		case 2: {
			int n = 1000000000;
			int k = 500000000;
			int[] addresses = { 0, 999999999, 1, 500000000, 500000001,
					987654321 };
			long expected__ = 1987654320;

			return verifyCase(casenum__, expected__,
					new ContiguousCache().minimumReads(n, k, addresses));
		}
		case 3: {
			int n = 8;
			int k = 2;
			int[] addresses = { 7 };
			long expected__ = 2;

			return verifyCase(casenum__, expected__,
					new ContiguousCache().minimumReads(n, k, addresses));
		}

		// custom cases

		/*
		 * case 4: { int n = ; int k = ; int[] addresses = ; long expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ContiguousCache().minimumReads(n, k, addresses)); }
		 */
		/*
		 * case 5: { int n = ; int k = ; int[] addresses = ; long expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ContiguousCache().minimumReads(n, k, addresses)); }
		 */
		/*
		 * case 6: { int n = ; int k = ; int[] addresses = ; long expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * ContiguousCache().minimumReads(n, k, addresses)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE

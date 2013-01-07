import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class AlternateColors {
	public String getColor(long r, long g, long b, long k) {
		// long x=3000000000000L;
		long min = min(r, min(g, b));
		long[] balls = { r, g, b };
		if (k <= min * 3) {
			if (k % 3 == 1) {
				return "RED";
			} else if (k % 3 == 2) {
				return "GREEN";
			} else
				return "BLUE";
		} else {
			// int to = 0;
			k -= (min * 3);
			long min2 = Long.MAX_VALUE;
			int cc=0;
			for (int i = 0; i < balls.length; i++) {
				balls[i] -= min;
				if (balls[i] == 0)
					continue;
				min2 = min(balls[i], min2);
				cc++;
				// if (min2 > balls[i]) {
				// min2 = balls[i];
				// }
			}
//			print(k,min2,cc);
			if (k <= min2 * cc) {
				if(cc==1){
					if (balls[0] > 0)
						return "RED";
					if (balls[1] > 0)
						return "GREEN";
					if (balls[2] > 0)
						return "BLUE";
				}else{
					if (balls[0] == 0) {
						if (k % 2 == 1) {
							return "GREEN";
						} else {
							return "BLUE";
						}
					} else if (balls[1] == 0) {
						if (k % 2 == 1) {
							return "RED";
						} else {
							return "BLUE";
						}
					} else if (balls[2] == 0) {
						if (k % 2 == 1) {
							return "RED";
						} else {
							return "GREEN";
						}
					}
				}
				
			} else {
				k -= min2 * 2;
				for (int i = 0; i < balls.length; i++) {
					balls[i] -= min2;
				}
//				print(balls);
				if (balls[0] > 0)
					return "RED";
				if (balls[1] > 0)
					return "GREEN";
				if (balls[2] > 0)
					return "BLUE";
			}
		}
		return "";
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			AlternateColorsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				AlternateColorsHarness.run_test(Integer.valueOf(args[i]));
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
				line += a[i][j] + " ";
			}
			System.err.println("[" + line.trim() + "]");
		}
		System.err.println("");
	}

	// END CUT HERE
}

// BEGIN CUT HERE
class AlternateColorsHarness {
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
			long r = 1;
			long g = 1;
			long b = 1;
			long k = 3;
			String expected__ = "BLUE";

			return verifyCase(casenum__, expected__,
					new AlternateColors().getColor(r, g, b, k));
		}
		case 1: {
			long r = 3;
			long g = 4;
			long b = 5;
			long k = 4;
			String expected__ = "RED";

			return verifyCase(casenum__, expected__,
					new AlternateColors().getColor(r, g, b, k));
		}
		case 2: {
			long r = 7;
			long g = 7;
			long b = 1;
			long k = 7;
			String expected__ = "GREEN";

			return verifyCase(casenum__, expected__,
					new AlternateColors().getColor(r, g, b, k));
		}
		case 3: {
			long r = 1000000000000L;
			long g = 1;
			long b = 1;
			long k = 1000000000002L;
			String expected__ = "RED";

			return verifyCase(casenum__, expected__,
					new AlternateColors().getColor(r, g, b, k));
		}
		case 4: {
			long r = 653;
			long g = 32;
			long b = 1230;
			long k = 556;
			String expected__ = "BLUE";

			return verifyCase(casenum__, expected__,
					new AlternateColors().getColor(r, g, b, k));
		}

		// custom cases

		case 5: {
			long r = 1000000000000L;
			long g = 1000000000000L;
			long b = 1000000000000L;
			long k = 3000000000000L;
			String expected__ = "BLUE";

			return verifyCase(casenum__, expected__,
					new AlternateColors().getColor(r, g, b, k));
		}
		case 6: {
			long r = 98;
			long g = 77;
			long b = 77;
			long k = 239;
			String expected__ = "RED";

			return verifyCase(casenum__, expected__,
					new AlternateColors().getColor(r, g, b, k));
		}
		/*
		 * case 6: { long r = ; long g = ; long b = ; long k = ; String
		 * expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * AlternateColors().getColor(r, g, b, k)); }
		 */
		/*
		 * case 7: { long r = ; long g = ; long b = ; long k = ; String
		 * expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * AlternateColors().getColor(r, g, b, k)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE

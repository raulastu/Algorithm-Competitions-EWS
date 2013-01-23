import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class TheSquareRootDilemma {
	public int countPairs(int N, int M) {
		int rc = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
//				if(i==j){
//					rc++;
//					continue;
//				}
//				double ax = sqrt(i)*sqrt(j);
//				double bx = (int)(sqrt(i)*sqrt(j));
////				if(i==3){
////					print(i,j,ax,bx,'x');
////				}
//				if (abs(ax - bx)<0.0000000009){
////					print(i,j,ax,bx);
//					rc++;
//				}
				rc++;
			}
		}
		return rc;
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
			TheSquareRootDilemmaHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TheSquareRootDilemmaHarness.run_test(Integer.valueOf(args[i]));
		}
	}

	// END CUT HERE
}

// BEGIN CUT HERE
class TheSquareRootDilemmaHarness {
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

	static boolean compareOutput(int expected, int result) {
		return expected == result;
	}

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
		switch (casenum__) {
		case 0: {
			int N = 2;
			int M = 2;
			int expected__ = 2;

			return verifyCase(casenum__, expected__,
					new TheSquareRootDilemma().countPairs(N, M));
		}
		case 1: {
			int N = 10;
			int M = 1;
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new TheSquareRootDilemma().countPairs(N, M));
		}
		case 2: {
			int N = 3;
			int M = 8;
			int expected__ = 5;

			return verifyCase(casenum__, expected__,
					new TheSquareRootDilemma().countPairs(N, M));
		}
		
		case 3: {
			int N = 100;
			int M = 100;
			int expected__ = 310;

			return verifyCase(casenum__, expected__,
					new TheSquareRootDilemma().countPairs(N, M));
		}
		case 4: {
			int N = 77777;
			int M = 77777;
			int expected__ = 310;

			return verifyCase(casenum__, expected__,
					new TheSquareRootDilemma().countPairs(N, M));
		}

		// custom cases

		/*
		 * case 4: { int N = ; int M = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TheSquareRootDilemma().countPairs(N, M)); }
		 */
		/*
		 * case 5: { int N = ; int M = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TheSquareRootDilemma().countPairs(N, M)); }
		 */
		/*
		 * case 6: { int N = ; int M = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TheSquareRootDilemma().countPairs(N, M)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE

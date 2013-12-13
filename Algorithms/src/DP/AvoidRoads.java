package DP;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class AvoidRoads {
	public long numWays(int width, int height, String[] bad) {
		long dp[][] = new long[height+1][width+ 1];
		boolean blocked [][][]=new boolean[height+1][width+1][2];
		for (int i = 0; i < bad.length; i++) {
			String ss[] = bad[i].split(" ");
			int x=parseInt(ss[0]);
			int y=parseInt(ss[1]);
			int x2=parseInt(ss[2]);
			int y2=parseInt(ss[3]);
			int maxX=max(x,x2);
			int maxY=max(y,y2);
			int minX=min(x,x2);
			int minY=min(y,y2);
			int d=1;
			if(maxX==minX)d=0;
			blocked[maxY][maxX][d]=true;
//			blocked[minX][minY][maxX][maxY]=true;
		}
//		print(blocked[0][0][0][1]);
		dp[0][0]=1;
		for (int i = 1; i < dp[0].length; i++) {
			if(!blocked[0][i][1])
				dp[0][i]=dp[0][i-1];
		}
//		fill(dp[0],1);
		for (int i = 1; i < dp.length; i++) {
			if(!blocked[i][0][0])
				dp[i][0]=dp[i-1][0];
//			print(dp);
			for (int j = 1; j < dp[i].length; j++) {
				long a = 0;
				if(!blocked[i][j][1]){
					a=dp[i][j-1];
				}
				long b = 0;
				if(!blocked[i][j][0]){
					b=dp[i-1][j];
				}
				dp[i][j]=a+b;
			}
		}
//		print(dp);
		return dp[height][width];
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
			AvoidRoadsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				AvoidRoadsHarness.run_test(Integer.valueOf(args[i]));
		}
	}

	// END CUT HERE
}

// BEGIN CUT HERE
class AvoidRoadsHarness {
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
			int width = 6;
			int height = 6;
			String[] bad = { "0 0 0 1", "6 6 5 6" };
			long expected__ = 252;

			return verifyCase(casenum__, expected__,
					new AvoidRoads().numWays(width, height, bad));
		}
		case 1: {
			int width = 1;
			int height = 1;
			String[] bad = {};
			long expected__ = 2;

			return verifyCase(casenum__, expected__,
					new AvoidRoads().numWays(width, height, bad));
		}
		case 2: {
			int width = 35;
			int height = 31;
			String[] bad = {};
			long expected__ = 6406484391866534976L;

			return verifyCase(casenum__, expected__,
					new AvoidRoads().numWays(width, height, bad));
		}
		case 3: {
			int width = 2;
			int height = 2;
			String[] bad = { "0 0 1 0", "1 2 2 2", "1 1 2 1" };
			long expected__ = 0;

			return verifyCase(casenum__, expected__,
					new AvoidRoads().numWays(width, height, bad));
		}
		case 4: {
			int width = 100;
			int height = 100;
			String[] bad = { "0 0 1 0", "1 2 2 2", "1 1 2 1" };
			long expected__ = 0;

			return verifyCase(casenum__, expected__,
					new AvoidRoads().numWays(width, height, bad));
		}
		// custom cases

		/*
		 * case 4: { int width = ; int height = ; String[] bad = ; long
		 * expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * AvoidRoads().numWays(width, height, bad)); }
		 */
		/*
		 * case 5: { int width = ; int height = ; String[] bad = ; long
		 * expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * AvoidRoads().numWays(width, height, bad)); }
		 */
		/*
		 * case 6: { int width = ; int height = ; String[] bad = ; long
		 * expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * AvoidRoads().numWays(width, height, bad)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE

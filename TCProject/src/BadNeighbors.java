import java.util.regex.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class BadNeighbors {
	int memo[][];
	public int maxDonations(int[] donations) {
		memo=new int[2][donations.length];
		int[]d1=new int[donations.length-1];
		int[]d2=new int[donations.length-1];
		int c1=0;
		int c2=0;
		for (int i = 0; i < donations.length; i++) {
			memo[0][i]=-1;
			memo[1][i]=-1;
			if(i!=0)
				d1[c1++]=donations[i];
			if(i!=donations.length-1)
				d2[c2++]=donations[i];
		}
		return Math.max(go(d1,0,0), go(d2,0,1));
	}
	
	private int go(int[] d, int i,int k) {
		if(i>=d.length)return 0;
		if(memo[k][i]!=-1)return memo[k][i];
		int a=d[i]+go(d, i+2,k);
		int b=go(d, i+1,k);
		memo[k][i]=Math.max(a, b);
		return memo[k][i];
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			BadNeighborsHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				BadNeighborsHarness.run_test(Integer.valueOf(args[i]));
		}
	}

	// END CUT HERE

	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}
}

// BEGIN CUT HERE

class BadNeighborsHarness {

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
			int[] donations = { 10, 3, 2, 5, 7, 8 };
			int expected__ = 19;

			return verifyCase(casenum__, expected__,
					new BadNeighbors().maxDonations(donations));
		}
		case 1: {
			int[] donations = { 11, 15 };
			int expected__ = 15;

			return verifyCase(casenum__, expected__,
					new BadNeighbors().maxDonations(donations));
		}
		case 2: {
			int[] donations = { 7, 7, 7, 7, 7, 7, 7 };
			int expected__ = 21;

			return verifyCase(casenum__, expected__,
					new BadNeighbors().maxDonations(donations));
		}
		case 3: {
			int[] donations = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
			int expected__ = 16;

			return verifyCase(casenum__, expected__,
					new BadNeighbors().maxDonations(donations));
		}
		case 4: {
			int[] donations = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679,
					4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
					52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
			int expected__ = 2926;

			return verifyCase(casenum__, expected__,
					new BadNeighbors().maxDonations(donations));
		}
		case 5: {
			int[] donations = {836, 100, 274, 931, 632, 817, 951, 992, 17, 349, 189, 99, 77, 316, 698, 10, 732, 3, 2, 445, 524, 343, 953, 513, 459};
			int expected__ = 6933;

			return verifyCase(casenum__, expected__,
					new BadNeighbors().maxDonations(donations));
		}
		case 6: {
			int[] donations = {1,10,23,10,1};
			int expected__ = 24;

			return verifyCase(casenum__, expected__,
					new BadNeighbors().maxDonations(donations));
		}
		// custom cases

		/*
		 * case 5: { int[] donations = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BadNeighbors().maxDonations(donations)); }
		 */
		/*
		 * case 6: { int[] donations = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BadNeighbors().maxDonations(donations)); }
		 */
		/*
		 * case 7: { int[] donations = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * BadNeighbors().maxDonations(donations)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE

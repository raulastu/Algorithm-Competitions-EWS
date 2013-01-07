package DFS;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class CoinsGameEasy {
	int di[] = { 0, 0, 1, -1 };
	int dj[] = { -1, 1, 0, 0 };
	int N, M;
	char[][] board;

	public int minimalSteps(String[] _board) {
		board = new char[_board.length][_board[0].length()];
		int[] x = new int[4];
		int c = 0;
		for (int i = 0; i < board.length; i++) {
			board[i] = _board[i].toCharArray();
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'o') {
					x[c++] = i;
					x[c++] = j;
				}
			}
		}
		N = board.length;
		M = board[0].length;
		move(x[0], x[1], x[2], x[3], 0);
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	int res = Integer.MAX_VALUE;

	public void move(int x1, int y1, int x2, int y2, int c) {
		if (c > 10)
			return;
		if (fell(x1, y1) && !fell(x2, y2)) {
			res = min(res, c);
		}
		if (!fell(x1, y1) && fell(x2, y2)) {
			res = min(res, c);
		}
		if (!fell(x1, y1) && !fell(x2, y2)) {
			for (int i = 0; i < 4; i++) {
				int X = x1 + di[i];
				int Y = y1 + dj[i];
				int X2 = x2 + di[i];
				int Y2 = y2 + dj[i];
				if (!fell(X, Y) && board[X][Y] == '#') {
					X = x1;
					Y = y1;
				}
				if (!fell(X2, Y2) && board[X2][Y2] == '#') {
					X2 = x2;
					Y2 = y2;
				}
				move(X, Y, X2, Y2, c + 1);
			}
		}

	}

	boolean fell(int i, int j) {
		return (i < 0 || i >= N || j < 0 || j >= M);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			CoinsGameEasyHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				CoinsGameEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}

	private static void print(Object... o) {
		System.err.println(Arrays.deepToString(o).replace("]", "]\n"));
	}

	// END CUT HERE
}

// BEGIN CUT HERE
class CoinsGameEasyHarness {
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
			String[] board = { "oo" };
			int expected__ = 1;

			return verifyCase(casenum__, expected__,
					new CoinsGameEasy().minimalSteps(board));
		}
		case 1: {
			String[] board = { ".#", ".#", ".#", "o#", "o#", "##" };
			int expected__ = 4;

			return verifyCase(casenum__, expected__,
					new CoinsGameEasy().minimalSteps(board));
		}
		case 2: {
			String[] board = { "..", "..", "..", "o#", "o#", "##" };
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new CoinsGameEasy().minimalSteps(board));
		}
		case 3: {
			String[] board = { "###", ".o.", "###", ".o.", "###" };
			int expected__ = -1;

			return verifyCase(casenum__, expected__,
					new CoinsGameEasy().minimalSteps(board));
		}
		case 4: {
			String[] board = { "###", ".o.", "#.#", ".o.", "###" };
			int expected__ = 3;

			return verifyCase(casenum__, expected__,
					new CoinsGameEasy().minimalSteps(board));
		}
		case 5: {
			String[] board = { "###########", "........#o#", "###########",
					".........o#", "###########" };
			int expected__ = 10;

			return verifyCase(casenum__, expected__,
					new CoinsGameEasy().minimalSteps(board));
		}
		case 6: {
			String[] board = { "############", ".........#o#", "############",
					"..........o#", "############" };
			int expected__ = -1;

			return verifyCase(casenum__, expected__,
					new CoinsGameEasy().minimalSteps(board));
		}

		// custom cases

		/*
		 * case 7: { String[] board = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * CoinsGameEasy().minimalSteps(board)); }
		 */
		/*
		 * case 8: { String[] board = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * CoinsGameEasy().minimalSteps(board)); }
		 */
		/*
		 * case 9: { String[] board = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * CoinsGameEasy().minimalSteps(board)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE

package drawing.copy;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class SpellCardsEasy {
	public int maxDamage(int[] level, int[] damage) {
		this.damage = damage;
		this.level = level;
		this.n = level.length;
		dp = new int[level.length + 1][level.length + 1];
		for (int i = 0; i < dp.length; i++) {
			fill(dp[i], -1);
		}
		// fill(allowed, true);
		go(0, 0);
		printTree();
		return dp[0][0];
	}

	int level[], damage[];
	int dp[][];
	int n;

	int go(int p, int owed) {
		tn(p,owed);
		if (dp[p][owed] == -1) {
			int res = 0;
			if (n - p == owed){
				tb();
				return 0;
			}	
			else {
				tns();
				// do not use the card
//				tl+="[";
				res = go(p + 1, max(0, owed - 1));
				// use the card
				// int b = 0;
				if (owed + level[p] <= n - p) {
					res = max(res, damage[p] + go(p + 1, owed + level[p] - 1));
				}
				tne();
				// res = max(b, a);
			}
			dp[p][owed] = res;
		}
		else{
			tb();
		}
//		tl+="]";
		
		return dp[p][owed];
	}
	
	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SpellCardsEasyHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				SpellCardsEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}

	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}
	
	static String tl="";
	private static void printTree() {
		try{
			String[] drawing = new TreeDrawing().draw(new String[]{tl});
			System.err.println(Arrays.deepToString(drawing).replaceAll("\\[|\\]", "").replaceAll(", ", "\n")+"\n");
			tl="";
		}catch (Exception ex){
			System.err.println("invalid tree>"+tl);
		}	
	}
	private static void tn(Object...o){tl+="("+Arrays.deepToString(o).replaceAll(" |\\[|\\]", "")+")";}
	private static void tb(){tl+="[]";}
	private static void tns(){tl+="[";}
	private static void tne(){tl+="]";}

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
class SpellCardsEasyHarness {
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
			int[] level = { 1, 1, 1 };
			int[] damage = { 10, 20, 30 };
			int expected__ = 60;

			return verifyCase(casenum__, expected__,
					new SpellCardsEasy().maxDamage(level, damage));
		}
		case 1: {
			int[] level = { 3, 3, 3 };
			int[] damage = { 10, 20, 30 };
			int expected__ = 10;

			return verifyCase(casenum__, expected__,
					new SpellCardsEasy().maxDamage(level, damage));
		}
		case 2: {
			int[] level = { 4, 4, 4 };
			int[] damage = { 10, 20, 30 };
			int expected__ = 0;

			return verifyCase(casenum__, expected__,
					new SpellCardsEasy().maxDamage(level, damage));
		}
		case 3: {
			int[] level = { 50, 1, 50, 1, 50 };
			int[] damage = { 10, 20, 30, 40, 50 };
			int expected__ = 60;

			return verifyCase(casenum__, expected__,
					new SpellCardsEasy().maxDamage(level, damage));
		}
		case 4: {
			int[] level = { 2, 1, 1 };
			int[] damage = { 40, 40, 10 };
			int expected__ = 80;

			return verifyCase(casenum__, expected__,
					new SpellCardsEasy().maxDamage(level, damage));
		}
		case 5: {
			int[] level = { 1, 2, 1, 1, 3, 2, 1 };
			int[] damage = { 10, 40, 10, 10, 90, 40, 10 };
			int expected__ = 150;

			return verifyCase(casenum__, expected__,
					new SpellCardsEasy().maxDamage(level, damage));
		}
		case 6: {
			int[] level = { 1, 2, 2, 3, 1, 4, 2 };
			int[] damage = { 113, 253, 523, 941, 250, 534, 454 };
			int expected__ = 1577;

			return verifyCase(casenum__, expected__,
					new SpellCardsEasy().maxDamage(level, damage));
		}

		// custom cases

		/*
		 * case 7: { int[] level = ; int[] damage = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * SpellCardsEasy().maxDamage(level, damage)); }
		 */
		/*
		 * case 8: { int[] level = ; int[] damage = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * SpellCardsEasy().maxDamage(level, damage)); }
		 */
		/*
		 * case 9: { int[] level = ; int[] damage = ; int expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * SpellCardsEasy().maxDamage(level, damage)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE

package DP.knapsack;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class Knapsack {
	public int maximize(int[] values, int weights[], int max) {
		this.max=max;
		this.values=values;
		this.weights=weights;
		dp=new int[weights.length][100];
		for (int i = 0; i < weights.length; i++) {
			fill(dp[i],-1);
		}
		
		return go(0,0);
	}
	int max;
	int values[];
	int weights[];
	int dp[][];
	
	int go(int i, int w){
		if(i==values.length)
			return 0;
		if(dp[i][w]==-1){
			int r = go(i+1,w);
			if(w+weights[i]<=max){
				r = max(r,values[i]+go(i+1,w+weights[i]));
			}
			dp[i][w]=r;
		}
		return dp[i][w];
	}
	

	// BEGIN CUT HERE

	public static void main(String[] args) {
		try {
			eq(0, (new Knapsack()).maximize(
					new int[] { 4, 2,  2, 10, 1},
					new int[] { 12, 1, 2, 4,  1}, 15), 15);
			eq(1, (new Knapsack()).maximize(
					new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
					new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 15), 15);
			
		} catch (Exception exx) {
			System.err.println(exx);
			exx.printStackTrace(System.err);
		}
	}

	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}

	private static void eq(int n, int a, int b) {
		if (a == b) {
			System.err.println("Case " + n + " passed.");
		} else {
			System.err.println("Case " + n + " failed: " + received + " " + a
					+ " " + expected + " " + b + ".");
		}
	}

	private static void eq(int n, double a, double b) {
		if (a == b) {
			System.err.println("Case " + n + " passed.");
		} else {
			System.err.println("Case " + n + " failed: " + received + " '" + a
					+ "' " + expected + " '" + b + "'.");
		}
	}

	private static void eq(int n, char a, char b) {
		if (a == b) {
			System.err.println("Case " + n + " passed.");
		} else {
			System.err.println("Case " + n + " failed: " + received + " '" + a
					+ "' " + expected + " '" + b + "'.");
		}
	}

	private static void eq(int n, long a, long b) {
		if (a == b) {
			System.err.println("Case " + n + " passed.");
		} else {
			System.err.println("Case " + n + " failed: " + received + " '" + a
					+ "L' " + expected + " '" + b + "L'.");
		}
	}

	private static void eq(int n, boolean a, boolean b) {
		if (a == b) {
			System.err.println("Case " + n + " passed.");
		} else {
			System.err.println("Case " + n + " failed: " + received + " '" + a
					+ "' " + expected + " '" + b + "'.");
		}
	}

	private static void eq(int n, String a, String b) {
		if (a != null && a.equals(b)) {
			System.err.println("Case " + n + " passed.");
		} else {
			System.err.println("Case " + n + " failed: " + received + " \"" + a
					+ "\" " + expected + " \"" + b + "\".");
		}
	}

	private static void eq(int n, int[] a, int[] b) {
		if (a.length != b.length) {
			System.err.println("Case " + n + " failed: different lengths");
			print(received + "<" + a.length + "> ", a);
			print(expected + "<" + b.length + "> ", b);
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				System.err
						.println("Case " + n + " failed. " + received + " and "
								+ expected + " array differ in position " + i);
				print(received + " ", a);
				print(expected + " ", b);
				return;
			}
		}
		System.err.println("Case " + n + " passed.");
	}

	private static void eq(int n, long[] a, long[] b) {
		if (a.length != b.length) {
			System.err.println("Case " + n + " failed: different lengths");
			print(received + "<" + a.length + "> ", a);
			print(expected + "<" + b.length + "> ", b);
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				System.err
						.println("Case " + n + " failed. " + received + " and "
								+ expected + " array differ in position " + i);
				print(received, a);
				print(expected, b);
				return;
			}
		}
		System.err.println("Case " + n + " passed.");
	}

	private static void eq(int n, double[] a, double[] b) {
		if (a.length != b.length) {
			System.err.println("Case " + n + " failed: different lengths");
			print(received + "<" + a.length + "> ", a);
			print(expected + "<" + b.length + "> ", b);
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				System.err
						.println("Case " + n + " failed. " + received + " and "
								+ expected + " array differ in position " + i);
				print(received, a);
				print(expected, b);
				return;
			}
		}
		System.err.println("Case " + n + " passed.");
	}

	private static void eq(int n, String[] a, String[] b) {
		if (a.length != b.length) {
			System.err.println("Case " + n + " failed: different lengths");
			print(received + "<" + a.length + "> ", (Object[]) a);
			print(expected + "<" + b.length + "> ", (Object[]) b);
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (!a[i].equals(b[i])) {
				System.err
						.println("Case " + n + " failed. " + received + " and "
								+ expected + " array differ in position " + i);
				print(received, (Object[]) a);
				print(expected, (Object[]) b);
				return;
			}
		}
		System.err.println("Case " + n + " passed.");
	}

	static String expected = "  expe";
	static String received = "  rc";
	// END CUT HERE
}

// BEGIN CUT HERE

// END CUT HERE

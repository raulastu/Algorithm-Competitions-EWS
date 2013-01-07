package BinarySearch;

// BEGIN CUT HERE
// END CUT HERE
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class EnemyTowers {

	public int attack(int myUnits, int _hpT, int _attackT, int numWodT,
			int numStoT) {
		attackT = _attackT;
		hpT = _hpT;
		int lo = 1;
		int hi = myUnits;
		int m = Integer.MAX_VALUE;
		int g1 = Integer.MAX_VALUE, g2 = Integer.MAX_VALUE;
		System.err.println(nround(126, hpT * numWodT, numWodT, 0));
		System.err.println(nround(74, hpT * numStoT, numStoT, 0));
		while (lo < hi) {
			int mid = (lo + (hi - lo) / 2);
			g1 = nround(mid, hpT * numWodT, numWodT, 0);
			g2 = nround(myUnits - mid, hpT * numStoT, numStoT, 0);
			System.err.println(g1 + " " + g2 + " " + mid);
			if (g1 == Integer.MAX_VALUE && g2 == Integer.MAX_VALUE) {
				return -1;
			}
			m = min(m, max(g1, g2));
			if (g1 == Integer.MAX_VALUE) {
				lo = mid + 1;
			} else if (g2 == Integer.MAX_VALUE) {
				hi = mid;
			} else {
				if (g1 > g2) {
					lo = mid + 1;
				} else if (g1 < g2) {
					hi = mid;
				} else {
					break;
				}
			}
		}
		return m == Integer.MAX_VALUE ? -1 : m;
	}

	int attackT;
	int hpT;
	boolean i1 = false;
	boolean i2 = false;

	int nround(int g1, int hpTotal, int remT, int i) {
		if (hpTotal <= 0) {
			return i;
		}
		if (g1 <= 0) {
			return Integer.MAX_VALUE;
		}
		if (i1) {
			System.err.println(g1 + " hpTotal :" + hpTotal + " remT:" + remT
					+ " hpT:" + hpT);
		}

		hpTotal -= g1;
		remT = (int) ceil((hpTotal) / (double) hpT);
		g1 -= remT * attackT;
		return nround(g1, hpTotal, remT, ++i);
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		try {
			eq(0, (new EnemyTowers()).attack(7, 2, 1, 2, 3), 2);
			eq(1, (new EnemyTowers()).attack(120, 10, 40000, 6, 6), 1);
			eq(2, (new EnemyTowers()).attack(119, 10, 40000, 6, 6), -1);
			eq(3, (new EnemyTowers()).attack(200, 50, 3, 10, 5), 6);
			eq(3, (new EnemyTowers()).attack(1000000000, 40000, 40000, 449,
					40000), 7);

			// eq(3, (new EnemyTowers()).attack(1000000000, 40000, 40000, 40000,
			// 40000), 6);
		} catch (Exception exx) {
			System.err.println(exx);
			exx.printStackTrace(System.err);
		}
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

	private static void print(Object... rs) {
		print("", rs);
	}

	private static void print(String msg, Object... rs) {
		String x = deepToString(rs);
		if (x.indexOf("[[") == 0) {
			x = x.substring(1, x.length() - 1);
		}
		System.err.println(msg + " " + x);
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

	static String expected = "  expe";
	static String received = "  rChi";
	// END CUT HERE
}

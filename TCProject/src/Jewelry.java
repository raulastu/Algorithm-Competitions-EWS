import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class Jewelry {
	public long howMany(int[] values) {
		long res;
		this.values = values;

		return go(0, 0, 0, 0, Integer.MAX_VALUE,"","");
	}

	int[] values;
	String trace="";
	long go(int i, int a, int b, int maxa, int minb, String al, String bl) {
//		print(i, a, b, maxa, minb, al,bl);
		if (i == values.length){
			return 0;
		}
			
		long r = 0;
		if (a == b && maxa <= minb && a > 0) {
			print(i, a, b, maxa, minb, al,bl);
			print("xxx");
			r++;
		}
//		int nwa=values[i]+a;
//		int nwb=values[i]+b;

		long ax = go(i + 1, values[i] + a, b, max(maxa, values[i]), minb,al+"."+values[i],bl);
		long bx = go(i + 1, a, b + values[i], maxa, min(minb, values[i]),al,bl+"."+values[i]);
		long cx = go(i + 1, a, b, maxa, minb,al,bl);
		r += ax + bx + cx;
		// r=min(r,r);
		return r;
	}

	// BEGIN CUT HERE

	public static void main(String[] args) {
		try {
			eq(0, (new Jewelry()).howMany(new int[] { 1, 2, 5, 3, 4, 5 }), 9L);
			eq(1,
					(new Jewelry()).howMany(new int[] { 1000, 1000, 1000, 1000,
							1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
							1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
							1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
							1000, 1000 }), 18252025766940L);
			eq(2, (new Jewelry()).howMany(new int[] { 1, 2, 3, 4, 5 }), 4L);
			eq(3,
					(new Jewelry()).howMany(new int[] { 7, 7, 8, 9, 10, 11, 1,
							2, 2, 3, 4, 5, 6 }), 607L);
			eq(4,
					(new Jewelry()).howMany(new int[] { 123, 217, 661, 678,
							796, 964, 54, 111, 417, 526, 917, 923 }), 0L);
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

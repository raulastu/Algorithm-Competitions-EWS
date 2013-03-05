import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class EllysReversals {
	public int getMin(String[] words) {
		int res;
		boolean del[] = new boolean[words.length];
		boolean didsomething = true;
		while (didsomething) {
			didsomething = false;
			inner: 
			for (int i = 0; i < words.length; i++) {
				if (del[i])
					continue;
				for (int j = i + 1; j < words.length; j++) {
					if (del[j])
						continue;
					if (equal(words[i], words[j])) {
						del[i] = true;
						del[j] = true;
						pr(words[i], words[j]);
						continue inner;
					}
				}
			}
		}
		res = 0;
		for (int i = 0; i < del.length; i++) {
			if (!del[i])
				res++;
		}
		return res;
	}

	boolean equal(String wa, String wb) {
		char[] a = wa.toCharArray();
		char[] b = wb.toCharArray();
		// pr(a);
		// pr(b);
		sort(a);
		sort(b);
		if (a.length != b.length)
			return false;
		for (int k = 0; k < a.length; k++) {
			if (a[k] != b[k])
				return false;
		}
		if (a.length % 2 == 1)
			if (wa.charAt(a.length - 1) != wb.charAt(a.length - 1))
				return false;
		return true;
	}

	// BEGIN CUT HERE

	public static void main(String[] args) {
		try {
			eq(0,
					(new EllysReversals()).getMin(new String[] { "esprit",
							"god", "redotopc", "odcpoter", "dog" }), 3);
			eq(1,
					(new EllysReversals()).getMin(new String[] { "no",
							"zaphod", "just", "very", "improbable" }), 5);
			eq(2, (new EllysReversals()).getMin(new String[] { "rats", "live",
					"stressed", "to", "act", "as", "star", "desserts", "of",
					"evil", "cat", "sa", "fo", "ot" }), 0);
			eq(3, (new EllysReversals()).getMin(new String[] { "topcoder",
					"redocpot", "doretopc", "cpotdoer", "harlemshake" }), 1);
			eq(4,
					(new EllysReversals()).getMin(new String[] {
							"iprlzgukfggzg", "bmhxvjbrtkbxy", "khapjiabbny",
							"nqlwgmcyvdikt", "nxromtvtpug", "leealcapovm",
							"ushnxwjczczbmd", "bwhykzupcux", "xrlboyuwlnsp",
							"bbjoketeheezfs", "dxfztrldomjqkv",
							"dkbktqdtgfujcut", "zfybzyuxgpnt", "ffmsldrdftode",
							"vopuufksxd", "pqhbsiujwda", "yhwbkzupcux",
							"hkbabnapjiy", "zqsqefrrzehtxn", "yovinyguyudmv" }),
					16);
			eq(5,
					(new EllysReversals()).getMin(new String[] { "dxkhoxqw",
							"eawok", "ikpwzsixc", "eaowk", "jqovb",
							"wpszxiikc", "ajbzmph", "cybfeim", "wqxdhkox",
							"szixkipwc", "woaek", "imxeyymb", "japmbzh",
							"voqjb", "crdzf", "dmfyqq", "pxnmllys", "smzhomj",
							"lfeieb", "beflei", "fymdqq", "wqxohkdx", "zszxdo",
							"llyspxnm", "zeobgie", "mszhomj", "qjvob",
							"beiefl", "bmxeyyim", "yyimxemb", "dzrcf",
							"juxjvkxmb", "zxzsdo", "ycfbeim", "cyfbeim",
							"xzszod", "rqtgbrw", "dmyfqq", "mpajbzh",
							"omhzmsj", "brgtqrw", "jxkvmxjub", "bogizee",
							"ujjxxmvkb", "rczdf", "syllpxmn", "zeigobe" }), 15);
			eq(6,
					(new EllysReversals()).getMin(new String[] { "sripr",
							"rsrts", "trser", "step", "ipi", "trtri", "issis",
							"rss", "prtrt", "trr", "ispe", "sie", "ese",
							"retii", "ttes", "teesr", "trprr", "rir", "rier",
							"irti", "iepi", "tir", "esp", "iis", "sers",
							"ritrs", "tttr", "eppr", "pti", "prss", "epsi",
							"ppiss", "tese", "tirtr", "irsrp", "trss", "eets",
							"iesrs", "tsri", "sste", "pee", "pessi", "rreit",
							"pse", "ttti", "eet", "isrtt", "ttst", "rsrsi",
							"tsr" }), 48);

		} catch (Exception exx) {
			System.err.println(exx);
			exx.printStackTrace(System.err);
		}
	}

	private static void pr(Object... rs) {
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
			pr(received + "<" + a.length + "> ", a);
			pr(expected + "<" + b.length + "> ", b);
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				System.err
						.println("Case " + n + " failed. " + received + " and "
								+ expected + " array differ in position " + i);
				pr(received + " ", a);
				pr(expected + " ", b);
				return;
			}
		}
		System.err.println("Case " + n + " passed.");
	}

	private static void eq(int n, long[] a, long[] b) {
		if (a.length != b.length) {
			System.err.println("Case " + n + " failed: different lengths");
			pr(received + "<" + a.length + "> ", a);
			pr(expected + "<" + b.length + "> ", b);
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				System.err
						.println("Case " + n + " failed. " + received + " and "
								+ expected + " array differ in position " + i);
				pr(received, a);
				pr(expected, b);
				return;
			}
		}
		System.err.println("Case " + n + " passed.");
	}

	private static void eq(int n, double[] a, double[] b) {
		if (a.length != b.length) {
			System.err.println("Case " + n + " failed: different lengths");
			pr(received + "<" + a.length + "> ", a);
			pr(expected + "<" + b.length + "> ", b);
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				System.err
						.println("Case " + n + " failed. " + received + " and "
								+ expected + " array differ in position " + i);
				pr(received, a);
				pr(expected, b);
				return;
			}
		}
		System.err.println("Case " + n + " passed.");
	}

	private static void eq(int n, String[] a, String[] b) {
		if (a.length != b.length) {
			System.err.println("Case " + n + " failed: different lengths");
			pr(received + "<" + a.length + "> ", (Object[]) a);
			pr(expected + "<" + b.length + "> ", (Object[]) b);
			return;
		}
		for (int i = 0; i < a.length; i++) {
			if (!a[i].equals(b[i])) {
				System.err
						.println("Case " + n + " failed. " + received + " and "
								+ expected + " array differ in position " + i);
				pr(received, (Object[]) a);
				pr(expected, (Object[]) b);
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

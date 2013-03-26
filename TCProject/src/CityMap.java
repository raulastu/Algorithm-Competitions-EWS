import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class CityMap {
	public String getLegend(String[] cityMap, int[] POIs) {
		String res = "";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int j = 0; j < cityMap.length; j++) {
			for (int j2 = 0; j2 < cityMap[j].length(); j2++) {
				char c = cityMap[j].charAt(j2);
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}
		}
		pr(map);
		for (int i = 0; i < POIs.length; i++) {
			for (Character s : map.keySet()) {
				if(map.get(s)==POIs[i]){
					res+=s;
					break;
				}
			}
		}
		return res;
	}

	// BEGIN CUT HERE

	public static void main(String[] args) {
		try {
			eq(0,
					(new CityMap()).getLegend(new String[] { "M....M",
							"...R.M", "R..R.R" }, new int[] { 3, 4 }), "MR");
			eq(1, (new CityMap()).getLegend(new String[] { "XXXXXXXZXYYY" },
					new int[] { 1, 8, 3 }), "ZXY");
			eq(2, (new CityMap()).getLegend(new String[] { "...........",
					"...........", "...........", "..........T" },
					new int[] { 1 }), "T");
			eq(3, (new CityMap()).getLegend(new String[] {
					"AIAAARRI.......GOAI.", ".O..AIIGI.OAAAGI.A.I",
					".A.IAAAARI..AI.AAGR.", "....IAI..AOIGA.GAIA.",
					"I.AIIIAG...GAR.IIAGA", "IA.AOA....I....I.GAA",
					"IOIGRAAAO.AI.AA.RAAA", "AI.AAA.AIR.AGRIAAG..",
					"AAAAIAAAI...AAG.RGRA", ".J.IA...G.A.AA.II.AA" },
					new int[] { 16, 7, 1, 35, 11, 66 }), "GOJIRA");
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

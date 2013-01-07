package _Archive;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class KingSort {

	public String[] getSortedList(String[] kings) {
		sort(kings, new cmp());
		return kings;
	}

	class cmp implements Comparator<String> {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		public cmp() {
			String[] romans = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L"};
//			System.err.println(romans.length);
			for (int i = 0; i < romans.length; i++) {
				map.put(romans[i], i + 1);
			}
		}

		public int compare(String o1, String o2) {
			String nameO1 = o1.split(" ")[0];
			String nameO2 = o2.split(" ")[0];
			String roman1s = o1.split(" ")[1];
			String roman2s = o2.split(" ")[1];
//			System.err.println(roman1s+" "+roman2s);
			int roman1 = map.get(roman1s);
			int roman2 = map.get(roman2s);
			
			if (nameO1.equals(nameO2)) {
				// return 0;
				return roman1 - roman2;
			}
			return o1.compareTo(o2);
		}

	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		try {
			eq(0,
					(new KingSort()).getSortedList(new String[] { "Louis IX",
							"Louis VIII" }), new String[] { "Louis VIII",
							"Louis IX" });
			eq(1,
					(new KingSort()).getSortedList(new String[] { "Louis IX",
							"Philippe II" }), new String[] { "Louis IX",
							"Philippe II" });
			eq(2,
					(new KingSort()).getSortedList(new String[] {
							"Richard III", "Richard I", "Richard II" }),
					new String[] { "Richard I", "Richard II", "Richard III" });
			eq(3,
					(new KingSort()).getSortedList(new String[] { "John X",
							"John I", "John L", "John V" }), new String[] {
							"John I", "John V", "John X", "John L" });
			eq(4,
					(new KingSort()).getSortedList(new String[] {
							"Philippe VI", "Jean II", "Charles V",
							"Charles VI", "Charles VII", "Louis XI" }),
					new String[] { "Charles V", "Charles VI", "Charles VII",
							"Jean II", "Louis XI", "Philippe VI" });
			eq(5,
					(new KingSort()).getSortedList(new String[] {
							"Philippe II", "Philip II" }), new String[] {
							"Philip II", "Philippe II" });
			eq(5,
					(new KingSort()).getSortedList(new String[] {"Henry XXXVII", "Henry VII", "Henry X", "Henry XXVI", "Henry IV", "Henry VIII", "Henry XXXIII", "Henry IX", "Henry XLVIII", "Henry XLII", "Henry XLI", "Henry XLIII", "Henry XXXV", "Henry XIV", "Henry XLIV", "Henry XXV", "Henry XXIV", "Henry III", "Henry XXI", "Henry XX", "Henry XXVII", "Henry XXXVIII", "Henry XXX", "Henry XXXIX", "Henry XXIII", "Henry L", "Henry XXII", "Henry I", "Henry II", "Henry XIX", "Henry XXVIII", "Henry XXIX", "Henry XLVI", "Henry V", "Henry XXXIV", "Henry XLIX", "Henry XII", "Henry XL", "Henry XVII", "Henry XV", "Henry XI", "Henry VI", "Henry XXXI", "Henry XVI", "Henry XXXVI", "Henry XXXII", "Henry XIII", "Henry XLVII", "Henry XLV", "Henry XVIII"}), 
					new String[] {
							"Philip II", "Philippe II" });

				
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
		System.err.println(Arrays.deepToString(rs));
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

package _Archive;

// BEGIN CUT HERE
// END CUT HERE
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class FindingSquareInTable {

    public int findMaximalSquare(String[] table) {
        long res = -1;
        HashSet<Long> set = new HashSet<Long>();
        for (long i = 0; i < 100000; i++) {
            set.add(i * i);
            if (i * i == 542352377) {
                System.err.println(i);
            }
        }
//        System.err.println(set.contains(542352377L));
        int max = max(table.length, table[0].length());
        for (int k = 1; k <= max; k++) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[0].length(); j++) {
//                    if (j == 0 && i == 0) {
//                        continue;
//                    }
                    for (int ii = 0; ii < table.length; ii++) {
                        for (int jj = 0; jj < table[0].length(); jj++) {
                            String s = "";
                            for (int m = ii, n = jj; s.length() < k && m < table.length &&
                                    n < table[0].length(); m += i, n += j) {
                                s += table[m].charAt(n);
                            }
                            res = res(s, set, res);
                            s = "";
                            for (int m = ii, n = jj; s.length() < k && m < table.length &&
                                    n >= 0; m += i, n += -j) {
                                s += table[m].charAt(n);//
                            }
                            res = res(s, set, res);
                        }
                    }
                }
            }
        }
        return (int) res;
    }

    long res(String s, Set set, long res) {
        if (s.equals("")) {
            return res;
        }
        long x = Long.parseLong(new StringBuffer(s).reverse() + "");
        long x1 = Long.parseLong(s);
        if (set.contains(x1)) {
            res = max(res, Integer.parseInt(s));
        }
        if (set.contains(x)) {
            res = max(res, x);
        }
        return res;
    }
// BEGIN CUT HERE

    public static void main(String[] args) {
        try {
            eq(0, (new FindingSquareInTable()).findMaximalSquare(new String[]{"123",
                        "456"}), 64);
            eq(1, (new FindingSquareInTable()).findMaximalSquare(new String[]{"00000",
                        "00000",
                        "00200",
                        "00000",
                        "00000"}), 0);
            eq(2, (new FindingSquareInTable()).findMaximalSquare(new String[]{"3791178",
                        "1283252",
                        "4103617",
                        "8233494",
                        "8725572",
                        "2937261"}), 320356);
            eq(3, (new FindingSquareInTable()).findMaximalSquare(new String[]{"135791357",
                        "357913579",
                        "579135791",
                        "791357913",
                        "913579135"}), 9);
            eq(4, (new FindingSquareInTable()).findMaximalSquare(new String[]{"553333733",
                        "775337775",
                        "777537775",
                        "777357333",
                        "755553557",
                        "355533335",
                        "373773573",
                        "337373777",
                        "775557777"}), -1);
            eq(5, (new FindingSquareInTable()).findMaximalSquare(new String[]{"257240281",
                        "197510846",
                        "014345401",
                        "035562575",
                        "974935632",
                        "865865933",
                        "684684987",
                        "768934659",
                        "287493867"}), 95481);
            eq(5, (new FindingSquareInTable()).findMaximalSquare(new String[]{"0"}), 0);
            eq(5, (new FindingSquareInTable()).findMaximalSquare(new String[]{"542352377"}), 324);
        } catch (Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

    private static void eq(int n, int a, int b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " " + a + " " + expected + " " + b + ".");
        }
    }

    private static void eq(int n, double a, double b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " '" + a + "' " + expected + " '" + b + "'.");
        }
    }

    private static void eq(int n, char a, char b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " '" + a + "' " + expected + " '" + b + "'.");
        }
    }

    private static void eq(int n, long a, long b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " '" + a + "L' " + expected + " '" + b + "L'.");
        }
    }

    private static void eq(int n, boolean a, boolean b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " '" + a + "' " + expected + " '" + b + "'.");
        }
    }

    private static void eq(int n, String a, String b) {
        if (a != null && a.equals(b)) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " \"" + a + "\" " + expected + " \"" + b + "\".");
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
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
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
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
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
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
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
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                print(received, (Object[]) a);
                print(expected, (Object[]) b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void print(String msg, Object... rs) {
        String x = deepToString(rs);
        if (x.indexOf("[[") == 0) {
            x = x.substring(1, x.length() - 1);
        }
        System.err.println(msg + " " + x);
    }
    static String expected = "  expe";
    static String received = "  rChi";
// END CUT HERE
}

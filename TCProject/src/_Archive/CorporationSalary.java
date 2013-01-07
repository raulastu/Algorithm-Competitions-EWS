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

public class CorporationSalary {

    public long totalSalary(String[] relations) {
        long res = 0;
        HashMap<Integer, Long> memo = new HashMap<Integer, Long>();
        for (int i = 0; i < relations.length; i++) {
            if (!relations[i].contains("Y")) {
                memo.put(i, 1L);
            }
        }
        for (int i = 0; i < relations.length; i++) {
            res += salary(relations, memo, i);
        }
        return res;
    }

    long salary(String[] rel, Map<Integer, Long> memo, int i) {
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        long s = 0;
        for (int j = 0; j < rel[i].length(); j++) {
            if (rel[i].charAt(j) == 'Y') {
                s += salary(rel, memo, j);
            }
        }
        memo.put(i, s);
        return s;
    }


// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new CorporationSalary()).totalSalary(new String[]{"N"}), 1L);
            eq(1, (new CorporationSalary()).totalSalary(new String[]{"NNYN",
                        "NNYN",
                        "NNNN",
                        "NYYN"}), 5L);
            eq(2, (new CorporationSalary()).totalSalary(new String[]{"NNNNNN",
                        "YNYNNY",
                        "YNNNNY",
                        "NNNNNN",
                        "YNYNNN",
                        "YNNYNN"}), 17L);
            eq(3, (new CorporationSalary()).totalSalary(new String[]{"NYNNYN",
                        "NNNNNN",
                        "NNNNNN",
                        "NNYNNN",
                        "NNNNNN",
                        "NNNYYN"}), 8L);
            eq(4, (new CorporationSalary()).totalSalary(new String[]{"NNNN",
                        "NNNN",
                        "NNNN",
                        "NNNN"}), 4L);
            eq(4, (new CorporationSalary()).totalSalary(new String[]{"NYYNNNNNNYYNNNYYNYNYNNYYNYYYYNNYYYNYNNYYN", "NNYNNNNNNYYNNNYNNNNYNNNNNYYYNNNYYNNNNNYNN", "NNNNNNNNNNYNNNNNNNNNNNNNNNNYNNNNNNNNNNNNN", "YYYNNNNYNYYNNNYYNYNYNYYYNYYYYNNYYYNYYNYYN", "YYYYNYNYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYNYYY", "YYYYNNNYNYYNNNYYNYNYNYYYNYYYYYYYYYNYYNYYN", "YYYNYNNYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYNYYY", "YYYNNNNNNYYNNNYYNYNYNNYYNYYYYNNYYYNYNNYYN", "YYYYNYNYNYYYNYYYYYYYNYYYYYYYYYYYYYYYYNYYY", "NNYNNNNNNNYNNNYNNNNYNNNNNYNYNNNNNNNNNNYNN", "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN", "YYYYNNNYNYYNNNYYYYNYNYYYYYYYYYYYYYYYYNYYN", "YYYYNYNYYYYYNYNYYYYYNYYYYYYYYYYYYYYYYNYYY", "YYYYNYNYNYYYNNYYYYYYNYYYYYYYYYYYYYYYYNYYN", "NNYNNNNNNNYNNNNNNNNYNNNNNYNYNNNNNNNNNNYNN", "NYYNNNNNNYYNNNYNNNNYNNYNNYYYNNNYYYNNNNYYN", "YYYYNYNYNYYNNNYYNYNYNYYYNYYYYYYYYYNYYNYYN", "NYYNNNNNNYYNNNYYNNNYNNYYNYYYYNNYYYNYNNYYN", "YYYYNYNYNYYYNNYYYYNYNYYYYYYYYYYYYYYYYNYYN", "NNYNNNNNNNYNNNNNNNNNNNNNNYNYNNNNNNNNNNYNN", "YYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYYYYYYNYNN", "YYYNNNNYNYYNNNYYNYNYNNYYNYYYYNNYYYNYYNYYN", "NYYNNNNNNYYNNNYNNNNYNNNNNYNYNNNYYYNNNNYYN", "NYNNNNNNNYYNNNYYNNNYNNYNNYYYNNNYYYNNNNYYN", "YYYYNYNYNYYNNNYYYYNYNYYYNYYYYYYYYYYYYNYYN", "NNYNNNNNNNYNNNNNNNNNNNNNNNNYNNNNNNNNNNYNN", "NNYNNNNNNYYNNNYNNNNYNNNNNYNYNNNNYNNNNNYNN", "NNNNNNNNNNYNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN", "NYYNNNNNNYYNNNYYNNNYNNYYNYNYNNNYYYNNNNYYN", "YYYYNNNYNYYNNNYYNYNYNYYYNYYYYNNYYYNYYNYYN", "YYYYNNNYNYYNNNYYNYNYNYYYNYYYYYNYYYNYYNYYN", "NNYNNNNNNYYNNNYNNNNYNNNNNYYYNNNNYNNNNNYNN", "NNYNNNNNNYYNNNYNNNNYNNNNNYNYNNNNNNNNNNYNN", "NYYNNNNNNYYNNNYNNNNYNNNNNYYYNNNYNNNNNNYYN", "YYYYNYNYNYYNNNYYYYNYNYYYNYYYYYYYYYNYYNYYN", "NYYNNNNNNYYNNNYYNNNYNNYYNYYYYNNYYYNNNNYYN", "YYYNNNNYNYYNNNYYNYNYNNYYNYYYYNNYYYNYNNYYN", "YYYYYYYYYYYYYYYYYYYYYYYYYNYYYYYYYYYYYNYYY", "NNYNNNNNNNYNNNNNNNNNNNNNNNNYNNNNNNNNNNNNN", "NYYNNNNNNYYNNNYNNNNYNNNNNYYYNNNYYNNNNNYNN", "YYYYNYNYNYYYNYYYYYYYNYYYYYYYYYYYYYYYYNYYN"}), 1013371163128L);
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

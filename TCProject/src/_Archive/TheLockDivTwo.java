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

public class TheLockDivTwo {

    public String password(int n, int k) {
        String res;
        char[][] c = new char[k][n];
        for (int i = 0; i < c[0].length; i++) {
            c[0][i] = '0';
        }
        HashSet<String> set = new HashSet<String>();
        set.add(new String(c[0]));
//        System.out.println(set);

        for (int i = 1; i < c.length; i++) {
            boolean found = false;
            for (int j = 0; j < c[0].length; j++) {
                char[] t = new char[c[0].length];
                for (int l = 0; l < c[0].length; l++) {
                    t[l] = c[i - 1][l];
                }
//                print("", t);
                if (c[i - 1][c[0].length - 1 - j] == '1') {
                    c[i - 1][c[0].length - 1 - j] = '0';
                    if (!set.contains(new String(c[i - 1]))) {
                        for (int l = 0; l < c[i].length; l++) {
                            c[i][l] = c[i - 1][l];
                        }
                        set.add(new String(c[i]));
//                        System.err.println(new String(c[i]));
                        found = true;
                        c[i - 1] = t;
                        break;
                    }
                }
                c[i - 1] = t;
            }
            if (!found) {
                for (int j = 0; j < c[0].length; j++) {
                    char[] t = new char[c[0].length];
                    for (int l = 0; l < c[0].length; l++) {
                        t[l] = c[i-1][l];
                    }
                    if (c[i - 1][c[0].length - 1 - j] == '0') {
                        c[i - 1][c[0].length - 1 - j] = '1';
                        if (!set.contains(new String(c[i - 1]))) {
                            for (int l = 0; l < c[i].length; l++) {
                                c[i][l] = c[i - 1][l];
                            }
                            set.add(new String(c[i]));
//                            System.err.println(new String(c[i]));
                            c[i - 1] = t;
                            break;
                        }
                    }
                    c[i - 1] = t;
                }
            }

        }
        print("", c);
//        print("", a);
        return new String(c[k - 1]);
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new TheLockDivTwo()).password(2, 4), "10");
            eq(1, (new TheLockDivTwo()).password(4, 6), "0100");
            eq(2, (new TheLockDivTwo()).password(10, 1), "0000000000");
            eq(3, (new TheLockDivTwo()).password(7, 100), "1100001");
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

package DP;

// BEGIN CUT HERE
// END CUT HERE
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class MatrixChainMultiplication {

    public String parenthesize(int[] a) {
        System.err.println(go(3));
        return go(5)+"";
    }

    int go(int n) {
        if (n == 1) {
            return 1;
        }
        int res = 0;
        for (int k = 1; k <= n - 1; k++) {
            res += go(k) + go(n - k);
        }
        return res;
    }

    public int multiply(int[][] A, int B[][]) {
        if (A[0].length != B.length) {
            System.err.println("Incompatible dimesions");
            return -1;
        } else {
            int[][] c = new int[A.length][B[0].length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    int xx = 0;
                    for (int k = 0; k < A[i].length; k++) {
                        xx = xx + A[i][k] * B[k][j];
                    }
                    c[i][j] = xx;
                }
            }
            print(c);
            return c[0][0];
        }
    }

    // BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new MatrixChainMultiplication()).parenthesize(new int[]{1, 2, 3,}),
                    "()()()");
            eq(0, (new MatrixChainMultiplication()).multiply(
                    new int[][]{
                        {7, 9, 3, 3},
                        {8, 5, 6, 4},
                        {8, 5, 6, 5}},
                    new int[][]{
                        {7, 9, 3, 4, 1},
                        {8, 5, 6, 4, 3},
                        {8, 5, 6, 4, 4},
                        {8, 5, 6, 4, 1}}),
                    1);
            eq(0, (new MatrixChainMultiplication()).multiply(
                    new int[][]{
                        {7, 9, 3, 3, 7, 9, 3, 3, 3, 3},
                        {8, 5, 6, 4, 7, 9, 3, 3, 3, 3},
                        {8, 5, 6, 5, 7, 9, 3, 3, 3, 3},
                        {7, 9, 3, 3, 7, 9, 3, 3, 3, 3},
                        {8, 5, 6, 4, 7, 9, 3, 3, 3, 3},
                        {8, 5, 6, 5, 7, 9, 3, 3, 3, 3},
                        {7, 9, 3, 3, 7, 9, 3, 3, 3, 3},
                        {8, 5, 6, 4, 7, 9, 3, 3, 3, 3},
                        {8, 5, 6, 5, 7, 9, 3, 3, 3, 3},
                        {7, 9, 3, 3, 7, 9, 3, 3, 3, 3},
                        {7, 9, 3, 3, 7, 9, 3, 3, 3, 3},
                        {8, 5, 6, 4, 7, 9, 3, 3, 3, 3},
                        {8, 5, 6, 5, 7, 9, 3, 3, 3, 3},
                        {7, 9, 3, 3, 7, 9, 3, 3, 3, 3},
                        {8, 5, 6, 4, 7, 9, 3, 3, 3, 3},
                        {8, 5, 6, 5, 7, 9, 3, 3, 3, 3},
                        {7, 9, 3, 3, 7, 9, 3, 3, 3, 3},
                        {8, 5, 6, 4, 7, 9, 3, 3, 3, 3},
                        {8, 5, 6, 5, 7, 9, 3, 3, 3, 3},
                        {7, 9, 3, 3, 7, 9, 3, 3, 3, 3},
                        {8, 5, 6, 4, 7, 9, 3, 3, 3, 3}},
                    new int[][]{
                        {7, 9, 3, 4, 1, 7, 9, 3, 4, 1},
                        {8, 5, 6, 4, 3, 7, 9, 3, 4, 1},
                        {8, 5, 6, 4, 4, 7, 9, 3, 4, 1},
                        {8, 5, 6, 4, 1, 7, 9, 3, 4, 1},
                        {8, 5, 6, 4, 1, 7, 9, 3, 4, 1},
                        {8, 5, 6, 4, 1, 7, 9, 3, 4, 1},
                        {8, 5, 6, 4, 1, 7, 9, 3, 4, 1},
                        {8, 5, 6, 4, 1, 7, 9, 3, 4, 1},
                        {8, 5, 6, 4, 1, 7, 9, 3, 4, 1},
                        {8, 5, 6, 4, 1, 7, 9, 3, 4, 1}}),
                    1);

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


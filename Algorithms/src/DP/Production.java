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

public class Production {

    int[] costs1;
    int[] costs2;
    int[] changes12;
    int[] changes21;
    int e1, e2;
    ArrayList<Integer> al1 = new ArrayList<Integer>();
    ArrayList<Integer> al2 = new ArrayList<Integer>();
    int track[][];

    public int recursiveForm(int[] costs1, int[] costs2, int[] changes12, int[] changes21,
            int e1, int e2, int x1, int x2) {
        this.costs1 = costs1;
        this.costs2 = costs2;
        this.changes12 = changes12;
        this.changes21 = changes21;
        this.e1 = e1;
        this.e2 = e2;
        track = new int[3][costs1.length];
        int n = costs1.length;
        int s1 = x1 + f(1, n - 1);
        int s2 = x2 + f(2, n - 1);
        print(track);
        String res = "";
        int i = track[1].length - 1;
        int x = (s1 < s2) ? 1 : 2;
        while (i >= 0) {
            res = x + " " + res;
            x = track[x][i--];
        }
        System.err.println(res);
        return min(s1, s2);
    }

    public int fastestWay(int[] costs1, int[] costs2, int[] changes12, int[] changes21,
            int e1, int e2, int x1, int x2) {
        track = new int[3][costs1.length];
        int[][] dp = new int[3][costs1.length];
        dp[1][0] = e1 + costs1[0];
        dp[2][0] = e2 + costs2[0];
        for (int i = 1; i < costs1.length; i++) {
            int s1 = costs1[i] + dp[1][i - 1];
            int s2 = costs1[i] + changes21[i - 1] + dp[2][i - 1];
            if (s1 < s2) {
                track[1][i] = 1;
            } else {
                track[1][i] = 2;
            }

            dp[1][i] = min(s1, s2);
            int ss1 = costs2[i] + dp[2][i - 1];
            int ss2 = costs2[i] + changes12[i - 1] + dp[1][i - 1];
            if (ss1 < ss2) {
                track[2][i] = 2;
            } else {
                track[2][i] = 1;
            }
            dp[2][i] = min(ss1, ss2);
        }
        print(dp);
        print(track);

        dp[1][dp[1].length - 1] += x1;
        dp[2][dp[2].length - 1] += x2;
        int s = dp[1][dp[1].length - 1];
        int s2 = dp[2][dp[2].length - 1];
        printWay(s, s2, track);
        return min(s, s2);
    }

    void printWay(int s1, int s2, int track[][]) {
        String res = "";
        int i = track[1].length - 1;
        int x = (s1 < s2) ? 1 : 2;
        while (i >= 0) {
            res = "line " + x + ", station " + (i + 1) + "\n" + res;
            x = track[x][i--];
        }
        System.err.println(res);
    }
    int l = -1;

    int f(int line, int i) {
        if (i == 0) {
            if (line == 1) {
                return e1 + costs1[0];
            } else {
                return e2 + costs2[0];
            }
        }
        if (line == 1) {
            int s1 = costs1[i] + f(1, i - 1);
            int s2 = costs1[i] + changes21[i - 1] + f(2, i - 1);
//            al1.add(min(s1, s2));
            if (s1 < s2) {
                track[line][i] = 1;
            } else {
                track[line][i] = 2;
            }
            return min(s1, s2);
        } else {
            int s2 = costs2[i] + f(2, i - 1);
            int s1 = costs2[i] + changes12[i - 1] + f(1, i - 1);
            if (s1 < s2) {
                track[line][i] = 1;
            } else {
                track[line][i] = 2;
            }
            return min(s1, s2);
        }
    }


// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new Production()).recursiveForm(
                    new int[]{7, 9, 3, 4, 8, 4},
                    new int[]{8, 5, 6, 4, 5, 7},
                    new int[]{2, 3, 1, 3, 4},
                    new int[]{2, 1, 2, 2, 1},
                    2, 4, 3, 2), 38);
            eq(0, (new Production()).fastestWay(
                    new int[]{7, 9, 3, 4, 8, 4},
                    new int[]{8, 5, 6, 4, 5, 7},
                    new int[]{2, 3, 1, 3, 4},
                    new int[]{2, 1, 2, 2, 1},
                    2, 4, 3, 2), 38);
//            eq(0, (new Production()).recursiveForm(
//                    new int[]{7, 9, 3, 4, 8, 4, 7, 9, 3, 4, 8, 4, 7, 9, 3, 4, 8, 4, 7, 9, 1, 4, 4, 7, 9, 1, 4},
//                    new int[]{8, 5, 6, 4, 5, 7, 7, 9, 3, 4, 8, 4, 7, 9, 3, 4, 8, 4, 7, 9, 2, 3, 4, 7, 9, 1, 4},
//                    new int[]{2, 3, 1, 3, 4, 2, 3, 1, 3, 4, 2, 3, 1, 3, 4, 2, 3, 1, 3, 3, 12, 4, 7, 9, 1, 4},
//                    new int[]{2, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 2, 3, 3, 4, 7, 9, 1, 4},
//                    2, 4, 3, 2), 154);
            eq(0, (new Production()).fastestWay(
                    new int[]{7, 9, 3, 4, 8, 4, 7, 9, 3, 4, 8, 4, 7, 9, 3, 4, 8, 4, 7, 9, 1, 4, 4, 7, 9, 1, 4},
                    new int[]{8, 5, 6, 4, 5, 7, 7, 9, 3, 4, 8, 4, 7, 9, 3, 4, 8, 4, 7, 9, 2, 3, 4, 7, 9, 1, 4},
                    new int[]{2, 3, 1, 3, 4, 2, 3, 1, 3, 4, 2, 3, 1, 3, 4, 2, 3, 1, 3, 3, 12, 4, 7, 9, 1, 4},
                    new int[]{2, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 2, 3, 3, 4, 7, 9, 1, 4},
                    2, 4, 3, 2), 154);
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


package _Archive;

// BEGIN CUT HERE
// END CUT HERE
import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class WindowManager {

    public String[] screen(int height, int width, String[] windows) {
//        String[] res;
        char[][] dis = new char[100][100];
        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis[0].length; j++) {
                dis[i][j] = ' ';
            }
        }
        for (int i = 0; i < windows.length; i++) {
            String[] vals = windows[i].split(" ");
            int a = Integer.parseInt(vals[0]);
            int b = Integer.parseInt(vals[1]);
            int vsz = Integer.parseInt(vals[2]);
            int hsz = Integer.parseInt(vals[3]);
            char sign = vals[4].toCharArray()[0];
            Pair[] points = getpoints(a, b, vsz, hsz, sign);
//            print("", points);
            for (Pair pair : points) {
                dis[pair.x][pair.y] = pair.sign;
            }

        }
//        print("", dis);
        char[][] res1 = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res1[i][j] = dis[i][j];

            }
        }
        String[] res = new String[height];
        for (int i = 0; i < res1.length; i++) {
            res[i] = new String(res1[i]);
        }
        return res;
    }

    Pair[] getpoints(int tlv, int tlh, int v, int h, char sign) {
        ArrayList<Pair> res = new ArrayList<Pair>();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i >= tlv && i < tlv + v && j >= tlh && j < tlh + h) {
                    if ((i == tlv && j == tlh) || (i == tlv && j == tlh + h - 1) ||
                            (i == tlv + v - 1 && j == tlh) || (i == tlv + v - 1 && j == tlh + h - 1)) {
                        res.add(new Pair(i, j, '+'));
                    } else if (i == tlv || i == tlv + v - 1) {
                        res.add(new Pair(i, j, '-'));
                    } else if (j == tlh + h - 1 || j == tlh) {
                        res.add(new Pair(i, j, '|'));
                    } else {
                        res.add(new Pair(i, j, sign));
                    }
                }
            }
        }

        return res.toArray(new Pair[0]);
    }

    class Pair {

        int x, y;
        char sign;

        @Override
        public String toString() {
            return x + " " + y + " " + sign;
        }

        public Pair(int x, int y, char sign) {
            this.x = x;
            this.y = y;
            this.sign = sign;
        }
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new WindowManager()).screen(4, 6, new String[]{"-5 -5 20 20 O", "0 0 2 2 Y", "0 0 4 6 X"}), new String[]{"+----+", "|XXXX|", "|XXXX|", "+----+"});
            eq(1, (new WindowManager()).screen(7, 7, new String[]{"-5 -5 20 12 9", "2 2 15 15 @", "2 2 3 3 *"}), new String[]{"999999|", "999999|", "99+-+--", "99|*|@@", "99+-+@@", "99|@@@@", "99|@@@@"});
            eq(2, (new WindowManager()).screen(1, 1, new String[]{"-20000 -20000 5 5 X"}), new String[]{" "});
            eq(3, (new WindowManager()).screen(5, 5, new String[]{"-1000000 -1000000 2000000 2000000 L"}), new String[]{"LLLLL", "LLLLL", "LLLLL", "LLLLL", "LLLLL"});
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

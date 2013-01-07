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

public class MineField {

    public String[] getMineField(String mineLocations) {
        String[] res;
        char[][] mi = new char[9][9];
        for (int i = 0; i < mi.length; i++) {
            Arrays.fill(mi[i], '0');
        }
        Pattern pat = Pattern.compile("[0-8],[0-8]");
        Matcher mat = pat.matcher(mineLocations);
//        print("", mi);
        while (mat.find()) {
            String[] s = mat.group().split(",");
//            System.err.println(mat.group());
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            mi[a][b] = 'M';
        }
//        print("", mi);
        int[] di = {-1, 1, 0, 0, +1, -1, -1, +1};
        int[] dj = {0, 0, -1, 1, +1, +1, -1, -1};

        for (int i = 0; i < mi.length; i++) {
            for (int j = 0; j < mi.length; j++) {
                int x = 0;
                if (mi[i][j] != 'M') {
                    for (int k = 0; k < di.length; k++) {
                        int X = i + di[k];
                        int Y = j + dj[k];
                        x += getC(X, Y, mi);
                    }
                    mi[i][j] = (char) ('0' + x);
                }
            }
        }
        res = new String[9];
        for (int i = 0; i < res.length; i++) {
            res[i] = new String(mi[i]);
        }
        return res;
    }

    int getC(int x, int y, char[][] min) {
        if (x >= 0 && x < 9 && y >= 0 && y < 9 && min[x][y] == 'M') {
            return 1;
        }
        return 0;
    }
// BEGIN CUT HERE

    public static void main(String[] args) {
        try {
            eq(0, (new MineField()).getMineField("(0,0)(1,0)(2,0)(3,0)(4,0)"), new String[]{"M20000000", "M30000000", "M30000000", "M30000000", "M20000000", "110000000", "000000000", "000000000", "000000000"});
            eq(1, (new MineField()).getMineField("(0,0)(0,8)(8,0)(8,8)"), new String[]{"M1000001M", "110000011", "000000000", "000000000", "000000000", "000000000", "000000000", "110000011", "M1000001M"});
            eq(2, (new MineField()).getMineField("(3,2)(3,3)(3,4)(4,2)(4,4)(5,2)(5,3)(5,4)(7,4)(6,7)"), new String[]{"000000000", "000000000", "012321000", "02MMM2000", "03M8M3000", "02MMM2111", "0124321M1", "0001M1111", "000111000"});
            eq(3, (new MineField()).getMineField(""), new String[]{"000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000", "000000000"});
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

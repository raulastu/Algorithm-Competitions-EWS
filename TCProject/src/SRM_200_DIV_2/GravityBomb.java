package SRM_200_DIV_2;

// BEGIN CUT HERE
// END CUT HERE
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class GravityBomb {

    public String[] aftermath(String[] board) {
        String[] res;
        char[][] b = new char[board.length][board[0].length()];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = board[i].charAt(j);
            }
        }
        for (int j = 0; j < b[0].length; j++) {
            for (int i = 0; i < b.length; i++) {
                for (int k = i + 1; k < b.length; k++) {
                    if (b[i][j] == 'X' && b[k][j] == '.') {
                        b[i][j] = '.';
                        b[k][j] = 'X';
                    }
                }
            }
        }

        boolean destroy = true;
//        print("", b);
        while (destroy) {
//            print("", b);
            destroy = true;
            for (int j = 0; j < b[b.length - 1].length; j++) {
                if (b[b.length - 1][j] == '.') {
                    destroy = false;
                }
            }
            if (destroy) {
                for (int i = b.length - 1; i > 0; i--) {
                    for (int j = 0; j < b[i].length; j++) {
                        b[i][j] = b[i - 1][j];
                    }
                }
                for (int j = 0; j < b[0].length; j++) {
                    b[0][j] = '.';
                }
            }
        }

        for (int i = 0; i < b.length; i++) {
            board[i] = new String(b[i]);
        }
        return board;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new GravityBomb()).aftermath(new String[]{"..X",
                        "X.X",
                        ".X."}), new String[]{"...", "...", "..X"});
            eq(1, (new GravityBomb()).aftermath(new String[]{"...",
                        "X..",
                        ".X."}), new String[]{"...", "...", "XX."});
            eq(2, (new GravityBomb()).aftermath(new String[]{"XXXXXX",
                        "......",
                        "......"}), new String[]{"......", "......", "......"});
            eq(3, (new GravityBomb()).aftermath(new String[]{"XX.XX....XX"}), new String[]{"XX.XX....XX"});
            eq(4, (new GravityBomb()).aftermath(new String[]{"X", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".",
                        ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".",
                        ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".",
                        ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."}), new String[]{".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."});
            eq(5, (new GravityBomb()).aftermath(new String[]{"XXX", "XXX"}), new String[]{"...", "..."});
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

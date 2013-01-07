package TCHS_SRM_41_DIV1;

// BEGIN CUT HERE
// END CUT HERE
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class TrianglesBoard {

    public int maxScore(String[] board) {
        int res = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                memo = new boolean[board.length][2 * board.length - 1];
                int x = removal(board, i, j);
//                System.err.println(i + " " + j + " " + x);
                res = max(x, res);
            }
        }
        return res;
    }
    boolean[][] memo;

    int removal(String[] board, int i, int j) {
        if (i < 0 || i >= board.length || j >= board[i].length() || j < 0 || memo[i][j]) {
            return 0;
        }
        char c = board[i].charAt(j);
        memo[i][j] = true;
        boolean adBottom = j % 2 == 0;
        int res = 0;
        if (c == 'A') {
            if (adBottom) {
                res += removal(board, i + 1, j + 1);
            } else {
                res += removal(board, i - 1, j - 1);
            }
            res += removal(board, i, j + 1);
            res += removal(board, i, j - 1);
        } else if (c == 'R') {
            for (int k = 0; k < board[i].length(); k++) {
                res += removal(board, i, k);
            }
        } else if (Character.isDigit(c)) {
            res += 1;
            if (adBottom) {
                if (isvalid(board, i + 1, j + 1, c)) {
                    res += removal(board, i + 1, j + 1);

                }
            } else {
                if (isvalid(board, i - 1, j - 1, c)) {
                    res += removal(board, i - 1, j - 1);
                }
            }
            if (isvalid(board, i, j + 1, c)) {
                res += removal(board, i, j + 1);
            }
            if (isvalid(board, i, j - 1, c)) {
                res += removal(board, i, j - 1);
            }
        }
        return res;
    }



    boolean isvalid(String[] board, int x, int y, char c) {
        if (x >= 0 && x < board.length && y < board[x].length() && y >= 0 &&
                board[x].charAt(y) == c) {
            return true;
        }
        return false;
    }
// BEGIN CUT HERE

    public static void main(String[] args) {
        try {
            eq(0, (new TrianglesBoard()).maxScore(new String[]{"0",
                        "121",
                        "31122"}), 3);
            eq(1, (new TrianglesBoard()).maxScore(new String[]{"1",
                        "121",
                        "12121"}), 1);
            eq(2, (new TrianglesBoard()).maxScore(new String[]{"1",
                        "1A1"}), 3);
            eq(3, (new TrianglesBoard()).maxScore(new String[]{"2",
                        "122",
                        "1A122",
                        "2222222"}), 12);
            eq(4, (new TrianglesBoard()).maxScore(new String[]{"2",
                        "224",
                        "12R43",
                        "R111333"}), 14);
            eq(5, (new TrianglesBoard()).maxScore(new String[]{"R",
                        "2AR",
                        "R12A2",
                        "2A2121R",
                        "R121212A2"}), 16);
            eq(6, (new TrianglesBoard()).maxScore(new String[]{"A",
                        "AAA",
                        "AAAAA"}), 0);
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

package Search.BFS;

import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class GameOfEight {

    public int fewestMoves(String[] board) {
        Queue<ArrayList<String>> q = new LinkedList<ArrayList<String>>();
        String init = "";
        for (int i = 0; i < 3; i++) {
            init += board[i];
        }
        Set<String> memo = new HashSet<String>();
        memo.add(init);
        ArrayList<String> l1 = new ArrayList<String>();
        l1.add(init);
        q.add(l1);
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            ArrayList<String> l = q.poll();
            String p = l.get(l.size() - 1);
            if (p.equals("12345678.")) {
                return l.size() - 1;
            }
            int x = -1;
            int y = -1;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '.') {
                    x = i / 3;
                    y = i % 3;
                    break;
                }
            }
            int loc = x * 3 + y;
            for (int i = 0; i < 4; i++) {
                int X = x + di[i];
                int Y = y + dj[i];
                if (X >= 0 && X < 3 && Y >= 0 && Y < 3) {
                    StringBuffer sb = new StringBuffer(p);
                    sb.setCharAt(loc, sb.charAt(X * 3 + Y));
                    sb.setCharAt(X * 3 + Y, '.');
                    if (!memo.contains(sb + "")) {
                        memo.add(sb + "");
                        ArrayList<String> wl = new ArrayList<String>(l);
                        wl.add(sb + "");
                        q.add(wl);
                    }
                }
            }
        }
        return -1;
    }
// BEGIN CUT HERE

    public static void main(String[] args) {
        try {
            long a = System.currentTimeMillis();
            eq(2, (new GameOfEight()).fewestMoves(new String[]{".23",
                        "456",
                        "781"}), -1);
            System.err.println(System.currentTimeMillis() - a);
            eq(0, (new GameOfEight()).fewestMoves(new String[]{"123",
                        "485",
                        "76."}), 4);
            eq(1, (new GameOfEight()).fewestMoves(new String[]{"123",
                        "456",
                        "78."}), 0);
            eq(1, (new GameOfEight()).fewestMoves(new String[]{"234",
                        "15.",
                        "768"}), 0);

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

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

public class CollectingRiders {

    class Node {

        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public int minimalMoves(String[] board) {
        int res = -1;
        int[] di = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] dj = {2, -2, 1, -1, 2, -2, 1, -1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                int sumInthisPoint = 0;
                for (int k = 0; k < board.length; k++) {
                    for (int l = 0; l < board[k].length(); l++) {
//                        if (i == k && j == l) {
//                            continue;
//                        }
                        if (board[k].charAt(l) == '.') {
                            continue;
                        }
                        boolean[][] memo = new boolean[board.length][board[0].length()];
                        Queue<ArrayList<Node>> q = new LinkedList<ArrayList<Node>>();
                        ArrayList<Node> li = new ArrayList<Node>();
                        li.add(new Node(k, l));
                        q.add(li);
                        boolean solved = false;
                        while (!q.isEmpty()) {
//                            print("", q);
                            ArrayList<Node> list = q.poll();
                            Node p = list.get(list.size() - 1);
                            if (p.x == i && p.y == j) {
                                int kk = Integer.parseInt(board[k].charAt(l) + "");
                                sumInthisPoint += ceil((list.size() - 1) / (double) kk);
//                                print("",list);
                                solved = true;
                                break;
                            }
                            for (int m = 0; m < di.length; m++) {
                                int X = p.x + di[m];
                                int Y = p.y + dj[m];
                                if (X >= 0 && X < board.length && Y >= 0 && Y < board[0].length() &&
                                        !memo[X][Y]) {
                                    memo[X][Y] = true;
                                    ArrayList<Node> wlist = new ArrayList<Node>(list);
                                    wlist.add(new Node(X, Y));
                                    q.add(wlist);
                                }
                            }
                        }
                        if (!solved) {
                            k = board.length;
                            sumInthisPoint = -1;
                            break;
                        }
                    }
                }
                if (sumInthisPoint != -1) {
                    res = min(res, sumInthisPoint);
                    if (res == -1) {
                        res = sumInthisPoint;
                    }
                }

            }
        }
        return res;
    }


// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new CollectingRiders()).minimalMoves(new String[]{"...1",
                        "....",
                        "2..."}), 2);
            eq(1, (new CollectingRiders()).minimalMoves(new String[]{"........",
                        ".1......",
                        "........",
                        "....3...",
                        "........",
                        "........",
                        ".7......",
                        "........"}), 2);
            eq(2, (new CollectingRiders()).minimalMoves(new String[]{"..",
                        "2.",
                        ".."}), 0);
            eq(3, (new CollectingRiders()).minimalMoves(new String[]{".1....1."}), -1);
            eq(4, (new CollectingRiders()).minimalMoves(new String[]{"9133632343",
                        "5286698232",
                        "8329333369",
                        "5425579782",
                        "4465864375",
                        "8192124686",
                        "3191624314",
                        "5198496853",
                        "1638163997",
                        "6457337215"}), 121);
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

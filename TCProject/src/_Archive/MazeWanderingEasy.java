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

public class MazeWanderingEasy {

    class Arr extends ArrayList<Node> {

        public Arr(Arr a, int dec) {
            super(a);
            this.dec = dec;
        }

        public Arr() {
        }
        int dec = 0;
    }

    class Node {

        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int decisions(String[] maze) {
        int fi = 0, fj = 0, mi = 0, mj = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                if (maze[i].charAt(j) == '*') {
                    fi = i;
                    fj = j;
                } else if (maze[i].charAt(j) == 'M') {
                    mi = i;
                    mj = j;
                }
            }
        }
        boolean[][] memo = new boolean[maze.length][maze[0].length()];
        Queue<Arr> q = new LinkedList<Arr>();
        Arr li = new Arr();
        li.add(new Node(mi, mj));
        memo[mi][mj] = true;
        q.add(li);
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        while (!q.isEmpty()) {
//            print("", q);
            Arr l = q.poll();
            Node p = l.get(l.size() - 1);
            if (p.x == fi && p.y == fj) {
                return l.dec;
            }
            Arr tmp = new Arr();
            for (int i = 0; i < 4; i++) {
                int X = p.x + di[i];
                int Y = p.y + dj[i];
                if (X >= 0 && X < maze.length && Y >= 0 && Y < maze[0].length() &&
                        maze[X].charAt(Y) != 'X' && !memo[X][Y]) {
                    memo[X][Y] = true;
                    tmp.add(new Node(X, Y));
                }
            }
            for (Node xy : tmp) {
                Arr wl = new Arr(l, l.dec);
                wl.add(new Node(xy.x, xy.y));
                if (tmp.size() > 1) {
                    wl.dec++;
                }
                q.add(wl);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try {
            eq(0, (new MazeWanderingEasy()).decisions(new String[]{"*.M"}), 0);
            eq(1, (new MazeWanderingEasy()).decisions(new String[]{"*.M",
                        ".X."}), 1);
            eq(2, (new MazeWanderingEasy()).decisions(new String[]{"...",
                        "XMX",
                        "..*"}), 2);
            eq(3, (new MazeWanderingEasy()).decisions(new String[]{".X.X......X",
                        ".X*.X.XXX.X",
                        ".XX.X.XM...",
                        "......XXXX."}), 3);
            eq(4, (new MazeWanderingEasy()).decisions(new String[]{"..........*",
                        ".XXXXXXXXXX",
                        "...........",
                        "XXXXXXXXXX.",
                        "M.........."}), 0);
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

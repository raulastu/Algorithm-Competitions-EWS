package Search.BFS;

import java.util.*;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class BFS {

    class node {

        int x, y, from, a, b;

        public node(int x, int y, int from, int a, int b) {
            this.x = x;
            this.y = y;
            this.from = from;
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return x + "," + y;
        }
    }

    public int minimalTime(String[] s) {
        int r = 0;
        boolean[][][][][] memo = new boolean[2][2][5][50][50];
        int xv[] = new int[6];
        fill(xv, -1);
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length(); j++) {
                if (s[i].charAt(j) == 'S') {
                    xv[0] = i;
                    xv[1] = j;
                }
                if (s[i].charAt(j) == 'C' && xv[2] == -1) {
                    xv[2] = i;
                    xv[3] = j;
                } else if (s[i].charAt(j) == 'C') {
                    xv[4] = i;
                    xv[5] = j;
                }
            }
        }
        ArrayList<ArrayList<node>> q = new ArrayList<ArrayList<node>>();
        ArrayList<node> al = new ArrayList<node>();
        al.add(new node(xv[0], xv[1], 4, 0, 0));
        memo[0][0][4][xv[0]][xv[1]] = true;
        q.add(al);
        int[] di = {-1, 1, 0, 0}; // up down l r
        int[] dj = {0, 0, -1, 1};
        int a = 0;
        int b = 0;
        while (!q.isEmpty()) {
//            System.err.println(q);
            ArrayList<node> l = q.get(0);
            q.remove(0);
            node p = l.get(l.size() - 1);
            if (p.a == 1 && p.b == 1) {
                return l.size() - 1;
            }
            for (int i = 0; i < 4; i++) {
                if (i == p.from) {
                    continue;
                }
                int X = p.x + di[i];
                int Y = p.y + dj[i];
                if (X >= 0 && X < s.length && Y >= 0 && Y < s[0].length() &&
                        s[X].charAt(Y) != '#' &&
                        !memo[p.a][p.b][i][X][Y]) {
                    int ta = p.a, tb = p.b;
                    memo[ta][tb][i][X][Y] = true;
                    if (X == xv[2] && Y == xv[3]) {
                        ta = 1;
                    }
                    if (X == xv[4] && Y == xv[5]) {
                        tb = 1;
                    }
                    ArrayList<node> cl = new ArrayList<node>();
                    for (node o : l) {
                        cl.add(new node(o.x, o.y, o.from, o.a, o.b));
                    }
                    cl.add(new node(X, Y, i, ta, tb));
                    q.add(cl);
                }
            }
        }
        return -1;
    }
// BEGIN CUT HERE

    public static void main(String[] args) {
        try {
            eq(0, (new BFS()).minimalTime(new String[]{
                        "SCC",
                        "..."}), 4);
            eq(1, (new BFS()).minimalTime(new String[]{"C.C.S"}), -1);
            eq(2, (new BFS()).minimalTime(new String[]{"#.#",
                        "CSC",
                        "#.#"}), 5);
            eq(3, (new BFS()).minimalTime(new String[]{"#.#....",
                        "##...#.",
                        "C#...#.",
                        ".....#.",
                        "..#....",
                        "..#S.#.",
                        ".##..#.",
                        "###..##",
                        "..C.#.#",
                        "###.#.."}), 24);
            eq(4, (new BFS()).minimalTime(new String[]{
                        "#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#C",
                        ".................S..................",
                        "C#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#.#"
                    }), 155);
            eq(4, (new BFS()).minimalTime(new String[]{".....#.###....", "..##.#.......#", "....#.#.....#.", "#..###.##.....", ".#.......#....", "..##.##.......", ".#...#...##.#.", ".#.....#.....#", "...#....#....#", "...#....#....#", ".#............", "....#.#..#.#.S", "...........#..", "....#.#.......", "##...#...#....", ".###.##C...##.", "#..C#..#...#..", ".#....#....#.."}), -1);
            eq(4, (new BFS()).minimalTime(new String[]{
                        ".................##.....#..",
                        "..##.#......#.............#",
                        "....#.......#.#...#....#.#.",
                        "..#.#.........#...#........",
                        "#.......#..#....#...#......",
                        ".......#...............#...",
                        "#...#..#.#.....###.........",
                        "...........#.....#.........",
                        "....#......C..##...C....#..",
                        ".##S..........#......#..##.",
                        ".....#....................#",
                        ".............#.....#.......",
                        ".#............#....#..#...#",
                        "..#.......##.#.....#.#.....",
                        ".........#.......#........."
                    }), 33);
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
// Powered by FileEdit
// Powered by CodeProcessor

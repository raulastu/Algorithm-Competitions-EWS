package Algorithms.spanningTree;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class ActivateGame {

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

        @Override
        public int hashCode() {
            return x + y;
        }

        @Override
        public boolean equals(Object obj) {
            Node b = (Node) obj;
            return b.x == x && b.y == y;
        }
    }

    class Edge {

        Node a, b;
        int val;

        public Edge(Node a, Node b, int val) {
            this.a = a;
            this.b = b;
            this.val = val;
        }

        @Override
        public String toString() {
            return a + " " + b + " - " + val;
        }

        @Override
        public boolean equals(Object obj) {
            Edge x = (Edge) obj;
            boolean eq = (a.equals(x.a) && b.equals(x.b)) || (a.equals(x.b) && b.equals(x.a));
            boolean eqVal = val == x.val;
            return eq && eqVal;
        }
    }

    public int findMaxScore(String[] grid) {
        HashSet<Edge> E = new HashSet<Edge>();
        HashSet<Node> V = new HashSet<Node>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                int val = val(grid[i].charAt(j));
                Node a = new Node(i, j);
                V.add(a);
                if (i < grid.length - 1) {
                    int valb = val(grid[i + 1].charAt(j));
                    Node b = new Node(i + 1, j);
                    E.add(new Edge(a, b, abs(val - valb)));
                }
                if (j < grid[i].length() - 1) {
                    int valb = val(grid[i].charAt(j + 1));
                    Node b = new Node(i, j + 1);
                    E.add(new Edge(a, b, abs(val - valb)));
                }
            }
        }
        ArrayList<Edge> newE = new ArrayList<Edge>();
        ArrayList<Node> newV = new ArrayList<Node>();
        newV.add(new Node(0, 0));
        Edge e;
//        print(E);
        do {
            e = null;
            int max = -1;
            boolean sd = false;
            for (Edge edge : E) {
                boolean a = (newV.contains(edge.a) && !newV.contains(edge.b));
                boolean b = (newV.contains(edge.b) && !newV.contains(edge.a));
                if (a || b) {
                    if (edge.val > max) {
                        sd = a;
                        max = edge.val;
                        e = edge;
                    }
                }
            }
            if (e != null) {
                newE.add(e);
                if (sd) {
                    newV.add(e.b);
                } else {
                    newV.add(e.a);
                }
            }
        } while (e != null);
        int res = 0;
        for (Edge ex : newE) {
            res += ex.val;
        }
        return res;
    }

    int val(char c) {
        int pt = 0;
        if (c >= 'a' && c <= 'z') {
            pt = 10 + c - 'a';
        } else if (c >= 'A' && c <= 'Z') {
            pt = 36 + c - 'A';
        } else {
            pt = c - '0';
        }
        return pt;
    }
// BEGIN CUT HERE

    public static void main(String[] args) {
        try {
            eq(0, (new ActivateGame()).findMaxScore(new String[]{"05",
                        "aB"}), 69);
            eq(1, (new ActivateGame()).findMaxScore(new String[]{"03",
                        "21"}), 7);
            eq(2, (new ActivateGame()).findMaxScore(new String[]{"John",
                        "Brus",
                        "Gogo"}), 118);
            eq(3, (new ActivateGame()).findMaxScore(new String[]{"AAA",
                        "AAA",
                        "AAA"}), 0);
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
        System.err.println(Arrays.deepToString(rs));
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

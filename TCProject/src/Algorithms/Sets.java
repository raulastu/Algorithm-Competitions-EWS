package Algorithms;

import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class Sets {

    class Node {

        int cal, index, a, b, c;

        public Node(int cal, int index, int a, int b, int c) {
            this.cal = cal;
            this.index = index;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        int totalVit() {
            return a + b + c;
        }

        @Override
        public String toString() {
            return a + " " + b + " " + c + " " + cal;
        }
    }

    public int sets(int[] calories, int a[], int[] b, int c[]) {
        ArrayList<Node> set = new ArrayList<Node>();
        for (int i = 0; i < calories.length; i++) {
            set.add(new Node(calories[i], i, a[i], b[i], c[i]));
        }
//        return genSubSets(0, set);
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 1; i <= 20; i++) {
            al.add(i);
        }

        long ax = System.currentTimeMillis();
        System.err.println(genSubSets2(0, new ArrayList<Node>(), set));
        System.err.println("time:" + (System.currentTimeMillis() - ax));

        ax = System.currentTimeMillis();
        System.err.println(genSubSetsByBits(set));
        System.err.println("time:" + (System.currentTimeMillis() - ax));
        return 1;
    }

    int genSubSets(ArrayList al) {
        int c = 0;
        int len = al.size();
//        int n = ;
        for (int i = 0; i < (1 << al.size()); i++) {
            ArrayList subset = new ArrayList();
            for (int j = 0; j < al.size(); j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(al.get(j));
                }
            }
            c++;
        }
        return c;
    }

    int genSubSetsByBits(ArrayList<Node> al) {
        int c = 0;
        int len = al.size();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << al.size()); i++) {
            ArrayList<Node> subset = new ArrayList<Node>();
            for (int j = 0; j < al.size(); j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(al.get(j));
                }
            }
            c++;
            int va = 0, vb = 0, vc = 0;
            int ca = 0;
            for (Node node : subset) {
                va += node.a;
                vb += node.b;
                vc += node.c;
                ca += node.cal;
            }
            if (va >= 100 && vb >= 100 && vc >= 100) {
                res = min(res, ca);
            }
//            System.err.println(subset);
        }
        return res;
    }

    int genSubSets2(int i, ArrayList<Node> tempset, ArrayList<Node> al) {
        if (al.size() == i) {
//            System.err.println(tempset);
            int va = 0, vb = 0, vc = 0;
            int ca = 0;
            for (Node node : tempset) {
                va += node.a;
                vb += node.b;
                vc += node.c;
                ca += node.cal;
            }
            if (va >= 100 && vb >= 100 && vc >= 100) {
                return ca;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        ArrayList<Node> tempset1 = new ArrayList<Node>(tempset);
        tempset1.add(al.get(i));
        ArrayList<Node> tempset2 = new ArrayList<Node>(tempset);
        int va = 0, vb = 0, vc = 0, cal = 0;
        for (Node node : tempset) {
            va += node.a;
            vb += node.b;
            vc += node.c;
            cal += node.cal;
        }
        if (va >= 100 && vb >= 100 && vc >= 100) {
            return cal;
        } else {
            int b = genSubSets2(i + 1, tempset1, al);
            int s = genSubSets2(i + 1, tempset2, al);
            return min(s, b);
        }
    }

    int genSubSets(int i, ArrayList<Integer> tempset, ArrayList<Integer> al) {
        if (al.size() == i) {
            return 1;
        }
        ArrayList<Integer> tempset1 = new ArrayList<Integer>(tempset);
        tempset1.add(al.get(i));
        ArrayList<Integer> tempset2 = new ArrayList<Integer>(tempset);
        return genSubSets(i + 1, tempset2, al) + genSubSets(i + 1, tempset1, al);
    }

    public static void main(String[] args) {
//        eq(0, new Sets().sets(new int[]{28, 23, 6, 42, 496}, new int[]{20, 69, 90, 10, 100},
//                new int[]{33, 33, 33, 40, 100}, new int[]{98, 1, 1, 1, 100}), 76);
        int[][] cal = new int[4][20];
        for (int i = 0; i < cal.length; i++) {
            for (int j = 0; j < cal[i].length; j++) {
                cal[i][j] = 5;
            }
        }
        eq(0, new Sets().sets(cal[0], cal[1], cal[2], cal[3]), 76);
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
}

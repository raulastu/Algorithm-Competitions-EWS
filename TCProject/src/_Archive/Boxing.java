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

public class Boxing {

    class Node {

        int x, y;

        public Node(int x, int y, int p) {
            this.x = x;
            this.y = y;
            ppl.add(p);
        }

        @Override
        public String toString() {
            return x + " " + y + " " + ppl;
        }

        public void mod(int i, int p) {
            x = min(i, x);
            y = max(i, y);
            ppl.add(p);
        }

        @Override
        public boolean equals(Object obj) {
            Node a = (Node) obj;
            if (a.ppl.size() == 1) {
                if (x <= a.x && a.y <= y) {
                    return true;
                }
            }
            return false;
        }

        boolean inInterval(int i) {
            return i >= x && i <= y;
        }
        HashSet<Integer> ppl = new HashSet<Integer>();
    }

    public int maxCredit(int[] a, int[] b, int[] c, int[] d, int[] e) {
        ArrayList<Node> l = new ArrayList<Node>();
        int[][] arrs = {a, b, c, d, e};
        for (int kk = 0; kk < arrs.length; kk++) {
            for (int i = 0; i < arrs[kk].length; i++) {
                boolean added = false;
                for (int j = 0; j < l.size(); j++) {
                    Node interval = l.get(j);
                    if (interval.ppl.size() == 1) {
                        interval.mod(arrs[kk][i], kk);
                        added = true;
                    } else {
                        if (interval.inInterval(arrs[kk][i])) {
                            interval.mod(arrs[kk][i], kk);
                            added = true;
                        }
                    }
                }
                if (!added) {
                    l.add(new Node(arrs[kk][i], arrs[kk][i], kk));
                }
                fix(l);
            }
        }
        System.err.println(l);
        int res = 0;
        for (Node node : l) {
            if (node.ppl.size() >= 3) {
                res++;
            }
        }
        return res;
    }

    void fix(ArrayList<Node> a) {
        for (Iterator<Node> it = a.iterator(); it.hasNext();) {
            Node node = it.next();
            boolean remove = false;
            if (node.ppl.size() == 1) {
                for (Node node1 : a) {
                    if (node.ppl.size() > 1) {
                        if (node.x >= node1.x && node.x <= node1.y) {
                            remove = true;
                        }
                    }
                }
            }
            if (remove) {
                it.remove();
            }
        }
    }

    int val(int i, int a[]) {
        if (i >= 0 && i < a.length) {
            return a[i];
        }
        return -1;
    }

    boolean ch(int i, int a[]) {
        return i < a.length;
    }
// BEGIN CUT HERE

    public static void main(String[] args) {
        try {
            eq(0, (new Boxing()).maxCredit(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 2, 3, 4, 5, 6}, new int[]{0, 1, 2}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 6);
            eq(1, (new Boxing()).maxCredit(new int[]{100, 200, 300, 1200, 6000}, new int[]{}, new int[]{900, 902, 1200, 4000, 5000, 6001}, new int[]{0, 2000, 6002}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 3);
            eq(2, (new Boxing()).maxCredit(new int[]{5000, 6500}, new int[]{6000}, new int[]{6500}, new int[]{6000}, new int[]{0, 5800, 6000}), 1);
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

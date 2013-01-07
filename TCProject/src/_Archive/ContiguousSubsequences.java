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

public class ContiguousSubsequences {

    class Arr extends ArrayList<Node> {

        public Arr(Arr a, int dec) {
            super(a);
            this.avg = dec;
        }

        public Arr() {
        }

        @Override
        public String toString() {
            return super.toString() + "." + avg;
        }
        double avg = 0;
    }

    class Node {

        int val, ind;

        public Node(int x, int y) {
            this.val = x;
            this.ind = y;
        }

        @Override
        public String toString() {
            return val + " " + ind;
        }
    }

    public int[] findMaxAverage(int[] a, int K) {
        int[] res = new int[2];
        LinkedList<Arr> tt = new LinkedList<Arr>();
        for (int j = K; j <= a.length; j++) {
            for (int i = 0; i <= a.length - j; i++) {
                Arr al = new Arr();
                for (int k = i; k < i + j; k++) {
                    al.add(new Node(a[k], k));
                }
                al.avg = avg(al);
                tt.add(al);
            }
        }
//        System.err.println(tt);
        sort(tt, new Comparator() {

            public int compare(Object o1, Object o2) {
                Arr a = (Arr) o1;
                Arr b = (Arr) o2;
                if (a.avg == b.avg) {
                    if (a.size() == b.size()) {
                        return b.get(0).ind - a.get(0).ind;
                    } else {
                        return a.size() - b.size();
                    }
                } else {
                    if (a.avg > b.avg) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        res[0] = tt.getLast().get(0).ind;
        res[1] = tt.getLast().get(tt.getLast().size() - 1).ind;
        return res;
    }

    double avg(Arr x) {
        double res = 0;
        for (Node integer : x) {
            res += integer.val;
        }
        return res / (double) x.size();
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new ContiguousSubsequences()).findMaxAverage(new int[]{1, 3, 7}, 2), new int[]{1, 2});
            eq(1, (new ContiguousSubsequences()).findMaxAverage(new int[]{5, 1, 3, 4}, 2), new int[]{2, 3});
            eq(2, (new ContiguousSubsequences()).findMaxAverage(new int[]{10}, 1), new int[]{0, 0});
            eq(3, (new ContiguousSubsequences()).findMaxAverage(new int[]{381, 921, 513, 492, 135, 802, 91, 519}, 1), new int[]{1, 1});
            eq(4, (new ContiguousSubsequences()).findMaxAverage(new int[]{381, 921, 513, 492, 135, 802, 91, 519}, 4), new int[]{0, 3});
            eq(5, (new ContiguousSubsequences()).findMaxAverage(new int[]{3, 5, 7, 7, 2, 5, 4, 7, 7, 2, 4}, 1), new int[]{2, 3});
            eq(6, (new ContiguousSubsequences()).findMaxAverage(new int[]{3, 1, 3, 3, 3, 1, 3, 3, 3}, 1), new int[]{2, 4});
            eq(7, (new ContiguousSubsequences()).findMaxAverage(new int[]{1, 3, 2, 1, 1, 2, 2, 2, 2}, 3), new int[]{5, 8});
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

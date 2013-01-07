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

public class RogersPhenomenon {

    public int countTriggers(int[] set1, int[] set2) {
        int res = 0;
        ArrayList<Integer> set1s = new ArrayList<Integer>();
        ArrayList<Integer> set2s = new ArrayList<Integer>();
        for (int i = 0; i < set1.length; i++) {
            set1s.add(set1[i]);
        }
        for (int i = 0; i < set2.length; i++) {
            set2s.add(set2[i]);
        }
        double media1 = media(set1s);
        double media2 = media(set2s);
        System.err.println(set1s);
        if (set1.length >= 2) {
            for (int i = 0; i < set1.length; i++) {
                ArrayList<Integer> set11 = new ArrayList<Integer>();
                for (int j = 0; j < set1.length; j++) {
                    if (j != i) {
                    set11.add(set1[j]);
                    }
                }
//                set11.remove(set1[i]);
                double newMedia = media(set11);
                ArrayList<Integer> newSet2 = new ArrayList<Integer>();
                newSet2.add(set1[i]);
                for (int j = 0; j < set2.length; j++) {
                    newSet2.add(set2[j]);
                }
//                System.err.println(set11);
//                System.err.println(newSet2);
                double media = media(newSet2);
                if (newMedia > media1 && media > media2) {
                    res++;
                }
            }
        }

        if (set2.length >= 2) {
            for (int i = 0; i < set2.length; i++) {
                ArrayList<Integer> set11 = new ArrayList<Integer>();
                for (int j = 0; j < set2.length; j++) {
                    if (j != i) {
                    set11.add(set2[j]);
                    }
                }
//                set11.remove(set2[i]);
                double newMedia2 = media(set11);

                ArrayList<Integer> newsET1 = new ArrayList<Integer>();
                newsET1.add(set2[i]);
                for (int j = 0; j < set1.length; j++) {
                    newsET1.add(set1[j]);
                }
                double newMedia1 = media(newsET1);
                if (newMedia1 > media1 && newMedia2 > media2) {
                    res++;
                }
            }
        }
        return res;
    }

    double media(ArrayList<Integer> s) {
        double cc = 0;
        for (Integer object : s) {
            cc += object;
        }
        return cc / (double) s.size();
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new RogersPhenomenon()).countTriggers(new int[]{1, 2, 3}, new int[]{4, 5, 6}), 1);
            eq(1, (new RogersPhenomenon()).countTriggers(new int[]{3, 100, 90}, new int[]{5, 1, 18, 29}), 0);
            eq(2, (new RogersPhenomenon()).countTriggers(new int[]{1, 1, 1, 1, 1, 5}, new int[]{-10, -9, -8, -7, -6}), 5);
            eq(3, (new RogersPhenomenon()).countTriggers(new int[]{12, 94, 53, 43, 58, 85, 55, 83, 47, 57}, new int[]{23, 100, 98, 27, 9, 70, 39, 39, 54}), 4);
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

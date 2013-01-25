import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class WhichData {
    public int[] bestVariance(int[] sampleData, int varNum, int varDen) {
        int[] res;
        return res;
    }

// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new WhichData()).bestVariance(new int[] {1,2,3,4,5,6,7,8}, 40, 20),new int[] { 1,  2,  3,  4,  5 });
            eq(1,(new WhichData()).bestVariance(new int[] {1,2,3,4,5,6,7,8}, 6, 1),new int[] { 1,  2,  4,  5,  8 });
            eq(2,(new WhichData()).bestVariance(new int[] {-10000,10000,-9999,9999,-9998,9000}, 10000, 1),new int[] { -10000,  -9998 });
            eq(3,(new WhichData()).bestVariance(new int[] {-10000,10000,-9999,9999,-9998,9998,1,1,2,2}, 9999, 10000),new int[] { -10000,  -9998 });
            eq(4,(new WhichData()).bestVariance(new int[] {500,500,500,500,500,500,500,580,
                100,100,100,100,100,100,100,180}, 700, 1),new int[] { 100,  100,  100,  100,  100,  100,  100,  180 });
            eq(5,(new WhichData()).bestVariance(new int[] {10,10,10,10,10,10}, 0, 9999),new int[] { 10 });
            eq(6,(new WhichData()).bestVariance(new int[] {2,5,8,15,-14,0,-2,3,0,-10,-3,-9,6,-13,4,-1}, 5787, 170),new int[] { -14,  -10,  -3,  -1,  0,  0,  2,  3,  4,  5 });
            eq(7,(new WhichData()).bestVariance(new int[] {-14,-3,-1,10,-5,0,13,6,11,9,5,6,3,-2,0,2}, 5061, 225),new int[] { -5,  -3,  -2,  -1,  0,  2,  5,  6,  6,  11 });
            eq(8,(new WhichData()).bestVariance(new int[] {0,-13,15,5,5,-7,-6,-7,-8,4,-12,-13,14,9,-3,-1}, 9262, 197),new int[] { -13,  -13,  -12,  -7,  -7,  -6,  -3,  4,  5,  5 });
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
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


    
    static String expected = "  expe";
    static String received = "  rc";
// END CUT HERE
}

// BEGIN CUT HERE

// END CUT HERE

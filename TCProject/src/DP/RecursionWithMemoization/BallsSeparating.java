package DP.RecursionWithMemoization;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class BallsSeparating {
    public int minOperations(int[] red, int[] green, int[] blue) {
        r=red;
        g=green;
        b=blue;
        for (int i = 0; i < memo.length; i++) {
        	fill(memo[i],-1);
		}
        int r = go(0,0);
        return r>inf?-1:r;
    }
    int []r,g,b;
    int inf=100000001;
    int memo[][] = new int[51][1<<3];
    int go(int i, int color){
    	if(i==r.length){
    		if(color==7)
    			return 0;
    		return inf;
    	}	
    	if(memo[i][color]==-1){
    		int rc = go(i+1,color|1)+g[i]+b[i];
        	int gc = r[i]+go(i+1,color|2)+b[i];
        	int bc = r[i]+g[i]+go(i+1,color|4);
        	memo[i][color]= min(rc,min(gc,bc));
    	}
    	return memo[i][color];
    }

// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new BallsSeparating()).minOperations(new int[] {1, 1, 1}, new int[] {1, 1, 1}, new int[] {1, 1, 1}),6);
            eq(1,(new BallsSeparating()).minOperations(new int[] {5}, new int[] {6}, new int[] {8}),-1);
            eq(2,(new BallsSeparating()).minOperations(new int[] {4, 6, 5, 7}, new int[] {7, 4, 6, 3}, new int[] {6, 5, 3, 8}),37);
            eq(3,(new BallsSeparating()).minOperations(new int[] {7, 12, 9, 9, 7}, new int[] {7, 10, 8, 8, 9}, new int[] {8, 9, 5, 6, 13}),77);
            eq(4,(new BallsSeparating()).minOperations(new int[] {842398, 491273, 958925, 849859, 771363, 67803, 184892, 391907, 256150, 75799}, new int[] {268944, 342402, 894352, 228640, 903885, 908656, 414271, 292588, 852057, 889141}, new int[] {662939, 340220, 600081, 390298, 376707, 372199, 435097, 40266, 145590, 505103}),7230607);
            int []a=new int[50];
            int []b=new int[50];
            int []c=new int[50];
            fill(a,1);
            fill(b,1);
            fill(c,1);
            eq(5,(new BallsSeparating()).minOperations(a,b,c),7230607);
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

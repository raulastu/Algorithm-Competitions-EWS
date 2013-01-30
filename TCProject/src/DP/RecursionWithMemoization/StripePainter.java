package DP.RecursionWithMemoization;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class StripePainter {
//	didnt get it
    public int minStrokes(String stripes) {
    	this.S=stripes.toCharArray();
        int res;
        memo=new int[51][51];
        for (int i = 0; i < memo.length; i++) {
        	fill(memo[i],-1);
		}
        res=go(0,S.length-1);
//        print(memo[1][1]);
        return res;
    }
    char []S;
    int memo[][];
    int go(int l, int r){
//    	print(l,r);
    	if(l>r)return 0;
    	if(memo[l][r]==-1){
    		if(S[l]!=S[r]){
    			int res=min(go(l+1,r),go(l,r-1))+1;
    			for (int i = l+1; i < r; i++) {
					if(S[i]==S[l]){
						res=min(res,go(l,i)+go(i+1,r));
					}
					if(S[i]==S[r]){
						res=min(res,go(l,i-1)+go(i,r));
					}
				}
    			memo[l][r]=res;
    			return res;
    		}
    		int res = go(l+1,r-1)+1;
//    		print(res);
    		for (int i = l+1; i < r; i++) {
    			if(S[i]==S[l]){
    				res=min(res,go(l+1,i)+go(i,r)-1);
//    				print(res);
    			}
			}
    		memo[l][r]=res;
    	}
    	return memo[l][r];
    }
// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
        	eq(0,(new StripePainter()).minStrokes("AAA"),1);
            eq(0,(new StripePainter()).minStrokes("RGBGR"),3);
            eq(1,(new StripePainter()).minStrokes("RGRG"),3);
            eq(2,(new StripePainter()).minStrokes("ABACADA"),4);
            eq(3,(new StripePainter()).minStrokes("AABBCCDDCCBBAABBCCDD"),7);
            eq(4,(new StripePainter()).minStrokes("BECBBDDEEBABDCADEAAEABCACBDBEECDEDEACACCBEDABEDADD"),26);
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

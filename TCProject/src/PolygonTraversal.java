import java.util.regex.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class PolygonTraversal {
	static boolean debug=true;
    public int count(int N, int[] points) {
        int res=0;
        int[] co=new int[N];
        fill(co,-1);
        for (int i = 1; i < points.length; i++) {
			co[points[i-1]-1]=points[i]-1;
		}
        int []not=new int[N-points.length+1];
        int nx=1;
        pr(co);
        for (int i = 1; i < co.length; i++) {
        	boolean found=false;
        	for (int j = 0; j < points.length; j++) {
				if(points[j]-1==i)
					found=true;
			}
			if(!found){
				not[nx++]=i;
			}
		}
        pr(not);
        not[0]=points[points.length-1]-1;
        ar=not;
        res = go(0,1,co,points[0]-1);
        return res;
    }
    int ar[];
    int go(int i, int memo, int [] co, int last){
    	if(memo==(1<<(ar.length))-1){
    		if(check(ar[i],last,co)){
    			return 1;
    		}
    		else return 0;
    	}
    		
    	int r=0;
    	for (int j = 0; j < ar.length; j++) {
    		if(i==j)continue;
    		if((memo&(1<<j))!=0)continue;
    		if(check(ar[i], ar[j], co)){
				co[ar[i]]=ar[j];
				r+=go(j, memo|(1<<j),co,last);
				co[ar[i]]=-1;
			}
		}
    	return r;
    }
    boolean check(int a, int b, int [] x){
		for (int i = 0; i < x.length; i++) {
			if(x[i]<0){
				continue;
			}
			if(inter(a,b,i,x[i]) || inter(a,b,x[i],i)){
				return true;
			}
		}
		return false;
    }
    
    boolean inter(int a, int b, int x, int y){
    	int max=max(a,b);
    	int min=min(a,b);
    	return (min<x && x<max) && (y<min || max<y);
    }

	private static void pr(Object... rs) {
		if(debug)
			System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}
// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new PolygonTraversal2()).count(5, new int[] {1, 3, 5}),1);
            eq(1,(new PolygonTraversal2()).count(6, new int[] {1, 4, 2}),1);
            eq(2,(new PolygonTraversal2()).count(7, new int[] {2, 4, 7}),2);
            eq(3,(new PolygonTraversal2()).count(7, new int[] {1, 2, 3, 4, 6, 5}),0);
            eq(4,(new PolygonTraversal2()).count(11, new int[] {1, 5, 10}),1412);
            
            long a = System.currentTimeMillis();
//            eq(4,(new PolygonTraversal2()).count(18, new int[] {17, 1, 2,3,4}),0);
            pr(System.currentTimeMillis()-a);
            a = System.currentTimeMillis();
            eq(4,(new PolygonTraversal2()).count(18, new int[]{17, 16, 2, 8, 1}),0);
            pr(System.currentTimeMillis()-a);
        } catch( Exception exx) {
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
                pr(received, (Object[]) a);
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

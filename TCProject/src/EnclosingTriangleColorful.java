import java.awt.Point;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class EnclosingTriangleColorful {
    public int getNumber(int m, int[] x, int[] y) {
        int res=0;
//        Point ax = new Point(0,1);
//		Point bx = new Point(3,0);
//		Point cx = new Point(3,3);
//        pr(ptInTriangle(new Point(1,1), ax, bx, cx));
        
//        if(true)
//        	return 1 ;
        
        this.x=x;
        this.y=y;
        
		for (int j = 1; j < m; j++) {
			for (int j2 = 1; j2 < m; j2++) {
				for (int k = 1; k < m; k++) {
					for (int i = 1; i < m; i++) {
						Point ye = new Point(0,j);//y
						Point r = new Point(j2,0);//r
						Point g = new Point(m,k);//g
						Point b = new Point(i,m);//b
						if(go(new Point[]{ye,g,b})){
							res++;
						}	
						if(go(new Point[]{g,b,r})){
							res++;
						}
						if(go(new Point[]{b,r,ye})){
							res++;
						}
						if(go(new Point[]{r,ye,g})){
							res++;
						}
					}
				}
			}
		}
        return res;
    }
    int x[],y[];
    boolean go(Point[]a){
    	int r=0;
    	for (int i = 0; i < y.length; i++) {
        	Point p = new Point(x[i],y[i]);
        	if(ptInTriangle(p, a[0], a[1], a[2]))
        		r++;
		}
		if(r==y.length)
			return true;
		return false;
    }

    boolean ptInTriangle(Point p, Point p0, Point p1,  Point p2) {
        double A = 1.0/(double)2 * (-p1.y * p2.x + p0.y * (-p1.x + p2.x) + p0.x * (p1.y - p2.y) + p1.x * p2.y);
//        pr(A);
        double  sign = A < 0 ? -1 : 1;
//        pr(sign);
        double s = (p0.y * p2.x - p0.x * p2.y + (p2.y - p0.y) * p.x + (p0.x - p2.x) * p.y) * sign;
//        pr(s);
        double t = (p0.x * p1.y - p0.y * p1.x + (p0.y - p1.y) * p.x + (p1.x - p0.x) * p.y) * sign;
        return s > 0 && t > 0 && (s + t) < 2 * A * sign;
    }
    
// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new EnclosingTriangleColorful()).getNumber(4, new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 }),8);
            eq(1,(new EnclosingTriangleColorful()).getNumber(7, new int[] { 1, 1, 6, 6 }, new int[] { 1, 6, 1, 6 }),0);
            eq(2,(new EnclosingTriangleColorful()).getNumber(4, new int[] { 2 }, new int[] { 2 }),72);
            eq(3,(new EnclosingTriangleColorful()).getNumber(10, new int[] { 2, 6, 7, 6 }, new int[] { 7, 7, 9, 3 }),52);
            eq(4,(new EnclosingTriangleColorful()).getNumber(15, new int[] { 7, 6, 5, 4, 3 }, new int[] { 1, 4, 7, 10, 13 }),150);
            eq(5,(new EnclosingTriangleColorful()).getNumber(300, new int[] { 117, 183, 181, 118, 132, 128, 184, 150, 168, 121, 
                 179, 132, 168, 182, 119, 117, 180, 120, 175, 177, 
                 116, 175, 128, 163, 181, 178, 123, 118, 172, 143, 
                 163, 157, 179, 122, 121, 119, 157, 122, 150, 180, 
                 137, 177, 125, 123, 172, 125, 137, 143, 120, 178 }
               , new int[] { 157, 157, 132, 163, 181, 180, 150, 116, 181, 125, 
                 125, 119, 119, 163, 132, 143, 172, 172, 179, 178, 
                 150, 121, 120, 118, 168, 123, 178, 137, 120, 117, 
                 182, 117, 175, 177, 175, 168, 183, 123, 184, 128, 
                 118, 122, 179, 122, 180, 121, 182, 183, 128, 177 }
               ),21690886);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
	private static void pr(Object... rs) {
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
            pr(received + "<" + a.length + "> ", a);
            pr(expected + "<" + b.length + "> ", b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                pr(received + " ", a);
                pr(expected + " ", b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, long[] a, long[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: different lengths");
            pr(received + "<" + a.length + "> ", a);
            pr(expected + "<" + b.length + "> ", b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                pr(received, a);
                pr(expected, b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, double[] a, double[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: different lengths");
            pr(received + "<" + a.length + "> ", a);
            pr(expected + "<" + b.length + "> ", b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                pr(received, a);
                pr(expected, b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, String[] a, String[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: different lengths");
            pr(received + "<" + a.length + "> ", (Object[]) a);
            pr(expected + "<" + b.length + "> ", (Object[]) b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                pr(received, (Object[]) a);
                pr(expected, (Object[]) b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }
    
    static String expected = "  expe";
    static String received = "  rc";
// END CUT HERE
}

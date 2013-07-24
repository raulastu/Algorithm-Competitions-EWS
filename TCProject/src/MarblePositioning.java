import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class MarblePositioning {
    public double totalWidth(int[] radius) {
        double res;
        return res;
    }

// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new MarblePositioning()).totalWidth(new int[] {1, 2}),2.8284271247461903);
            eq(1,(new MarblePositioning()).totalWidth(new int[] {7,7,7}),28.0);
            eq(2,(new MarblePositioning()).totalWidth(new int[] {10, 20, 30}),62.92528739883945);
            eq(3,(new MarblePositioning()).totalWidth(new int[] {100, 100,11,11,25}),200.0);
            eq(4,(new MarblePositioning()).totalWidth(new int[] {1,999950884,1}),63246.0);
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

// BEGIN CUT HERE
PROBLEM STATEMENT
NOTE: This problem statement contains images that may not display properly if viewed outside of the applet.


Everybody loves geometry, so here is a geometry problem.
You have a few marbles of possibly different sizes.
You are given a int[] radius that describes the marbles: each element of radius is the radius of one of your marbles.

You want to place all marbles onto a straight line that is drawn on the table.
Clearly, this makes the problem two-dimensional: we can just view the marbles as circles that will all be touching the line from above.
Of course, the marbles cannot overlap, so in our problem no two circles are allowed to overlap.
Note that you may place the marbles onto the line in any order, you do not have to preserve the order in which they are given in radius.

Additionally, you want to pack the bottoms of the marbles as close together as possible.
More precisely:
For each marble consider the point where it touches the line.
Compute and return the smallest possible distance between the farthest two of those points.
(That is, if you imagine the line as going from the left to the right, your task is to minimize the distance between the leftmost and the rightmost of the points where the circles touch the line.)

DEFINITION
Class:MarblePositioning
Method:totalWidth
Parameters:int[]
Returns:double
Method signature:double totalWidth(int[] radius)


NOTES
-The returned values must have an absolute or relative error less than 1e-9.


CONSTRAINTS
-radius will contain between 2 and 8 elements, inclusive.
-Each element of radius will be between 1 and 1000000000 (10^9), inclusive.


EXAMPLES

0)
{1, 2}

Returns: 2.8284271247461903

One of the best ways to place the marbles is the following one:




1)
{7,7,7}

Returns: 28.0



2)
{10, 20, 30}

Returns: 62.92528739883945





3)
{100, 100,11,11,25}

Returns: 200.0



4)
{1,999950884,1}

Returns: 63246.0



// END CUT HERE

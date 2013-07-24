import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class TheMountain {
    public int minSum(int n, int m, int[] rowIndex, int[] columnIndex, int[] element) {
        int res;
        return res;
    }

// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new TheMountain()).minSum(2, 3, new int[] {0, 0, 0, 1, 1, 1}, new int[] {0, 1, 2, 0, 1, 2}, new int[] {4, 6, 9, 1, 3, 6}),29);
            eq(1,(new TheMountain()).minSum(2, 3, new int[] {1, 0, 1}, new int[] {2, 2, 0}, new int[] {5, 7, 6}),40);
            eq(2,(new TheMountain()).minSum(3, 3, new int[] {0, 0, 2, 2}, new int[] {0, 2, 2, 0}, new int[] {1, 1, 1, 1}),15);
            eq(3,(new TheMountain()).minSum(2, 2, new int[] {0, 0, 1, 1}, new int[] {0, 1, 1, 0}, new int[] {5, 8, 5, 8}),-1);
            eq(4,(new TheMountain()).minSum(1, 3, new int[] {0}, new int[] {1}, new int[] {1}),-1);
            eq(5,(new TheMountain()).minSum(123, 45, new int[] {2, 3, 5, 7, 11}, new int[] {13, 17, 19, 23, 29}, new int[] {100, 200, 300, 400, 500}),367047);
            eq(6,(new TheMountain()).minSum(200, 200, new int[] {5}, new int[] {8}, new int[] {666}),5737554);
            eq(7,(new TheMountain()).minSum(10, 10, new int[] {0, 8, 7}, new int[] {3, 1, 9}, new int[] {5, 4, 7}),593);
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
You are given ints n and m: the dimensions of a matrix.
A matrix M with n rows and m columns is called a mountain if it satisfies the following conditions:

All elements of M are positive integers.
There are integers a and b with the following properties:
  
  0 <= a <= n-1 and 0 <= b <= m-1.
  For each row i, M[i][0] < M[i][1] < ... < M[i][b-1] < M[i][b] > M[i][b+1] > ... > M[i][m-1].
  For each column j, M[0][j] < M[1][j] < ... < M[a-1][j] < M[a][j] > M[a+1][j] > ... > M[n-1][j].
  



In addition to n and m, you are given some elements of M.
More precisely, you are given the int[]s rowIndex, columnIndex and element.
For each valid k, M[rowIndex[k]][columnIndex[k]] has to be element[k].

Your task is to fill in the missing values so that M becomes a mountain.
Find and return the smallest possible sum of all elements in a mountain M that matches the given constraints.
If there is no mountain that matches the given constraints, return -1 instead.

DEFINITION
Class:TheMountain
Method:minSum
Parameters:int, int, int[], int[], int[]
Returns:int
Method signature:int minSum(int n, int m, int[] rowIndex, int[] columnIndex, int[] element)


CONSTRAINTS
-n and m will each be between 1 and 200, inclusive.
-rowIndex will contain between 1 and min(n*m, 50) elements, inclusive.
-columnIndex and element will contain the same number of elements as rowIndex.
-Each element of rowIndex will be between 0 and n-1, inclusive.
-Each element of columnIndex will be between 0 and m-1, inclusive.
-Each element of element will be between 1 and 1,000, inclusive.
-No two indices represented by rowIndex and columnIndex will be the same.


EXAMPLES

0)
2
3
{0, 0, 0, 1, 1, 1}
{0, 1, 2, 0, 1, 2}
{4, 6, 9, 1, 3, 6}

Returns: 29

We are already given all elements of this matrix.
It looks as follows:

[4 6 9]
[1 3 6]

We can easily verify that this is a mountain for a=0 and b=2.
The sum of all elements is 4+6+9+1+3+6=29.

1)
2
3
{1, 0, 1}
{2, 2, 0}
{5, 7, 6}

Returns: 40

The matrix looks as follows.

[? ? 7]
[6 ? 5]

The optimal solution is as follows. The sum is 7+8+7+6+7+5=40.

[7 8 7]
[6 7 5]


2)
3
3
{0, 0, 2, 2}
{0, 2, 2, 0}
{1, 1, 1, 1}

Returns: 15

The matrix looks as follows:

[1 ? 1]
[? ? ?]
[1 ? 1]

The optimal solution is as follows.

[1 2 1]
[2 3 2]
[1 2 1]


3)
2
2
{0, 0, 1, 1}
{0, 1, 1, 0}
{5, 8, 5, 8}

Returns: -1

The given matrix is not a mountain.

[5 8]
[8 5]


4)
1
3
{0}
{1}
{1}

Returns: -1

This matrix looks as follows:

[? 1 ?]

It is not possible to make a mountain out of it, because in a mountain all elements have to be positive.
(Note that 0 is not positive.)

5)
123
45
{2, 3, 5, 7, 11}
{13, 17, 19, 23, 29}
{100, 200, 300, 400, 500}

Returns: 367047



6)
200
200
{5}
{8}
{666}

Returns: 5737554



7)
10
10
{0, 8, 7}
{3, 1, 9}
{5, 4, 7}

Returns: 593



// END CUT HERE

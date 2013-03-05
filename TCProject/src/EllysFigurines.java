import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class EllysFigurines {
    public int getMoves(String[] board, int R, int C) {
        int res=1<<30;
        int N = board[0].length();
        for (int mask = 0; mask < 1<<N; mask++) {
        	int cand=0;
			for (int i = 0; i < N; i++) {
				if((mask&(1<<i))>0){
					i+=(C-1);
					cand++;
				}
			}
//			print("x",Integer.toString(mask, 2));
//			print("cand",cand);
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length(); j++) {
					if((mask&(1<<j))>0)
						continue;
					if(board[i].charAt(j)=='X'){
						cand++;
						i+=(R-1);
						break;
					}
				}
			}
			res=min(cand,res);
		}
        return res;
    }

// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new EllysFigurines()).getMoves(new String[] {".X.X.",
                "XX..X",
                ".XXX.",
                "...X.",
                ".X.XX"}, 1, 2),3);
            eq(1,(new EllysFigurines()).getMoves(new String[] {".X.X.",
                "XX..X",
                ".X.X.",
                "...X.",
                ".X.XX"}, 2, 2),2);
            eq(2,(new EllysFigurines()).getMoves(new String[] {"XXXXXXX"}, 2, 3),1);
            eq(3,(new EllysFigurines()).getMoves(new String[] {"XXXXX",
                "X....",
                "XXX..",
                "X....",
                "XXXXX"}, 1, 1),4);
            eq(4,(new EllysFigurines()).getMoves(new String[] {"XXX..XXX..XXX.",
                ".X..X....X...X",
                ".X..X....X...X",
                ".X..X....X...X",
                ".X...XXX..XXX.",
                "..............",
                "...XX...XXX...",
                "....X......X..",
                "....X....XXX..",
                "....X......X..",
                "...XXX..XXX..."}, 1, 2),7);
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

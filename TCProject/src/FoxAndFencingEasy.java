import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class FoxAndFencingEasy {
    public String WhoCanWin(int mov1, int mov2, int d) {
        String res;
//        pr(mov1*2);
        if(d<=mov1)
        	return "Ciel";
        if(mov1>2*mov2)
        	return "Ciel";
//        if(mov1==mov2)
//        	return "Draw";
        if(mov1*2<mov2)
        	return "Liss";
        return "Draw";
    }

// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
//            eq(0,(new FoxAndFencingEasy()).WhoCanWin(1, 58, 1),"Ciel");
            eq(1,(new FoxAndFencingEasy()).WhoCanWin(100, 100, 100000000),"Draw");
            eq(2,(new FoxAndFencingEasy()).WhoCanWin(100, 150, 100000000),"Draw");
            eq(3,(new FoxAndFencingEasy()).WhoCanWin(100, 250, 100000000),"Liss");
            eq(3,(new FoxAndFencingEasy()).WhoCanWin(100000000, 100000000, 100000000),"Liss");
            eq(3,(new FoxAndFencingEasy()).WhoCanWin(2685, 1800, 7007),"Draw");
            
//            eq(0,(new FoxAndFencingEasy()).WhoCanWin(1, 1, 1),"Ciel");
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

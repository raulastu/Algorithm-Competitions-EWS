package A_topcoderTakesForeverSOImadetemplates;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class IntArr_Int_RetString {

    public String getPersistence(int[] matches, int n) {
        int j = 0;
        this.matches = matches;
        System.err.println(dif("150", "151"));
        String a = "";
        fuck = new String[matches.length][n];
        for (int i = 1; i < matches.length; i++) {
            String x = go(i, n - matches[i], "");
            if(dif(a,x)<0)
                a=x;
        }        
        return a.equals("")?"0":a;
    }
    int matches[];
    int max = 0;
    String [][] fuck;

    
    String go(int i, int n, String s) {
        if (n < 0) {
            System.err.println("nn"+i);
            return "";
        }
        if(!fuck[i][n].equals(""))return fuck[i][n];
        String res = i+"";
        System.err.println(res+" "+n);
        String win = res;
        for (int j = 0; j < matches.length; j++) {
            if(n - matches[j]<0)continue;
            String other = res + go(j, n - matches[j], res);            
            if (dif(win, other) < 0) {
                win = other;
            }
        }
        res = win;
//        System.err.println("x"+res);
        fuck[i][n] = res;
        return res;
    }

    
    int dif(String a, String b) {
//        a = a.replaceAll("^0+", "");
//        b = b.replaceAll("^0+", "");
//        b = b.replaceAll("^0+", "");
        if (a.length() > b.length()) {
            return 1;
        }
        if (a.equals(b)) {
            return 0;
        }
        if (a.length() < b.length()) {
            return -1;
        }

        char[] ax = a.toCharArray();
        char[] bx = b.toCharArray();
        int r = 0;
        for (int i = 0; i < bx.length; i++) {
            if ((int) (ax[i] - '0') > (int) (bx[i] - '0')) {
                return 1;
            } else if ((int) (ax[i] - '0') < (int) (bx[i] - '0')) {
                return -1;
            }
        }
        return r;
    }
//    String s x(String x){
//        x.replaceAll("\\w0", "");
//    }
// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new IntArr_Int_RetString()).getPersistence(new int[]{6, 7, 8}, 21), "210");
            eq(1, (new IntArr_Int_RetString()).getPersistence(new int[]{5, 23, 24}, 30), "20");
            eq(2, (new IntArr_Int_RetString()).getPersistence(new int[]{1, 5, 3, 2}, 1), "0");
            eq(3, (new IntArr_Int_RetString()).getPersistence(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 50), "99999999999999999999999999999999999999999999999999");

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

    private static void print(Object... rs) {
        System.err.println(Arrays.deepToString(rs));
    }

    private static void printm(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.err.println("[" + a[i] + "]");
        }
    }

    private static void printm(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.err.println("[" + new String(a[i]) + "]");
        }
    }
    static String expected = "  expe";
    static String received = "  rChi";
// END CUT HERE
}

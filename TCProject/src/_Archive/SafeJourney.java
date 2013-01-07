package _Archive;

// BEGIN CUT HERE
// END CUT HERE
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class SafeJourney {
    public int fewestRoadCrossings(int width, int length, String[] horizontal, String[] vertical, String home, String work) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new SafeJourney()).fewestRoadCrossings(6, 4, new String[] { "2 0 6" }, new String[] { "2 2 4", "4 0 2" }, "1 3", "5 1"),2);
            eq(1,(new SafeJourney()).fewestRoadCrossings(6, 4, new String[] { "2 0 6" }, new String[] { "2 0 2", "4 2 4" }, "1 3", "5 1"),1);
            eq(2,(new SafeJourney()).fewestRoadCrossings(4, 5, new String[] { "4 1 3,1 1 3" }, new String[] { "2 1 4" }, "1 2", "3 3"),0);
            eq(3,(new SafeJourney()).fewestRoadCrossings(7, 8, new String[] { "2 0 7", "4 0 7", "5 2 4,5 5 6", "6 0 4,6 5 7", "7 1 3" }
               , new String[] { "2 2 5", "3 0 6", "4 0 7", "5 0 5" }, "1 3", "6 1"),4);
            eq(4,(new SafeJourney()).fewestRoadCrossings(5, 5, new String[] { }, new String[] { "3 0 2", "3 2 5" }, "2 4", "4 1"),1);
            eq(5,(new SafeJourney()).fewestRoadCrossings(100, 100, new String[] { "10 0 100,20 0 100,30 0 100,40 0 100,50 0 100",
                 "60 0 100,70 0 100,80 0 100,90 0 100" }, new String[] { "10 0 100,20 0 100,30 0 100,40 0 100,50 0 100",
                 "60 0 100,70 0 100,80 0 100,90 0 100" }, "15 6", "93 95"),17);
            eq(6,(new SafeJourney()).fewestRoadCrossings(13, 9, new String[] { "7 0 5,6 0 5,4 4 8,4 9 13,3 4 13,2 4 8,3 1 3" }, new String[] { "1 1 3,3 0 3,4 2 7,5 2 7,7 5 9,8 5 9,8 0 1,9 1 3", "10 1 3" }, "2 8", "2 1"),1);
            eq(7,(new SafeJourney()).fewestRoadCrossings(15, 8, new String[] { "1 9 14", "4 0 2", "6 2 3", "6 9 12", "7 0 2", "7 7 14" }, new String[] { "3 0 7", "4 1 8", "7 0 7", "9 1 6", "12 4 6", "14 1 6" }, "10 4", "1 2"),0);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
    private static void eq(int n,int a, int b) {
        if (a==b) {
            System.err.println("Case "+n+" passed.");
        } else {
            System.err.println("Case "+n+" failed: "+received+" "+a+" "+expected+" "+b+".");
        }
    }

    private static void eq(int n,double a, double b) {
        if (a==b) {
            System.err.println("Case "+n+" passed.");
        } else {
            System.err.println("Case "+n+" failed: "+received+" '"+a+"' "+expected+" '"+b+"'.");
        }
    }

    private static void eq(int n,char a, char b) {
        if (a==b) {
            System.err.println("Case "+n+" passed.");
        } else {
            System.err.println("Case "+n+" failed: "+received+" '"+a+"' "+expected+" '"+b+"'.");
        }
    }

    private static void eq(int n,long a, long b) {
        if (a==b) {
            System.err.println("Case "+n+" passed.");
        } else {
            System.err.println("Case "+n+" failed: "+received+" '"+a+"L' "+expected+" '"+b+"L'.");
        }
    }

    private static void eq(int n,boolean a, boolean b) {
        if (a==b) {
            System.err.println("Case "+n+" passed.");
        } else {
            System.err.println("Case "+n+" failed: "+received+" '"+a+"' "+expected+" '"+b+"'.");
        }
    }

    private static void eq(int n,String a, String b) {
        if (a!=null&&a.equals(b)) {
            System.err.println("Case "+n+" passed.");
        } else {
            System.err.println("Case "+n+" failed: "+received+" \""+a+"\" "+expected+" \""+b+"\".");
        }
    }

    private static void eq(int n,int[] a, int[] b) {
        if (a.length!=b.length) {
            System.err.println("Case "+n+" failed: different lengths");
            print(received+"<"+a.length+"> ", a);
            print(expected+"<"+b.length+"> ", b);
            return;
        }
        for (int i = 0; i<a.length; i++) {
            if (a[i]!=b[i]) {
                System.err.println("Case "+n+" failed. "+received+" and "+expected+" array differ in position "+i);
                print(received+" ", a);
                print(expected+" ", b);
                return;
            }
        }
        System.err.println("Case "+n+" passed.");
    }

    private static void eq(int n,long[] a, long[] b) {
        if (a.length!=b.length) {
            System.err.println("Case "+n+" failed: different lengths");
            print(received+"<"+a.length+"> ", a);
            print(expected+"<"+b.length+"> ", b);
            return;
        }
        for (int i = 0; i<a.length; i++) {
            if (a[i]!=b[i]) {
                System.err.println("Case "+n+" failed. "+received+" and "+expected+" array differ in position "+i);
                print(received, a);
                print(expected, b);
                return;
            }
        }
        System.err.println("Case "+n+" passed.");
    }

    private static void eq(int n,double[] a, double[] b) {
        if (a.length!=b.length) {
            System.err.println("Case "+n+" failed: different lengths");
            print(received+"<"+a.length+"> ", a);
            print(expected+"<"+b.length+"> ", b);
            return;
        }
        for (int i = 0; i<a.length; i++) {
            if (a[i]!=b[i]) {
                System.err.println("Case "+n+" failed. "+received+" and "+expected+" array differ in position "+i);
                print(received, a);
                print(expected, b);
                return;
            }
        }
        System.err.println("Case "+n+" passed.");
    }

    private static void eq(int n,String[] a, String[] b) {
        if (a.length!=b.length) {
            System.err.println("Case "+n+" failed: different lengths");
            print(received+"<"+a.length+"> ", (Object[]) a);
            print(expected+"<"+b.length+"> ", (Object[]) b);
            return;
        }
        for (int i = 0; i<a.length; i++) {
            if (!a[i].equals(b[i])) {
                System.err.println("Case "+n+" failed. "+received+" and "+expected+" array differ in position "+i);
                print(received, (Object[]) a);
                print(expected, (Object[]) b);
                return;
            }
        }
        System.err.println("Case "+n+" passed.");
    }

    private static void print(String msg, Object... rs) {
        String x = deepToString(rs);
        if(x.indexOf("[[")==0)
            x=x.substring(1,x.length()-1);
        System.err.println(msg+" "+x);
    }
    
    static String expected = "  expe";
    static String received = "  rChi";
// END CUT HERE
}

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

public class DeckRearranging {
    public String rearrange(String deck, int[] above) {
        StringBuilder sr = new StringBuilder();
        for (int i = 0; i < deck.length(); i++) {
            sr.insert(above[i],deck.charAt(i)+"");
        }
        return sr.toString();
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new DeckRearranging()).rearrange("BRBRR", new int[] {0, 0, 1, 0, 3}),"RRBRB");
            eq(1,(new DeckRearranging()).rearrange("RRRRRR", new int[] {0,1,2,0,1,3}),"RRRRRR");
            eq(2,(new DeckRearranging()).rearrange("RBRRBRBB", new int[] {0,1,2,3,4,5,6,7}),"RBRRBRBB");
            eq(3,(new DeckRearranging()).rearrange("RBRRBRBB", new int[] {0,0,0,0,0,0,0,0}),"BBRBRRBR");
            eq(4,(new DeckRearranging()).rearrange("RBRRBRBB", new int[] {0,1,0,0,4,0,6,7}),"RRRRBBBB");
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

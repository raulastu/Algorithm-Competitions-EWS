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

public class Library {
    public int documentAccess(String[] records, String[] userGroups, String[] roomRights) {
        int res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new Library()).documentAccess(new String[] {"diary computers editor","fairytale gardening editor","comix cars author","comix cars librarian"}, new String[] {"employee","editor","author"}, new String[] {"history","cars","computers"}),2);
            eq(1,(new Library()).documentAccess(new String[] {"diary computers editor","fairytale gardening editor","comix cars author","comix cars librarian"}, new String[] {"employee","editor","author","librarian"}, new String[] {"history","cars","computers"}),2);
            eq(2,(new Library()).documentAccess(new String[] {"diary computers editor","fairytale gardening editor","comix cars author","comix cars librarian"}, new String[] {"employee","editor","author","librarian"}, new String[] {}),0);
            eq(3,(new Library()).documentAccess(new String[] {"a b c","a b d","b b c","b b d","e c d","e c b","e c c","t d e"}, new String[] {"c","d","x"}, new String[] {"a","b","c"}),3);
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

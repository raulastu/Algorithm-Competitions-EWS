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

public class GoldMine {
    public int[] getAllocation(String[] mines, int miners) {
        int[] res;
        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new GoldMine()).getAllocation(new String[] { "000, 030, 030, 040, 000, 000, 000",
                 "020, 020, 020, 010, 010, 010, 010" }, 4),new int[] { 2,  2 });
            eq(1,(new GoldMine()).getAllocation(new String[] { "100, 000, 000, 000, 000, 000, 000",
                 "100, 000, 000, 000, 000, 000, 000",
                 "100, 000, 000, 000, 000, 000, 000",
                 "100, 000, 000, 000, 000, 000, 000",
                 "100, 000, 000, 000, 000, 000, 000" }, 8),new int[] { 6,  2,  0,  0,  0 });
            eq(2,(new GoldMine()).getAllocation(new String[] { "050, 000, 000, 000, 000, 050, 000",
                 "050, 000, 000, 000, 000, 050, 000",
                 "050, 000, 000, 000, 000, 050, 000",
                 "050, 000, 000, 000, 000, 050, 000",
                 "050, 000, 000, 000, 000, 050, 000",
                 "050, 000, 000, 000, 000, 050, 000",
                 "050, 000, 000, 000, 000, 050, 000",
                 "050, 000, 000, 000, 000, 050, 000",
                 "050, 000, 000, 000, 000, 050, 000",
                 "050, 000, 000, 000, 000, 050, 000" }, 30),new int[] { 4,  4,  4,  4,  4,  4,  4,  2,  0,  0 });
            eq(3,(new GoldMine()).getAllocation(new String[] { "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004",
                 "026, 012, 005, 013, 038, 002, 004" }, 56),new int[] { 2,  2,  2,  2,  2,  2,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1 });
            eq(4,(new GoldMine()).getAllocation(new String[] { "100, 000, 000, 000, 000, 000, 000",
                 "090, 010, 000, 000, 000, 000, 000",
                 "080, 020, 000, 000, 000, 000, 000",
                 "075, 025, 000, 000, 000, 000, 000",
                 "050, 050, 000, 000, 000, 000, 000",
                 "025, 075, 000, 000, 000, 000, 000",
                 "020, 080, 000, 000, 000, 000, 000",
                 "010, 090, 000, 000, 000, 000, 000",
                 "000, 100, 000, 000, 000, 000, 000",
                 "000, 090, 010, 000, 000, 000, 000",
                 "000, 080, 020, 000, 000, 000, 000",
                 "000, 075, 025, 000, 000, 000, 000",
                 "000, 050, 050, 000, 000, 000, 000",
                 "000, 025, 075, 000, 000, 000, 000",
                 "000, 020, 080, 000, 000, 000, 000",
                 "000, 010, 090, 000, 000, 000, 000",
                 "000, 000, 100, 000, 000, 000, 000",
                 "000, 000, 090, 010, 000, 000, 000",
                 "000, 000, 080, 020, 000, 000, 000",
                 "000, 000, 075, 025, 000, 000, 000",
                 "000, 000, 050, 050, 000, 000, 000",
                 "000, 000, 025, 075, 000, 000, 000",
                 "000, 000, 020, 080, 000, 000, 000",
                 "000, 000, 010, 090, 000, 000, 000",
                 "000, 000, 000, 100, 000, 000, 000",
                 "000, 000, 000, 100, 000, 000, 000",
                 "000, 000, 000, 090, 010, 000, 000",
                 "000, 000, 000, 080, 020, 000, 000",
                 "000, 000, 000, 075, 025, 000, 000",
                 "000, 000, 000, 050, 050, 000, 000",
                 "000, 000, 000, 025, 075, 000, 000",
                 "000, 000, 000, 020, 080, 000, 000",
                 "000, 000, 000, 010, 090, 000, 000",
                 "000, 000, 000, 000, 100, 000, 000",
                 "000, 000, 000, 000, 090, 010, 000",
                 "000, 000, 000, 000, 080, 020, 000",
                 "000, 000, 000, 000, 075, 025, 000",
                 "000, 000, 000, 000, 050, 050, 000",
                 "000, 000, 000, 000, 025, 075, 000",
                 "000, 000, 000, 000, 020, 080, 000",
                 "000, 000, 000, 000, 010, 090, 000",
                 "000, 000, 000, 000, 000, 100, 000",
                 "000, 000, 000, 000, 000, 090, 010",
                 "000, 000, 000, 000, 000, 080, 020",
                 "000, 000, 000, 000, 000, 075, 025",
                 "000, 000, 000, 000, 000, 050, 050",
                 "000, 000, 000, 000, 000, 025, 075",
                 "000, 000, 000, 000, 000, 020, 080",
                 "000, 000, 000, 000, 000, 010, 090",
                 "000, 000, 000, 000, 000, 000, 100" }, 150),new int[] { 0,  0,  0,  1,  1,  1,  1,  1,  1,  1,  1,  1,  2,  2,  2,  2,  2,  2,  2,  2,  3,  3,  3,  3,  3,  3,  3,  3,  3,  4,  4,  4,  4,  4,  4,  4,  4,  4,  5,  5,  5,  5,  5,  5,  5,  5,  5,  5,  6,  6 });
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

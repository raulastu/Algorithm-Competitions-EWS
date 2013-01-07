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

public class LoveCalculator {

    public String findBoy(String girl, String[] boys) {
        String res;

        int b[] = new int[boys.length];
        double max = -1;
        String boy = "";
        sort(boys);


        for (int j = 0; j < boys.length; j++) {
            int L = 0, O = 0, V = 0, E = 0;
            for (int k = 0; k < girl.length(); k++) {
                switch (girl.charAt(k)) {
                    case 'L':
                        L++;
                        break;
                    case 'O':
                        O++;
                        break;
                    case 'V':
                        V++;
                        break;
                    case 'E':
                        E++;
                        break;
                }
            }
            for (int k = 0; k < boys[j].length(); k++) {
                switch (boys[j].charAt(k)) {
                    case 'L':
                        L++;
                        break;
                    case 'O':
                        O++;
                        break;
                    case 'V':
                        V++;
                        break;
                    case 'E':
                        E++;
                        break;
                }
            }
            double p = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
            if (p > max) {
                max = p;
                boy = boys[j];
            }
        }


        return boy;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new LoveCalculator()).findBoy("LOVE", new String[]{"JACOB", "FRANK", "DANO"}), "FRANK");
            eq(1, (new LoveCalculator()).findBoy("JANE", new String[]{"THOMAS", "MICHAEL", "INDY", "LIU"}), "INDY");
            eq(2, (new LoveCalculator()).findBoy("LILLY", new String[]{"PIERRE"}), "PIERRE");
            eq(3, (new LoveCalculator()).findBoy("MERYLOV", new String[]{"JOHN", "DAVE", "STEVE", "JOHN", "DAVE"}), "DAVE");
            eq(4, (new LoveCalculator()).findBoy("LLOL", new String[]{"BVERON", "CVERON", "AVERON", "DVERON"}), "AVERON");
            eq(5, (new LoveCalculator()).findBoy("VELYLEOCEVE", new String[]{"YVXHOVE", "LCOKO", "OGWSJVEVEDLE", "WGFVSJEL", "VLOLUVCBLLQVESWHEEKC"}), "VLOLUVCBLLQVESWHEEKC");
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

    private static void print(String msg, Object... rs) {
        String x = deepToString(rs);
        if (x.indexOf("[[") == 0) {
            x = x.substring(1, x.length() - 1);
        }
        System.err.println(msg + " " + x);
    }
    static String expected = "  expe";
    static String received = "  rChi";
// END CUT HERE
}

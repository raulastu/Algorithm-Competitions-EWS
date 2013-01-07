package SRM_214_DIV_2;

// BEGIN CUT HERE
// END CUT HERE
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bloggoShortcuts {

    public String expand(String text) {
        while (text.contains("*")) {
            text = text.replaceFirst("\\*", "<b>");
            text = text.replaceFirst("\\*", "</b>");
        }
        while (text.contains("_")) {
            text = text.replaceFirst("_", "<i>");
            text = text.replaceFirst("_", "</i>");
        }
        return text;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new bloggoShortcuts()).expand("You _should_ see the new walrus at the zoo!"), "You <i>should</i> see the new walrus at the zoo!");
            eq(1, (new bloggoShortcuts()).expand("Move it from *Accounts Payable* to *Receiving*."), "Move it from <b>Accounts Payable</b> to <b>Receiving</b>.");
            eq(2, (new bloggoShortcuts()).expand("I saw _Chelydra serpentina_ in *Centennial Park*."), "I saw <i>Chelydra serpentina</i> in <b>Centennial Park</b>.");
            eq(3, (new bloggoShortcuts()).expand(" _ _ __  _ yabba dabba _   *  dooooo  * ****"), " <i> </i> <i></i>  <i> yabba dabba </i>   <b>  dooooo  </b> <b></b><b></b>");
            eq(4, (new bloggoShortcuts()).expand("_now_I_know_*my*_ABC_next_time_*sing*it_with_me"), "<i>now</i>I<i>know</i><b>my</b><i>ABC</i>next<i>time</i><b>sing</b>it<i>with</i>me");
        } catch (Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

    private static void eq(int n, int a, int b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
        }
    }

    private static void eq(int n, double a, double b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: expected '" + b + "', received '" + a + "'.");
        }
    }

    private static void eq(int n, char a, char b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: expected '" + b + "', received '" + a + "'.");
        }
    }

    private static void eq(int n, long a, long b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: expected \"" + b + "L, received " + a + "L.");
        }
    }

    private static void eq(int n, boolean a, boolean b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
        }
    }

    private static void eq(int n, String a, String b) {
        if (a != null && a.equals(b)) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: expected \"" + b + "\", received \"" + a + "\".");
        }
    }

    private static void eq(int n, int[] a, int[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, long[] a, long[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, String[] a, String[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void print(int a) {
        System.err.print(a + " ");
    }

    private static void print(long a) {
        System.err.print(a + "L ");
    }

    private static void print(String s) {
        System.err.print("\"" + s + "\" ");
    }

    private static void print(int[] rs) {
        if (rs == null) {
            return;
        }
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if (i != rs.length - 1) {
                System.err.print(", ");
            }
        }
        System.err.println('}');
    }

    private static void print(long[] rs) {
        if (rs == null) {
            return;
        }
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if (i != rs.length - 1) {
                System.err.print(", ");
            }
        }
        System.err.println('}');
    }

    private static void print(String[] rs) {
        if (rs == null) {
            return;
        }
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print("\"" + rs[i] + "\"");
            if (i != rs.length - 1) {
                System.err.print(", ");
            }
        }
        System.err.println('}');
    }

    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}

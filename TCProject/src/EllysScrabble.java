import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class EllysScrabble {
    public String getMin(String letters, int maxDistance) {
        String res;
        int [] r=new int[letters.length()];
        fill(r,0);
        char[] c=letters.toCharArray();
        for (int ll = 0; ll < 26; ll++) {
			char l = (char)('A'+ll);
			for (int i = 0; i < c.length; i++) {
				if(c[i]==l){
					for (int j = max(0,i-maxDistance-r[i]); j < i; j++) {
						if(c[j]>c[i]){
							boolean possible=true;
							for (int j2 = j; j2 < i; j2++) {
								if(r[j2]==maxDistance)
									possible=false;
							}
							if(!possible)continue;
							
							char my=c[i];
							int myscore=r[i];
							for (int k = i; k > j; k--) {
								c[k]=c[k-1];
								r[k]=r[k-1];
								r[k]++;
							}
							c[j]=my;
							r[j]=myscore;
							r[j]-=i-j;
							
							break;
						}
					}
					pr(c,l);
					pr(r);
				}
			}
			
		}
        return new String(c);
    }

// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new EllysScrabble()).getMin("TOPCODER", 3),"CODTEPOR");
            eq(1,(new EllysScrabble()).getMin("ESPRIT", 3),"EIPRST");
            eq(2,(new EllysScrabble()).getMin("BAZINGA", 8),"AABGINZ");
            eq(3,(new EllysScrabble()).getMin("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 9),"ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            eq(4,(new EllysScrabble()).getMin("GOODLUCKANDHAVEFUN", 7),"CADDGAHEOOFLUKNNUV");
            eq(5,(new EllysScrabble()).getMin("AAAWDIUAOIWDESBEAIWODJAWDBPOAWDUISAWDOOPAWD", 6),"AAAADDEIBWAEUIODWADSBIAJWODIAWDOPOAWDUOSPWW");
            eq(6,(new EllysScrabble()).getMin("ABRACADABRA", 2),"AABARACBDAR");
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

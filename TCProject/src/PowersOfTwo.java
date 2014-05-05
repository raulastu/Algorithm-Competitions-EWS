import java.math.BigInteger;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class PowersOfTwo {
    public long count(long[] powers) {
        long res=0;
        sort(powers);
        long carry=2;
        for (int i = 1; i < powers.length; i++) {
			if(powers[i]!=powers[i-1]){
				carry*=2L;
				res+=carry;
			}else{
				res+=carry;
			}
		}
//        pr(res);
        
//        HashSet<Long> set = new HashSet<Long>();
//        for(int bitmask=0; bitmask<(1<<powers.length); bitmask++){
//        	long s=0;
//        	BigInteger b = new BigInteger("0");  
//        	for (int i = 0; i < powers.length; i++) {
//				if((bitmask&(1<<i)) != 0){
////					pr(i);
//					s+=powers[i];
////					b = b.add(new BigInteger(powers[i]+""));
//				}
//			}
////        	set.add(b.toString());
//        	set.add(s);
//        }
//        Long[] a = new Long[set.size()];
//        a = set.toArray(a);
//        Collections.sort(Arrays.asList(a));
//        pr(powers);
//        pr(a);
        return res;
    }

// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new PowersOfTwo()).count(new long[] {1L,2L}),4L);
            eq(0,(new PowersOfTwo()).count(new long[] {1L,2L,4}),4L);
            eq(0,(new PowersOfTwo()).count(new long[] {1L,2L,4,8}),4L);
            eq(0,(new PowersOfTwo()).count(new long[] {1L,2L,4,8,16}),4L);
            eq(0,(new PowersOfTwo()).count(new long[] {1L,2L,4,8,16,16}),4L);
            eq(0,(new PowersOfTwo()).count(new long[] {1L,2L,4,8,16,32}),4L);
            eq(0,(new PowersOfTwo()).count(new long[] {1L,2L,4,8,16,16,32}),4L);
            eq(0,(new PowersOfTwo()).count(new long[] {1L,2L,4,4,8,16,16,32}),4L);
            eq(0,(new PowersOfTwo()).count(new long[] {1L,2L,4,4,4,8,16,16,32}),4L);
            eq(1,(new PowersOfTwo()).count(new long[] {1L,1L,1L,1L}),5L);
            eq(2,(new PowersOfTwo()).count(new long[] {1L,2L,2L,2L,4L,4L,16L}),32L);
            eq(2,(new PowersOfTwo()).count(new long[] {1L,2L,4L,8L,16L}),32L);
            eq(2,(new PowersOfTwo()).count(new long[] {1L,16L}),32L);
            eq(2,(new PowersOfTwo()).count(new long[] {1L,2,16L}),32L);
            eq(2,(new PowersOfTwo()).count(new long[] {1L,2,16,16L}),32L);
            eq(2,(new PowersOfTwo()).count(new long[] {1L,2,16,1024L,1024L}),32L);
            eq(2,(new PowersOfTwo()).count(new long[] {1L,2,4,8L,8L}),32L);
            eq(2,(new PowersOfTwo()).count(new long[] {1L,2,4,8L,8L,1024}),-1L);
            eq(2,(new PowersOfTwo()).count(new long[] {1L,2,4,8L,16,64}),32L);
            eq(2,(new PowersOfTwo()).count(new long[] {1L,2,4,8L,8,16}),32L);
            
            eq(2,(new PowersOfTwo()).count(new long[] {1L,1,1,2,2,2}),-1);
            eq(2,(new PowersOfTwo()).count(new long[] {1L,1,1,2,2,8}),-1);


            eq(3,(new PowersOfTwo()).count(new long[] {1L,32L,1L,16L,32L}),18L);
            eq(4,(new PowersOfTwo()).count(new long[] {1048576L,1073741824L,549755813888L,70368744177664L,4398046511104L,262144L,1048576L,2097152L,8796093022208L,
                1048576L,1048576L,35184372088832L,2097152L,256L,256L,256L,262144L,1048576L,1048576L,70368744177664L,262144L,1048576L}),18432L);
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

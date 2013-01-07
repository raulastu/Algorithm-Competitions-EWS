package _Archive;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class MinskyMysteryDiv2 {
    public long computeAnswer(long N) {
        long res;
        long bag0=0,bag1=0,bag2=0,bag3=0,bag4=0;
        bag0=N;
        bag1++;
        System.err.println(N);

        while(true){
//        	System.err.println("proc for "+N);
        	bag1++; //2 3 4
        	bag4=0;        	
        	while(bag0!=0){
        		if(bag0!=0 && bag1!=0){
        			long min = Math.min(bag0,bag1);
        			bag2+=min;	//2 to bag2, 3 to bag2
        			bag3+=min;    //2 to bag3, 3 to bag3,
        			bag0-=min;   //bag0 2 less, 3 less
        			bag1-=min;
        		}        
        		bag4++;
        		if(bag1==0&&bag0==0){        			
        			bag4+=bag3;
        			bag3=0;
        			System.err.println(bag4);
        			return bag4;
        		}
        		bag1+=bag3; //2 to bag1, 3 to bag1
        		bag3=0;
        	}
        	bag0+=bag2; //2 more to bag0, 3 more to bag0
        	bag2=0;
        }  
//        return -1;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
        	for (int i = 10; i < 1000000; i++) {
        		long real = new MinskyMysteryDiv2().computeAnswer(i);
        		long N=i;
        		long notr=0;
                if(N>=2)
                	if(N%2==0)
                		notr=(N)/2+2;
                	else
                		notr=(N)+1;
                else 
                	notr = -1;
                if(notr==real){
                	System.err.println("DEAL "+real+" "+notr);
                }else{
                	System.err.println("DEAL B"+real+" "+notr);
                	break;
                }
			}
//        	eq(0,(new MinskyMysteryDiv2()).computeAnswer(1000000L),3L);
//        	eq(1,(new MinskyMysteryDiv2()).computeAnswer(1000000000L),3L);
//        	eq(0,(new MinskyMysteryDiv2()).computeAnswer(1000000000000L),3L);
//            eq(0,(new MinskyMysteryDiv2()).computeAnswer(2L),3L);
//            eq(1,(new MinskyMysteryDiv2()).computeAnswer(3L),4L);
//            eq(2,(new MinskyMysteryDiv2()).computeAnswer(4L),4L);
//            eq(3,(new MinskyMysteryDiv2()).computeAnswer(15L),8L);
//            eq(4,(new MinskyMysteryDiv2()).computeAnswer(24L),14L);
        } catch( Exception exx) {
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

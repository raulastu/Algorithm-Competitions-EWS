import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class AstronomicalRecordsEasy {
    public int minimalPlanets(int[] A, int[] B) {
        int res;
//        if(A.length>B.length){
//        	int[]t=A;
//        	A=B;
//        	B=t;
//        }
//        pr(A,B);	
//        int min=A.length+B.length;
//        for (int i = 0; i < A.length; i++) {
//        	for (int ii = 1; ii < B.length; ii++) {
//            	int count=0;
//            	int memo[]=new int[B.length];
//            	for (int j = 1; j < A.length; j++) {
//            		int b=(int)(B[0]*(A[j]/(double)A[i]));
//            		int xx=Arrays.binarySearch(B, b);
//            		if(xx<0){
//            			count++;
//            		}else
//            			memo[xx]=1;
////            		pr(b,count);
//    			}
//    			min=min(B.length+count+i,min);
//    		}
//		}
        int min=0;
        int n=A.length;
        int m=B.length;
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				List aa = Arrays.asList(A);
				List bb = Arrays.asList(B);
				for (int k = 0; k < n; k++) {
					aa.set(k, (aa.get(k))*B[j]);
				}
				for (int k = 0; k < m; k++) {
					bb.set(k, parseInt(bb.get(k).toString())*A[i]);
				}
				for (Object object : bb) {
					Integer ob=(Integer)object;
					if(!aa.contains(ob)){
						aa.add(ob);
					}
				}
				if(aa.size()>min)
					min=aa.size();
			}
		}
        		
        
        return min;
    }

// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new AstronomicalRecordsEasy()).minimalPlanets(new int[] {1,2,3,4}, new int[] {2,3,4,5}),5);
            eq(1,(new AstronomicalRecordsEasy()).minimalPlanets(new int[] {1,2,3,4}, new int[] {2,4,6,8}),4);
            eq(2,(new AstronomicalRecordsEasy()).minimalPlanets(new int[] {1,2,3,5,6,8,9}, new int[] {2,4,5,6,7,8,9}),9);
            eq(3,(new AstronomicalRecordsEasy()).minimalPlanets(new int[] {1,2,3,4}, new int[] {6,7,8,9}),6);
            eq(4,(new AstronomicalRecordsEasy()).minimalPlanets(new int[] {200,500}, new int[] {100,200,300,400,600,700,800,900}),9);
            eq(5,(new AstronomicalRecordsEasy()).minimalPlanets(new int[] {1,2,3,4,5,6,7,8,9,10,11,12}, new int[] {6,7,8,9,10,11,12,13,14,15}),15);
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

package _Archive;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class TheBrickTowerMediumDivTwo {
	int [] hcopy;
	int [] _heights;
    public int[] find(int[] heights) {
    	
//    	hcopy = Arrays.copyOf(heights, heights.length);
    	hcopy=arrcopy(heights,hcopy);
    	sort(hcopy);
//    	print(heights);
//    	print(hcopy);
//    	System.err.println("x");
    	_heights=heights;
        int[] res=new int[heights.length];        
        for (int i = 0; i < res.length; i++) {
			res[i]=i;
		}
        int min = Integer.MAX_VALUE;
        int res1[]=new int[res.length];
        do{
        	int [] r = new int [_heights.length];
        	for (int i = 0; i < r.length; i++) {
        		r[i]=_heights[res[i]];
    		}
//        	print(res);
//        	print(r);
        	int dist=distance(r);
        	if(dist<min){
        		min=dist;
//    			res1=Arrays.copyOf(res, res.length);
    			res1=arrcopy(res,res1);
        	}else if(dist==min){
        		if(min==Integer.MAX_VALUE){	    			
//	    			System.arraycopy(res, 0, res.length, res1,0,res.length);
	    			res1=arrcopy(res,res1);
        		}else{
        			if(islessthan(res,res1)){
            			min=dist;
            			res1=arrcopy(res,res1);
            		}	
        		}
        	}
        }while(nextPermutation(res));
        return res1;
    }
    int [] arrcopy(int[]a,int b[]){
    	b= new int[a.length];
    	for (int i = 0; i < b.length; i++) {
			b[i]=a[i];
		}
    	return b;
    }
    boolean islessthan(int res[], int []res1){
    	for (int i = 0; i < res.length; i++) {
			if(res[i]>res1[i]){
				return false;
			}
		}
    	return true;
    }
    
    int distance(int a[]){
    	int r = 0;
    	for (int i = 1; i < a.length; i++) {
			r+=max(a[i],a[i-1]);
		}
    	return r;
    }
    boolean check(int a[]){
    	for (int i = 0; i < a.length; i++) {
			if(i%2!=0){
				{
					if(a[i]!=hcopy[i] && a[i]!=hcopy[i-1]){
						return false;
					}
				}
				
			}else{
				if(i==a.length-1){
					if(a[i]!=hcopy[i]){
						return false;
					}
				}else {
					if(a[i]!=hcopy[i] && a[i]!=hcopy[i+1]){
						return false;
					}
				}
			}
		}
    	return true;
    }
    
    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    void reverse(int a[]) {
        reverse(a, 0, a.length);
    }

    void reverse(int a[], int from, int to) {
        while (from < --to) {
            swap(a, from++, to);
        }
    }

    boolean nextPermutation(int[] a) {
        int j = a.length - 1;
        if (j <= 0) {
            return false;
        }
        while (j > 0 && a[j] <= a[--j]);

        if (a[j + 1] <= a[j]) {
            reverse(a);
            return false;
        }
        int k = a.length;
        while (a[--k] <= a[j]);
        swap(a, k, j);
        reverse(a, j + 1, a.length);
        return true;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new TheBrickTowerMediumDivTwo()).find(new int[] {4, 7, 5}),new int[] {0, 2, 1 });
            eq(1,(new TheBrickTowerMediumDivTwo()).find(new int[] {4, 4, 4, 4, 4, 4, 4}),new int[] {0, 1, 2, 3, 4, 5, 6 });
            eq(2,(new TheBrickTowerMediumDivTwo()).find(new int[] {2, 3, 3, 2}),new int[] {0, 3, 1, 2 });
            eq(3,(new TheBrickTowerMediumDivTwo()).find(new int[] {13, 32, 38, 25, 43, 47, 6}),new int[] {0, 6, 3, 1, 2, 4, 5 });
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

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class BinPackingEasy {
    public int minBins(int[] item) {
        int res=0;
        boolean found=true;
    	boolean mark[]=new boolean[item.length];
        while(found){
        	found=false;
        	int max =0;
        	int a=-1,b=-1,c=-1;
        	for (int i = 0; i < item.length; i++) {
        		if(mark[i])continue;
    			for (int j = i+1; j < item.length; j++) {
    				if(mark[j])continue;
    				int s = item[i]+item[j];
					if(s>max && s<=300){
						max=s;
						a=i;b=j;
					}
    			}
    		}
        	if(a!=-1){
        		found=true;
        		mark[a]=true;
        	}
			if(b!=-1){
				found=true;
				mark[b]=true;    		
			}
			if(c!=-1){
				found=true;
				mark[c]=true;
			}
			if(!found){
				break;
			}else
				res++;
        }

    	for (int i = 0; i < item.length; i++) {
    		if(!mark[i])res++;
    	}
        return res;
    }

    int [] it;
    int []memo;
    
    int go(int i, int c, long s){
    	if(i==it.length){
    		return 0;
    	}
    	if(memo[i]==-1){
    		int a = it[i]+go(i+1,c, i|s);
    		
    		int b = go(i+1,c, s);
    		if(a<=c){
    			b = max(a,b);
    		}
    		memo[i]=b;
    	}
    	return memo[i];
    }
// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new BinPackingEasy()).minBins(new int[] {150, 150, 150, 150, 150}),3);
            
            eq(1,(new BinPackingEasy()).minBins(new int[] {130, 140, 150, 160}),2);
            eq(2,(new BinPackingEasy()).minBins(new int[] {101, 101, 101, 101, 101, 101, 101, 101, 101}),5);
            eq(3,(new BinPackingEasy()).minBins(new int[] {101, 200, 101, 101, 101, 101, 200, 101, 200}),6);
            eq(4,(new BinPackingEasy()).minBins(new int[] {123, 145, 167, 213, 245, 267, 289, 132, 154, 176, 198}),8);
            eq(4,(new BinPackingEasy()).minBins(new int[] {263, 235, 133, 144, 253, 128, 223, 113, 135, 250, 107, 264, 219, 182, 130, 123, 147, 253, 173, 219, 132, 174, 259, 268, 124, 148, 117, 221, 265, 172, 161, 126, 101, 126, 254, 170, 203, 237, 222, 126, 170, 207, 185, 160, 193, 264, 268, 221, 159, 164}),36);
            
            eq(0,(new BinPackingEasy()).minBins(new int[] {300,101}),2);
            eq(0,(new BinPackingEasy()).minBins(new int[] {300}),1);
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

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class CentaurCompanyDiv2 {
    public long count(int[] a, int[] b) {
//        long res;
        uf=new uf();
        this.a=a;
        this.b=b;
        for (int i = 0; i < b.length; i++) {
//        	a[i]=1;
//        	a[i]=1;
			uf.union(a[i],b[i]);
			ab[a[i]][b[i]]=1;
		}
        long res =go(0,new ArrayList<Integer>());
//        for (int i = 1; i <=50; i++) {
//        	res+=go(i);
//		}
        return 1+res;
    }
    int [][] ab=new int [51][51];
    uf uf;
    int []a,b;
    long go(int i, ArrayList<Integer> arr){
    	if(i==uf.data.length){
    		return ok(arr)?1:0;
    	}
    	print(i);
    	long res=0;
    	if(ab[pi][i]==1){
    		
    	}
//    	ArrayList<Integer> ar2=new ArrayList<Integer>(arr);
//    	ar2.add(i);
    	res+=go(i+1,arr)+go(i+1,arr);
    	return res;
    }
    boolean ok(ArrayList<Integer>ar){
    	if(ar.isEmpty())
    		return false;
    	for (int i = 1; i < ar.size(); i++) {
			if(!uf.connect(ar.get(0), ar.get(i)))
				return false;
		}
    	return true;
    }
    class uf{
    	int data[];
    	int N=51;
    	uf(){
    		data=new int[N];
    		for (int i = 0; i < data.length; i++) {
    			data[i]=i;
    		}
    	}
    	int find(int i){
    		return data[i];
    	}

    	public void union(int p,int q){
    		int rootFirst = data[p];
    		int rootSecond = data[q];
    		for (int i = 0; i < data.length; i++) {
    			if(data[i]==rootFirst)
    				data[i]=rootSecond;
    		}
    	}

    	public boolean connect(int p,int q){
    		return data[p]==data[q];
    	}
    	void print(Object... ob){
    		System.err.println(Arrays.deepToString(ob));
    	}
    	void printData(){
    		String s = Arrays.deepToString(new Object[]{data});
    		s=s.replace(",", "");
    		s=s.replaceAll("\\[", "");
    		s=s.replaceAll("\\]", "");
    		System.err.println(s);
    	}
    }

// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new CentaurCompanyDiv2()).count(new int[] {1}, new int[] {2}),4L);
            eq(1,(new CentaurCompanyDiv2()).count(new int[] {2,2}, new int[] {1,3}),7L);
//            eq(2,(new CentaurCompanyDiv2()).count(new int[] {1,2,3,4,5,6,7,8,9}, new int[] {2,3,4,5,6,7,8,9,10}),56L);
//            eq(3,(new CentaurCompanyDiv2()).count(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, new int[] {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51}),1125899906842675L);
//            eq(4,(new CentaurCompanyDiv2()).count(new int[] {10, 7, 2, 5, 6, 2, 4, 9, 7}, new int[] {8, 10, 10, 4, 1, 6, 2, 2, 3}),144L);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
	private static void print(Object... rs) {
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


    
    static String expected = "  expe";
    static String received = "  rc";
// END CUT HERE
}

// BEGIN CUT HERE

// END CUT HERE

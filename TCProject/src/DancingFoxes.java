import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class DancingFoxes {
    public int minimalDays(String[] friendship) {
        int res;
        if(friendship[0].length()!=friendship.length)
        	return 1212;
        Queue<node> Q = new LinkedList<DancingFoxes.node>();
        Q.add(new node(0,1));
        boolean [] memo = new boolean[friendship.length];
        int N  = friendship.length;
        int c[]=new int[50];
        c[0]=1;
        c[1]=0;
        c[2]=1;
        c[3]=2;
        c[4]=3;
        for (int i = 5; i < c.length; i++) {
        	c[i]=i/3+c[i-2];
		}
        for (int i = 0; i < c.length; i++) {
			
		}
        while(!Q.isEmpty()){
        	node p=Q.poll();
        	if(p.x==1){
//        		pr(p.c);
        		res=0;
        		int xx=p.c;
        		while(xx>2){
        			xx=xx-(xx/3);
        			res++;
        		}
//        		if(xx==2)
//        			res++;
        		return res;
        	}
        	for (int i = 0; i < friendship.length; i++) {
				if(friendship[p.x].charAt(i)=='Y'){
					if(!memo[i]){
						memo[i]=true;
						Q.add(new node(i,p.c+1));
					}
				}
			}
        }
        return -1;
    }
    
    class node{
    	int x, c;
    	public node(int x, int c) {
			this.x=x;
			this.c=c;
		}
    }
    
// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new DancingFoxes()).minimalDays(new String[] {"NNY",
                "NNY",
                "YYN"}),1);
            eq(1,(new DancingFoxes()).minimalDays(new String[] {"NNNNN",
                "NNYYY",
                "NYNYY",
                "NYYNY",
                "NYYYN"}),-1);
            eq(2,(new DancingFoxes()).minimalDays(new String[] {
            	"NNYYNN",
                "NNNNYY",
                "YNNNYN",
                "YNNNNY",
                "NYYNNN",
                "NYNYNN"}),2);
            eq(3,(new DancingFoxes()).minimalDays(new String[] {"NNYNNNNYN",
                "NNNNYNYNN",
                "YNNYNYNNN",
                "NNYNYNYYN",
                "NYNYNNNNY",
                "NNYNNNYNN",
                "NYNYNYNNN",
                "YNNYNNNNY",
                "NNNNYNNYN"}),3);
            eq(4,(new DancingFoxes()).minimalDays(new String[] {"NY",
                "YN"}),0);
            eq(4,(new DancingFoxes()).minimalDays(new String[] {
            		"NNYNNNNNN",
            		"NNNNNNNNY",
            		"YNNYNNNNN",
            		"NNYNYNNNN",
            		"NNNYNYNNN",
            		"NNNNYNYNN",
            		"NNNNNYNYN",
            		"NNNNNNYNY",
            		"NYNNNNNYN",
            	}),0);
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

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class NegativeGraphDiv2 {
    public long findMin(int N, int[] s, int[] t, int[] weight, int charges) {
        long res;
        HashMap<Integer, node> map = new HashMap<Integer, NegativeGraphDiv2.node>();
        for (int i = 0; i < N; i++) {
			map.put(i+1, new node(i+1));
		}
        for (int i = 0; i < s.length; i++) {
			map.get(s[i]).nexts.add(new edge(weight[i],map.get(t[i])));
        }
        
        PriorityQueue<st> Q = new PriorityQueue<st>(2500, new Comparator<st>() {
        		@Override
        		public int compare(st a, st b) {
//        			return a.w-b.w;
        			return 0;
        		}
		});
//        pr(map);
        Q.add(new st(1,charges,0));
        int min=1<<30;
        int memo [][][] = new int[51][51][1001];
        HashSet<String > memox = new HashSet<String>();
        while(!Q.isEmpty()){
//        	pr(Q);
//        	pr(memox);
        	st q = Q.poll();
        	if(q.a==N){
        		min = min(min,q.w);
        	}
        	node n = map.get(q.a);
        	for (edge e : n.nexts) {
//        		pr(e);
        		String m = q.a+" "+e.next.a + " "+ q.chargesLeft+" "+e.w;
        		String m2 = q.a+" "+e.next.a + " "+ (q.chargesLeft-1)+" "+e.w;
        		if(!memox.contains(m)){
//				if(memo[q.a][e.next.a][q.chargesLeft]==0){
//					memo[q.a][e.next.a][q.chargesLeft]=1;
        			memox.add(m);
					st nextSt = new st(e.next.a, q.chargesLeft, q.w+e.w);
					Q.add(nextSt);
				}
				if(q.chargesLeft>0 && !memox.contains(m2)){
					memox.add(m2);
					st nextSt = new st(e.next.a, q.chargesLeft-1, q.w + -e.w);
					Q.add(nextSt);
				}
			}
        }
        
        return min;
    }
    
    void go(int a, int chargesLeft){
    	
    	
    }

    class st{
    	int a,chargesLeft,w;
    	public st(int a, int ch, int w) {
			this.a=a;
			this.chargesLeft=ch;
			this.w=w;
		}
    	@Override
    	public String toString() {
    		// TODO Auto-generated method stub
    		return a+" "+w+" ch="+chargesLeft;
    	}
    }
    
    class edge{
    	int w;
    	node next;
    	public edge(int w, node next) {
			this.w=w;
			this.next=next;
		}
    	@Override
    	public String toString() {
    		// TODO Auto-generated method stub
    		return w+"-"+next;
    	}
    }
    class node{
    	ArrayList<edge> nexts=new ArrayList<edge>();
    	int a;
    	public node(int t) {
    		a=t;
		}
    	@Override
    	public String toString() {
    		// TODO Auto-generated method stub
    		return a+" "+nexts;
    	}
    }
// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new NegativeGraphDiv2()).findMin(3, new int[] {1,1,2,2,3,3}, new int[] {2,3,1,3,1,2}, new int[] {1,5,1,10,1,1}, 1),-9L);
            eq(1,(new NegativeGraphDiv2()).findMin(1, new int[] {1}, new int[] {1}, new int[] {100}, 1000),-100000L);
            eq(2,(new NegativeGraphDiv2()).findMin(2, new int[] {1,1,2}, new int[] {2,2,1}, new int[] {6,1,4}, 2),-9L);
            eq(3,(new NegativeGraphDiv2()).findMin(2, new int[] {1}, new int[] {2}, new int[] {98765}, 100),-98765L);
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

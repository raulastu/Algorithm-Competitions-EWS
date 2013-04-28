package gcjR1;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class gcjr1_B {

	Scanner in;
	PrintWriter out;
	String inputFile="B-small-attempt1.in",outputFile="B-out1.txt";
	Scanner testsc,realInputsc;
	
	boolean test = false;
	
	public void solve() throws Exception {
		in = test?testsc:realInputsc;
		int cases = parseInt(in.nextLine());
		for (int icase = 0; icase < cases; icase++) {
			int ar[] = na(in.nextLine());
			long E=ar[0], R=ar[1];
			int N=ar[2];
			int arr[]=na(in.nextLine());
//			pr(ar,arr);
			long res2 = solve(E,R,N,arr);
			sort(arr);
			
			long res= 0;
			
			if(R>E){
				pr('X');
				for (int i = 1; i < arr.length; i++) {
					res+=E*arr[i];
				}
				res+=E*arr[0];
			}else{
				res=0;
				for (int i = 0; i < arr.length-1; i++) {
					res+=R*arr[i];
				}
				res+=E*arr[arr.length-1];
			}
			
			if(res!=res2){
				pr("FAILED",res,res2);
			}else
				pr(res,res2);
			
			String r = ("Case #" + (icase + 1) + ": "+res);
			out(r);
		}
		close();
	}
	
	long solve(long E , long R, int N, int[]ar) {
//        long E = sc.nextLong();
//        long R = sc.nextLong();
        if (R > E) R = E;
//        int N = sc.nextInt();
        long[] v = new long[N];
        Pair[] p = new Pair[N];
        for (int i=0; i<N; i++) {
            v[i] = ar[i];
            p[i] = new Pair(v[i], i);
        }
        boolean[] was = new boolean[N];
        long[] from = new long[N];
        long[] to = new long[N];
        Arrays.sort(p);
        long ans = 0;
        for (int i=0; i < N; i++) {
            int pos = p[i].pos;
            from[pos] = E;
            for (int j=0; j < pos; j++) if (was[j]) from[pos] = Math.min(from[pos], to[j] + (pos - j) * R);
            to[pos] = 0;
            for (int j=pos+1; j < N; j++) if (was[j]) to[pos] = Math.max(to[pos], from[j] - (j - pos) * R);
            ans += (from[pos] - to[pos]) * p[i].value;
            was[pos] = true;
        }
        return ans;
    }
	
	   class Pair implements Comparable<Pair> {
	        long value;
	        int pos;
	        public Pair(long value, int pos) {
	            this.value = value;
	            this.pos = pos;
	        }
	        public int compareTo(Pair other) {
	            if (this.value < other.value) return 1;
	            if (this.value > other.value) return -1;
	            return 0;
	        }
	    }
	   
	public static void main(String[] args) throws Exception {
		
		new gcjr1_B().solve();
	}
	public gcjr1_B() throws Exception {
		if(!test)
			realInputsc = new Scanner(new File("/Users/rc/test1/"+inputFile));
		else
			testsc = new Scanner(new File("src/B_example"));
		
		String outFile = "/Users/rc/test1/" + outputFile;
		if(!test)
			out = new PrintWriter(new File(outFile));
	}
	private void close() {
		if(!test){
			out.close();
		}
		in.close();
	}

	void pr(Object... ob) {
//		if (test)
			System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}

	void out(String r) {
		if(!test)
			out.println(r);
		
		System.out.println(r);
	}

	int[] na(String ar) {
		String[] r = ar.split(" +");
		int[] res = new int[r.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = Integer.parseInt(r[i]);
		}
		return res;
	}
}
package gcjR1B;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.w3c.dom.Node;

public class gcjr1_A {

	Scanner in;
	PrintWriter out;
	String inputFile="A-large-practice.in",outputFile="A-out1-large-practice.txt";
	Scanner testsc,realInputsc;
	
	boolean test = false;
	
	public void solve() throws Exception {
		in = test?testsc:realInputsc;
		int cases = parseInt(in.nextLine());
		for (int icase = 1; icase <= cases; icase++) {
			String res="";
			long []l1=na(in.nextLine());
			long A=l1[0];
			long N=l1[1];
			long ar[]=na(in.nextLine());
			sort(ar);
			
			long aa = 1000000000000L;
			
			this.ar=ar;
			dp=new long[ar.length];
			fill(dp,-1);
			memo = new HashMap<>();
			long r = go(0,A);
			String rr = ("Case #" + icase + ": "+r);
			out(rr);
		}
		close();
	}
	long ar[];
	long dp[];
	HashMap<String,Long> memo;
	long go(int i, long x){
		if(i==ar.length)
			return 0;
//		pr(i,x);
		if(!memo.containsKey(i+" "+x)){
			long r=0;
			if(x>ar[i]){
				r=go(i+1,x+(long)ar[i]);
			}else{
				r = 1L+go(i+1,x);
				if(x-1>0)
					r = min(r,1+go(i,2L*x-1L));
			}
			memo.put(i+" "+x,r);
//			dp[i]=r;
		}
		return memo.get(i+" "+x);
	}
	
	class node{
		long a,b,c;
		public node(long a,long b, long c) {
			this.a=a;
			this.b=b;
			this.c=c;
		}
	}
	
	// IO
	public static void main(String[] args) throws Exception {
		
		new gcjr1_A().solve();
	}
	public gcjr1_A() throws Exception {
		if(!test)
			realInputsc = new Scanner(new File("/Users/rc/test1/"+inputFile));
		else
			testsc = new Scanner(new File("src/A_example"));
		
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

	long[] na(String ar) {
		String[] r = ar.split(" +");
		long[] res = new long[r.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = Long.parseLong(r[i]);
		}
		return res;
	}
}
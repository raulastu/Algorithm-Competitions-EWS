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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.w3c.dom.Node;

public class gcjr1_A {

	Scanner in;
	PrintWriter out;
	String inputFile="A-large.in",outputFile="A-out2-large.txt";
	Scanner testsc,realInputsc;
	
	boolean test = false;
	
	public void solve() throws Exception {
		in = test?testsc:realInputsc;
		int cases = parseInt(in.nextLine());
		HashMap<String,Long> map = new HashMap<String, Long>();
		for (int icase = 1; icase <= cases; icase++) {
			long ar[] = na(in.nextLine());
//			pr(ar);
//			long r=1;
//			long t=2000000000000000000L;
			long r=ar[0];
			long t=ar[1];
//			t*=PI;
			long res=0;
//			pr(t,getPaint(r));
			pr(r,t);
			
			
			for(int i=100;i>0;i--){
				long xx=0;
				while(t>=(xx=getPaint(r))){
					t-=xx;
					res++;
					r+=2;
				}
			}
//			Queue<node> Q = new LinkedList<node>();
////			long res =0;
//			Q.add(new node(t,r));
//			while(!Q.isEmpty()){
//				node p=Q.poll();
//				res++;
//				if(p.a>((p.b<<1)+1)){
//					Q.add(new node(p.a-(p.b<<1)+1,p.b+2));
//				}
//			}
//			res = go(t,r);
//			map.put("", value)
			String rr = ("Case #" + icase + ": "+res);
			out(rr);
		}
		close();
	}
	class node{
		long a,b;
		public node(long a,long b) {
			this.a=a;
			this.b=b;
		}
	}
	long go(long t, long r){
		if(t<((r<<1)+1)){
			return 0;
		}
		return 1+go(t-((r<<1)+1),r+2);
	}
//	double getVal(double r){
//		return 
//	}
	long getPaint(long r){
		long rx=(r<<1)+1;
		return rx;
	}

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
		if (test)
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
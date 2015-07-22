package gcj15Qual;

import static java.lang.Integer.parseInt;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class gcjr1_A {

	Scanner in;
	PrintWriter out;
	String inputFile="B-small-attempt1.in",outputFile="B-small-attempt2.txt";
	Scanner testsc,realInputsc;
	
	boolean test = true;
	
	public boolean can(int mins, int []a) throws Exception{
		ArrayList<Integer> Q = new ArrayList<Integer>();
		int c = 0 ;
		for (int j = 0; j < a.length; j++) {
			c+=a[j];
		}
		
		for (int i = 0; i < a.length; i++) {
			Q.add(a[i]);
		}
//		pr(mins,Q);
		long ac = 0;
		Collections.sort(Q);
		pr(mins);
		for(int i=0; i<=mins;i++){
			pr(i,Q);
			Integer l = Q.get(Q.size()-1);
//			System.out.println(Q);
			if(l==0)break;
//			pr("x",mins,l);
			if(l+i<=mins){
				int cc = 0 ;
				for (int j = 0; j < Q.size(); j++) {
					cc+=Q.get(j);
				}
				if(cc!=c){
//					System.err.println(cc);
//					System.err.println(c);
					throw new Exception();
//					System.err.println("xxxxxx");
				}
				pr(Q);
				return true;
			}
			Q.remove(Q.size()-1);
			Integer aa = (l)/2;
			Integer bb = (l+1)/2;
			Q.add(aa);
			Q.add(bb);
			Collections.sort(Q);
		}
		return false;
	}
	
	public void solve() throws Exception {
		in = test?testsc:realInputsc;
		int cases = parseInt(in.nextLine());
		HashMap<String,Long> map = new HashMap<String, Long>();
		for (int icase = 1; icase <= cases; icase++) {
			in.nextLine();
			int ar[] = na(in.nextLine());
			int r= 1000;
			for (int i = 1; i <= 1000; i++) {
				if(can(i,ar)){
					r = i;
					break;
				}
			}
			String rr = ("Case #" + icase + ": "+r);
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

	int[] na(String ar) {
		String[] r = ar.split(" +");
		int[] res = new int[r.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = Integer.parseInt(r[i]);
		}
		return res;
	}
}
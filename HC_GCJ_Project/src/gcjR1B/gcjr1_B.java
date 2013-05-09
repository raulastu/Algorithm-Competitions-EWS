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
import java.util.Scanner;

public class gcjr1_B {

	Scanner in;
	PrintWriter out;
	String inputFile="B-small-practice.in",outputFile="B-out1.txt";
	Scanner testsc,realInputsc;
	
	boolean test = true;
	
	public void solve() throws Exception {
		in = test?testsc:realInputsc;
		int cases = parseInt(in.nextLine());
		for (int icase = 0; icase < cases; icase++) {
			int ar[] = na(in.nextLine());
			int N=ar[0];
			int X=ar[1];
			int Y=ar[2];
			m = new int[C*2][C*2];
//			pr(m);
			
//			pr(rr);
//			pr(m);
//			rr=m[0][C-2]+;
			if(abs(X)>20 || abs(Y)>20){
				String r = ("Case #" + (icase + 1) + ": "+0.0);
				out(r);
			}
			else {
				if(X==0){
					int d2=1;
					for (int i = 1; i <= Y; i++) {
						d2+=1+pow(2,i+1);
					}
//					pr("d2",d2);
					if(d2<N){
						String r = ("Case #" + (icase + 1) + ": "+0.0);
						out(r);
					}else{
						go(0,0,N-1);
						String r = ("Case #" + (icase + 1) + ": "+(m[Y][X+C]/(double)m[0][C]));
						out(r);	
					}
				}else{
					go(0,0,N-1);
					String r = ("Case #" + (icase + 1) + ": "+(m[Y][X+C]/(double)m[0][C]));
					out(r);
				}
			}
//			pr(m);
		}
		close();
	}
	int C=20;
	int m[][];
	int go(int x, int y, int n){
		if(n<=0){
			m[y][x+C]++;
			return 1;
		}
//		pr(x,y);
//		m[y][x+C]++;
		int r=0;
		if(x==0){
			if(y==0){
				r+=go(2,0,n-1);
				r+=go(-2,0,n-1);
			}else{
				r+=go((y+2),0,n-1);
				r+=go(-(y+2),0,n-1);
			}
		}else{
			if(x<0)
				r+=go(x+1,y+1,n-1);
			else
				r+=go(x-1,y+1,n-1);
			r+=go(-x,y,n-1);
		}
//		pr(x,y,r);
		m[y][x+C]+=r;
		return r;
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
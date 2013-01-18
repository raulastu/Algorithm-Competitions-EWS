package programmingchallenges;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import java.io.PrintWriter;
import java.util.*;

public class _100_3NPlus1 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(in.hasNext()){
			int a = in.nextInt();
			int b = in.nextInt();
			int aa=min(a,b);
			int bb=max(a,b);
			long res = 0;
//			go(1000000-1);
			for (int i = aa; i <= bb; i++) {
				res=max(go2(i),res);
			}
			System.out.println(a+" "+b +" "+res);
		}
		in.close();
		out.close();
	}
	//Why this does not work?
	static long go(long n){
//		System.err.println(n);
		if(n==1)
			return 1;
		if(n%2!=0)
			return go((n*3+1)/2)+2;
		else
			return go(n/2)+1;
	}
	
	static long go2(long n){
//		System.err.println(n);
		long r=1;
		long n2=n;
		while(n2!=1){
			if(n2%2==0){
				n2/=2;
			}else{
				n2=(n2*3+1)/2;
				r++;
			}
			r++;
		}
		return r;
	}
	// 999999 1000000
	// 1 999999
	
	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}
}

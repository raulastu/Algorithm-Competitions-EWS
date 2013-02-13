
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

import javax.swing.text.AbstractDocument.LeafElement;

public class A {

	long mod=1000000007;
	long[]fact;
	public void solve() {
		fact=new long[10001];
		fact[1]=fact[0]=1;
		for (int i = 2; i < fact.length; i++) {
			fact[i]=(i*fact[i-1])%mod;
		}
		print(fact);
		int r = readInt();
		for (int n = 1; n <= r; n++) {
			int []rc=readIntArray();
			int N=rc[0];
			int K=rc[1];
//			int N=10000;
//			int K=5000-1;
			arr=readIntArray();
//			arr=readIntArray2();
			sort(arr);
			int xi=1;
			long res=0;
			
			memo=new int[N+1][K+1];
			for (int i = arr.length-1; i>=0; i--) {
				long rx=fact(N-xi,K-1);
				res=(res+arr[i]*rx)%mod;
				if(N-xi==K-1)
					break;
				xi++;
			}
			out.println("Case #"+n+": "+res);
			System.out.println("Case #"+n+": "+res);
		}
	}
	long fact(int N,int M){
		if(N==M)return 1;
		long r = fact[N]/((fact[M]*(fact[N-M]))%mod);
		return r;
	}
	int memo[][];
	int arr[];
	
	long bin(int N, int K, int i){
		if(memo[N][K]==-1){
			if(N==K)return arr[i]%mod;
			if(K==1)return (((long)N)*(long)arr[i])%mod;
			long r = bin(N-1,K-1,i)+bin(N-1,K,i);
//			print(N,K,i,r);
			memo[N][K]=(int)(r%mod);
		}
//		r=r*number;
//			return r;
		return memo[N][K];
	}
	A(){
//		in = new Scanner(System.in);
//		out = new PrintWriter(System.out);
		try {
			
//			in = new Scanner(new File("A_in.txt"));
			in = new Scanner(new File("card_game (3).txt"));
			out = new PrintWriter(new File("A_out.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new A().solve();
		close();
	}

	static Scanner in;
	static PrintWriter out;

	static int readInt(){
		return parseInt(in.nextLine());
	}
	static int[] readIntArray(){
		String l[] = in.nextLine().split(" ");
		int[] r=new int[l.length];
		for (int i = 0; i < l.length; i++) {
			r[i]=parseInt(l[i]);
		}
		return r;
	}
	static int[] readIntArray2(){
//		String l[] = in.nextLine().split(" ");
		int[] r=new int[10000];
		fill(r,2000000000);
		return r;
	}
	
	static void print(Object... ob) {
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}


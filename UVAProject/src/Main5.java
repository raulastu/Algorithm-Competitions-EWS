

import java.util.*;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class Main5 {
	public void solve() {
		int N= in.nextInt();
		int Q= in.nextInt();
		A = new int[N];
		int n = 2*1<<(int)((Math.log(N) / Math.log(2) + 1));
//		print(n);
		T = new int[n];
		build(1,0,N-1);
//		print(T);
		for (int i = 0; i < Q; i++) {
			int opt = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			if(opt==0){
				update2(1,0,N-1,a,b);
			}else{
				System.out.println(query(1,0,N-1,a,b));
			}
//			print(A,T);
		}
	}
	
	class SegmentTree{
		
	}
	int A[];
	int T[];
	void build(int node, int a, int b){
//		print(node, a, b);
		if(a==b){
			T[node]=(A[b]%3==0?1:0);
			return;
		}
		build(node*2,a,(a+b)/2);
		build(node*2+1,(a+b)/2+1,b);
		T[node]=T[node*2]+T[node*2+1];
	}
	
	void update(int node, int a, int b, int i, int j){
//		print(node, a, b);
		if(b==a){
			A[i]++;
			T[node]=A[i]%3==0?1:0;
		}else if(i>b || j<a)
			return;
		else{
			update(node*2,a,(a+b)/2,i,j);
			update(node*2+1,(a+b)/2+1,b,i,j);
			T[node]=T[node*2]+T[node*2+1];
		}
	}
	
	void update2(int node, int a, int b, int i, int j){
		if(b<i || a>j)
			return ;
		if(a==b){
			T[node]=(++A[b])%3==0?1:0;
			return;
		}
		update2(node*2, a,(a+b)/2,i,j);
		update2(node*2+1, (a+b)/2+1,b,i,j);
		T[node]=T[node*2]+T[node*2+1];
	}
	
	int query(int node, int a, int b, int i, int j){
		if(b<i || a>j)
			return -1;
		if(a>=i && b<=j)
			return T[node];
		int p1 = query(node*2, a,(a+b)/2,i,j);
		int p2 = query(node*2+1, (a+b)/2+1,b,i,j);
		if(p1==-1)
			return p2;
		if(p2==-1)
			return p1;
		return p2+p1;
	}
	
	
	Main5(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new Main5().solve();
		close();
	}

	static Scanner in;
	static PrintWriter out;

	static int readInt(){
		return in.nextInt();
//		return parseInt(in.nextInt());
	}
	static int[] readIntArray(){
		String l[] = in.nextLine().split(" ");
		int[] r=new int[l.length];
		for (int i = 0; i < l.length; i++) {
			r[i]=parseInt(l[i]);
		}
		return r;
	}
	
	static void print(Object... ob) {
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}

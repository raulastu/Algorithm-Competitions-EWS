package segment_tree.MULTQ3;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class Main {
	public void solve() {
		int N = ni(), Q = ni();
		T = new int[N<<2][3];
		L = new int[N<<2];
		build(1,0,N-1);
//		pr(T);
		for (int i = 0; i < Q; i++) {
			int opt=ni();
			int from = ni();
			int to = ni();
			if(opt==1){
				out.println(query(1,0,N-1,from,to));
			}else{
				update(1,0,N-1,from,to);
			}
			pr(T,L);
		}
//		out.println(01);
	}
	int T[][];
	int L[];
	
	void build(int node, int b, int e){
//		System.err.println(node);
		int l=node<<1;int r=l+1; int m=(b+e)>>1;
		if(b==e){
			T[node][0]++;
			return;
		}
		build(l,b,m);
		build(r,m+1,e);
		T[node][0]=T[r][0]+T[l][0];
	}
	void pull(int node, int l, int r){
		T[node][0]=T[r][0]+T[l][0];
		T[node][1]=T[r][1]+T[l][1];
		T[node][2]=T[r][2]+T[l][2];
	}
	void push(int node, int b, int e){
		int n = L[node]%3;
		if(n>0){
			if(b!=e){
				L[node<<1]+=n;
				L[(node<<1)+1]+=n;
			}
			if(n==1){
				swap(T[node],1,2); // 0,1,2 ->2 0 1
				swap(T[node],0,1);
			}else{
				swap(T[node],0,1); // 0,1,2 ->1 2 0
				swap(T[node],2,1);
			}
			L[node]=0;
		}
	}
	void swap(int a[], int i, int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	int query(int node, int b, int e, int i, int j){
		int l = node<<1; int r=l+1; int m=(b+e)>>1;
		push(node,b,e);
		if(e<i||b>j)
			return 0;
		if(i<=b && e<=j){
			return T[node][0];
		}
		
		int l1 = query(l,b,m,i,j);
		int l2 = query(r,m+1,e,i,j);
		pull(node,l,r);
		return l1+l2;
	}
	void update(int node, int b, int e, int i, int j){
		int l = node<<1; int r=l+1; int m=(b+e)>>1;
//		push(node,b,e);
		if(i>e || j<b)
			return;
		if(i<=b && e<=j){
			L[node]++;
			push(node,b,e);
			return;
		}
		update(l,b,m,i,j);
		update(r,m+1,e,i,j);
//		pull(node,l,r);
	}
	

	void run() throws Exception {
		oj=true;
		in = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);

		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}

	public static void main(String[] args) throws Exception {new Main().run();}

	InputStream in;
	PrintWriter out;
	String INPUT = "";
	
	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	private byte[] inbuf = new byte[1024];
	private int lenbuf = 0, ptrbuf = 0;

	private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = in.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	private boolean isSpaceChar(int c) {return !(c >= 33 && c <= 126);}
	private int skip() {int b;while ((b = readByte()) != -1 && isSpaceChar(b));return b;}

	String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != // ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}
	
	
	private int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	long nl(){
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	void pr(Object... ob) {
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}


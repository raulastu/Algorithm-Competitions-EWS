package contest100;


import java.util.*;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _C {

	public void solve() {
		int N = ni(), Q= ni();
		int[] a= na(N);
		T = new int[N*4];
		lp = new int[N*4];
		a2=new int[N];
		for (int i = 0; i < Q; i++) {
			int l=ni()-1;
			int r=ni()-1;
			update(1,0,N-1,l,r);
		}
		query(1,0,N-1);
		a=radixSort(a);
		a2=radixSort(a2);
//		pr(a,a2);
		long r=0;
		for (int i = 0; i < a.length; i++) {
			r+=((long)a[i]*(long)a2[i]); 
		}  
		out.println(r); 
//		pr(a,a2); 
	}     
	      
	  
	public static int[] radixSort(int[] f)
	{   
		int[] to = new int[f.length]; 
		{
			int[] b = new int[65537];
			for(int i = 0;i < f.length;i++)b[1+(f[i]&0xffff)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < f.length;i++)to[b[f[i]&0xffff]++] = f[i];
			int[] d = f; f = to;to = d;
		}
		{
			int[] b = new int[65537];
			for(int i = 0;i < f.length;i++)b[1+(f[i]>>>16)]++;
			for(int i = 1;i <= 65536;i++)b[i]+=b[i-1];
			for(int i = 0;i < f.length;i++)to[b[f[i]>>>16]++] = f[i];
			int[] d = f; f = to;to = d;
		}
		return f;
	}

	int[] a2;
	int[]T;
	int[]lp;
	void query(int node, int a, int b){
		push(node, a, b);
		if(a==b){
			a2[b]=T[node];
			return;
		}
		int l=node*2,r=l+1,mid=(a+b)>>1;
		query(l,a,mid);
		query(r,mid+1,b);
//		T[node]=T[l]+T[r];
	}
	void push(int node , int a, int b){
		if(lp[node]>0){
			int l=node*2,r=l+1;
			if(a!=b){
				lp[l]+=lp[node];
				lp[r]+=lp[node];
			}
			T[node]+=lp[node];
			lp[node]=0;
		}
	}
	
	void update(int node, int a, int b, int i, int j){
		
		if(a>b || i>b || a>j)
			return;
		
//		print(node, a, b, mid, i, j);
//		push(node, a, b);
		
		if(a>=i && b<=j){
			lp[node]++;
//			push(node, a, b);
			return;
		}
		int l=node*2,r=l+1,mid=(a+b)>>1;
		update(l,a,mid,i,j);
		update(r,mid+1,b,i,j);
//		T[node]=T[l]+T[r];
	}

	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	
	void run() throws Exception{
		in = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis()-s+"ms");
	}
	
	public static void main(String[] args) throws Exception { new _C().run();}

	InputStream in;
	PrintWriter out;
	String INPUT = "";

	private byte[] inbuf = new byte[1024];
	private int lenbuf = 0, ptrbuf = 0;
	
	private int readByte(){
		if(lenbuf == -1)throw new InputMismatchException();
		if(ptrbuf >= lenbuf){
			ptrbuf = 0;
			try { lenbuf = in.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
			if(lenbuf <= 0)return -1;
		}
		return inbuf[ptrbuf++];
	}
	
	private int ni(){
		int num = 0, b;
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
	
	
	private int[] na(int n){
		int[] a = new int[n];
		for(int i = 0;i < n;i++)a[i] = ni();
		return a;
	}
	

	private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
	private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
	
	private String ns(){
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	
	private char[] ns(int n){
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	private long nl(){
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
		if(!oj) System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}

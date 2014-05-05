import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _426_C_Sereja_and_Swaps {
	//->solution screencast http://youtu.be/oHg5SJYRHA0
	public void solve() {
		int n = ni(), k=ni();
		ar=na(n);
		dp = new int[n+1][k+1];
		maxx=-1000;
		for (int i = 0; i < ar.length; i++) {
			if(ar[i]<0)
				maxx=max(maxx,ar[i]);
		}
		for (int i = 0; i < dp.length; i++) {
			fill(dp[i],-1001);
		}
		int x = go(0,k);
		out.println(x);
	}
	int maxx;
	int []ar;
	int dp[][];
	
	int go(int i,int k){
		pr(i,k);
		if(i==ar.length || k<=0){
			return maxx;
		}
		int maxa=-1000,maxb=-1000,max=-1000;
//		if(dp[i][k]==-1001){
			
			if(ar[i]<0 ){
				go(i+1, k);
			}else{
				max=getMax(ar);
				go(i+1, k);
				if(i-1>=0 && ar[i-1]<0){
					pr("back",i-1,i);
					int a = ar[i];
					ar[i]=ar[i-1];
					ar[i-1]=a;
					pr(ar);
					maxa=getMax(ar);
					pr("ahead",i-1,i,maxb);
					go(0, k-1);
					a = ar[i];
					ar[i]=ar[i-1];
					ar[i-1]=a;
				}
				if(i+1<ar.length && ar[i+1]<0){
					int a = ar[i];
					ar[i]=ar[i+1];
					ar[i+1]=a;
					maxb=getMax(ar);
					pr(ar);
					pr("ahead",i+1,i,maxb);
					go(0, k-1);
					a = ar[i];
					ar[i]=ar[i+1];
					ar[i+1]=a;
				}
			}
//		}
		return dp[i][k]=max(max,max(maxa,maxb));
	}
	int getMax(int ar[]){
		int maxb=maxx, s=maxx;
		for (int j = 0; j < ar.length; j++) {
			if(ar[j]<0){
				maxb=max(s,maxb);
				s=maxx;
//				if(s!=-1001){
//					s=0;
//				}
			}else{
				if(s==maxx)
					s=0;
				s+=ar[j];
			}	
		}
		maxb=max(s,maxb);
		return maxb;
	}
	
	// IO methods
		
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _426_C_Sereja_and_Swaps().run();}

	InputStream in=System.in;
	PrintWriter out=new PrintWriter(System.out);
	
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

	public String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != // ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	public char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	public char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	public int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}
	
	
	public int ni() {
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
	
	public long nl(){
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

	void pr(Object... ob) {if (!oj)System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));}
}


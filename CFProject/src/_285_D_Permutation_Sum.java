import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _285_D_Permutation_Sum {
	
	public void solve() {
		n = ni();
		int a [] = new int[n];
		int b [] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i]=i+1;
			b[i]=i+1;
		}
		int res = 0;
		sort(a);
		do{
			sort(b);
			do{
				if(check(a,b)){
					res++;
					res%=1000000007;
//					pr(a,b);
				}
			}while(nextPermutation(b));
		}while(nextPermutation(a));
		out.println(res);
	}
	int n = 1;
	boolean check(int[]a,int[]b){
		int x[]=new int[n+1];
		for (int i = 0; i < n; i++) {
			int xx = (a[i]-1+b[i]-1)%n+1;
			if(x[xx-1]!=0){
				return false;
			}
			x[xx-1]++;
		}
//		if(!distinct)return false;
		return true;
	}
	static boolean nextPermutation(int[] src) {
		int i;
		for(i = src.length - 2;i >= 0 && src[i] > src[i + 1];i--)
			;
		if(i == -1)
			return false;
		int j;
		for(j = i + 1;j < src.length && src[i] < src[j];j++)
			;
		int d = src[i];
		src[i] = src[j - 1];
		src[j - 1] = d;
		for(int p = i + 1, q = src.length - 1;p < q;p++, q--){
			d = src[p];
			src[p] = src[q];
			src[q] = d;
		}
		return true;
	}
    
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _285_D_Permutation_Sum().run();}

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


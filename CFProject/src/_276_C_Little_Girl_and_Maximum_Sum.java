import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _276_C_Little_Girl_and_Maximum_Sum {
	
	public void solve() {
		int n = ni(),q=ni();
		int [] ar = na(n); 
		long res = 0;
		T= new int[n];
		MAX=n;
		for (int i = 0; i < q; i++) {
			int a=ni(),b=ni();
			update(a,1);
			update(b+1,-1);
		}
		int [] RT = new int [T.length];
		pr("T",T);
		RT[0]=read(1);
		for (int i = 1; i < RT.length; i++) {
			RT[i]=read(i+1);
		}
		pr("RT",RT); 
		RT= radixSort(RT);
		ar =radixSort(ar);
		pr("RT",RT); 
		for (int i = 0; i < ar.length; i++) {
			res+=((long)ar[i]*(long)RT[i]);
		}
		out.println(res);
	}
	
	int [] T;
	int MAX;
	void update(int idx, int val){
		while(idx<=MAX){
			T[idx-1]+=val;
			idx+=(idx&-idx);
		}
	}
	int read(int idx){
		int r=0;
		while(idx>0){
			r+=T[idx-1];
			idx-=(idx&-idx);
		}
		return r;
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
	// END - solution
	// IO methods
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _276_C_Little_Girl_and_Maximum_Sum().run();}

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
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
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


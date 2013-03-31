import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _284_C_Cows_and_Sequence {
	
	long T[];
	public void solve() {
		pr(Integer.toBinaryString(6));
		pr(Integer.toBinaryString(-6));
		int n = ni();
		long res = 0;
		T = new long[MAX];
		int max=1;
		double total=0;
		for (int i = 0; i < n; i++) {
			int opt=ni();
			if(opt==1){//add tho the first x;
				int a=ni(),x=ni();
				update(1,x);
//				printall(max);
				update(a+1,-x);
//				printall(max);
				total+=(long)((double)x*(double)a);
			}else if(opt==2){
				long k=ni();
				update(max+1,k);
				update(max+2,-k);
				max++;
				total+=k;
			}else if(opt==3){
				long x = read(max);
				total-=x;
				update(max,-x);
				update(max+1,x);
				max--;
			}
//			pr("x");
//			printall(max);
//			out.println(String.format("%.6f",(total/(double)max)));
			out.println(total/(double)max);
		}
	}
//	void printall(int m){
//		long r[]= new long[m+1];
//		for (int i = 1; i <= m; i++) {
//			r[i]=read(i)-read(i-1);
//		}
//		pr("ar",r,"BIT",T);
//	}

	int MAX=200005;
//	int MAX=30;
	void update(int idx,long val){
		while(idx<=MAX){
			T[idx-1]+=val;
			idx+=(idx&-idx);
		}
	}
	long read(int idx){
		long r=0;
		while(idx>0){
			r+=T[idx-1];
			idx-=(idx&-idx);
		}
		return r;
	}
	
	// IO methods
		
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _284_C_Cows_and_Sequence().run();}

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


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;


public class Solution2 {

	int A[];
	int T[];
	public void solve() {
		char[] t = ns().toCharArray();
		char[] s = ns().toCharArray();
		int m=0;
		int minit=0;
		long res=0;
		int N=t.length;
//		pr(t,s);
		for (int i = 0; i < N; i++) {
//			pr(t[i],s[m],i,m);
			if(t[i]==s[0]){
				minit=i;
				m=1;
				if(m==s.length){
					int a = (minit);
					int b =(N-i-1);
					int max=Math.max(a,b);
					pr(a,b,max);
					res+=a*b+max;
					m=0;
					minit=0;
				}
				continue;
			}
			if(t[i]==s[m]){
				m++;
			}
			if(m==s.length){
				int a = (minit);
				int b =(N-i-1);
				int max=Math.max(a,b);
				pr(a,b,max);
				res+=a*b+max;
				m=0;
				minit=0;
			}
		}
		out.println(res+1);
		
	}
	
	void run() throws Exception {
			long s = System.currentTimeMillis();
			solve();
			out.flush();
//			pr(System.currentTimeMillis() - s + "ms");
		}
		public static void main(String[] args) throws Exception {new Solution2().run();}

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

		void pr(Object... ob) {if (!false)System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));}
	
}

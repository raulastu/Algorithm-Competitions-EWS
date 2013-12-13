import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;


public class Main_KMP {

	int A[];
	int T[];
	public void solve() {
		int N = 1000;
		int [] sieve= new int[N];
		int bound = (int)Math.sqrt(N);
		
		for (int i = 1; i < bound; i++) {
			for (int j = i*2; j < N; j+=i) {
				sieve[j]+=i;
			}
		}
		
		int []a=new int[N];
		a[0]=a[1]=0;
		for (int i = 2; i < a.length; i++) {
			a[i]=a[i-1]+sieve[i];
		}
//		pr(a[N-1],a[N-2]);
		pr(sieve,a);
		int T = ni();
		for (int i = 0; i < T; i++) {
			int x=ni();
			out.println(a[x]);
		}
	}
	
	
	int B = 26;
	int m,n;
	int M = 1000000007;

	int mod(int a, int b){
		return (a%b+b)%b;
	}
	
	void find(char [] text, char []pattern){
		m = pattern.length;
		n = text.length;
		int E=1;
		for (int i = m-2; i >=0; i--) {
			E=mod(E*B,M);
		}
		int hp=0;
		for (int i = 0; i < m; i++) {
			hp=mod(hp*B+pattern[i],M);
		}
		int ht = 0;
		for (int i = 0; i < m; i++) {
			ht=mod(ht*B+text[i],M);
		}
		int found=0;
		if(ht==hp)
			for (int i = 0; i < m; i++) 
				if(text[i]!=pattern[i])
					break;
				else if(i==m-1){
					found|=1;
					out.println(i);
				}
					
					
		for (int i = 1; i < n-m+1; i++) {
			ht=mod(ht-mod(text[i-1]*E,M),M);
			ht=mod(ht*B,M);
			ht=mod(ht+text[i+m-1],M);
//			pr(ht);
			if(ht==hp){
					for (int j = 0; j < m; j++){
						if(text[i+j]!=pattern[j])
							break;
						if(j==m-1){
							found|=1;
							out.println(i);
						}
					}
			}
		}
//		pr()
		if(found==1)
			out.println();
	}
	
	void run() throws Exception {
			long s = System.currentTimeMillis();
			solve();
			out.flush();
			pr(System.currentTimeMillis() - s + "ms");
		}
		public static void main(String[] args) throws Exception {new Main_KMP().run();}

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

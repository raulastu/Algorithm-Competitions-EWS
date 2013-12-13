import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;


public class Main222 {

	int pow(int a, int n, int m) {
		if (n == 1)
			return a;
		if ((n & 1) != 0) {
			return (a * pow((a * a) % m, (n - 1) >> 1, m)) % m;
		} else {
			return (pow((a * a) % m, n >> 1, m)) % m;
		}
	}
	
	public void solve() {
		
	}
	int s(int x){
		int s=0;
		while(x>0){
			s+=x%10;
			x/=10;
		}
		return s;
			
	}
	int ar[][];
	boolean is(ArrayList<Integer>s, int i, int c){
		if(c==s.size())
			return true;
		boolean r=false;
		int x = s.get(i);
		for (int j = 0; j < ar.length; j++) {
			if(i==j)continue;
			int y=s.get(j);
			if(ar[x][y]==1){
				r = r && is(s,j,c+1);
			}
		}
		return r;
	}
	
	void build(int node, int b, int e){
//		System.err.println(node);
		int l=node<<1;int r=l+1; int m=(b+e)>>1;
//		pr(node,b,e);
		if(b==e){
			T[node]=A[b];
			return;
		}
		build(l,b,m);
		build(r,m+1,e);
		if (T[l] >= T[r])
            T[node] = T[l];
        else
            T[node] = T[r];
	}
	int query(int node, int b, int e, int i, int j){
		int l = node<<1; int r=l+1; int m=(b+e)>>1;
//		pr(node,b,e,i,j);
		if(e<i||b>j)
			return -1;
		if(i<=b && e<=j){
			return T[node];
		}
		int l1 = query(l,b,m,i,j);
		int l2 = query(r,m+1,e,i,j);
//		pull(node,l,r);
		return l1>l2?l1:l2;
	}
	void run() throws Exception {
			long s = System.currentTimeMillis();
			solve();
			out.flush();
			pr(System.currentTimeMillis() - s + "ms");
		}
		public static void main(String[] args) throws Exception {new Main222().run();}

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

		void pr(Object... ob) {if (!true)System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));}
	
}

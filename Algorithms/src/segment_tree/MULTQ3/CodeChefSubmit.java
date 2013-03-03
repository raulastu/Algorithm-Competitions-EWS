package segment_tree.MULTQ3;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
 
class Parser
{
   final private int BUFFER_SIZE = 1 << 16;
 
   private DataInputStream din;
   private byte[] buffer;
   private int bufferPointer, bytesRead;
 
   public Parser(InputStream in)
   {
      din = new DataInputStream(in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
   }
 
   public int nextInt() throws Exception
   {
      int ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = c == '-';
      if (neg) c = read();
      do
      {
         ret = ret * 10 + c - '0';
         c = read();
      } while (c > ' ');
      if (neg) return -ret;
      return ret;
   }
 
   private void fillBuffer() throws Exception
   {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) buffer[0] = -1;
   }
 
   private byte read() throws Exception
   {
      if (bufferPointer == bytesRead) fillBuffer();
      return buffer[bufferPointer++];
   }
}
 
public class CodeChefSubmit {
 
	static Parser in = new Parser(System.in);
	static PrintWriter out = new PrintWriter(System.out);
 
	public static void main(String[] args) throws Exception {
		int n = in.nextInt(), m = in.nextInt();
		
		p = 1;
		while (p < n) p <<= 1;
		P = p << 1;
		
		T = new int[R][P];
		plus = new int[P];
		
		init();
		
		for (int i = 0; i < m; i++) {
			int q = in.nextInt();
			a = in.nextInt();
			b = in.nextInt();
			if (q == 0) add(1, 0, p-1);
			else out.println(count(1, 0, p-1, 0));
		}
		
		out.flush();
	}
	
	final static int R = 3;
 
	static int p, P;
	static int[][] T;
	static int[] plus;
	
	static int a, b;
	
	static void init() {
		for (int i = p; i < P; i++) T[0][i] = 1;
		for (int i = p-1; i >= 1; i--) T[0][i] = T[0][i << 1] + T[0][(i << 1) + 1];
	}
	
	static void add(int x, int l, int r) {
		if (r < a || b < l) return;
		if (a <= l && r <= b) {
			plus[x]++;
			if (plus[x] >= R) plus[x] -= R;
			return;
		}
		
		if (plus[x] > 0) {
			plus[x << 1] += plus[x];
			if (plus[x << 1] >= R) plus[x << 1] -= R;
			plus[(x << 1) + 1] += plus[x];
			if (plus[(x << 1) + 1] >= R) plus[(x << 1) + 1] -= R;
			plus[x] = 0;
		}
		
		add(x << 1, l, (l+r) >> 1);
		add((x << 1) + 1, ((l+r) >> 1) + 1, r);
		
		for (int i = 0; i < R; i++) {
			int idxLeft = i - plus[x << 1];
			if (idxLeft < 0) idxLeft += R;
			int idxRight = i - plus[(x << 1) + 1];
			if (idxRight < 0) idxRight += R;
			T[i][x] = T[idxLeft][x << 1] + T[idxRight][(x << 1) + 1];
		}
	}
	
	static int count(int x, int l, int r, int q) {
		if (r < a || b < l) return 0;
		if (a <= l && r <= b) {
			int idx = q - plus[x];
			if (idx < 0) idx += R;
			return T[idx][x];
		}
		
		int idx = q - plus[x];
		if (idx < 0) idx += R;
		
		return count(x << 1, l, (l+r) >> 1, idx) + 
			count((x << 1) + 1, ((l+r) >> 1) + 1, r, idx);
	}
}
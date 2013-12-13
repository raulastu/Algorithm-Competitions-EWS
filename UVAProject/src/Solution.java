import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;

public class Solution {

	int A[];
	int T[];

	public void solve() {									
		N=ni();
		M=ni();
		char grid[][] = nm(N, M);
//		pr(grid);
		int [][]ints = new int[N][M]; 
		int [][]dpRR = new int[N][M];
		int [][]dpBB = new int[N][M];
		int [][]val=new int[N][M];
		
		for (int i = N-1; i >=0; i--) {
			for (int j = M-1; j >=0; j--) {
				if(grid[i][j]=='*'){
					int val1=0;
					if(j<M-1){
						val1=val[i][j+1];
						if(dpRR[i][j+1]== 1||dpBB[i][j+1]==1 ){
//							dpRR[i][j]=dpRR[i][j+1];
							dpRR[i][j]=dpBB[i][j]=1;
//							val[i][j]=val[i][j+1];
//							continue;
						}
					}
					int val2=0;
					if(i<N-1){
						val2=val[i+1][j];
						if(dpRR[i+1][j]== 1||dpBB[i+1][j]==1 ){
//							dpBB[i][j]=dpBB[i+1][j];
							dpRR[i][j]=dpBB[i][j]=1;
//							val[i][j]=val[i+1][j];
//							continue;?
						}
					}
//					pr(i,j);
					val[i][j]=Math.min(val1,val2)+1;
					dpRR[i][j]=dpBB[i][j]=1;
				}else{
					int val1=0;
					if(j<M-1){
						val1=val[i][j+1];
						if(dpRR[i][j+1]== 1||dpBB[i][j+1]==1 ){
							dpRR[i][j]=dpRR[i][j+1];
							val[i][j]=val[i][j+1];
							continue;
						}
					}
					int val2=0;
					if(i<N-1){
						val2=val[i+1][j];
						if(dpRR[i+1][j]== 1||dpBB[i+1][j]==1 ){
							dpBB[i][j]=dpBB[i+1][j];
							val[i][j]=val[i+1][j];
							continue;
						}
					}
//					pr(i,j);
					val[i][j]=Math.max(val1,val2);
					dpRR[i][j]=dpBB[i][j]=1;
				}
			}
		}
		pr(dpRR,dpBB);
		pr();
		pr(val);
		out.println(val[0][0]);
		
	}
	
	ArrayList<node> get(char grid[][]) {
		int[][] ints = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int c = 0;
				if(grid[i][j]=='*')c--;
				for (int j2 = 0; j2 < N; j2++) {
					if (grid[j2][j] == '*') {
						c++;
					}
				}
				for (int j2 = 0; j2 < M; j2++) {
					if (grid[i][j2] == '*') {
						c++;
					}
				}
				ints[i][j] = c;
			}
		}
		// node nodes[] = new node[N*M];
		ArrayList<node> nodes = new ArrayList<Solution.node>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (ints[i][j] > 0)
					nodes.add(new node(i, j, ints[i][j]));
			}
		}
		Collections.sort(nodes, new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				return o2.c - o1.c;
			}
		});
		return nodes;
	}

	int N;
	int M;

	class node {
		int x, y, c;

		public node(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}

		@Override
		public String toString() {
			return this.c + " " + this.x + " " + this.y;
		}
	}

	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		// pr(System.currentTimeMillis() - s + "ms");
	}

	public static void main(String[] args) throws Exception {
		new Solution().run();
	}

	InputStream in = System.in;
	PrintWriter out = new PrintWriter(System.out);

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

	private boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	private int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	public String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != //
									// ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	public char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	public char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
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

	public long nl() {
		long num = 0;
		int b;
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

	void pr(Object... ob) {
		if (!false)
			System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}

}

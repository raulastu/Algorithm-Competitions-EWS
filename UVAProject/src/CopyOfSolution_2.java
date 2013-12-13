import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;

public class CopyOfSolution_2 {

	int A[];
	int T[];

	public void solve() {									
		N=ni();
		M=ni();
		char grid[][] = nm(N, M);
//		pr(grid);
		int [][]ints = new int[N][M]; 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int c = 0;
				for (int j2 = 0; j2 < N; j2++) {
					if(grid[j2][j]=='*'){
						c++;
					}
				}
				for (int j2 = 0; j2 < M; j2++) {
					if(grid[i][j2]=='*'){
						c++;
					}
				}
				ints[i][j]=c;
			}
		}
//		node nodes[] = new node[N*M];
		int res=0;
		ArrayList<node> nodes = get(grid);
//		pr(nodes);
		while(nodes.size()>0){
//			pr(nodes);
			int x=nodes.get(0).x;
			int y=nodes.get(0).y;
			res++;
			for (int j = 0; j < M; j++) {
				if(grid[x][j]=='*'){
					grid[x][j]='.';
				}
			}
			for (int j = 0; j < N; j++) {
				if(grid[j][y]=='*'){
					grid[j][y]='.';
				}
			}
			nodes = get(grid);
		}
		out.println(res);
		
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
		ArrayList<node> nodes = new ArrayList<CopyOfSolution_2.node>();
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
		new CopyOfSolution_2().run();
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

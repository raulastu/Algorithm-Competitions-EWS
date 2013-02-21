import java.util.Arrays;

public class SegmentTree {

	int A[];
	int M[];

	void init() {
		A = new int[] { 2, 4, 3, 1, 6, 7, 8, 9, 1, 7};
//		int s= 0;
//		for (int i = 0; i < A.length; i++) {
//			s+=A[i];
//		}
//		print(s);
//		A = new int[10000];
//		Arrays.fill(A,(int)Math.random()*3);
		int N = A.length;
		int n = 2 * 1<<(int)((Math.log(N) / Math.log(2) + 1));
		print(n);
		M = new int[n];
		Arrays.fill(M, -1);
		build(1, 0, N - 1);
		print(M);
		int x = query(1, 0, N - 1, 7, N-1);
//		print(M);
		print(x);

	}

	void build(int node, int b, int e) {
		print(node, b, e);
		if (b == e) {
			M[node] = A[b];
		} else {
			build(2 * node, b, (b + e) / 2);
			build(2 * node + 1, (b + e) / 2 + 1, e);
			M[node] = M[2 * node]+M[2 * node + 1];
		}
	}
	
	void update(int node, int b, int e, int newvalue){
		if (b == e) {
			M[node] = newvalue;
		} else {
			update(2 * node, b, (b + e) / 2, newvalue);
			update(2 * node + 1, (b + e) / 2 + 1, e, newvalue);
			M[node] = M[2 * node]+M[2 * node + 1];
		}
	}
	int query(int node, int b, int e, int i, int j) {
		int p1;
		int p2;

		// if the current interval doesn't intersect
		// the query interval return -1
		if (i > e || j < b) {
			print("x");
			return -1;
		}

		// if the current interval is included in
		// the query interval return M[node]
		if (b >= i && e <= j)
			return M[node];
		
		p1 = query(2 * node, b, (b + e) / 2, i, j);
		p2 = query(2 * node + 1, (b + e) / 2 + 1, e, i, j);
		
		if (p1 == -1)
			return M[node] = p2;
		if (p2 == -1)
			return M[node] = p1;
//		if (A[p1] <= A[p2])
		return M[node]=p1+p2;
//		return M[node]=p2;
	}

	public static void main(String[] args) {
		new SegmentTree().init();
	}

	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}

}

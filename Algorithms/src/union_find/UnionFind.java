package union_find;

public class UnionFind {
	class UF {
		int N;
		int data[];

		public UF(int N) {
			data = new int[N];
			for (int i = 0; i < N; i++)
				data[i] = i;
		}

		public void union(int p, int q) {
			data[root(p)] = root(q);
		}

		int root(int p) {
			while (data[p] != p) {
				return root(data[p]);
			}
			return p;
		}
	}
}

package union_find;

import java.util.Arrays;

public class DisjointSets {

	
	public static void main(String[] args) {
		DJSet ds = new  DJSet(20);
		pr(ds.upper);
		ds.union(0, 1);
		pr(ds.upper);
		ds.union(2, 3);
		pr(ds.upper);
		ds.union(1, 2);
		pr(ds.upper);
		ds.union(5, 6);
		pr(ds.upper);
		ds.union(5, 7);
		pr(ds.upper);
		ds.union(5, 8);
		pr(ds.upper);
		ds.union(5, 9);
		pr(ds.upper);
		ds.union(0, 5);
		pr(ds.upper);
//		ds.union(, );
//		pr(ds.upper);
	}
	static void pr(Object... ob) {
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
	
//	public static class DJSet { public int[] upper; public DJSet(int n){ upper = new int[n]; Arrays.fill(upper, -1);} public int root(int x){	return upper[x] < 0 ? x : (upper[x] = root(upper[x]));}	public boolean equiv(int x, int y){ return root(x) == root(y);} public boolean union(int x, int y){ x = root(x);y = root(y);if(x != y) { if(upper[y] < upper[x]) { int d = x; x = y; y = d;	} upper[x] += upper[y]; upper[y] = x;} return x == y;} public int count(){ int ct = 0; for(int u : upper)if(u < 0)ct++; return ct; }}
	public static class DJSet {
		public int[] upper;

		public DJSet(int n) {
			upper = new int[n];
			Arrays.fill(upper, -1);
		}

		public int root(int x) {
			//path compression
			return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
		}

		public boolean equiv(int x, int y) {
			return root(x) == root(y);
		}

		public boolean union(int x, int y) {
			x = root(x);
			y = root(y);
			if (x != y) {
				// check for the one who has more nodes and attach the other tree to it
				if (upper[y] < upper[x]) {
					int d = x;
					x = y;
					y = d;
				}
				upper[x] += upper[y];
				upper[y] = x;
			}
			return x == y;
		}

		public int count() {
			int ct = 0;
			for (int u : upper)
				if (u < 0)
					ct++;
			return ct;
		}
	}
}

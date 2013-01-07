package judges.UVA;

import static java.lang.Integer.parseInt;
import static java.lang.Math.min;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UnidireccionalTSP {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
//		BufferedReader in = new BufferedReader(new Reader BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (in.hasNext()) {
			int R = in.nextInt();
			int C = in.nextInt();
			grid=new int [R][C];
			for (int i = 0; i < R; i++) {
//				String [] bombline = in.nextLine().split(" ");
				for (int j = 0; j < C; j++) {
					grid[i][j]= in.nextInt();
				}
			}
//			print(grid);
			int res = Integer.MAX_VALUE;
			String winnerPath = "";
			for (int i = 0; i < R; i++) {
				memo = new boolean[R][C];
				int startX = i;
				int startY = 0;
				int endX = C-1;
				PriorityQueue<node> q = new PriorityQueue<node>();
				q.add(new node(startX, startY, grid[startX][startY],(i+1)+""));
				
				while(!q.isEmpty()){
					node p = q.poll();
//					print(q);
					if(p.y==endX){
						if(res>p.c){
							res = p.c;
							winnerPath = p.path;
						}
					}
					for (int j = 0; j < 3; j++) {
						int XX= p.x+di[j];
						int YY= p.y+1;
						if(XX<0)
							XX=R-1;
						if(XX==R)
							XX=0;
						if(YY >=0 && YY <grid[XX].length &&!memo[XX][YY]){
							memo[XX][YY]=true;
							q.add(new node(XX,YY,p.c+grid[XX][YY],p.path+ " "+(XX+1)));
						} 
					}
				}
			}
			System.out.println(winnerPath.trim());
			System.out.println(res);
		}
		in.close();
		out.close();
	}
	static class node implements Comparable<node>{
		private int x,y,c;
		private String path;
		public node(int x, int y, int c, String path) {
			this.x=x;
			this.y=y;
			this.c=c;
			this.path=path;
		}
		public String toString() {
			return x+"/"+y+"/"+c;
		}
		@Override
		public int compareTo(node o) {
			if(this.c==o.c){
				return this.x-o.x;
			}
			return this.c-o.c;
		}
	}
	static int []counter;
	static boolean memo [][];
	static int [][] grid;
	static int[] di={1,-1,0};
	static int[] dj={1,1,1};
	static void print(Object... ob){
		System.out.println(Arrays.deepToString(ob));
	}
}

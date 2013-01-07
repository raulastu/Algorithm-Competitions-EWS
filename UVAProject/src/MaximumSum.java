

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MaximumSum {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (in.hasNext()) {
			int n = parseInt(in.nextLine());
			int [][] grid = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					grid[i][j]=in.nextInt();
				}
			}
			int dp[][]=new int[n][n];

			int r = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					int up=Integer.MIN_VALUE;
					if(i-1>=0){
						up=dp[i-1][j]+grid[i][j];
					}
					int back=Integer.MIN_VALUE;
					if(j-1>=0){
						back=dp[i][j-1]+grid[i][j];
					}
					int big = Integer.MIN_VALUE;
					if(j-1>=0 && i-1>=0){
						big=dp[i][j-1]+dp[i-1][j]+grid[i][j];
					}
					int max = max(back,max(up, max( big, grid[i][j])));
					dp[i][j]=max;
					r=max(r,max);
					
				}
			}
			print(grid);
			print(dp);
			System.out.println(r);
			
		}
		in.close();
		out.close();
	}
	static class node{
		private int x,y,c;
		public node(int x, int y, int c) {
			this.x=x;
			this.y=y;
			this.c=c;
		}
		public String toString() {
			return x+"/"+y+"/"+c;
		}
	}
	static int []counter;
	static boolean memo [][];
	static int [][] grid;
	static int[] di={0,0,1,-1};
	static int[] dj={-1,1,0,0};
	static void print(Object... ob){
		System.out.println(Arrays.deepToString(ob));
	}
}

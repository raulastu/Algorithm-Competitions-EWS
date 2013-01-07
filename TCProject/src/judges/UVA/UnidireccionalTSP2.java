package judges.UVA;

import static java.lang.Integer.parseInt;
import static java.lang.Math.min;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class UnidireccionalTSP2 {

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
			memo = new int[R][C];
			for (int j = 0; j < memo.length; j++) {
				Arrays.fill(memo[j], -1);
			}
			
			for (int i = 0; i < R; i++) {
				int startX = i;
				int startY = 0;
				int val = grid[startX][startY]+go(startX,startY);
//				memo[i][0]=val;
				res = min(res,val);
//				printm(memo);
			}
			int m=Integer.MAX_VALUE;
			int XXX=-1;
			for (int i = 0; i < memo.length; i++) {
				if(memo[i][0]<m){
					m=memo[i][0];
					XXX=i;
				}
			}
			System.out.print(XXX+1);
			for (int i = 1; i < memo[0].length; i++) {
				int best = Integer.MAX_VALUE;
				int bestXX = -1;
				for (int j = 0; j < 3; j++) {
					int XX = XXX+di[j];
					int YY = i;
					if(XX<0)
						XX=grid.length-1;
					if(XX==grid.length)
						XX=0;
					if(YY<C){
						if(memo[XX][YY]<best){
							best=memo[XX][YY];
							bestXX=XX;
						}else if (memo[XX][YY]==best){
							if(XX<bestXX){
								bestXX=XX;
							}
						}
					}
				}
				XXX=bestXX;
//				System.out.println(best+" "+bestXX);
				System.out.print(" "+(bestXX+1));
			}
//			System.out.println(res);
//			System.out.println(winnerPath.trim());
			System.out.println("\n"+m);
		}
		in.close();
		out.close();
	}
	static int min=Integer.MAX_VALUE;
	static String minStr = "";
	static int go(int x, int y ){
//		ar.add(x);
		if(y==grid[x].length-1){
			memo[x][y]=grid[x][y];
			return grid[x][y];
		}
		if(memo[x][y]!=-1){
			return memo[x][y];
		}
		int r = Integer.MAX_VALUE;
		for (int j = 0; j < 3; j++) {
			int XX= x+di[j];
			int YY= y+1;
			if(XX<0)
				XX=grid.length-1;
			if(XX==grid.length)
				XX=0;
			if(YY <grid[XX].length){
				int res= grid[x][y]+go(XX,YY);
				r = min(res,r);
			}
		}
//		if(r==Integer.MAX_VALUE)
//			r=0;
//		memo[x][y]=r+grid[x][y];
		memo[x][y]=r;
		return r;
	}
	static int []counter;
	static int memo [][];
	static int [][] grid;
	static int[] di={1,-1,0};
	static int[] dj={1,1,1};
	static void print(Object... ob){
		System.out.println(Arrays.deepToString(ob));
	}
	static void printm(Object... ob){
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}

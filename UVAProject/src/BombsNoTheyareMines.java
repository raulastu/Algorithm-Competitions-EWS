
import static java.lang.Integer.parseInt;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BombsNoTheyareMines {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			String [] start = in.nextLine().split(" ");
			int R = parseInt(start[0]);
			int C = parseInt(start[1]);
			if(R==0 && C==0){
				break;
			}
			grid=new int [R][C];
			memo = new boolean[R][C];
			int nBombs = parseInt(in.nextLine());
			for (int i = 0; i < nBombs; i++) {
				String [] bombline = in.nextLine().split(" ");
				int bombedRow = parseInt(bombline[0]);
				for (int j = 2; j < bombline.length; j++) {
					int bombedCol = parseInt(bombline[j]);
					grid[bombedRow][bombedCol]=1;
				}
			}
//			print(grid);
			String [] startPosition = in.nextLine().split(" ");
			int startX = parseInt(startPosition[0]);
			int startY = parseInt(startPosition[1]);
			String [] endPosition = in.nextLine().split(" ");
			int endX = parseInt(endPosition[0]);
			int endY = parseInt(endPosition[1]);
			java.util.Queue<node> q = new LinkedList<node>();
			q.add(new node(startX, startY,0));
			String res = "";
			while(!q.isEmpty()){
				node p = q.poll();
//				print(q);
				if(p.x==endX && p.y==endY){
					res = p.c+"";
				}
				for (int i = 0; i < 4; i++) {
					int XX= p.x+di[i];
					int YY= p.y+dj[i];
					if(XX>=0 && YY >=0 && XX<grid.length && YY <grid[XX].length && grid[XX][YY]==0 &&!memo[XX][YY]){
						memo[XX][YY]=true;
						q.add(new node(XX,YY,p.c+1));
					} 
				}
			}
			System.out.println(res);
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

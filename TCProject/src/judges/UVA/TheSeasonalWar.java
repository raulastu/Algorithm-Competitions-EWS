package judges.UVA;

import static java.lang.Integer.parseInt;
import static java.lang.Math.min;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TheSeasonalWar {
	
	
    static int di[] = { -1,-1,-1,0,0,1,1,1 };
    static int dj[] = { -1,1,0,1,-1,0,-1,1 };
	static class node {
		int x,y,c;
		public node(int x,int y, int c) {
			this.x=x;
			this.y=y;
			this.c=c;
		}
	}
	
	public static void main(String[] args) throws Exception {

		
		
		Scanner in = new Scanner(System.in);
//		BufferedReader in = new BufferedReader(new Reader BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int count=1;
		while (in.hasNextLine()) {
			int n = parseInt(in.nextLine().trim());
			grid=new char[n][n];
			memo = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				grid[i]=in.nextLine().trim().toCharArray();
			}
//			printm(grid);
//			printm(memo);
			int r = 0;
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if(!memo[i][j] && grid[i][j]=='1'){
						r++;
						go(i,j);
					}
				}
			}
			System.out.println("Image number "+count+" contains "+r+" war eagles.");
			count++;
		}
		in.close();
		out.close();
	}
	static char grid[][];
	static boolean memo[][];
	static void go(int x,int y){
		memo[x][y]=true;
		for (int i = 0; i < di.length; i++) {
			int X = x+di[i];
			int Y = y+dj[i];
			if(X>=0 && Y>=0 && X<grid.length && Y<grid[X].length && grid[X][Y]=='1' && !memo[X][Y]){
				go(X,Y);
			}
		}
	}
	
	static void print(Object... ob){
		System.out.println(Arrays.deepToString(ob));
	}
	static void printm(Object... ob){
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}

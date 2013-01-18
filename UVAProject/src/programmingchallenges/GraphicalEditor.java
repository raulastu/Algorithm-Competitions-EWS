package programmingchallenges;

import static java.lang.Math.*;

import static java.lang.Integer.*;
import static java.util.Arrays.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class GraphicalEditor {

	String packageName() {
		return "src/"
				+ this.getClass().getPackage().getName().replace(".", "/");
	}

	public static void main(String[] args) throws Exception {
//		 Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File(new GraphicalEditor().packageName()+ "/GraphicalEditor10267.txt"));
		PrintWriter out = new PrintWriter(System.out);
		wh:
		while (in.hasNextLine()) {
			String [] line = in.nextLine().split(" ");
			char command = line[0].charAt(0);
//			char[][] grid;
//			int N, M;
			
			switch (command) {
				case 'I':
					M = parseInt(line[1]);
					N = parseInt(line[2]);
					grid=new char[N][M];
					for (int i = 0; i < N; i++) 
						fill(grid[i],'O');
					break;
				case 'C':
					for (int i = 0; i < N; i++)
						fill(grid[i],'O');
					break;
				case 'L':{
					int X = parseInt(line[1])-1;
					int Y = parseInt(line[2])-1;
					char C = line[3].charAt(0);
					if(!validCoord(X, Y))
						break;
					grid[Y][X]=C;
					break;
					}
				case 'V':{
					int X = parseInt(line[1])-1;
					int a =parseInt(line[2])-1;
					int b =parseInt(line[3])-1;
					int Y1 = min(a,b);
					int Y2 = max(a,b);
					if(!validCoord(X,Y1) || !validCoord(X,Y2)){
						break;
					}
					char C = line[4].charAt(0);
					for (int i = Y1; i <= Y2; i++) {
						grid[i][X]=C;
					}
					break;
					}
				case 'H':{
					int X1 = parseInt(line[1])-1;
					int X2 = parseInt(line[2])-1;
					int Y = parseInt(line[3])-1;
					if(!validCoord(X1,Y) || !validCoord(X2,Y)){
						break;
					}
					char C = line[4].charAt(0);
					fill(grid[Y],X1,X2+1,C);
					break;
					}
				case 'K':{
					int a = parseInt(line[1])-1;
					int b = parseInt(line[2])-1;
					int c = parseInt(line[3])-1;
					int d = parseInt(line[4])-1;
					int X1=min(a,c);
					int Y1=min(b,d);
					int X2=max(a,c);
					int Y2=max(b,d);
					if(!validCoord(X1,Y1) || !validCoord(X2,Y2)){
						break;
					}
					char C = line[5].charAt(0);
					for (int i = Y1; i <=Y2; i++) {
						fill(grid[i],X1,X2+1,C);
					}
					break;
					}
				case 'F':{
					int X = parseInt(line[1])-1;
					int Y = parseInt(line[2])-1;
					if(!validCoord(X,Y)){
						break;
					}
					char C = line[3].charAt(0);
					memo=new boolean[N][M];
					fillgrid(X,Y,grid[Y][X],C);
					break;
					}
				case 'S':
					String s = line[1];
					System.out.println(s);
					for (int i = 0; i < N; i++) {
						System.out.println(new String(grid[i]));
					}
					break;
				case 'X':
					break wh;
				default:
					break;
			}
		}
		in.close();
		out.close();
	}
	static char[][]grid;
	static boolean[][]memo;
	static int di[]={1,-1,0,0},
				dj[]={0,0,-1,1},M,N;
	
	private static boolean validCoord(int x, int y){
		return x>=0 && x<M && y>=0 && y<N;
	}
	private static void fillgrid(int x, int y, char prior, char C){
		for (int i = 0; i < 4; i++) {
			int X=x+di[i];
			int Y=y+dj[i];
			if(X>=0 && X<M && Y>=0 && Y<N && !memo[Y][X] && grid[Y][X]==prior){
				memo[Y][X]=true;
				grid[Y][X]=C;
				fillgrid(X,Y,prior,C);
			}
		}
	}
	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}
}

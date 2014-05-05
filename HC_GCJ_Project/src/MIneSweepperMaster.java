import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;
import static java.lang.Integer.*;

public class MIneSweepperMaster {
	static String solve2(String line) {
		String[] ab = line.split(" ");
		int R = parseInt(ab[0]);
		int C = parseInt(ab[1]);
		int M = parseInt(ab[2]);
		char[][] res = new char[R][C];

		for (int i = 0; i < res.length; i++) {
			Arrays.fill(res[i], '.');
		}
		for (int bitmask = 0; bitmask < 1<<R*C; bitmask++) {
			if(bitCount(bitmask)==M){
				String s = Integer.toBinaryString(bitmask);
				s=s.replace("1", "*").replace("0", ".");
				int l=s.length();
				
				for (int i = 0; i < R*C-l; i++) {
					s="."+s;
				}
				for (int i = 0; i < R; i++) {
					res[i]=s.substring(C*i,C*(i+1)).toCharArray();
				}
//				pr(getR(res));
				if(win(res)){
					return getR(res);
				}
			}
		}
		return "Impossible";
	}
	
	static String solve3(String line) {
		win=false;
		String[] ab = line.split(" ");
		int R = parseInt(ab[0]);
		int C = parseInt(ab[1]);
		int M = parseInt(ab[2]);
		char[][] res = new char[R][C];

		for (int i = 0; i < res.length; i++) {
			Arrays.fill(res[i], '.');
		}
		MM=M;
		if(MM>0)
			fill2(res, res.length-1, res[0].length-1,M-1, done);
		else{
			res[0][0]='c';
			return getR(res);
		}
		if(win)
			return ress;
		else return "Impossible";
					
	}
	static String ress="";

	static boolean win=false;
	
	static boolean [][] done;
	static int MM;
	static void fill2(char[][] grid,int x, int y, int M, boolean [][]done){
		grid[x][y]='*';
		if(win)
			return;
		if(M<=0){
			if(win==false && win(grid)){
				win=true;
				ress=getR(grid);
			}
			return;
		}
		int newM=M;
		for (int i = 0; i < 8; i++) {
			int X = x+di[i];
			int Y = y+dj[i];
			if(X>=0 && X<grid.length && Y>=0 && Y<grid[X].length && grid[X][Y]=='.'){
				newM--;
				fill2(grid,X,Y,newM,done);
//				grid[X][Y]='.';
			}
		}
	}
	
	static String solve(String line) {
		String[] ab = line.split(" ");
		int R = parseInt(ab[0]);
		int C = parseInt(ab[1]);
		int M = parseInt(ab[2]);
		char[][] res = new char[R][C];

		for (int i = 0; i < res.length; i++) {
			Arrays.fill(res[i], '.');
		}
		if (M == R * C - 1) {
			for (int i = 0; i < res.length; i++) {
				Arrays.fill(res[i], '*');
			}
			return getR(res);
		}

		if (R <= 1 || C <= 1) {
			for (int i = R - 1; i >= 0; i--) {
				for (int j = C - 1; j >= 0; j--) {
					if (j <= 1 && i <= 1)
						continue;
					M--;
					if (M < 0)
						break;
					res[i][j] = '*';
				}
			}
//			pr(getR(res), M);
			if (M >= 1)
				return "Impossible";
			else{
				return getR(res);
			}
		}

		for (int i = R - 1; i >= 2; i--) {
			for (int j = C - 1; j >= 0; j--) {
				if (j <= 1 || i <= 1)
					continue;
				M--;
				if (M < 0)
					break;
				res[i][j] = '*';
			}
		}
		
		if (M <= 0){
			return getR(res);
		}
			
		int c= 2, r=2;
		if (M % 2 != 0){
			if(R>=3 && C>=3 && res[2][2]=='*'){
				res[2][2]='.';
				c=r=3;
				M++;
			}else
				return "Impossible";
		}
			

		for (int i = C - 1; i >= c; i--) {
			if (R > 1) {
				M--;
				if (M < 0)
					break;
				res[0][i] = '*';
				M--;
				if (M < 0)
					break;
				res[1][i] = '*';
			}
		}
		for (int i = R - 1; i >= r; i--) {
			if (C > 1) {
				M--;
				if (M < 0)
					break;
				res[i][0] = '*';

				M--;
				if (M < 0)
					break;
				res[i][1] = '*';
			}
		}
		if (M >= 1)
			return "Impossible";
		else{
			return getR(res);
		}	
	}
	
	static boolean win(char[][]grid){
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]=='.'){
					char gridt[][]= new char[grid.length][grid[i].length];
					for (int k = 0; k < gridt.length; k++) {
						for (int k2 = 0; k2 < gridt[k].length; k2++) {
							gridt[k][k2]=grid[k][k2];
						}
					}
//					gridt[i][j]='c';
					myFill(gridt,i,j);
					boolean win=true;
					for (int k = 0; k < gridt.length; k++) {
						for (int k2 = 0; k2 < gridt[k].length; k2++) {
							if(gridt[k][k2]=='.')
								win =false;
						}
					}
					
					if(win){
//						grid[i][j]='c';
//						pr(getR(gridt));
						return win;
					}
						
				}
			}
		}
		return false;
	}
	
	static int di[]={0,0,1,-1,-1,1,1,-1};
	static int dj[]={1,-1,0,0,-1,1,-1,1};
	
	static void myFill(char[][]grid, int x, int y){
		boolean mine=false;
		for (int i = 0; i < 8; i++) {
			int X = x+di[i];
			int Y = y+dj[i];
			if(X>=0 && X<grid.length && Y>=0 && Y<grid[X].length && (grid[X][Y]=='.' || grid[X][Y]=='*')){
				if(grid[X][Y]=='*')
					mine=true;
			}
		}
		if(!mine){
			for (int i = 0; i < 8; i++) {
				int X = x+di[i];
				int Y = y+dj[i];
				if(X>=0 && X<grid.length && Y>=0 && Y<grid[X].length && grid[X][Y]=='.'){
					grid[X][Y]='f';
					myFill(grid,X,Y);
				}
			}
		}
	}
	
	static String getR(char[][]res){
		if(!win(res)){
			System.err.println("Error");
		}
		
		String rr = "";
		res[0][0]='c';
		for (int i = 0; i < res.length; i++) {
			rr += new String(res[i]);
			if (i != res.length - 1)
				rr += "\n";
		}
		return rr;
	}
	static void pr(Object ... o){
		System.err.println(Arrays.deepToString(o).replace("[", ""));
	}
	public static void main(String[] args) throws Exception {
//		 Scanner sc = new Scanner(new
//		 File("/Users/rc/test1/codejam14/C_in.txt"));
//		Scanner sc = new Scanner(new File(
//				"/Users/rc/test1/codejam14/practice/C-small-practice.in"));
		Scanner sc = new Scanner(new File(
				"/Users/rc/test1/codejam14/practice/C-large-practice.in"));
		
		
		String writtenFile = "/Users/rc/test1/codejam14/practice/CSolve_GRAND_out.txt";
		PrintWriter pw = new PrintWriter(new File(writtenFile));
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			// String sx [] = split(" ");
			String s = solve(sc.nextLine()) + "";
			String ss = "Case #" + (i + 1) + ":\n" + s;
			System.err.println(ss);
			pw.println(ss);
		}
		System.err.println(writtenFile);
		sc.close();
		pw.close();
	}
}

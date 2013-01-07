package judges.UVA;

import static java.lang.Integer.parseInt;
import static java.lang.Math.min;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GiocoDellX {
	
	
    static int di[] = { -1,0,1,-1,0,1};
    static int dj[] = { -1,-1,0,0,1,1 };
    static int dix[] = {1,0,-1};
    static int djx[] = {1,1,1};
    static int dix2[] = {1,1,1};
    static int djx2[] = {0,-1,1};
//    ( i-1 , j-1 ) , ( i-1 ,  j  ) 
//    (  i  , j-1 ) , (  i  , j+1 ) 
//    ( i+1 ,  j  ) , ( i+l , j+1 )

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
//		Scanner in = new Scanner(new File("/Users/rc/git/TCProject/src/Judges_HuaHCoding/input_temp_case"));
//		BufferedReader in = new BufferedReader(new Reader BufferedInputStream(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int count=1;
		while (in.hasNextLine()) {
			int n = parseInt(in.nextLine().trim());
			if(n==0)
				break;
			grid=new char[n][n];
			memo = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				grid[i]=in.nextLine().trim().toCharArray();
			}
//			printm(grid);
//			printm(memo);
			int r = 0;
			boolean found=false;
			for (int i = 0; i < grid.length; i++) {
				if(!memo[i][0] && grid[i][0]=='w'){
					boolean a = go(i,0,'w');
					if(a){
						found=true;
						System.out.println(count+" W");
						break;
					}
				}
			}
			memo = new boolean[n][n];
			if(!found)
				for (int i = 0; i < grid.length; i++) {
					if(!memo[0][i] && grid[0][i]=='b'){
						boolean a = go(0,i,'b');
						if(a){
							System.out.println(count+" B");
							break;
						}
					}
				}
			count++;
		}
		in.close();
		out.close();
	}
	static char grid[][];
	static boolean memo[][];
	static boolean go(int x,int y, char c){
		if(c=='w'){
			if(y==grid.length-1){
//				System.out.println(x);
				return true;
			}	
		}else{
			if(x==grid.length-1){
//				System.out.println(y);
				return true;
			}	
		}
		memo[x][y]=true;
		boolean r = false;
		for (int i = 0; i < di.length; i++) {
			int X = x+di[i];
			int Y = y+dj[i];
			if(X>=0 && Y>=0 && X<grid.length && Y<grid[X].length && grid[X][Y]==c && !memo[X][Y]){
				r = r || go(X,Y,c);
			}
		}
		return r;
	}
	static void print(Object... ob){
		System.out.println(Arrays.deepToString(ob));
	}
	static void printm(Object... ob){
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}

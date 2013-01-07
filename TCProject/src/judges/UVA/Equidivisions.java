package judges.UVA;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

class Equidivisions {

	public static void main(String[] args) throws Exception {
//		BufferedReader in = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			int n = Integer.parseInt(in.nextLine().trim());
			if(n==0)
				break;
			grid=new int [n][n]; 
			memo=  new boolean[n][n];
			for (int i = 1; i < n; i++) {
				String[] p = in.nextLine().split(" ");
				for (int j = 0; j < p.length; j+=2) {
					int a = Integer.parseInt(p[j])-1;
					int b = Integer.parseInt(p[j+1])-1;
					grid[a][b]=i;
				}
			}
//			print(grid);
			counter = new int[n];
			
			String res = "good";
			cx:
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					if(memo[i][j])
						continue;
					if(counter[grid[i][j]]>0){
						res="wrong";
						break cx;
					}else{
						go(i,j,grid[i][j]);
					}
				}
			}

			System.out.println(res);
		}
		in.close();
		out.close();
	}
	static int []counter;
	static boolean memo [][];
	static int [][] grid;
	static int[] di={0,0,1,-1};
	static int[] dj={-1,1,0,0};
	static void go(int x, int y, int k){
		memo[x][y]=true;
		counter[k]++;
		for (int i = 0; i < di.length; i++) {
			int X = di[i]+x;
			int Y = dj[i]+y;
			if(X>=0 && Y>=0 && X<grid.length && Y<grid[X].length && grid[X][Y]==k && !memo[X][Y]){
				go(X,Y,k);
			}
		}
	}
	static void print(Object... ob){
		System.out.println(Arrays.deepToString(ob));
	}
}

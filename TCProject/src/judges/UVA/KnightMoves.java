package judges.UVA;

import static java.lang.Integer.parseInt;
import static java.lang.Math.min;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightMoves {
	
	
	static boolean memo[][];
//	static int di[]={1,1,-1,-1,2,2,-2,-2};
//	static int dj[]={2,-2,2,-2,1,-1,-1,1};

    static int di[] = { -2, -2, -1, -1, 1, 1, 2, 2 };
    static int dj[] = { -1, 1, 2, -2, -2, 2, -1, 1 };
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
		while (in.hasNextLine()) {
			String[] a = in.nextLine().split(" ");
			String start = a[0];
			String end = a[1];
			
			int startY = (int)(start.toCharArray()[0]-'a');
			int startX = (int)(start.toCharArray()[1]-'0');
			int endY = (int)(end.toCharArray()[0]-'a');
			int endX = (int)(end.toCharArray()[1]-'0');
			startX--;
			endX--;
			Queue<node> q = new LinkedList<node>();
			memo = new boolean[8][8];
			q.add(new node(startX,startY,0));
			memo[startX][startY]=true;
			while(!q.isEmpty()){
				node p = q.poll();
//				print(q);
				if(p.x==endX && p.y==endY){
					System.out.print("To get from "+start+" to "+end+" takes "+p.c+" knight moves.\n");
//					break;
				}
				for (int i = 0; i < di.length; i++) {
					int XX=p.x+di[i];
					int YY=p.y+dj[i];
					if(XX>=0 && XX<8 && YY>=0 && YY<8 && !memo[XX][YY]){
						memo[XX][YY]=true;
						q.add(new node(XX,YY,p.c+1));
					}
				}
			}
		}
		in.close();
		out.close();
	}
	static void print(Object... ob){
		System.out.println(Arrays.deepToString(ob));
	}
	static void printm(Object... ob){
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}

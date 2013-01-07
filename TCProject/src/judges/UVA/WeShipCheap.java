package judges.UVA;

import static java.lang.Integer.parseInt;
import static java.lang.Math.min;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WeShipCheap {
	
	public static void main(String[] args) throws Exception {
//		System.out.println(toNum("AA"));
//		System.out.println(toNum("AB"));
//		System.out.println(toNum("ZZ"));
//		System.out.println(toStr(toNum("AA")));
//		System.out.println(toStr(toNum("AB")));
//		System.out.println(toStr(toNum("JJ")));
//		System.out.println(toStr(toNum("ZZ")));
//		if(true)return;
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int N = 676;
		while (in.hasNextLine()) {
			int n = parseInt(in.nextLine());
			int [][] relations = new int [N][N];
			for (int i = 0; i < n; i++) {
				String[] a = in.nextLine().split(" ");
				int A = toNum(a[0]);
				int B = toNum(a[1]);
				relations[A][B]=1;
				relations[B][A]=1;
			}
			
//			print(map);
			boolean found=false;
			String ends [] = in.nextLine().split(" ");
			int start = toNum(ends[0]);
			int end = toNum(ends[1]);
			Queue<node> q = new LinkedList<node>();
			q.add(new node(start,toStr(start)));
			boolean [] memo = new boolean[N];
			memo[start]=true;
			
			while(!q.isEmpty()){
//				print(q); 
				node p = q.poll();
				if(p.x == end){
//					System.err.println(p.route);
					String [] s = p.route.trim().split(" ");
					if(s.length==1)
						System.out.println("No route");
					for (int i = 1; i < s.length; i++) {
						System.out.println(s[i-1]+" "+s[i]);
					}
					found=true;
					break;
				}
				for (int i = 0; i < relations[p.x].length; i++) {
					if(relations[p.x][i]==1 && !memo[i]){
						memo[i]=true;
						q.add(new node(i,p.route+" "+toStr(i)));
					}
				}
			}
			if(!found){
				System.out.println("No route");
			}
			
			if(in.hasNextLine()){
				in.nextLine();
				System.out.println();
			}
				
		}
		in.close();
		out.close();
	}
	static int R= (int)('Z'-'A')+1;
	static int toNum(String a){
		char [] aa = a.toCharArray();
		int A = aa[0]-'A';
		int B = aa[1]-'A';
		int r = A*R+B;
		return r;
//		return parseInt(a, 16);
	}
	
	static String toStr(int num){
		int B = num%R;
		char b = (char)(B+'A');
		int A = (num - B)/R;
		char a = (char)(A+'A');
		return a+""+b;
	}
	
	static class node{
		int x;
		String route;
		public node(int x, String route) {
			this.x=x;
			this.route=route;
		}
		public String toString() {
		
			return x+" ."+route+".";
		}
	}
	
	static void print(Object... ob){
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}

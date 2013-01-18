//package Judges_CodeForces;

import static java.lang.Integer.parseInt;
import static java.lang.Math.min;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MrBlenderAndSquare {
	
	public static void main(String[] args) throws Exception {
		
//		Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("test.txt"));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(in.nextLine());
		String []list = in.nextLine().split(" ");
		seq = new int[list.length];
//		int []m=new int[1000001];
		int r = 0;

		for (int i = 0; i < list.length; i++) {
			seq[i]=Integer.parseInt(list[i]);
			
		}
		
		if(seq.length<=2){
			System.out.println(seq.length);
			return;
		}
		int memo[][]=new int[4000][4000];
		for (int i = 0; i < seq.length; i++) {
			for (int j = i+1; j < seq.length; j++) {
				int a = seq[i];
				int b = seq[j];
				if(memo[a][b]==1)continue;
				
				memo[a][b]=1;
				boolean ab=true;
				int rr=2;
//				print(a,b);
				for (int k = j+1; k < seq.length; k++) {
					if(ab && seq[k]==a){
						ab=!ab;
						rr++;
					}else if(!ab && seq[k]==b){
						ab=!ab;
						rr++;
					}
				}
				r=Math.max(r,rr);
			}
		}
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[i].length; j++) {
//				Arrays.fill(dp[i][j],-1);
//			}
//		}
//		go(0,1,0);
		System.out.println(r);
		in.close();
		out.close();
	}
//	static int N=4000;
//	static int dp[][][]=new int[N][4000][4000];
	static int seq[];
//	int [] ques = new int[4000];
//	static int go(int i, int j, int k){
//		if(i==dp.length||j==dp.length)
//			return 0;
//		if(dp[i][j][k]==-1){
//			int res = go(i+1, j,k);
//			if(seq[i]==seq[j]){
//				res = Math.max(res,go(i+1,k,j));
//			}
//			dp[i][j][k]=res;
//		}
//		return dp[i][j][k];
//	}
	
	static void print(Object... ob){
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}

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

public class AlmostArithmeticalProgression {
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
//		Scanner in = new Scanner(new File("src/Judges_CodeForces/test.txt"));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(in.nextLine());
		if(n<=2){
			System.out.println(n);
			return;
		}
		int r = 0;
		
		
		int memo[]=new int[1000002];
//		Map<Integer,Integer>
//		HashSet<String> set = new HashSet<String>();
		
		int [] seq2=new int[n];
		int c=1;
		int ix=0;
		while(in.hasNext()){
			int number = in.nextInt();
			if(memo[number]!=0){
				seq2[ix]=memo[number];
			}else{
				memo[number]=c++;
				seq2[ix]=memo[number];
			}
			ix++;
		}
		
//		print(seq2);
		int memo2[][]=new int[4002][4002];
		int memo3[]=new int[4001];
		for (int i = 0; i < seq2.length; i++) {
//			if(seq2[i]==0)break;
			if(memo3[seq2[i]]==1)continue;
				memo3[seq2[i]]=1;
			for (int j = i+1; j < seq2.length; j++) {
				int a = seq2[i];
				int b = seq2[j];
				if(memo2[a][b]==1)continue;
//					set.add(a+" "+b);
				memo2[a][b]=1;
				boolean ab=true;
				int rr=2;
//				print(a,b);
				for (int k = j+1; k < seq2.length; k++) {
					if(ab && seq2[k]==a){
						ab=!ab;
						rr++;
					}else if(!ab && seq2[k]==b){
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

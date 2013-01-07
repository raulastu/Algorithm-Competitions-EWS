//package Judges_CodeForces.match157;

import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class B {

	public void solve(int cub[][]) {
		cube=cub;
		cube[0][0]=0;
		cube[1][1]=0;
		cube[2][2]=0;
		solve();
	}
	int [][]cube;
	public void solve() {
		cube=new int[3][3];
		cube[0]= readIntArray();
		cube[1]= readIntArray();
		cube[2]= readIntArray();
		int a1=cube[0][1]+cube[0][2];
		int a2=cube[1][0]+cube[1][2];
		int a3=cube[2][0]+cube[2][1];
//		int a = 200000+100000
		int min=min(a1,min(a2,a3));
		int max=max(a1,max(a2,a3));
//		print(min,max);
		if(true){
			if(min!=max){
				int dif = (max-min)/2;
//				int step = dif/2;
				int mid = (min+dif)/2;
				int nmin=mid-dif;
				int nmax=mid+dif;
//				print(dif,nmin,nmax);
				if(a1==min){
					cube[0][0]=nmax;
				}
				if(a2==min){
					cube[1][1]=nmax;
				}
				if(a3==min){
					cube[2][2]=nmax;
				}
				
				if(a1==max){
					cube[0][0]=nmin;
				}
				if(a2==max){
					cube[1][1]=nmin;
				}
				if(a3==max){
					cube[2][2]=nmin;
				}
				
				if(a1!=max && a1!=min){
					cube[0][0]=mid;
				}
				if(a2!=max && a2!=min){
					cube[1][1]=mid;
				}
				if(a3!=max && a3!=min){
					cube[2][2]=mid;
				}
			}else{
				if(a1==min){
					cube[0][0]=min/2;
				}
				if(a2==min){
					cube[1][1]=min/2;
				}
				if(a3==min){
					cube[2][2]=min/2;
				}
			}
		}
		
		for (int i = 0; i < cube.length; i++) {
				System.out.println(cube[i][0]+" "+cube[i][1]+" "+cube[i][2]);
		}
		
	}
	B(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new B().solve();
		close();
	}

	static Scanner in;
	static PrintWriter out;

	static int readInt(){
		return parseInt(in.nextLine());
	}
	static int[] readIntArray(){
		String l[] = in.nextLine().split(" ");
		int[] r=new int[l.length];
		for (int i = 0; i < l.length; i++) {
			r[i]=parseInt(l[i]);
		}
		return r;
	}
	static void print(Object... ob) {
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}

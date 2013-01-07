package Judges_CodeForces.match158;

import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class B2 {
	public boolean isMagic(int [][]cube){
		int r=0;
		for (int i = 0; i < cube.length; i++) {
			r+=cube[0][i];
		}
		int d=0;
		int hori=0;
		for (int i = 0; i < cube.length; i++) {
			hori+=cube[0][i];
			d=0;
			for (int j = 0; j < cube.length; j++) {
				d+=cube[i][j];
			}
			if(r!=d)return false;
		}
		d=0;
		for (int i = 0; i < cube.length; i++) {
			d=0;
			for (int j = 0; j < cube.length; j++) {
				d+=cube[j][i];
			}
			if(d!=hori)
				return false;
		}
		if(hori!=r)return false;
		
		int a1=cube[0][0]+cube[1][1]+cube[2][2];
		int a2=cube[2][0]+cube[1][1]+cube[0][2];
		if(a1!=a2)
			return false;
		if(hori!=a1)
			return false;
		return true;
	}
	public void solve() {
		int []array=new int[10];
		for (int i = 1; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				for (int j2 = 1; j2 < array.length; j2++) {
					for (int k = 1; k < array.length; k++) {
						for (int k2 = 1; k2 < array.length; k2++) {
							for (int l = 1; l < array.length; l++) {
								for (int l2 = 1; l2 < array.length; l2++) {
									for (int m = 1; m < array.length; m++) {
										for (int m2 = 1; m2 < array.length; m2++) {
											int cub[][]={{i,j2,k},
													{k2,l,l2},
													{m,m2,j}};
											if(isMagic(cub)){
												print(cub);
												B x=new B();
												x.solve(cub);
												if(!isMagic(x.cube)){
													System.err.println("XXXXXX");
													print(x.cube);
													System.exit(0);
												}else
													print(x.cube);
													print("good");
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		int [][]cube=new int[3][3];
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
				int mid = ((max-min)+dif)/2;
				int nmin=mid-dif;
				int nmax=mid+dif;
				
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
					cube[1][0]=nmin;
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
					cube[0][0]=1;
				}
				if(a2==min){
					cube[1][1]=1;
				}
				if(a3==min){
					cube[2][2]=1;
				}
			}
		}
		
		for (int i = 0; i < cube.length; i++) {
				System.out.println(cube[i][0]+" "+cube[i][1]+" "+cube[i][2]);
		}
		
	}
	B2(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new B2().solve();
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

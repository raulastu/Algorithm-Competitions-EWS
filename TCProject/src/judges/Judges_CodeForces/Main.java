package Judges_CodeForces;

import static java.lang.Integer.parseInt;

import static java.lang.Math.min;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(in.nextLine());
		String []l = in.nextLine().split(" ");
		int ex[]=new int[n];
		
		node[]c= new node[3];
		 c[0]= new node(0,"chest");
		 c[1]= new node(0,"biceps");
		 c[2]=new node(0,"back");
		
		for (int i = 0; i < l.length; i++) {
			ex[i]=Integer.parseInt(l[i]);
			c[i%3].c+=ex[i];
		}
		
		Arrays.sort(c,new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				return o1.c-o2.c;
			}
		});
//		print(c);
		System.out.println(c[2].s);
		in.close();
		out.close();
	}
	static class node{
		int c;
		String s;
		public node(int c, String s) {
			this.c=c;
			this.s=s;
		}
		@Override
		public String toString() {
			
			return c+" "+s;
		}
	}
	static void print(Object... ob){
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}

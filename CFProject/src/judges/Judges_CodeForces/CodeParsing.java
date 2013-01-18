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

public class CodeParsing {
	
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		String l = in.nextLine();
		int xc=0;
		int yc=0;
		for (int i = 0; i < l.length(); i++) {
			if(l.charAt(i)=='x')
				xc++;
			else
				yc++;
		}
		if(yc>xc){
			int r=yc-xc;
			char[]x=new char[r];
			Arrays.fill(x,'y');
			System.out.println(new String(x));
		}else{
			int r=xc-yc;
			char[]x=new char[r];
			Arrays.fill(x,'x');
			System.out.println(new String(x));
		}
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

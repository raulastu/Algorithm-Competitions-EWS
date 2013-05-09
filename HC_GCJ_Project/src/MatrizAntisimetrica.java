package Judges_HuaHCoding;


import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;

public class MatrizAntisimetrica {
	static String solve(String line) {
		String[] l = line.split(" +");
		int n= (int)Math.sqrt(l.length);
		int [][] m = new int[n][n];
		for (int i = 0; i < l.length; i++) {
			m[(int)(i/n)][i%n]=Integer.parseInt(l[i]);
		}
		int r=0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if(i!=j && m[i][j]!=-m[j][i])
					r++;
			}
		}
		r=r/2;
		for (int i = 0; i < m.length; i++) {
			if(m[i][i]!=0)
				r++;
		}
//		printm(m);
		return r+"";
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("/Users/rc/test1/Matriz Antisimetrica_in.txt"));
//		Scanner sc = new Scanner(new File("/Users/rc/git/TCProject/src/Judges_HuaHCoding/input_temp_case"));
//		Scanner sc = new Scanner(System.in);
		String writtenFile = "/Users/rc/test1/out.txt";
		PrintWriter pw = new PrintWriter(new File(writtenFile));
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
//			String sx [] = split(" "); 
			String s = solve(sc.nextLine())+"";
			System.err.println("-----------------Case #"+(i+1)+"");
//			System.err.println("output ");
			System.err.println(s);
			pw.println(s);
		}
		System.err.println(writtenFile);
		sc.close();
		pw.close();
	}
	static void print(Object... ob){
		System.err.println(Arrays.deepToString(ob));
	}
	static void printm(Object... ob){
		System.err.println(Arrays.deepToString(ob).replace("]", "]\n"));
	}
}

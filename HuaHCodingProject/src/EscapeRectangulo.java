package Judges_HuaHCoding;


import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.*;

public class EscapeRectangulo {
	static int solve(int x1,int y1,int w,int h) {
		return min(x1,min(y1,min(w-x1,h-y1)));
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("/Users/rc/test1/Escape del Rectangulo_in (10).txt"));
//		Scanner sc = new Scanner(new File("/Users/rc/git/TCProject/src/Judges_HuaHCoding/input_temp_case"));
//		Scanner sc = new Scanner(System.in);
		String writtenFile = "/Users/rc/test1/out.txt";
		PrintWriter pw = new PrintWriter(new File(writtenFile));
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String sx [] = sc.nextLine().split(" "); 
			int x1 = Integer.parseInt(sx[0]);
			int y1 = Integer.parseInt(sx[1]);
			int x2 = Integer.parseInt(sx[2]);
			int y2 = Integer.parseInt(sx[3]);
			String s = solve(x1,y1,x2,y2)+"";
			System.err.println("-----------------Case #"+(i+1)+"");
//			System.err.println("output ");
			System.err.println(s);
			pw.println(s);
		}
		System.err.println(writtenFile);
		sc.close();
		pw.close();
	}
}

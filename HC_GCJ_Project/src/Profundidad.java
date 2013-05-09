package Judges_HuaHCoding;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Profundidad {
	static int solve(int n) {
		if(n<=9)
			return 0;
		int x=1;
		char []st = (n+"").toCharArray();
		for (int i = 0; i < st.length; i++) {
			x*=(int)(st[i]-'0');
		}
//		System.err.println(x);
		return 1+solve(x);
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("/Users/rc/test1/Profundidad_in (1).txt"));
//		Scanner sc = new Scanner(new File("/Users/rc/git/TCProject/src/Judges_HuaHCoding/input_temp_case"));
//		Scanner sc = new Scanner(System.in);
		String writtenFile = "/Users/rc/test1/out.txt";
		PrintWriter pw = new PrintWriter(new File(writtenFile));
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			int nn = Integer.parseInt(sc.nextLine());
			String s = solve(nn)+"";
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

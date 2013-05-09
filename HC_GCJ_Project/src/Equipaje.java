package Judges_HuaHCoding;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Equipaje {
	static String solve(String inputCase, int n) {
		if(inputCase.equals(""))return 0+"";
		String[] s = inputCase.split(" ");
		int r=1;
		int c=n;
		for (int i = 0; i < s.length; i++) {
			int x = Integer.parseInt(s[i]);
			if(c-x<0){
				r++;
				c=n;
				c-=x;
				
			}else{
				c-=x;
			}
		}
		return r+"";
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("/Users/rc/test1/Equipaje_in (4).txt"));
//		Scanner sc = new Scanner(new File("/Users/rc/git/TCProject/src/Judges_HuaHCoding/input_temp_case"));
//		Scanner sc = new Scanner(System.in);
		String writtenFile = "/Users/rc/test1/out.txt";
		PrintWriter pw = new PrintWriter(new File(writtenFile));
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String inputLine = sc.nextLine();
			int nn = Integer.parseInt(sc.nextLine());
			String s = solve(inputLine, nn);
			System.err.println("-----------------Case #"+(i+1)+"");
			System.err.println(inputLine);
//			System.err.println("output ");
			System.err.println(s);
			pw.println(s);
		}
		System.err.println(writtenFile);
		sc.close();
		pw.close();
	}
}

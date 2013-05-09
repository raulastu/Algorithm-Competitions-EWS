package Judges_HuaHCoding;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	static String solve(String inputCase) {
		String []line = inputCase.split(" ");
		int r = 0;
		for (int i = 0; i < line.length; i++) {
			if(line[i].equals("HON") || line[i].equals("POKER") || line[i].equals("JEZZ")){
				r++;
			}
		}
		return r==0?"FML":r+"";
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("/Users/rc/test1/Moy's Day_in.txt"));
		PrintWriter pw = new PrintWriter(new File(
				"/Users/rc/test1/Moysday_out.txt"));
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String s = solve(sc.nextLine());
			System.err.println(s);
			pw.println(s);
		}
		sc.close();
		pw.close();
	}
}

package Judges_HuaHCoding;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class BigInteger {
	static String solve(String inputCase) {
		if(inputCase.matches("[-]{0,1}[0-9]+")){
			return "VALIDO";
		}else
			return "INVALIDO";
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("/Users/rc/test1/BigInteger_in.txt"));
//		Scanner sc = new Scanner(new File("/Users/rc/git/TCProject/src/Judges_HuaHCoding/input_temp_case"));
//		Scanner sc = new Scanner(System.in);
		String writtenFile = "/Users/rc/test1/BigInteger_out.txt";
		PrintWriter pw = new PrintWriter(new File(writtenFile));
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String inputLine = sc.nextLine();
			String s = solve(inputLine);
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

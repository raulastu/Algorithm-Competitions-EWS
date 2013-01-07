package Judges_HuaHCoding;


import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.*;

public class Acronimo {
	static String solve(String line) {
		String[] l = line.split(" +");
		String res="";
		for (String string : l) {
			if(string.equals("the")||
					string.equals("of") ||
					string.equals("and") ||
					string.equals("")){
				
			}else{
				res+=(string.toCharArray()[0]+"").toUpperCase();
			}
		}
				
		return res;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("/Users/rc/test1/acr.txt"));
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
}

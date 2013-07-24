import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.*;

public class Justi {
	static String solve(String line) {
		String [] a=line.substring(1,line.length()-1).split(",");
		int xx=0;
//		int ma
		for (int i = 0; i < a.length; i++) {
			xx= max(xx,a[i].length());
		}
		
		for (int i = 0; i < a.length; i++) {
			if(xx-a[i].length()>0){
				int len = xx-a[i].length();
				String s="";
				for (int j = 0; j < len; j++) {
					s+=" ";
				}
				a[i]=s+a[i];
			}
		}
		String res = "{";
		for (int i = 0; i < a.length; i++) {
			
				res+=a[i];
				if(i<a.length-1)
					res+=",";
		}
		res+="}";
		return res;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File(
				"/Users/rc/test1/Justificar Texto_in.txt"));
		// Scanner sc = new Scanner(new
		// File("/Users/rc/git/TCProject/src/Judges_HuaHCoding/input_temp_case"));
		// Scanner sc = new Scanner(System.in);
		String writtenFile = "/Users/rc/test1/out.txt";
		PrintWriter pw = new PrintWriter(new File(writtenFile));
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			// String sx [] = split(" ");
			String s = solve(sc.nextLine()) + "";
			System.err.println(s);
			pw.println(s);
		}
		System.err.println(writtenFile);
		sc.close();
		pw.close();
	}
}

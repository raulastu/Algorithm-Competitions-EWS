import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.*;

public class Feynman {
	static String solve(String line) {
		int n = Integer.parseInt(line);
		int r = 0;
		for (int i = 1; i <= n; i++) {
			r+=i*i;
		}
		return r+"";
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File(
				"/Users/rc/test1/Feynman_in.txt"));
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

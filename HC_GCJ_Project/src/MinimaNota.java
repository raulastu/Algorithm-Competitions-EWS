import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.*;

public class MinimaNota {
	static String solve(int a, int b, int c) {
		int r = (int)Math.ceil(4*10.5-a-b-c);
		if(r<0)r=0;
		if(r>20)r=-1;
		return r+"";
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File(
				"/Users/rc/test1/MinimaNota_in.txt"));
		// Scanner sc = new Scanner(new
		// File("/Users/rc/git/TCProject/src/Judges_HuaHCoding/input_temp_case"));
		// Scanner sc = new Scanner(System.in);
		String writtenFile = "/Users/rc/test1/out.txt";
		PrintWriter pw = new PrintWriter(new File(writtenFile));
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String sx [] = sc.nextLine().split(" ");
			int a = Integer.parseInt(sx[0]);
			int b = Integer.parseInt(sx[1]);
			int c = Integer.parseInt(sx[2]);
			String s = solve(a,b,c) + "";
			System.err.println(s);
			pw.println(s);
		}
		System.err.println(writtenFile);
		sc.close();
		pw.close();
	}
}

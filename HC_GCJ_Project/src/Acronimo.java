
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.*;

public class Acronimo {
	static String solve(String line) {		
		return convertirEsperantos(Integer.parseInt(line));
	}
	static String[] esperantos = {
	        "unu", "du", "tri", "kvar", "kvin", "ses", "sep", "ok", "nau", "dek"};
	   static  String convertirEsperantos(int n) {
	        String numero = "";
	        if (n > 0 && n < 100) {
	            int pr = n / 10;
	            if (n > 10) {
	                if (pr != 1) {
	                    numero += esperantos[pr - 1]+esperantos[9]+" ";
	                }
	                if (pr == 1) {
	                    numero += esperantos[9]+" ";
	                }
	                n = n - 10 * pr;
	            }
	            if (n > 0) {
	                numero += esperantos[n - 1];
	            }
	        }
	        return numero;
	    }
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("/Users/rc/test1/Esperanto Numbers_in.txt"));
//		Scanner sc = new Scanner(new File("/Users/rc/git/TCProject/src/Judges_HuaHCoding/input_temp_case"));
//		Scanner sc = new Scanner(System.in);
		String writtenFile = "/Users/rc/test1/out.txt";
		PrintWriter pw = new PrintWriter(new File(writtenFile));
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
//			String sx [] = split(" "); 
			String s = solve(sc.nextLine())+"";
			System.err.println(s);
			pw.println(s);
		}
		System.err.println(writtenFile);
		sc.close();
		pw.close();
	}
}

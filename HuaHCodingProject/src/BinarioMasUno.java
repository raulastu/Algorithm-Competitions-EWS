package Judges_HuaHCoding;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


public class BinarioMasUno {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("/Users/rc/test1/BinarioMasUno_in (1).txt"));
		//Scanner in = new Scanner(new File("D:/in.txt"));
		String writtenFile = "/Users/rc/test1/out.txt";
		PrintWriter out = new PrintWriter(new File(writtenFile));
		int casos = Integer.parseInt(in.nextLine());
		for (int i = 0; i < casos; i++) {
			String n=in.nextLine();
			long nuevo=0;
			for (int j = n.length()-1; j >= 0; j--) {
				nuevo+=Integer.parseInt(n.charAt(j)+"")*Math.pow(2, (n.length()-j-1));
			}
			out.println(Long.toBinaryString(nuevo+1));
		}
		in.close();
		out.close();
	}
}
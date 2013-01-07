/* * To change this template, choose Tools | Templates * and open the template in the editor. */package javaapplication1;

import java.io.*;
import java.math.BigInteger;
import java.util.Vector;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/** * * @author SMPERU_01 */
public class problem32 {
	/** * @param args the command line arguments */
	public static String[] ar;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(
				"e:/Valid Integer_in.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter(
				"e:/Valid Integer_out.txt"));
		int total = Integer.parseInt(in.readLine());
		for (int i = 0; i < total; i++) {
			String st = in.readLine();
			String isvin = (st.compareTo("-") == 0 || st.compareTo("") == 0) ? "INVALIDO"
					: "VALIDO";
			for (int j = 0; j < st.length(); j++) {
				if (j > 0 && st.charAt(j) == '-') {
					isvin = "INVALIDO";
					break;
				}
			}
			out.write(isvin + "");
			out.newLine();
		}
		in.close();
		out.close();
	}
}
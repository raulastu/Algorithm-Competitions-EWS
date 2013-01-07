

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		BufferedInputStream in = new BufferedInputStream(System.in);
		
//		Scanner in = new Scanner(System.in);
//		PrintWriter out = new PrintWriter(System.out);
//        int n = Integer.parseInt(in.nextLine());
//        for (int i = 0; i < n; i++) {
//        	String line = in.nextLine();
//        	if(line.length()==0){
//        		
//        	}
//			
//		}
		go(0);
	}
	static void go(int i){
		System.err.println(i);
		go(i+1);
	}
}

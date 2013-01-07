//package Judges.USACO;
//package Judges.USACO;

/*
 ID: erreaue2
 LANG: JAVA
 TASK: gift1
 */
import java.io.*;
import java.util.*;

class gift1 {
	public static void main(String[] args) throws IOException {
		LinkedHashMap<String,Integer> map = new LinkedHashMap<String, Integer>();
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
//		BufferedReader f = new BufferedReader(new FileReader("src/Judges/USACO/test.txt"));

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"gift1.out")));
		int n = Integer.parseInt(f.readLine());
		int [] friends = new int [n];
		String [] friendNames = new String[n];
		for (int i = 0; i < friendNames.length; i++) {
			map.put(f.readLine(),0);
//			friendNames[i]=f.readLine();
		}
		for (int i = 0; i < n; i++) {
			String giver = f.readLine();
			map.get(giver);
			String[] a = f.readLine().split(" ");
			int ammount=Integer.parseInt(a[0]);
			int takers=Integer.parseInt(a[1]);
			int givingamt=0;
			if(takers!=0)
				givingamt=(ammount/takers);
			map.put(giver, map.get(giver)-givingamt*takers);
			
			for (int j = 0; j < takers; j++) {
				String taker = f.readLine();
				map.put(taker,map.get(taker)+givingamt);
			}
		}
		for (String key : map.keySet()) {
			String r= key+" "+map.get(key);
			out.println(r);
//			System.err.println(r);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
}
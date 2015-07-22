package gcj15Qual;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class gcjr1_C {

	Scanner in;
	PrintWriter out;
	String inputFile="C-small.in",outputFile="C-out.txt";
	Scanner testsc,realInputsc;
	
	boolean test = true;
	
	public void solve() throws Exception {
		in = test?testsc:realInputsc;
		int cases = parseInt(in.nextLine());
		for (int icase = 0; icase < cases; icase++) {
			int ar[] = na(in.nextLine());
			int NN = 3;
			int M = 5;
			int K = 7;
			
			for (int i = 0; i < 100; i++) {
				int arr[]=na(in.nextLine());
				sort(arr);
				HashSet<Integer> arl = new HashSet<>(); 
				// 2 3 4 5
				for (int j = 0; j < arr.length; j++) {
					if(arr[j]%2==0){
						arl.add(2);
					}
					else if(arr[j]%4==0){
						arl.add(4);
					}
					else if(arr[j]%3==0){
						arl.add(3);
					}
					else if(arr[j]%5==0){
						arl.add(5);
					}
				}
				String rrr="";
				for (Integer integer : arl) {
					rrr+=integer;
				}
				String r = ("Case #" + (icase + 1) + ": "+rrr);
				out(r);
			}
			
		}
		close();
	}

	public static void main(String[] args) throws Exception {
		
		new gcjr1_C().solve();
	}
	public gcjr1_C() throws Exception {
		if(!test)
			realInputsc = new Scanner(new File("/Users/rc/test1/"+inputFile));
		else
			testsc = new Scanner(new File("src/C_example"));
		
		String outFile = "/Users/rc/test1/" + outputFile;
		if(!test)
			out = new PrintWriter(new File(outFile));
	}
	private void close() {
		if(!test){
			out.close();
		}
		in.close();
	}

	void pr(Object... ob) {
		if (test)
			System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}

	void out(String r) {
		if(!test)
			out.println(r);
		
		System.out.println(r);
	}

	int[] na(String ar) {
		String[] r = ar.split(" +");
		int[] res = new int[r.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = Integer.parseInt(r[i]);
		}
		return res;
	}
}
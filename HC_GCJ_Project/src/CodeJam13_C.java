import java.io.File;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.math.*;


public class CodeJam13_C {

	int d[]= new int[27];
	int solve3(BigInteger a, BigInteger b, BigInteger[]r){
		int res =0;
		for (int i = 0; i < r.length; i++) {
			BigInteger bx= r[i];
			if(bx.compareTo(a)>=0 && bx.compareTo(b)<=0){
				res++;
			}
		}
		return res;
	}
	BigInteger[] solve2(){
		int n = 26;
		int m = 4;
		int x=0;
		ArrayList<BigInteger> res= new ArrayList<BigInteger>();
		res.add(new BigInteger("1"));
		res.add(new BigInteger("2"));
		res.add(new BigInteger("3"));
		for (int i = 1; i < (1<<n); i=Integer.bitCount(i) < m ? i+1 : (i|(i-1))+1)
		{
			x++;
//			BigInteger x =
			String num = Integer.toBinaryString(i);
			String num1 = num+""+new StringBuilder(num).reverse();
			String num11 = num+"0"+new StringBuilder(num).reverse();
			String num22 = num+"1"+new StringBuilder(num).reverse();
			
			String num33 = num+"2"+new StringBuilder(num).reverse();
			
			res.add(new BigInteger(num1));
			res.add(new BigInteger(num11));
			res.add(new BigInteger(num22));
			int bits=0;
			for (int j = 0; j < n; j++) {
				if(((1<<j)&i)!=0){
					bits++;
				}
			}
			if(bits<3)
				res.add(new BigInteger(num33));
//		    pr(num1);pr(num2);pr(num3);
		}
//		for (int i = 0; i < n; i++) {
		StringBuilder s=new StringBuilder("22");
		res.add(new BigInteger(s.toString()));
		for (int j = 0; j < n; j++) {
			StringBuilder s2=null;
			if(s.length()%2==0){
				 s2 = new StringBuilder(s);
				s2.insert(s.length()/2, "1");
//					res.add(s2.toString());
			}
			s.insert(s.length()/2, "0");
			res.add(new BigInteger(s.toString()));
			if(s2!=null)
				res.add(new BigInteger(s2.toString()));
		}
		
		Collections.sort(res,new Comparator<BigInteger>() {
			@Override
			public int compare(BigInteger a, BigInteger b) {
				return a.compareTo(b);
			}
		});
		BigInteger []rres =res.toArray(new BigInteger[res.size()]);
		for (int i = 0; i < rres.length; i++) {
			rres[i]=rres[i].pow(2);
		}
//		pr(rres);
//		pr(x);
		return rres;
	}
	void pr(Object... ob) {
//		if(false)
		out.println(Arrays.deepToString(ob).replace("],", "],\n"));
		out.flush();
	}

	Scanner in;
	PrintWriter out;
	
	public void solve() throws Exception{
		in = new Scanner(new File("/Users/rc/test1/C-large-2.in"));
//		out = new PrintWriter(System.out);
		BigInteger [] res2 = solve2();
//		pr(res2);
//		if(true)return;
//		Scanner in = new Scanner(new File("/Users/rc/Eclipse-Workspaces/Algorithm-Competitions-EWS/HuaHCodingProject/src/input_temp_case"));
//		in = new Scanner(new File("src/C_example"));
		
		
		//Scanner in = new Scanner(new File("D:/in.txt"));
		String writtenFile = "/Users/rc/test1/C-large-2.inC-large-2.inC-large-2.in.txt";
		
		out = new PrintWriter(new File(writtenFile));
		int casos = Integer.parseInt(in.nextLine());
//		pr(aa,T);
		for (int i = 0; i < casos; i++) {
			String ab[]= in.nextLine().split(" ");
			BigInteger a = new BigInteger(ab[0]);
			BigInteger b = new BigInteger(ab[1]);
			int ress = solve3(a,b,res2);
			out.println("Case #"+(i+1)+": "+ress);
		}
		in.close();
		out.close();
	}
	boolean isPalindrome(long i){
		long rev = 0;
		long xi=i;
		while(i>0){
			rev=rev*10L+(i%10L);
			i/=10L;
		}
		return (rev==xi);
	}
	public static void main(String[] args) throws Exception {
		new CodeJam13_C().solve();
	}
}
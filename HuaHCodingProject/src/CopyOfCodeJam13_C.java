import java.io.File;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.math.*;
import javax.jws.Oneway;


public class CopyOfCodeJam13_C {

	int d[]= new int[27];
	int solve3(BigInteger a, BigInteger b, String[]r){
		int res =0;
		for (int i = 0; i < r.length; i++) {
			BigInteger bx= new BigInteger(r[i]);
			if(bx.compareTo(a)>=0 && bx.compareTo(b)<=0){
				res++;
			}
		}
		return res;
	}
	String[] solve2(){
		int n = 26;
		int m = 4;
		int x=0;
		ArrayList<String> res= new ArrayList<String>();
		res.add("1");
		res.add("2");
		res.add("3");
		for (int i = 1; i < (1<<n); i=Integer.bitCount(i) < m ? i+1 : (i|(i-1))+1)
		{
			x++;
//			BigInteger x =
			String num = Integer.toBinaryString(i);
			String num1 = num+""+new StringBuilder(num).reverse();
			String num11 = num+"0"+new StringBuilder(num).reverse();
			String num22 = num+"1"+new StringBuilder(num).reverse();
			
			String num33 = num+"2"+new StringBuilder(num).reverse();
			
			res.add(num1);
			res.add(num11);
			res.add(num22);
			int bits=0;
			for (int j = 0; j < n; j++) {
				if(((1<<j)&i)!=0){
					bits++;
				}
			}
			if(bits<3)
				res.add(num33);
//		    pr(num1);pr(num2);pr(num3);
		}
//		for (int i = 0; i < n; i++) {
		StringBuilder s=new StringBuilder("22");
		res.add(s.toString());
		for (int j = 0; j < n; j++) {
			StringBuilder s2=null;
			if(s.length()%2==0){
				 s2 = new StringBuilder(s);
				s2.insert(s.length()/2, "1");
//					res.add(s2.toString());
			}
			s.insert(s.length()/2, "0");
			res.add(s.toString());
			if(s2!=null)
				res.add(s2.toString());
		}
		
		Collections.sort(res,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				BigInteger a = new BigInteger(o1);
				BigInteger b = new BigInteger(o2);
				return a.compareTo(b);
			}
		});
		String []rres =res.toArray(new String[res.size()]);
//		pr(rres);
		pr(x);
		return rres;
	}
	void pr(Object... ob) {
//		if(false)
		out.println(Arrays.deepToString(ob).replace("],", "],\n"));
		out.flush();
	}

	Scanner in;
	PrintWriter out;
	int read(int idx){
		int r=0;
		while(idx>0){
			r+=T[idx-1];
			idx -= (idx & -idx);
		}
		return r;
	}
	void update(int idx, int val){
		while(idx<=N){
			T[idx-1]+=val;
			idx += (idx & -idx);
		}
	}
//	int N =  10000001;
	
	long x = 40000000000000000L;
//			 1000000002000000001
//	long x = 40004000900040004L;
//			 40004000900040004
//	40000000800000004
	int N =  1;
	int T[];
	public void solve() throws Exception{
		in = new Scanner(new File("/Users/rc/test1/C-large-1.in"));
		out = new PrintWriter(System.out);
		N =  (int)Math.sqrt(x);
		T= new int[N];
		pr(N);
		String [] res2 = solve2(new BigInteger("1"), new BigInteger("1000"));
		int ress = solve3()
//		if(true)return;
//		Scanner in = new Scanner(new File("/Users/rc/Eclipse-Workspaces/Algorithm-Competitions-EWS/HuaHCodingProject/src/input_temp_case"));
//		Scanner in = new Scanner(new File("src/C_example"));
		
		
		//Scanner in = new Scanner(new File("D:/in.txt"));
//		String writtenFile = "/Users/rc/test1/C-large-1.in.out.txt";
		
//		out = new PrintWriter(new File(writtenFile));
		int casos = Integer.parseInt(in.nextLine());
		
		pr(isPalindrome(9));
		pr(isPalindrome(200010002),isPalindrome(2001002L*2001002L));
		pr(200010002L*200010002L);
		pr(200010002L*200010002L);
		pr(200000002L*200000002L);
		pr(1000000001L*1000000001L);
		
//		
//		200000002*200000002
//		out.close();
//		if(true)
//			return;
//		pr(isPalindrome(1231));
//		int [] aa = new int[N];
//		long x = 100000000000005L;
		int xx=0;
		for (int j = 1; (long)j*(long)j <= x; j++) {
			if(isPalindrome(j) && isPalindrome(((long)j*((long)j)))){
//				aa[j]=1;
				pr(j,(long)j*((long)j),res2[xx++]);
				update(j,1);
//				pr();
			}
		}
//		pr(aa,T);
		for (int i = 0; i < casos; i++) {
			String ab[]= in.nextLine().split(" ");
			long a = Long.parseLong(ab[0]);
			long b = Long.parseLong(ab[1]);
			int r = read((int)Math.sqrt(b))-read((int)Math.sqrt(a-1));
			out.println("Case #"+(i+1)+": "+r);
//			return;
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
		new CopyOfCodeJam13_C().solve();
	}
}
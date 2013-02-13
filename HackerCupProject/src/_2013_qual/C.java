package _2013_qual;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class C {

	public void solve() {
		int ncase = readInt();
		for (int i = 1; i <= ncase; i++) {
			int []l = readIntArray();
			int n= l[0];
			int k = l[1];
			l = readIntArray();
			long a = l[0];
			long b = l[1];
			long c = l[2];
			long r = l[3];
			int [] res = new int [k];
			res[0]=(int)a;
//			int rres[] = new int[k+1];
//			int []restotal=new int[n];
//			restotal[0]=(int)a;
			LinkedList<Integer> list = new LinkedList<>();
			boolean memo[] = new boolean[k+1];
			for (int j = 0; j < k+1; j++) {
				list.add(j);
			}
			for (int j = 1; j < k; j++) {
				a = (b*a+c)%r;
				res[j]=(int)a;
//				restotal[j]=res[j];
//				System.out.print(a+" ");
//				d[(int)a]=true;
				
			}
			for (int j = res.length-1; j >=0; j--) {
				
				if(res[j]-1<=j){
					if(memo[res[j]])continue;
					memo[res[j]]=true;
					list.remove(new Integer((int)res[j]));
					list.add(j+1, new Integer((int)res[j]));
				}
			}
//			print(list);
			int right = n-k;
			int index = right%(k+1)-1;
//			print(right,index,list.get(index));
//			print("list "+list);
//			print("restotal before",restotal);
//			for (int j = k; j < n; j++) {
//				int rx[]=Arrays.copyOfRange(restotal, j-k, j);
////				print(rx);
//				sort(rx);
////				print(rx);
//				int pick =rx.length;
//				for (int j2=0;j2<=k;j2++) {
//					if(binarySearch(rx, j2)<0){
//						pick=j2;break;
//					}
//				}
//				restotal[j]=pick;
//			}
//			print("resttotal",restotal);
			out.println("Case #"+(i)+": "+list.get(index));
		}
	}
	
	C(){
//		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		try {
//			in = new Scanner(new File("C_in.txt"));
			in = new Scanner(new File("find_the_mintxt.txt"));
			out = new PrintWriter(new File("C_out.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new C().solve();
		close();
	}

	static Scanner in;
	static PrintWriter out;

	static int readInt(){
		return parseInt(in.nextLine());
	}
	static long readLong(){
		return Long.parseLong(in.nextLine());
	}
	static int[] readIntArray(){
		String l[] = in.nextLine().split(" ");
		int[] r=new int[l.length];
		for (int i = 0; i < l.length; i++) {
			r[i]=parseInt(l[i]);
		}
		return r;
	}
	
	static void print(Object... ob) {
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}


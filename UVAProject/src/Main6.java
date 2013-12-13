import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class Main6 {

	public void solve() {
//		Scanner sc = new Scanner(System.in);
//		int n = Integer.parseInt(sc.nextLine());
//		n = 10000;
		pr("\n".getBytes());
		int n = ni();
//		int xx=100000;
		while(n!=0){
			String s = ns1();
//			int size = (int)(Math.random()*10000);
//			char [] axx = new char[size];
//			for (int i = 0; i < axx.length; i++) {
//				char ccc = (char)((Math.random()*('z'-'a'))+'a');
////				pr(ccc);
//				axx[i]=ccc;
//			}
//			String s =new String(axx);
//			for (int i = 0; i < 1000000; i++) {
//				s+='x';
//			}
//			int[] xa = new int[1000000000];
//			pr(s);
			int a = 0;
			HashMap<Character,Integer> set = new HashMap<Character,Integer>();
//			int [] alf= new int[128];
			int r = 0;
			for (int i = 0; i < s.length(); i++) {
//				pr(set);
//				char that = s.charAt(a);
				char thix = s.charAt(i);
				if(set.size()<n){
					Integer ax = set.get(thix);
					if(ax==null){
						set.put(thix,1);
					}else
						set.put(thix,ax+1);
					
				}else if(set.size()==n){
					if(!set.containsKey(thix)){
						while(set.size()==n && a<s.length()){
							char that = s.charAt(a);
							if(set.containsKey(that) && set.get(that)>1)
								set.put(that, set.get(that)-1);
							else
								set.remove(that);
							a++;
						}
						set.put(thix,1);
					}else
						set.put(thix, set.get(thix)+1);
				}
				int newr=i-a+1;
//				pr(newr, set,a,i,s.substring(a,i));
				if(newr>r){
//					pr()
//					pr(set,a,i,s.substring(a,i));
					r=newr;
				}
//				r=max(r,);
			}
			out.println(r);
//			n = (int)(Math.random()*128);
			n = ni();
		}
		
	}
	

	void run() throws Exception {
		in = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);
		long s = System.currentTimeMillis();
		solve();
		out.flush();
//		pr(System.currentTimeMillis() - s + "ms");
	}

	public static void main(String[] args) throws Exception {new Main6().run();}

	InputStream in;
	PrintWriter out;
	String INPUT = "";
	
	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	private byte[] inbuf = new byte[1024];
	private int lenbuf = 0, ptrbuf = 0;

	private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = in.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	private boolean isSpaceChar(int c) {return !(c >= 33 && c <= 126);}
	private int skip() {int b;while ((b = readByte()) != -1 && isSpaceChar(b));return b;}

	private String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != // ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	private String ns1() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b) && b != ' ')) { // when nextLine, 
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	
	private int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}
	
	
	private int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	private long nl(){
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	void pr(Object... ob) {if (!oj)System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));}
}


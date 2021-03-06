package two_pointers;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class Main {

	public void solve() {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		while(n!=0){
			String s = sc.nextLine();
//			pr(s);
			int a = 0;
			HashMap<Character,Integer> map = new HashMap<Character,Integer>();
//			int [] alf= new int[128];
			int r = 0;
			for (int i = 0; i < s.length(); i++) {
//				pr(set);
				char thix = s.charAt(i);
				while(map.size()==n && !map.containsKey((thix)){
					char that = s.charAt(a);
					if(map.get(that)>1)
						map.put(that, map.get(that)-1);
					else
						map.remove(that);
					a++;
				}
				Integer ax = map.get(thix);
				if(ax==null){
					map.put(thix,1);
				}else
					map.put(thix,ax+1);
				
				int newr=i-a+1;
//				pr(newr, set,a,i,s.substring(a,i));
				if(newr>r){
//					pr()
					pr(map,a,i,s.substring(a,i));
					r=newr;
				}
//				r=max(r,);
			}
			out.println(r);
			n = Integer.parseInt(sc.nextLine());
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

	public static void main(String[] args) throws Exception {new Main().run();}

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


import java.io.File;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import static java.lang.Math.*;

public class Justi {
	static String solve(String line) {
		String s = "";
		int []a = new int['z'+1];
		a['A']=a['E']=a['O']=a['I']=a['U']=a['a']=a['e']=a['i']=a['o']=a['u']=1;
		
		boolean cons=false;
		String q="";
		System.err.println(line);
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i)==' '){
				s+=q+" ";
				q="";
				cons=false;
			}else if(a[line.charAt(i)]==1){
				q+=line.charAt(i);
			}else{
				if(!cons)
					s+=q;
				s+=line.charAt(i);
				q="";
				cons=true;
			}
		}
		s+=q;
		return s;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File(
				"/Users/rc/test1/in5.txt"));
		// Scanner sc = new Scanner(new
		// File("/Users/rc/git/TCProject/src/Judges_HuaHCoding/input_temp_case"));
		// Scanner sc = new Scanner(System.in);
		String writtenFile = "/Users/rc/test1/out.txt";
		PrintWriter pw = new PrintWriter(new File(writtenFile));
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			// String sx [] = split(" ");
			String s = solve(sc.nextLine()) + "";
			System.err.println(s);
			pw.println(s);
		}
		System.err.println(writtenFile);
		sc.close();
		pw.close();
	}
}

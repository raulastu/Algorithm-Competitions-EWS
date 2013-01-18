package programmingchallenges;

import static java.lang.Math.*;

import static java.lang.Integer.*;
import static java.util.Arrays.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class LCDDisplay706 {

	String packageName() {
		return "src/"
				+ this.getClass().getPackage().getName().replace(".", "/");
	}

	public static void main(String[] args) throws Exception {
		 Scanner in = new Scanner(System.in);
//		Scanner in = new Scanner(new File(new LCDDisplay706().packageName()+ "/test3.txt"));
		PrintWriter out = new PrintWriter(System.out);
		digs = new char[11][10][][];
		builddigits();
//		print(digs[10][0]);
//		print(digs[1][1]);
//		print(digs[1][2]);
		while (in.hasNextInt()) {
			int s = in.nextInt();
			int n = in.nextInt();
			if (n + s == 0)
				break;
			int rows = 2 * s + 3;
//			print(digs[0]);
//			print(digs[1]);
			int nr = (n + "").length();
			int [] digar=new int[nr];
			int ix = nr-1;
			while(n>0){
				digar[ix--]=n%10;
				n/=10;
			}
			String res = "";
			for (int i = 0; i < rows; i++) {
				for(int di=0;di<nr;di++ ) {
					res += new String(digs[s][digar[di]][i]);
					if(di<nr-1)
						res +=" ";
				}
				res += '\n';
			}
			System.out.println(res);
		}
		in.close();
		out.close();
	}

	static char[][][][] digs;

	static void builddigits() {
		for(int s=1;s<=10;s++){
			int cols = 2 + s;
			int rows = 2 * s + 3;
			digs[s] = new char[10][rows][cols];
			for (int i = 0; i < 10; i++) {
				int digit = i;
				char[][] dig = new char[rows][cols];
				for (int j = 0; j < dig.length; j++) {
					fill(dig[j], ' ');
				}
				switch (digit) {
				case 0:
					fill(dig[0], 1, cols - 1, '-');
					fill(dig[rows - 1], 1, cols - 1, '-');
					for (int j = 1; j < rows / 2; j++) {
						dig[j][0] = dig[j][cols - 1] = '|';
						dig[j + rows / 2][0] = dig[j + rows / 2][cols - 1] = '|';
					}
					break;
				case 1:
					for (int j = 1; j < rows/2; j++) {
						dig[j][cols-1]=dig[j+rows/2][cols-1]='|';
					}
					break;
				case 2:
					fill(dig[0],1,cols-1,'-');
					fill(dig[rows-1],1,cols-1,'-');
					fill(dig[rows/2],1,cols-1,'-');
					for (int j = 1; j < rows/2; j++) {
						dig[j][cols-1]=dig[j+rows/2][0]='|';
					}
					break;
				case 3:
					fill(dig[0],1,cols-1,'-');
					fill(dig[rows-1],1,cols-1,'-');
					fill(dig[rows/2],1,cols-1,'-');
					for (int j = 1; j < rows/2; j++) {
						dig[j][cols-1]=dig[j+rows/2][cols-1]='|';
					}
					break;
				case 4:
					fill(dig[rows/2],1,cols-1,'-');
					for (int j = 1; j < rows/2; j++) {
						dig[j][cols-1]=dig[j][0]=dig[j+rows/2][cols-1]='|';
					}
					break;
				case 5:
					fill(dig[0],1,cols-1,'-');
					fill(dig[rows-1],1,cols-1,'-');
					fill(dig[rows/2],1,cols-1,'-');
					for (int j = 1; j < rows/2; j++) {
						dig[j][0]=dig[j+rows/2][cols-1]='|';
					}
					break;
				case 6:
					fill(dig[0],1,cols-1,'-');
					fill(dig[rows-1],1,cols-1,'-');
					fill(dig[rows/2],1,cols-1,'-');
					for (int j = 1; j < rows/2; j++) {
						dig[j][0]=dig[j+rows/2][cols-1]=dig[j+rows/2][0]='|';
					}
					break;
				case 7:
					fill(dig[0],1,cols-1,'-');
					for (int j = 1; j < rows/2; j++) {
						dig[j][cols-1]=dig[j+rows/2][cols-1]='|';
					}
					break;
				case 8:
					fill(dig[0],1,cols-1,'-');
					fill(dig[rows-1],1,cols-1,'-');
					fill(dig[rows/2],1,cols-1,'-');
					for (int j = 1; j < rows/2; j++) {
						dig[j][cols-1]=dig[j][0]=dig[j+rows/2][cols-1]=dig[j+rows/2][0]='|';
					}

					break;
				case 9:fill(dig[0],1,cols-1,'-');
					fill(dig[rows-1],1,cols-1,'-');
					fill(dig[rows/2],1,cols-1,'-');
					for (int j = 1; j < rows/2; j++) {
						dig[j][cols-1]=dig[j][0]=dig[j+rows/2][cols-1]='|';
					}
					break;
				}
				digs[s][i] = dig;
			}
		}

	}

	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}
}

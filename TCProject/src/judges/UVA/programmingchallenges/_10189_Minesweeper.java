package judges.UVA.programmingchallenges;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import java.io.PrintWriter;
import java.util.*;

public class _10189_Minesweeper {
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n=1;
		int []di={0,0,-1,1,1,-1,1,-1};
		int []dj={-1,1,0,0,1,-1,-1,1};
		while(in.hasNextLine()){
			String [] a = in.nextLine().split(" ");
			int A =Integer.parseInt(a[0]);
			int B =Integer.parseInt(a[1]);
			if(A+B==0)break;
			char[][] mines=new char[A][B];
			for (int i = 0; i < A; i++) {
				mines[i] = in.nextLine().replace(".", "0").toCharArray();
//				System.out.println(mines[i]);
			}
			if(n>1)
				System.out.println();
			
			for (int i = 0; i < A; i++) {
				for (int j = 0; j < B; j++) {
					if(mines[i][j]=='*'){
						for (int j2 = 0; j2 < 8; j2++) {
							int X=i+di[j2];
							int Y=j+dj[j2];
							if(X>=0 && X<A && Y>=0 && Y<B && mines[X][Y]!='*'){
								mines[X][Y]=((mines[X][Y]-'0')+1+"").toCharArray()[0];
//								System.err.println(Character.toChars(((mines[X][Y]-'0')+1))[0]);
							}
						}
					}
				}
			}
//			print(mines);
			System.out.println("Field #"+n+++":");
			for (int i = 0; i < A; i++) {
				System.out.println(new String(mines[i]));
			}
			
		}
		in.close();
		out.close();
	}
	
	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}
}

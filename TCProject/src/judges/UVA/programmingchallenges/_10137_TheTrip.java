package judges.UVA.programmingchallenges;
import static java.lang.Math.*;
import static java.lang.Integer.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

import sun.tools.tree.ThisExpression;

public class _10137_TheTrip {
	
	String packageName(){
		return "src/"+this.getClass().getPackage().getName().replace(".", "/");
	}
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
//		Scanner in = new Scanner(new File(new _10137_TheTrip().packageName()+"/test.txt"));
		PrintWriter out = new PrintWriter(System.out);
		while(in.hasNext()){
			int a = in.nextInt();
			if(a==0)break;
			double []ar = new double[a];
			double sum=0;
			for (int i = 0; i < a; i++) {
				ar[i] = in.nextDouble();
				sum+=ar[i];
			}
			double amt= sum/a+.005;
			double res =0;
			for (int j = 0; j < ar.length; j++) {
				if(ar[j]>amt){
					res+=ar[j]-amt;
				}
			}
			System.out.printf("$%.2f\n",res);
		}
		in.close();
		out.close();
	}
	
	static void print(Object... ob){
		System.err.println(Arrays.deepToString(ob));
	}
}

package programmingchallenges;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class TheTrip10137 {
	
	String packageName(){
		return "src/"+this.getClass().getPackage().getName().replace(".", "/");
	}
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
//		Scanner in = new Scanner(new File(new TheTrip10137().packageName()+"/test.txt"));
		PrintWriter out = new PrintWriter(System.out);
		while(in.hasNext()){
			long n = in.nextLong();
			if(n==0)break;
			double []ar = new double[(int)n];
			double sum=0;
			for (int i = 0; i < n; i++) {
				ar[i] = in.nextDouble();
				sum+=ar[i];
			}
			double amt= (sum/(double)n);
			double neg =0;
			double pos=0;
//			print(amt);
			for (int j = 0; j < ar.length; j++) {
				double dif =(double)(long)((ar[j]-amt)*100.0)/100.0;
				if(dif<0){
					neg+=dif;
				}else{
					pos+=dif;
				}
			}
//			print(lower,upper);
//			print(1/(double)100*(upper/(lower+upper)));
//			print(pos,neg);
			double res =(-neg>pos)?-neg:pos;
//			print(res);
			System.out.printf("$%.2f\n",(double)(res));
		}
		in.close();
		out.close();
	}
	
	static void print(Object... ob){
		System.err.println(Arrays.deepToString(ob));
	}
}

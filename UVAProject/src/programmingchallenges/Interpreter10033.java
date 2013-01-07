package programmingchallenges;

import static java.lang.Math.*;
import static java.lang.Integer.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Interpreter10033 {

	String packageName() {
		return "src/"
				+ this.getClass().getPackage().getName().replace(".", "/");
	}

	public static void main(String[] args) throws Exception {
		 Scanner in = new Scanner(System.in);
//		Scanner in = new Scanner(new File(new Interpreter10033().packageName()+ "/test2.txt"));
		PrintWriter out = new PrintWriter(System.out);
		int i = parseInt(in.nextLine());
		in.nextLine();
		for (int j = 0; j < i; j++) {
			String line = "";
			int[] regArray = new int[10];
			int[] RAM = new int[1000];
			int x=0;
			while (in.hasNextLine() && !(line = in.nextLine()).equals("")) {
				int instruction = parseInt(line);
				RAM[x++]=instruction;
			}
			int res = 0;
			x:
			for (int k = 0; k < RAM.length;) {
				res++;
				int instruction = RAM[k];
				int a2, a1, key;
				a2 = instruction % 10;
				instruction /= 10;
				a1 = instruction % 10;
				instruction /= 10;
				key = instruction % 10;
//				print(key,a1,a2);
				switch (key) {
				case 0:
					if(regArray[a2]==0){
						k++;
					}else{
						k=regArray[a1];
					}
					break;
				case 1:
						break x;
				case 2:
					regArray[a1] = a2;
					k++;
					break;
				case 3:
					regArray[a1] = (regArray[a1]+a2)%1000;
					k++;
					break;
				case 4:
					regArray[a1] = (regArray[a1]*a2)%1000;
					k++;
					break;
				case 5:
					regArray[a1] = regArray[a2];
					k++;
					break;
				case 6:
					regArray[a1] = (regArray[a1]+regArray[a2])%1000;
					k++;
					break;
				case 7:
					regArray[a1] = (regArray[a1]*regArray[a2])%1000;
					k++;
					break;
				case 8:
					regArray[a1] = RAM[regArray[a2]];
					k++;
					break;
				case 9:
					RAM[regArray[a2]] = regArray[a1];
					k++;
					break;
				}
//				print(registers);
			}
			System.out.println(res);
			if(j<i-1)
				System.out.println();
//			print(res);
		}
		in.close();
		out.close();
	}

	static void print(Object... ob) {
		System.err.println(Arrays.deepToString(ob));
	}
}

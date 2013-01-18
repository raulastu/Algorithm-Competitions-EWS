package programmingchallenges;

import static java.lang.Math.*;

import static java.lang.Integer.*;
import static java.util.Arrays.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class CheckTheCheck10196 {

	String packageName() {
		return "src/"
				+ this.getClass().getPackage().getName().replace(".", "/");
	}

	public static void main(String[] args) throws Exception {
//		 Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File(new CheckTheCheck10196().packageName()+ "/CheckTheCheck10196.txt"));
		PrintWriter out = new PrintWriter(System.out);
		int xi=1;
		while (in.hasNextLine()) {
			table = new char[8][8];
			boolean valid=false;
			for (int i = 0; i < 8; i++) {
				String line =in.nextLine();
				table[i]=line.toCharArray();
				int j;
				if((j=line.indexOf('k'))>=0){
					bkx=i;
					bky=j;
				}
				if((j=line.indexOf('K'))>=0){
					wkx=i;
					wky=j;
				}
				valid = valid || new String(table[i]).replace(".", "").length()>0;
				
			}
			boolean bkCheck=false;
			boolean wkCheck=false;
//			print(bkx,bky,wkx,wky);
			for (int i = 0; i < table.length; i++) {
				for (int j = 0; j < table.length; j++) {
					char c=table[i][j];
					boolean white=Character.isUpperCase(c);
					c=Character.toLowerCase(c);
						switch(c){
							case 'p':
								if(white){
									bkCheck=bkCheck||pawnThreatW(i, j);
								}else{
									wkCheck=wkCheck||pawnThreatB(i, j);
								}
								break;
							case 'r':
								if(white){
									bkCheck=bkCheck||rock(i, j,bkx,bky);
								}else{
									wkCheck=wkCheck||rock(i, j,wkx,wky);
								}
								break;
							case 'b':
								if(white){
//									System.err.println(bkCheck);
									bkCheck=bkCheck||bishop(i,j,bkx,bky);
//									System.err.println(bkCheck);
								}else{
									wkCheck=wkCheck||bishop(i,j,wkx,wky);
								}
								break;
							case 'q':
								if(white){
									bkCheck=bkCheck||queen(i,j,bkx,bky);
								}else{
									wkCheck=wkCheck||queen(i,j,wkx,wky);
								}
								break;
							case 'k':
								break;
							case 'n':
								if(white){
									bkCheck=bkCheck||knight(i,j,bkx,bky);
								}else{
									wkCheck=wkCheck||knight(i,j,wkx,wky);
								}
								break;
						}
				}
			}
			if(!valid)
				break;
			
			if(bkCheck){
				System.out.println("Game #"+xi+": black king is in check.");
			}
			if(wkCheck){
				System.out.println("Game #"+xi+": white king is in check.");
			}
			if(!bkCheck && !wkCheck){
				System.out.println("Game #"+xi+": no king is in check.");
			}
			xi++;
			in.nextLine();
			
		}
		in.close();
		out.close();
	}
	static char[][]table;
	static boolean[][]memo;
	static int 	di[]={-2,-2, 2, 2, 1, 1,-1, -1},
				dj[]={1 ,-1, 1,-1, 2,-2, 2,-2},M,N;
	
	static int wkx,wky,bkx,bky;
	
	
	
	static boolean knight(int x, int y, int kx, int ky){
		for (int i = 0; i < 8; i++) {
			int X= x+di[i];
			int Y= y+dj[i];
			if(X>=0 && X<8 && Y>=0 && Y<8 && X==kx && Y==ky){
				return true;
			}
		}
		return false;
	}
	static boolean queen(int x, int y, int kx,int ky){
		boolean r=false;
		r=r||bishop(x,y,kx,ky);
		r=r||rock(x,y,kx,ky);
		return r;
	}
	static boolean bishop(int x, int y, int kx,int ky){
		for (int i = x+1,j=y+1; i < 8 && j<8; i++,j++) {
			if(i==kx && j==ky)
				return true;
			if(table[i][j]!='.')
				break;
		}
		for (int i = x-1,j=y-1; i >= 0 && j>=0; i--,j--) {
			if(i==kx && j==ky)
				return true;
			if(table[i][j]!='.')
				break;
		}
		for (int i = x+1,j=y-1; i < 8 && j>=0; i++,j--) {
			if(i==kx && j==ky)
				return true;
			if(table[i][j]!='.')
				break;
		}
		for (int i = x-1,j=y+1; i >=0 && j<8; i--,j++) {
			if(i==kx && j==ky)
				return true;
			if(table[i][j]!='.')
				break;
		}
		return false;
	}
	static boolean rock(int x, int y, int kx,int ky){
		for (int j = y+1; j < 8 ; j++) {
			if(x==kx && j==ky)return true;
			if(table[x][j]!='.')break;
			
		}
		for (int j = y-1; j >=0 ; j--) {
			if(x==kx && j==ky)
				return true;
			if(table[x][j]!='.')
				break;
		}
		for (int i = x+1; i < 8; i++) {
			if(i==kx && y==ky)
				return true;
			if(table[i][y]!='.')
				break;
		}
		for (int i = x-1; i >=0; i--) {
			if(i==kx && y==ky)
				return true;
			if(table[i][y]!='.')
				break;
		}
		return false;
	}
	static boolean pawnThreatW(int x, int y){
		if(valid(x-1,y-1)){
			if(x-1==bkx && y-1==bky)
				return true;
		}
		if(valid(x-1,y+1)){
			if(x-1==bkx && y+1==bky)
				return true;
		}
		return false;
	}
	static boolean pawnThreatB(int x, int y){
		if(valid(x+1,y-1)){
			if(x+1==wkx && y-1==wky)
				return true;
		}
		if(valid(x+1,y+1)){
			if(x+1==wkx && y+1==wky)
				return true;
		}
		return false;
	}
	
	static boolean valid(int x, int y){
		if(x>=0 && x<8 && y>=0 && y<8)
			return true;
		return false;
	}
	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}
}

package programmingchallenges;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class AustralianVoting10142 {
	
	String packageName(){
		return "src/"+this.getClass().getPackage().getName().replace(".", "/");
	}
	public static void main(String[] args) throws Exception {
//		Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File(new AustralianVoting10142().packageName()+"/AustralianVoting10142.txt"));
		PrintWriter out = new PrintWriter(System.out);
		int n  = parseInt(in.nextLine());
		for(int i=0;i<n;i++){
			in.nextLine();
			int can=parseInt(in.nextLine());
			String [] cand = new String[can];
			node[] canNode = new node[can];
			for (int j = 0; j < can; j++) {
				cand[j]=in.nextLine();
				canNode[j] = new node(cand[j]);
			}
			ArrayList<int[]> ballots = new ArrayList<int[]>();
			String line ="";
			while(in.hasNextLine() && !(line=in.nextLine()).equals("")){
				String []s = line.split(" ");
				int []ss=new int[can];
				for (int j = 0; j < can; j++) {
					ss[j]=parseInt(s[j]);
				}
				ballots.add(ss);
			}
			int [][]ball=new int[ballots.size()][can];
			for (int j = 0; j < ballots.size(); j++) {
				ball[j]=ballots.get(j);
			}
			int [] candidatesVotes=new int[can];
			
			for (int j = 0; j < ball.length; j++) {
				int j2=0;
				while(ball[j][j2]==-1){
					j2++;
				}
				canNode[ball[j][j2]-1].votes++;
				canNode[ball[j][j2]-1].percentage+=(1/(double)ball.length);
			}
			Arrays.sort(canNode, new Comparator<node>() {
				@Override
				public int compare(node o1, node o2) {
					return o2.votes-o1.votes;
				}
			});
			if(canNode[0].percentage>1/2){
				System.out.println(canNode[0]);
				break;
			}
			boolean tied=true;
			for (int j = 1; j < canNode.length; j++) {
				if(canNode[j].votes!=canNode[j-1].votes){
					tied=false;
					break;
				}
			}
			if(tied){
				Arrays.sort(canNode, new Comparator<node>() {
					@Override
					public int compare(node o1, node o2) {
						return o2.name.compareTo(o1.name);
					}
				});
			}
			print(canNode);
		}
		in.close();
		out.close();
	}
	static class node{
		String name;
		int votes;
		double percentage;
		public node(String name) {
			this.name=name;
		}
		@Override
		public String toString() {
			return name+" "+votes+" "+percentage;
		}
	}
	
	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}
}

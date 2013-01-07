import java.util.Arrays;


public class Fib {
	public static void main(String[] args) {
		fib(5);
		printTree();
	}

	
	public static long fib(long n){
		tn(n);
		if(n==0 || n==1){
			tb();
			return 0;
		}
		tns();
		long x = fib(n-1)+fib(n-2);
		tne();
		return x; 
	}
	
	
	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}
	
	static String tl="";
	private static void printTree() {
//		System.err.println(tl);
//		System.err.println(tl.length());
		try{
			String[] drawing = new Util.treeDrawing.TreeDrawing().draw(new String[]{tl});
			System.err.println(Arrays.deepToString(drawing).replaceAll("\\[|\\]", "").replaceAll(", ", "\n")+"\n");
		}catch (Exception ex){
			ex.printStackTrace();
			System.err.println("invalid tree>"+tl);
		}	
		tl="";
	}
	private static void tn(Object...o){tl+="("+Arrays.deepToString(o).replaceAll(" |\\[|\\]", "")+")";}
	private static void tb(){tl+="[]";}
	private static void tns(){tl+="[";}
	private static void tne(){tl+="]";}

	
	
}

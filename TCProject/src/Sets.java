import java.util.Arrays;


public class Sets {
	public static void main(String[] args) {
		a=new int[]{1,2,3,4};
		subsets(0);
		printTree();
	}

	static int []a;
	public static void subsets(int i){
		tn(i);
		if(i>=a.length){
			tb();
			return;
		}
		tns();
		subsets(i+1);
		subsets(i+2);
		tne();
		return; 
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

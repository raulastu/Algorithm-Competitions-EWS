package BinaryIndexedTree;

import java.util.Arrays;

public class BIT {
	
	int MAX=16;
	int [] tree;
	
	public BIT() {
		int []f={
				1,0,2,1,1,3,0,4,2,5,2,2,3,1,0,2
		};
		int []c=new int[f.length];
		pr(f.length);
		c[0]=f[0];
		for (int i = 1; i < c.length; i++) {
			c[i]=c[i-1]+f[i];
		}
		for (int i = 0; i < 16; i++) {
			String idx=Integer.toBinaryString(i+1);
			String idxc=Integer.toBinaryString(~(i+1));
			int r = lastSign(idx);
			int r2=(int)Math.pow(2,r);
			pr(i+1,f[i],c[i],idx,r,r2,(i+1)-r2+1,i+1);
		}
		
		tree= new int[17];
		//START - building the tree naively;
//		for (int i = 1; i < tree.length; i++) {
//			tree[i]=f[i-1];
//			int j=i-(i&-i)+1;
//			int s=0;
//			for (; j<=i; j++) { //(idx - 2^r + 1) to index idx 
//				s+=f[j-1];
//			}
//			tree[i]=s;
//		}
		// END - building the tree naively;
		
		for (int i = 1; i < tree.length; i++) {
			update(i,f[i-1]);
			update(i+1,-f[i-1]);
		}
		//reading values
		pr(read(13,tree));
		pr(tree);
	}
	
	void update(int idx, int val){
		while(idx<=MAX){
			tree[idx]+=val;
			idx+=(idx&-idx);
		}
	}
	
	static int read(int idx, int tree[]){
		int sum=0;
//		idx-=(idx&-idx);
		while(idx>0){
			sum+=tree[idx];
//			pr(idx,
//				Integer.toBinaryString(idx),
//				Integer.toBinaryString(idx&-idx),
//				(idx&-idx)
//			);
			idx-=(idx&-idx);
		}
		pr();
		return sum;
	}

	
	//getting the index of the least significant bit (from right to left)
	static int lastSign(String x){
		int ix=0;
		for (int j = 0; j < x.length(); j++) {
			if(x.charAt(j)=='1'){
				ix=x.length()-1-j;
			}
		}
		return ix;
	}
	static void pr(Object... ob) {
			System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}

	public static void main(String[] args) {
		new BIT();
	}
}

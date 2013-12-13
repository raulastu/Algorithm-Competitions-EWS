package strings;

import java.util.Arrays;

//
public class KMP {
	
	int find(char [] haystack, char []needle){
		int [] t = new int[needle.length];
		t[0]=-1;
		for (int i = 1; i < t.length; i++) {
			
		}
		for (int m = 0; m < haystack.length - needle.length; m++) {
			pr(m,t);
			for (int i = 0; i < needle.length; i++) {
				if(haystack[m+i]==needle[0]){
					t[i]=-1;
				}else{
					t[i]+=t[i-1]+1;
				}
				
				if(needle[i]==haystack[m+i]){
					if(i==needle.length-1)
						return m;
					continue;
				}else{
					m+=i-t[i];
					break;
				}
			}
		}
		return -1;
	}
	
	int [] getTable (char w[]){
		int [] t = new int[w.length];
		t[0]=-1;
		t[1]=0;
		int pos=2,cnd=0;
		while(pos<w.length){
			if(w[pos-1]==w[cnd]){
				cnd++;
				t[pos]=cnd;
				pos++;
			}else if(cnd>0){
				cnd = t[cnd];
			}else{
				t[pos]=0;
				pos++;
			}	
		}
		return t;
	}
	
	public static void main(String[] args) {
		char [] h = "ABC ABCDAB ABCDABCDABDE".toCharArray();
		char [] n = "ABCDABD".toCharArray();
		int r = new KMP().find(h, n);
		System.out.println(r);
	}
	
	void pr(Object... ob) {
			System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
	
}

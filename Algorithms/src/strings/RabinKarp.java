package strings;

import java.util.Arrays;

public class RabinKarp {

	int B = 26;
	int m,n;
	int M = 1000000007;
	
	int find(char [] text, char []pattern){
		m = pattern.length;
		n = text.length;
		int E=1;
		for (int i = m-2; i >=0; i--) {
			E=mod(E*B,M);
		}
		int hp=0;
		for (int i = 0; i < m; i++) {
			hp=mod(hp*B+pattern[i],M);
		}
		int ht = 0;
		for (int i = 0; i < m; i++) {
			ht=mod(ht*B+text[i],M);
		}
		if(ht==hp)
			for (int i = 0; i < m; i++) 
				if(text[i]!=pattern[i])
					break;
				else if(i==m-1)
					pr("i",0);
		for (int i = 1; i < n-m+1; i++) {
			ht=mod(ht-mod(text[i-1]*E,M),M);
			ht=mod(ht*B,M);
			ht=mod(ht+text[i+m-1],M);
			pr(ht);
			if(ht==hp){
				for (int j = i; j <i+ m; j++) 
					if(text[j]!=pattern[j])
						break;
					else if(j==m-1)
						pr("i",0);
				break;
			}
		}
//		pr(hp,ht);
		return -1;
	}
	int mod(int a, int b){
		return (a%b+b)%b;
	}
	int hash(char []s, int from, int to, int []exps){
		int ret = 0;
		for (int i = from; i < to; i++) {
			ret+=(s[i]%M*exps[i]%M)%M;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		char [] h = "ABC ABCDAB ABCDABCDABDEX".toCharArray();
		char [] n = "EX".toCharArray();
		int r = new RabinKarp().find(h, n);
		System.out.println(r);
	}
	
	void pr(Object... ob) {
			System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
	
}

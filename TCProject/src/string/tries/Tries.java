package string.tries;

import java.util.Arrays;

public class Tries {
	void test(){
		vertex v=new vertex();
//		v.cha=' ;
		v.addWord("");
		v.addWord("tree");
		v.addWord("tr");
		v.addWord("trie");
		v.addWord("algo");
		v.addWord("assoc");
		v.addWord("all");
		v.addWord("also");
		System.err.println(v);
		System.err.println(v.countWords("trx"));
		System.err.println(v.countWords2("al",1));
		System.err.println(v.countPrefixes("as"));
	} 
	class vertex{
		int words=0;
		int prefixes=0;
		char cha;
		vertex[] edges=new vertex[26];
		
		void init(vertex v){
			v.words=0;
			v.prefixes=0;
		}
		void addWord(String word){
			if(word.isEmpty()){
				words++;
			}else{
				
				char c = word.charAt(0);
				if(edges[c-'a']==null){
					edges[c-'a']=new vertex();
					edges[c-'a'].cha=c;
				}
				edges[c-'a'].prefixes++;
				edges[c-'a'].addWord(word.substring(1));
			}
		}
		int countWords(String word){
			if(word.isEmpty()){
				return words;
			}
			char k = word.charAt(0);
			if(edges[k-'a']==null){
				return 0;
			}else{
				return edges[k-'a'].countWords(word.substring(1));
			}
		}
		
		int countWords2(String word, int missingLetters){
			if(word.isEmpty()){
				return words;
			}
			char k = word.charAt(0);
			if(edges[k-'a']==null && missingLetters==0){
				return 0;
			}else if(edges[k-'a']==null){
				return countWords2(word.substring(1), missingLetters-1);
			}else{
				int r=countWords2(word, missingLetters-1);
				r=r+edges[k-'a'].countWords2(word.substring(1), missingLetters);
				return r;
			}
		}
		int countPrefixes(String prefix){
			if(prefix.isEmpty()){
				return prefixes;
			}
			char k = prefix.charAt(0);
			if(edges[k-'a']==null){
				return 0;
			}else{
				return edges[k-'a'].countPrefixes(prefix.substring(1));
			}
		}
		
		@Override
		public String toString() {
			String kids="[";
			for (int i = 0; i < 26; i++) {
				kids+=(edges[i]!=null?edges[i]:"");
			}
			kids+="]";
			return ""+cha+""+kids;
		}
	}
	
	private static String print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
		return Arrays.deepToString(rs).replace("]", "]\n");
	}
	public static void main(String[] args) {
		new Tries().test();
	}
}

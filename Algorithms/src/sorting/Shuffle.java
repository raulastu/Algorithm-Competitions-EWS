package sorting;

public class Shuffle {
    void shuffle(int ar[]){
        for (int i = ar.length-1; i>=0;i--){
                int j = (int)(Math.random()*i);
	      	      int t = ar[i];
	      	      ar[i]=ar[j];
	      	      ar[j]=t;
        }    
    }
}

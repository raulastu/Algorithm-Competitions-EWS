package segment_tree;

public class Snippet {
	#include <iostream>
	#include <cmath>
	#include <stdio.h>
	
	#define len(c) sizeof(c)/4
	#define print(c,n) for(int ix = 0; ix < n; ix++) cout <<c[ix]<<" ";cout<<endl;
	#define getcx getchar_unlocked
	#define MAXN 100000
	#define N 400000
	#define long long ll
	
	using namespace std;
	
	inline void inp( int &n )
	{
	    n=0;
	    int ch=getcx();int sign=1;
	    while( ch < '0' || ch > '9' ){if(ch=='-')sign=-1; ch=getcx();}
	    
	    while(  ch >= '0' && ch <= '9' )
	        n = (n<<3)+(n<<1) + ch-'0', ch=getcx();
	    n=n*sign;
	}
	
	
	ll A[MAXN];
	ll T[N];
	ll LP[N];
	
	void build(int node, int a, int b){
	    int m=(a+b)/2,r=node*2,l=node*2+1;
	    if(a==b){
	//        T[node]=A[];
	        //        T[node][1]=0;
	        //        T[node][2]=0;
	        return;
	    }
	    build(r, a,m);
	    build(l, m+1,b);
	    //    for (int i=0; i<3; i++) {
	    //        T[node][i] = T[node*2][i]+T[node*2+1][i];
	    //    }
	    T[node]=T[r]+T[l];
	}
	
	void propagate(int node, int a, int b){
	    int n=LP[node];
	    if(n>0){
	        if(a!=b){
	            LP[node*2]+=LP[node];
	            LP[node*2+1]+=LP[node];
	        }
	        T[node]+=LP[node];
	        LP[node]=0;
	    }
	}
	
	void update(int node, int a, int b, int i, int j, int v){
	    int m=(a+b)/2,r=node*2,l=node*2+1;
	    propagate(node,a,b);
	    if(i>b || j<a)
	        return;
	    if(a>=i && b<=j){
	        LP[node]+=v;
	        propagate(node, a,b);
	        return;
	    }
	    update(r, a,m,i,j);
	    update(l, m+1,b,i,j);
	    T[node] = T[r]+T[l];
	}
	
	int query(int node, int a, int b, int i, int j){
	    int m=(a+b)/2,r=node*2,l=node*2+1;
	    propagate(node,a,b);
	    if(i>b || j<a){
	        return 0;
	    }
	    if(a>=i && b<=j){
	        return T[node][0];
	    }
	    
	    int p1 = query(r,a,m,i,j);
	    int p2 = query(l,m+1,b,i,j);
	    return p1+p2;
	}
	
	
	int main()
	{
	    cout<<"xxx";
	    int T;
	    inp(T);
	    while(T--){
	        int n,q;
	        inp(n);
	        inp(q);
	        A= new int[n];
	//        build(1, 0, n-1);
	        for(int i=0;i<q;i++){
	            int opt,a,b,v;
	            inp(opt);
	            inp(a);
	            inp(b);
	            if(opt==0){
	                inp(v);
	                update(1, 0, n-1, a, b, v);
	            }else{
	                printf("%d\n", query(1, 0, n-1, a, b));
	            }
	        }
	    }
	    return 0;
	}
	
	
}


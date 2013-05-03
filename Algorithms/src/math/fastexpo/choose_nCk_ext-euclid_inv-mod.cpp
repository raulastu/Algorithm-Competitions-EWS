#include <algorithm>
#include <iostream>
#include <sstream>
#include <string>
#include <vector>
#include <queue>
#include <set>
#include <map>
#include <cstdio>
#include <cstdlib>
#include <cctype>
#include <cmath>
#define fill(a , value) memset(a , value , sizeof(a))

using namespace std;


// START COMBINATORICS
struct EuclidReturn{
    long long u,v,d;

    EuclidReturn(long long _u, long long _v, long long _d){
        u = _u; v = _v; d = _d;
    }
};

EuclidReturn Extended_Euclid(long long a, long long b){
    if(b==0) return EuclidReturn(1,0,a);
    EuclidReturn aux = Extended_Euclid(b,a%b);
    long long v = aux.u-(a/b)*aux.v;
    return EuclidReturn(aux.v,v,aux.d);
}

// ax = b (mod n)
long long solveMod(long long a,long long b,long long n){
    EuclidReturn aux = Extended_Euclid(a,n);
    if(b%aux.d==0) return ((aux.u * (b/aux.d))%n+n)%n;
    return -1;// no hay solucuion
}

// ax = 1(mod n)
long long modular_inverse(long long a, long long n){
    EuclidReturn aux = Extended_Euclid(a,n);
    return ((aux.u/aux.d)%n+n)%n;
}
long long comb(long long n, long long m){
    if(m>n-m) m = n-m;

    long long C = 1;
    //C^{n}_{i} -> C^{n}_{i+1}
    for(long long i=0;i<m;++i)
    	C = ( C * ( ( (n-i)*modular_inverse(1+i,MOD) )%MOD ) )%MOD;
    return C;
}

// END COMBINATORICS

// BEGIN CUT HERE
int main( int argc, char* argv[] ) {
    {
        int cardsARRAY[] = {0,6,5,10,3,0,11};
        vector <int> cards( cardsARRAY, cardsARRAY+ARRSIZE(cardsARRAY) );
        CardStraights theObject;
        eq(0, theObject.longestStraight(cards),5);
    }
    {
        int cardsARRAY[] = {100,100,100,101,100,99,97,103};
        vector <int> cards( cardsARRAY, cardsARRAY+ARRSIZE(cardsARRAY) );
        CardStraights theObject;
        eq(1, theObject.longestStraight(cards),3);
    }
    {
        int cardsARRAY[] = {0,0,0,1,2,6,8,1000};
        vector <int> cards( cardsARRAY, cardsARRAY+ARRSIZE(cardsARRAY) );
        CardStraights theObject;
        eq(2, theObject.longestStraight(cards),6);
    }
    {
        int cardsARRAY[] = {1,9,5,7,3,4,0,0,0,10};
        vector <int> cards( cardsARRAY, cardsARRAY+ARRSIZE(cardsARRAY) );
        CardStraights theObject;
        eq(3, theObject.longestStraight(cards),10);
    }
    {
        int cardsARRAY[] = {0,0,0,8,10,12,13,15,17,18,19,20,21,22,23};
        vector <int> cards( cardsARRAY, cardsARRAY+ARRSIZE(cardsARRAY) );
        CardStraights theObject;
        eq(3, theObject.longestStraight(cards),14);
    }
    {
        int cardsARRAY[] = {0,0,0,1};
        vector <int> cards( cardsARRAY, cardsARRAY+ARRSIZE(cardsARRAY) );
        CardStraights theObject;
        eq(3, theObject.longestStraight(cards),4);
    }
}
// END CUT HERE

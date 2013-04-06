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
using namespace std;
#define all(v) (v).begin(),(v).end()
#define rall(v) (v).rbegin(),(v).rend()
#define debug(a) cerr << #a << ": " << a << endl;
#define debugv(b) cerr << #b << ":\n"; for(int countvec = 0; countvec < b.size(); countvec++) {cerr << b[countvec] << "    ";} cerr << endl;
#define debuga(b) cerr << #b << ":\n"; for(int countvec = 0; countvec < sizeof(b)/sizeof(int); countvec++) {cerr << b[countvec] << "    ";} cerr << endl;
#define debugm(c) cerr << #c << ":\n"; for(int countmat = 0; countmat < c.size(); countmat++) {for(int countbb = 0; countbb < c[countmat].size(); countbb++) { cerr << c[countmat][countbb] << "    "; } cerr << endl; }
#define fill(a , value) memset(a , value , sizeof(a))
#define FOREACH(i,c) for (typeof((c).end()) i = (c).begin(); i != (c).end(); ++i)
string tos(int a) {ostringstream os(""); os << a; return os.str();}


// BEGIN CUT HERE
vector<string> split( const string& s, const string& delim =" " ) {
    vector<string> res;
    string t;
    for ( int i = 0 ; i != s.size() ; i++ ) {
        if ( delim.find( s[i] ) != string::npos ) {
            if ( !t.empty() ) {
                res.push_back( t );
                t = "";
            }
        } else {
            t += s[i];
        }
    }
    if ( !t.empty() ) {
        res.push_back(t);
    }
    return res;
}

vector<int> splitInt( const string& s, const string& delim =" " ) {
    vector<string> tok = split( s, delim );
    vector<int> res;
    for ( int i = 0 ; i != tok.size(); i++ )
        res.push_back( atoi( tok[i].c_str() ) );
    return res;
}
// END CUT HERE

// BEGIN CUT HERE
#define ARRSIZE(x) (sizeof(x)/sizeof(x[0]))

template<typename T> void print( T a ) {
    cerr << a;
}
static void print( long long a ) {
    cerr << a << "L";
}
static void print( string a ) {
    cerr << '"' << a << '"';
}
template<typename T> void print( vector<T> a ) {
    cerr << "{";
    for ( int i = 0 ; i != a.size() ; i++ ) {
        if ( i != 0 ) cerr << ", ";
        print( a[i] );
    }
    cerr << "}" << endl;
}
template<typename T> void eq( int n, T have, T need ) {
    if ( have == need ) {
        cerr << "Case " << n << " passed." << endl;
    } else {
        cerr << "Case " << n << " failed: expected ";
        print( need );
        cerr << " received ";
        print( have );
        cerr << "." << endl;
    }
}
template<typename T> void eq( int n, vector<T> have, vector<T> need ) {
    if( have.size() != need.size() ) {
        cerr << "Case " << n << " failed: returned " << have.size() << " elements; expected " << need.size() << " elements.";
        print( have );
        print( need );
        return;
    }
    for( int i= 0; i < have.size(); i++ ) {
        if( have[i] != need[i] ) {
            cerr << "Case " << n << " failed. Expected and returned array differ in position " << i << ".";
            print( have );
            print( need );
            return;
        }
    }
    cerr << "Case " << n << " passed." << endl;
}
static void eq( int n, string have, string need ) {
    if ( have == need ) {
        cerr << "Case " << n << " passed." << endl;
    } else {
        cerr << "Case " << n << " failed: expected ";
        print( need );
        cerr << " received ";
        print( have );
        cerr << "." << endl;
    }
}
// END CUT HERE
void divisors(int n){
    // int n;
   int i=2;
   scanf("%d",&n);
   while(i < sqrt(n))
    {
        if(n%i==0) {
                  printf("%d,",i);
                  printf("%d,",n/i);
        }

        i++;
    }
   if(i*i == n)
        printf("%d,",i); 
    printf("\n,"); 
}
int isPrime(int n){
    if(n<=2)return 1;
    for (int i = 2; i*i <=n; ++i)
    {
        if(n%i==0)
            return 0;
    }
    return 1;
}
int dp[1001];
int go(int n, int j){
    
    if(isPrime(n)==1 || n<=1 ){
        return 1;
    }
    int win=0;
    int i=2;
    if(dp[n]==-1){
        while(i < sqrt(n))
        {
            if(n%i==0) {
                win+=go(n-i,j==0?1:0);
                win+=go(n-(n/i),j==0?1:0);
            }
            i++;
        }
        if(i*i == n)
            win+=go(n-i,j==0?1:0); 
        int r = 0;
        if(win>0)
            r= 0;
        if(win==0)
            r= 1;
        // debug(n);
        // debug(r);
        // debug(win);
        // return r;
        dp[n]=r;
        // dp[n][j==0?1:0]=win==0?1:0;
    }
    return dp[n];
}
string my(int n){
    int x=go(n,0);
    return x==0?"John":"Brus";
}
int a[1111];
map<int,int>memo;
bool win(int n){
    for (int d = n-1; d>1; d--)
    {
        if(n%d==0){
            map<int,int>::iterator it = memo.find(n-d);
            int WIN=0;
            if(it!=memo.end()){
                WIN = it->second;
            }
            else
                WIN = win(n-d);
            if(!WIN){
                memo[n]=1;
                return true;
            }
        }
    }
    memo[n]=0;
    return false;
}
string yours(int n){
    memo.clear();
    string john="John",brus="Brus";
    string ans[2]={john,brus};
    return ans[(win(n)+1)%2];
}
class TheNumberGameDivTwo {
public:
    string find(int n) {
        string res;
        
        // cerr<<isPrime(2)<<endl;
        // cerr<<isPrime(4)<<endl;
        // cerr<<isPrime(6)<<endl;
        for (int i = 1; i <= 1000; ++i)
        {
            fill(dp,-1);
            if(my(i)!=yours(i)){
                cerr<<i<<" do it"<<endl;
            }
        }
        fill(dp,-1);
        return my(n);
    }
};

// BEGIN CUT HERE
int main( int argc, char* argv[] ) {

    {
        TheNumberGameDivTwo theObject;
        eq(3, theObject.find(6),"John");
    }
    if(1)return 1;
    {
        TheNumberGameDivTwo theObject;
        eq(1, theObject.find(2),"Brus");
    }
        {
        TheNumberGameDivTwo theObject;
        eq(3, theObject.find(3),"Brus");
    }
    {
        TheNumberGameDivTwo theObject;
        eq(3, theObject.find(4),"John");
    }
    {
        TheNumberGameDivTwo theObject;
        eq(2, theObject.find(9),"Brus");
    }
    {
        TheNumberGameDivTwo theObject;
        eq(2, theObject.find(8),"Brus");
    }
    {
        TheNumberGameDivTwo theObject;
        eq(2, theObject.find(16),"John");
    }
    {
        TheNumberGameDivTwo theObject;
        eq(2, theObject.find(747),"Brus");
    }
    {
        TheNumberGameDivTwo theObject;
        eq(3, theObject.find(128),"Brus");
    }
}
// END CUT HERE

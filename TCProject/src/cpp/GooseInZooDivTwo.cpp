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


bool memo[51][51];
vector <string> field;
int MOD=1000000007;;
int N, M;


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
    for(long long i=0;i<m;++i) C = ( C * ( ( (n-i)*modular_inverse(1+i,MOD) )%MOD ) )%MOD;
    return C;
}

void dfs(int x, int y, int dist){
  // debug(x);
  // debug(y);
  // debug(field[0].size());
  memo[x][y]=1;
  for (int i = 0; i < N ; ++i)
    {
      for (int j = 0; j < M; ++j)
      {
        if(field[i][j]=='v' && !memo[i][j] && abs(i-x)+abs(j-y)<=dist) {
          dfs(i,j,dist);
        }
      }
    }  
}
struct node{
  int a,b,c;
  node(int _a, int _b, int _c){
    a=_a;
    b=_b;
    c=_c;
  }
};

int di[]={0,0,-1,1};
int dj[]={-1,1,0,0};

void bfs(int x, int y, int dist){
  queue <node> Q;
  Q.push(node(x,y,dist));
  memo[x][y]=1;
  while(!Q.empty()){
    node p = Q.front();Q.pop();
    for(int i=0;i<4;i++){
      int X=p.a+di[i];
      int Y=p.b+dj[i];
      if(X>=0 && X<N && Y>=0 && Y<M && !memo[X][Y]){
        if(p.c>0){
          if(field[X][Y]=='v'){
            memo[X][Y]=1;
            Q.push(node(X,Y,dist));
          }else{
            Q.push(node(X,Y,p.c-1));
          }
        }
      }
    }
  }
}

long long F[2501];

long long choose(int N, int K){
    if(N==M)return 1;
    return F[N]/((F[K]*F[N-K])%MOD);
}

long long binomial(int n, int k)
{
    long long coeff = 1;
    for (int i = n - k + 1; i <= n; i++) {
      coeff = (coeff*(long long)i)%MOD;
    }
    for (int i = 1; i <= k; i++) {
      coeff = (coeff/(long long)i)%MOD;
    }
    return coeff;
}

class GooseInZooDivTwo {
public:
    int count(vector <string> _field, int dist) {

      F[0]=0;
      F[1]=1;;
      for (int i = 2; i < 2501; ++i)
      {
          F[i]=((long long)i*F[i-1])%MOD;
      }
      // debuga(F);
        long res=1;
        field=_field;
        N=(int)field.size();
        M=(int)field[0].size();
        // memo,false;
        memset(memo,0,sizeof(memo));
        int rr=0;
        for (int i = 0; i < N; ++i)
        {
          for (int j = 0; j < M; ++j)
          {
            if(field[i][j]=='v' && !memo[i][j]){
              // dfs(i,j,dist);
              rr++;
              bfs(i,j,dist);
              res=(res*2L)%MOD;
            }
          }
        }
        long long r=0;
        for (int i = 1; i <= rr; ++i)
        {
          r=(r+comb(rr,i))%MOD;
        }
        res--;
        return r;
    }
};

// BEGIN CUT HERE
int main( int argc, char* argv[] ) {
    {
        string fieldARRAY[] = {"vvv"};
        vector <string> field( fieldARRAY, fieldARRAY+ARRSIZE(fieldARRAY) );
        GooseInZooDivTwo theObject;
        eq(0, theObject.count(field, 0),7);
    }
    {
        string fieldARRAY[] = {"."};
        vector <string> field( fieldARRAY, fieldARRAY+ARRSIZE(fieldARRAY) );
        GooseInZooDivTwo theObject;
        eq(1, theObject.count(field, 100),0);
    }
    {
        string fieldARRAY[] = {"vvv"};
        vector <string> field( fieldARRAY, fieldARRAY+ARRSIZE(fieldARRAY) );
        GooseInZooDivTwo theObject;
        eq(2, theObject.count(field, 1),1);
    }
    {
        string fieldARRAY[] = {"v.v..................v............................"
           ,".v......v..................v.....................v"
           ,"..v.....v....v.........v...............v......v..."
           ,".........vvv...vv.v.........v.v..................v"
           ,".....v..........v......v..v...v.......v..........."
           ,"...................vv...............v.v..v.v..v..."
           ,".v.vv.................v..............v............"
           ,"..vv.......v...vv.v............vv.....v.....v....."
           ,"....v..........v....v........v.......v.v.v........"
           ,".v.......v.............v.v..........vv......v....."
           ,"....v.v.......v........v.....v.................v.."
           ,"....v..v..v.v..............v.v.v....v..........v.."
           ,"..........v...v...................v..............v"
           ,"..v........v..........................v....v..v..."
           ,"....................v..v.........vv........v......"
           ,"..v......v...............................v.v......"
           ,"..v.v..............v........v...............vv.vv."
           ,"...vv......v...............v.v..............v....."
           ,"............................v..v.................v"
           ,".v.............v.......v.........................."
           ,"......v...v........................v.............."
           ,".........v.....v..............vv.................."
           ,"................v..v..v.........v....v.......v...."
           ,"........v.....v.............v......v.v............"
           ,"...........v....................v.v....v.v.v...v.."
           ,"...........v......................v...v..........."
           ,"..........vv...........v.v.....................v.."
           ,".....................v......v............v...v...."
           ,".....vv..........................vv.v.....v.v....."
           ,".vv.......v...............v.......v..v.....v......"
           ,"............v................v..........v....v...."
           ,"................vv...v............................"
           ,"................v...........v........v...v....v..."
           ,"..v...v...v.............v...v........v....v..v...."
           ,"......v..v.......v........v..v....vv.............."
           ,"...........v..........v........v.v................"
           ,"v.v......v................v....................v.."
           ,".v........v................................v......"
           ,"............................v...v.......v........."
           ,"........................vv.v..............v...vv.."
           ,".......................vv........v.............v.."
           ,"...v.............v.........................v......"
           ,"....v......vv...........................v........."
           ,"....vv....v................v...vv..............v.."
           ,".................................................."
           ,"vv........v...v..v.....v..v..................v...."
           ,".........v..............v.vv.v.............v......"
           ,".......v.....v......v...............v............."
           ,"..v..................v................v....v......"
           ,".....v.....v.....................v.v......v......."};
        vector <string> field( fieldARRAY, fieldARRAY+ARRSIZE(fieldARRAY) );
        GooseInZooDivTwo theObject;
        eq(3, theObject.count(field, 3),797922654);
    }
}
// END CUT HERE

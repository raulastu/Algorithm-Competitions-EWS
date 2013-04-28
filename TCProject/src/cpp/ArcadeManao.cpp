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
class ArcadeManao {
public:
    int shortestLadder(vector <string> level, int coinRow, int coinColumn) {
        int res;

        if(coinRow==level.size()-1){
            return 0;
        }
        vector<int> di;
        vector<int> dj;
        int N=level.size();
        int M=level[0].size();
        for (int i = 1; i <= 50; ++i)
        {
            di.push_back(i);
            di.push_back(-i);
            di.push_back(0);
            di.push_back(0);

            dj.push_back(0);
            dj.push_back(0);
            dj.push_back(i);
            dj.push_back(-i);
            
            queue<pair<int,int> > Q;
            Q.push(make_pair(coinRow-1,coinColumn-1));
            bool memo[N][M];
            while(!Q.empty()){
                pair<int,int> p = Q.front();Q.pop();
                if(p.first==level.size()-1){
                    return i;
                }
                for (int j = 0; j < di.size(); ++j)
                {
                    int X = p.first+di[j];
                    int Y = p.second+dj[j];
                    if(X>=0 && X<N && Y>=0 && Y<M && !memo[X][Y] && level[X][Y]=='X'){
                        memo[X][Y]=true;
                        Q.push(make_pair(X,Y));
                    }
                }

            }
        }
        // debug(res);
        return res;
    }

};
// BEGIN CUT HERE
int main( int argc, char* argv[] ) {
    {
        string levelARRAY[] = {"XXXX....",
            "...X.XXX",
            "XXX..X..",
            "......X.",
            "XXXXXXXX"};
        vector <string> level( levelARRAY, levelARRAY+ARRSIZE(levelARRAY) );
        ArcadeManao theObject;
        eq(0, theObject.shortestLadder(level, 2, 4),2);
    }
    {
        string levelARRAY[] = {"XXXX",
            "...X",
            "XXXX"};
        vector <string> level( levelARRAY, levelARRAY+ARRSIZE(levelARRAY) );
        ArcadeManao theObject;
        eq(1, theObject.shortestLadder(level, 1, 1),1);
    }
    {
        string levelARRAY[] = {"..X..",
            ".X.X.",
            "X...X",
            ".X.X.",
            "..X..",
            "XXXXX"};
        vector <string> level( levelARRAY, levelARRAY+ARRSIZE(levelARRAY) );
        ArcadeManao theObject;
        eq(2, theObject.shortestLadder(level, 1, 3),4);
    }
    {
        string levelARRAY[] = {"X"};
        vector <string> level( levelARRAY, levelARRAY+ARRSIZE(levelARRAY) );
        ArcadeManao theObject;
        eq(3, theObject.shortestLadder(level, 1, 1),0);
    }
    {
        string levelARRAY[] = {"XXXXXXXXXX",
            "...X......",
            "XXX.......",
            "X.....XXXX",
            "..XXXXX..X",
            ".........X",
            ".........X",
            "XXXXXXXXXX"};
        vector <string> level( levelARRAY, levelARRAY+ARRSIZE(levelARRAY) );
        ArcadeManao theObject;
        eq(4, theObject.shortestLadder(level, 1, 1),2);
    }
}
// END CUT HERE

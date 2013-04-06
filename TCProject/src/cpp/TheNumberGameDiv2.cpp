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
class TheNumberGameDiv2 {
public:
    int minimumMoves(int A, int B) {
        int res=0;
        queue< pair<string,int> >Q;
        Q.push(make_pair(tos(A),0));

        set<string> set;
        set.clear();
        set.insert(tos(A));
        while(!Q.empty()){
            pair<string,int> p=Q.front();Q.pop();
            if(p.first==tos(B)){
                return p.second;
            }
            string son=p.first.substr(0,p.first.size()-1);
            if(set.count(son)==0){
                set.insert(son);
                Q.push(make_pair(son,p.second+1));
            }
            string rev=p.first;
            reverse(all(rev));
            if(set.count(rev)==0){
                set.insert(rev);
                Q.push(make_pair(rev,p.second+1));
            }
        }
        return -1;
    }

};
// BEGIN CUT HERE
int main( int argc, char* argv[] ) {
    {
        TheNumberGameDiv2 theObject;
        eq(0, theObject.minimumMoves(25, 5),2);
    }
    {
        TheNumberGameDiv2 theObject;
        eq(1, theObject.minimumMoves(5162, 16),4);
    }
    {
        TheNumberGameDiv2 theObject;
        eq(2, theObject.minimumMoves(334, 12),-1);
    }
    {
        TheNumberGameDiv2 theObject;
        eq(3, theObject.minimumMoves(218181918, 9181),6);
    }
    {
        TheNumberGameDiv2 theObject;
        eq(4, theObject.minimumMoves(9798147, 79817),-1);
    }
}
// END CUT HERE

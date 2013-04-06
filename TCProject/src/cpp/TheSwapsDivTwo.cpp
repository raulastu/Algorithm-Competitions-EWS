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
class TheSwapsDivTwo {
public:
    int find(vector <int> sequence) {
        int res=0;
        set<string>S;
        // S.insert(s(sequence));
        for (int i = 0; i < sequence.size(); ++i)
        {
            for (int j = i+1; j < sequence.size(); ++j)
            {
                swap(sequence[i],sequence[j]);
                string sss = s(sequence);
                if(S.count(sss)==0){
                    S.insert(sss);
                    res++;
                }
                swap(sequence[j],sequence[i]);
            }
        }
        return res;
    }
    string s(vector<int> s){
        string sx="";
        for (int i = 0; i < s.size(); ++i)
        {
            sx+=tos(s[i])+" ";
        }
        return sx;
    }

};
// BEGIN CUT HERE
int main( int argc, char* argv[] ) {
    {
        int sequenceARRAY[] = {4, 7, 4};
        vector <int> sequence( sequenceARRAY, sequenceARRAY+ARRSIZE(sequenceARRAY) );
        TheSwapsDivTwo theObject;
        eq(0, theObject.find(sequence),3);
    }
    {
        int sequenceARRAY[] = {1, 47};
        vector <int> sequence( sequenceARRAY, sequenceARRAY+ARRSIZE(sequenceARRAY) );
        TheSwapsDivTwo theObject;
        eq(1, theObject.find(sequence),1);
    }
    {
        int sequenceARRAY[] = {1, 2, 3};
        vector <int> sequence( sequenceARRAY, sequenceARRAY+ARRSIZE(sequenceARRAY) );
        TheSwapsDivTwo theObject;
        eq(1, theObject.find(sequence),1);
    }
    {
        int sequenceARRAY[] = {9, 9, 9, 9};
        vector <int> sequence( sequenceARRAY, sequenceARRAY+ARRSIZE(sequenceARRAY) );
        TheSwapsDivTwo theObject;
        eq(2, theObject.find(sequence),1);
    }
    {
        int sequenceARRAY[] = {22, 16, 36, 35, 14, 9, 33, 6, 28, 12, 18, 14, 47, 46, 29, 22, 14, 17, 4, 15, 28, 6, 39, 24, 47, 37};
        vector <int> sequence( sequenceARRAY, sequenceARRAY+ARRSIZE(sequenceARRAY) );
        TheSwapsDivTwo theObject;
        eq(3, theObject.find(sequence),319);
    }
}
// END CUT HERE

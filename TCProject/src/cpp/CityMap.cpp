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
class CityMap {
public:
    string getLegend(vector <string> cityMap, vector <int> POIs) {
        string res="";
        stringstream ss;
        int count = POIs.size();
        int map[26];
        fill(map,0);
        // debuga(map);
        for (int i = 0; i < cityMap.size(); ++i)
        {

            for (int j = 0; j < cityMap[i].length(); ++j)
            {
                if(cityMap[i][j]!='.'){
                    // debug((int)cityMap[i][j]-'A');
                    // debug(cityMap[i][j]);
                    map[cityMap[i][j]-'A']++;
                }
                    // map[]++;
            }
        }
        // debuga(map);
        for (int i = 0; i < count; ++i)
        {
            for (int j = 0; j < 26; ++j)
            {
                if(map[j]==POIs[i]){
                    // ss<<;
                    res+=(j+'A');
                    // ss>>res;
                }
            }
        }
        return res;
    }

};
// BEGIN CUT HERE
int main( int argc, char* argv[] ) {
    {
        string cityMapARRAY[] = {"M....M",
            "...R.M",
            "R..R.R"};
        vector <string> cityMap( cityMapARRAY, cityMapARRAY+ARRSIZE(cityMapARRAY) );
        int POIsARRAY[] = {3, 4};
        vector <int> POIs( POIsARRAY, POIsARRAY+ARRSIZE(POIsARRAY) );
        CityMap theObject;
        eq(0, theObject.getLegend(cityMap, POIs),"MR");
    }
    {
        string cityMapARRAY[] = {"XXXXXXXZXYYY"};
        vector <string> cityMap( cityMapARRAY, cityMapARRAY+ARRSIZE(cityMapARRAY) );
        int POIsARRAY[] = {1, 8, 3};
        vector <int> POIs( POIsARRAY, POIsARRAY+ARRSIZE(POIsARRAY) );
        CityMap theObject;
        eq(1, theObject.getLegend(cityMap, POIs),"ZXY");
    }
    {
        string cityMapARRAY[] = {"...........",
            "...........",
            "...........",
            "..........T"};
        vector <string> cityMap( cityMapARRAY, cityMapARRAY+ARRSIZE(cityMapARRAY) );
        int POIsARRAY[] = {1};
        vector <int> POIs( POIsARRAY, POIsARRAY+ARRSIZE(POIsARRAY) );
        CityMap theObject;
        eq(2, theObject.getLegend(cityMap, POIs),"T");
    }
    {
        string cityMapARRAY[] = {"AIAAARRI.......GOAI.",
            ".O..AIIGI.OAAAGI.A.I",
            ".A.IAAAARI..AI.AAGR.",
            "....IAI..AOIGA.GAIA.",
            "I.AIIIAG...GAR.IIAGA",
            "IA.AOA....I....I.GAA",
            "IOIGRAAAO.AI.AA.RAAA",
            "AI.AAA.AIR.AGRIAAG..",
            "AAAAIAAAI...AAG.RGRA",
            ".J.IA...G.A.AA.II.AA"}
           ;
        vector <string> cityMap( cityMapARRAY, cityMapARRAY+ARRSIZE(cityMapARRAY) );
        int POIsARRAY[] = {16,7,1,35,11,66}
           ;
        vector <int> POIs( POIsARRAY, POIsARRAY+ARRSIZE(POIsARRAY) );
        CityMap theObject;
        eq(3, theObject.getLegend(cityMap, POIs),"GOJIRA");
    }
}
// END CUT HERE

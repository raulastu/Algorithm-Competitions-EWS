// BEGIN CUT HERE

// END CUT HERE
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
class TransformArray {
public:
    int doTransform(vector <int> elements) {
        int res=0;
        sort(elements.begin(),elements.end());
        for (int i = 0; i < elements.size()-1; ++i)
        {
            elements[i+1]-=elements[i];
            res+=elements[i];
        }
        return res;
    }

};
// BEGIN CUT HERE
int main( int argc, char* argv[] ) {
    {
        int elementsARRAY[] = {3,2,3,2};
        vector <int> elements( elementsARRAY, elementsARRAY+ARRSIZE(elementsARRAY) );
        TransformArray theObject;
        eq(0, theObject.doTransform(elements),5);
    }
    {
        int elementsARRAY[] = {3};
        vector <int> elements( elementsARRAY, elementsARRAY+ARRSIZE(elementsARRAY) );
        TransformArray theObject;
        eq(1, theObject.doTransform(elements),0);
    }
    {
        int elementsARRAY[] = {1,2,3,4};
        vector <int> elements( elementsARRAY, elementsARRAY+ARRSIZE(elementsARRAY) );
        TransformArray theObject;
        eq(2, theObject.doTransform(elements),4);
    }
    {
        int elementsARRAY[] = {10,6,3,7,7,9,5,1,8,4};
        vector <int> elements( elementsARRAY, elementsARRAY+ARRSIZE(elementsARRAY) );
        TransformArray theObject;
        eq(3, theObject.doTransform(elements),27);
    }
}
// END CUT HERE

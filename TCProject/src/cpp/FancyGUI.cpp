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
int window[100][100];
class FancyGUI {
public:

    int totalDarkArea(int N, vector <int> x1, vector <int> y1, vector <int> x2, vector <int> y2) {
        int res=0;
        memset(window,0,sizeof(window));
        
        for(int i=0;i<x1.size();i++){
            for (int j = x1[i]; j <= x2[i]; ++j)
            {
                for (int k = y1[i]; k <= y2[i]; ++k)
                {
                    window[j-1][k-1]++;
                }
            }
        }
        for (int i = 0; i < 100; ++i)
        {
            for (int j = 0; j < 100; ++j)
            {
                if(window[i][j]>N)
                    res++;
            }
        }
        return res;
    }

};
// BEGIN CUT HERE
int main( int argc, char* argv[] ) {
    {
        int x1ARRAY[] = {21, 41, 71};
        vector <int> x1( x1ARRAY, x1ARRAY+ARRSIZE(x1ARRAY) );
        int y1ARRAY[] = {21, 41, 71};
        vector <int> y1( y1ARRAY, y1ARRAY+ARRSIZE(y1ARRAY) );
        int x2ARRAY[] = {80, 60, 90};
        vector <int> x2( x2ARRAY, x2ARRAY+ARRSIZE(x2ARRAY) );
        int y2ARRAY[] = {80, 60, 90};
        vector <int> y2( y2ARRAY, y2ARRAY+ARRSIZE(y2ARRAY) );
        FancyGUI theObject;
        eq(0, theObject.totalDarkArea(1, x1, y1, x2, y2),500);
    }
    {
        int x1ARRAY[] = {1, 21, 41};
        vector <int> x1( x1ARRAY, x1ARRAY+ARRSIZE(x1ARRAY) );
        int y1ARRAY[] = {1, 21, 41};
        vector <int> y1( y1ARRAY, y1ARRAY+ARRSIZE(y1ARRAY) );
        int x2ARRAY[] = {100, 80, 60};
        vector <int> x2( x2ARRAY, x2ARRAY+ARRSIZE(x2ARRAY) );
        int y2ARRAY[] = {100, 80, 60};
        vector <int> y2( y2ARRAY, y2ARRAY+ARRSIZE(y2ARRAY) );
        FancyGUI theObject;
        eq(1, theObject.totalDarkArea(2, x1, y1, x2, y2),400);
    }
    {
        int x1ARRAY[] = {10};
        vector <int> x1( x1ARRAY, x1ARRAY+ARRSIZE(x1ARRAY) );
        int y1ARRAY[] = {20};
        vector <int> y1( y1ARRAY, y1ARRAY+ARRSIZE(y1ARRAY) );
        int x2ARRAY[] = {19};
        vector <int> x2( x2ARRAY, x2ARRAY+ARRSIZE(x2ARRAY) );
        int y2ARRAY[] = {29};
        vector <int> y2( y2ARRAY, y2ARRAY+ARRSIZE(y2ARRAY) );
        FancyGUI theObject;
        eq(2, theObject.totalDarkArea(0, x1, y1, x2, y2),100);
    }
    {
        FancyGUI theObject;
        eq(3, theObject.totalDarkArea(1, vector <int>(), vector <int>(), vector <int>(), vector <int>()),0);
    }
}
// END CUT HERE

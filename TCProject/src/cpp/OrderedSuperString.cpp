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
    cout << a;
}
static void print( long long a ) {
    cout << a << "L";
}
static void print( string a ) {
    cout << '"' << a << '"';
}
template<typename T> void print( vector<T> a ) {
    cout << "{";
    for ( int i = 0 ; i != a.size() ; i++ ) {
        if ( i != 0 ) cout << ", ";
        print( a[i] );
    }
    cout << "}" << endl;
}
template<typename T> void eq( int n, T have, T need ) {
    if ( have == need ) {
        cout << "Case " << n << " passed." << endl;
    } else {
        cout << "Case " << n << " failed: expected ";
        print( need );
        cout << " received ";
        print( have );
        cout << "." << endl;
    }
}
template<typename T> void eq( int n, vector<T> have, vector<T> need ) {
    if( have.size() != need.size() ) {
        cout << "Case " << n << " failed: returned " << have.size() << " elements; expected " << need.size() << " elements.";
        print( have );
        print( need );
        return;
    }
    for( int i= 0; i < have.size(); i++ ) {
        if( have[i] != need[i] ) {
            cout << "Case " << n << " failed. Expected and returned array differ in position " << i << ".";
            print( have );
            print( need );
            return;
        }
    }
    cout << "Case " << n << " passed." << endl;
}
static void eq( int n, string have, string need ) {
    if ( have == need ) {
        cout << "Case " << n << " passed." << endl;
    } else {
        cout << "Case " << n << " failed: expected ";
        print( need );
        cout << " received ";
        print( have );
        cout << "." << endl;
    }
}
// END CUT HERE
class OrderedSuperString {
public:
    int getLength(vector <string> words) {
        int res=0;
        int count = words.size();
        string s = words[0];
        int ix=0;
        for (int i = 1; i < count; ++i)
        {
            int n = words[i].length();
            for (; ix < s.length(); ++ix)
            {
                string thiss=s.substr(ix,n);
                string thats=words[i].substr(0,min(n,(int)s.length()-ix));
                // printf("%s %s\n", thiss.c_str(), thats.c_str());
                if(thiss==thats){
                    break;
                }
            }
            // cout<<;
            // if(ix==s.length()){
            //     s+=words[i];
            // }
            // else
            // printf("finished %s %d\n", s.c_str(),ix);
            if(ix+n>s.length()){
                int d =ix+n-s.length()-1;
                // printf("%s %d %d %s %s\n", s.c_str(), ix, d, words[i].c_str(),words[i].substr(d).c_str());
                s+=words[i].substr(s.length()-ix);
            }
        }
        return s.length();
    }

};
// BEGIN CUT HERE
int main( int argc, char* argv[] ) {
    {
        string wordsARRAY[] = {"abc","ca"};
        vector <string> words( wordsARRAY, wordsARRAY+ARRSIZE(wordsARRAY) );
        OrderedSuperString theObject;
        eq(0, theObject.getLength(words),4);
    }
    {
        string wordsARRAY[] = {"a","a","b","a"};
        vector <string> words( wordsARRAY, wordsARRAY+ARRSIZE(wordsARRAY) );
        OrderedSuperString theObject;
        eq(1, theObject.getLength(words),3);
    }
    {
        string wordsARRAY[] = {"abcdef", "ab","bc", "de","ef"};
        vector <string> words( wordsARRAY, wordsARRAY+ARRSIZE(wordsARRAY) );
        OrderedSuperString theObject;
        eq(2, theObject.getLength(words),6);
    }
    {
        string wordsARRAY[] = {"ab","bc", "de","ef","abcdef"};
        vector <string> words( wordsARRAY, wordsARRAY+ARRSIZE(wordsARRAY) );
        OrderedSuperString theObject;
        eq(3, theObject.getLength(words),12);
    }
}
// END CUT HERE

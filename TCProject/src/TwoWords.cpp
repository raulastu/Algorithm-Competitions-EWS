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
class TwoWords {
public:
    string howMany(string statement, string word1, string word2) {
        string res;
        int n=word1.length();
        int count=statement.length();
        bool found1=false;
        for (int i = 0; i <= count-n; ++i)
        {
            if(same(statement.substr(i,n),word1)){
                // cout<<statement.substr(i,n)<<endl;
                found1=true;
                if(cont(statement.substr(0,i),word2)
                    || cont(statement.substr(i+n,count-i),word2)){
                    return "both";
                }
            }
        }
        n=word2.length();
        for (int i = 0; i <= count-n; ++i)
        {
            if(same(statement.substr(i,n),word2)){
                // cout<<statement.substr(i,n)<<endl;
                found1=true;
                if(cont(statement.substr(0,i),word1)
                    || cont(statement.substr(i+n,count-i),word1)){
                    return "both";
                }
            }
        }
        return found1?"one":"none";
    }
    bool cont(string a, string b){
        // cout<<a<<" "<<b<<endl;
        if(a.length()<b.length())
            return false;
        int n = b.length();
        for (int i = 0; i <= a.length()-n; ++i)
        {
            if(same(a.substr(i,n),b)){
                return true;
            }
        }
        return false;
    }
    bool same(string a, string b){
        if(a.length()!=b.length())
            return false;
        for (int i = 0; i < a.length(); ++i)
        {
            if(a[i]=='?' || b[i]=='?') continue;
            if(a[i]!=b[i])return false;
        }
        return true;
    }

};
// BEGIN CUT HERE
int main( int argc, char* argv[] ) {
    {
        TwoWords theObject;
        eq(0, theObject.howMany("yello??taxi", "yellow", "taxi"),"both");
    }
    {
        TwoWords theObject;
        eq(1, theObject.howMany("?ellowtaxi", "yell", "l?w"),"one");
    }
    {
        TwoWords theObject;
        eq(2, theObject.howMany("tha?isunbelievable", "han?y", "?th?"),"none");
    }
    {
        TwoWords theObject;
        eq(3, theObject.howMany("secondfirst", "second", "first"),"both");
    }
    {
        TwoWords theObject;
        eq(4, theObject.howMany("me?sa?e", "?ceage", "essay"),"one");
    }
    {
        TwoWords theObject;
        eq(5, theObject.howMany("?", "??", "???"),"none");
    }
    {
        TwoWords theObject;
        eq(6, theObject.howMany("hello", "h?", "ll?"),"both");
    }
}
// END CUT HERE

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
#define fill(a , value) memset(a , value , sizeof(a))

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
    cout << a<<endl;
}
static void print( long long a ) {
    cout << a << "L"<<endl;
}
static void print( string a ) {
    cout << '"' << a << '"'<<endl;
}
// END CUT HERE
template<typename T> void print( vector<T> a ) {
    // BEGIN CUT HERE
    cout << "{";
    for ( int i = 0 ; i != a.size() ; i++ ) {
        if ( i != 0 ) cout << ", ";
        cout<<a[i];
    }
    cout << "}" << endl;
    // END CUT HERE
}
// BEGIN CUT HERE
template<typename T> void eq( int n, T have, T need ) {
    if ( have == need ) {
        cout << "Case " << n << " passed." << endl;
    } else {
        cout << "Case " << n << " failed: expected ";
        // print( need );
        cout <<need<< " received ";
        // print( have );
        cout <<have<< "." << endl;
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
class CardStraights {
public:
    int longestStraight(vector <int> cards) {
        int zeroes=0;
        sort(cards.begin(), cards.end());
        int count = cards.size();
        // if(cards[count-1]==0)return zeroes;
        for (int i = 0; i < count; ++i)
        {
            if(cards[i]==0){
                zeroes++;
            }
        }
        int maxx=zeroes;
        int rc=zeroes;
        int b=zeroes;
        print(cards);
        cards.erase(unique(cards.begin(), cards.end()),cards.end());
        print(cards);
        if(cards[0]==0)
            cards.erase(cards.begin());
        count = cards.size();
        print(cards);
        // two pointers solution
        for (int i = zeroes; i < count; ++i)
        {
            while(b<count-1 && cards[b+1]-cards[b]-rc<=1){
                // printf("%d %d %d %d \n",cards[b+1],cards[b],b,rc);
                int dif = cards[b+1]-cards[b];
                // a=cards[b];
                b++;
                if(dif<=1)continue;
                rc-=(dif-1);
            }

            // printf("%d i %d %d %d \n",cards[b],cards[i],b,rc);
            int dif = cards[b]-cards[i];
            maxx=max(maxx,dif+1+rc);
            if(i==b){
                b++;
                rc=zeroes;
            }else
                rc+=(cards[i+1]-cards[i]-1);
        }

        //brute force solution
        // for (int i = 0; i < count; ++i)
        // {
        //     int j = i ;
        //     while(j<count-1 && cards[j+1]-cards[j]-rc<=1){
        //         int dif = cards[j+1]-cards[j];
        //         j++;
        //         if(dif<=1)continue;
        //         rc-=(dif-1);
        //     }
        //     maxx=max(maxx,cards[j]-cards[i]+1+rc);
        //     rc=zeroes;
        // }
        return maxx;
    }
};
// BEGIN CUT HERE
int main( int argc, char* argv[] ) {
    {
        int cardsARRAY[] = {0,6,5,10,3,0,11};
        vector <int> cards( cardsARRAY, cardsARRAY+ARRSIZE(cardsARRAY) );
        CardStraights theObject;
        eq(0, theObject.longestStraight(cards),5);
    }
    {
        int cardsARRAY[] = {100,100,100,101,100,99,97,103};
        vector <int> cards( cardsARRAY, cardsARRAY+ARRSIZE(cardsARRAY) );
        CardStraights theObject;
        eq(1, theObject.longestStraight(cards),3);
    }
    {
        int cardsARRAY[] = {0,0,0,1,2,6,8,1000};
        vector <int> cards( cardsARRAY, cardsARRAY+ARRSIZE(cardsARRAY) );
        CardStraights theObject;
        eq(2, theObject.longestStraight(cards),6);
    }
    {
        int cardsARRAY[] = {1,9,5,7,3,4,0,0,0,10};
        vector <int> cards( cardsARRAY, cardsARRAY+ARRSIZE(cardsARRAY) );
        CardStraights theObject;
        eq(3, theObject.longestStraight(cards),10);
    }
    {
        int cardsARRAY[] = {0,0,0,8,10,12,13,15,17,18,19,20,21,22,23};
        vector <int> cards( cardsARRAY, cardsARRAY+ARRSIZE(cardsARRAY) );
        CardStraights theObject;
        eq(3, theObject.longestStraight(cards),14);
    }
    {
        int cardsARRAY[] = {0,0,0,1};
        vector <int> cards( cardsARRAY, cardsARRAY+ARRSIZE(cardsARRAY) );
        CardStraights theObject;
        eq(3, theObject.longestStraight(cards),4);
    }
}
// END CUT HERE

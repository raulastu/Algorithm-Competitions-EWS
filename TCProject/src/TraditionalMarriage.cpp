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

std::vector<std::string> &split(const std::string &s, char delim, std::vector<std::string> &elems) {
    std::stringstream ss(s);
    std::string item;
    while (std::getline(ss, item, delim)) {
        elems.push_back(item);
    }
    return elems;
}


std::vector<std::string> split(const std::string &s, char delim) {
    std::vector<std::string> elems;
    return split(s, delim, elems);
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

vector< vector<string> > properties;
vector<int> weight;
int inf = 50000010;
int mm[50][1<<4];

int go(int i, int m){
    if(i==properties.size()){
        if(m==(1<<4)-1){
            return 0;
        }else{
            return (1<<30);
        }
    }
    if(mm[i][m]==-1){
        int n=0;
        if(find(properties[i].begin(),properties[i].end(),"old")!= properties[i].end()){
            n|=1<<0;
        }
        if(find(properties[i].begin(),properties[i].end(),"borrowed")!= properties[i].end()){
            n|=1<<1;
        }
        if(find(properties[i].begin(),properties[i].end(),"blue")!= properties[i].end()){
            n|=1<<2;
        }
        if(find(properties[i].begin(),properties[i].end(),"new")!= properties[i].end()){
            n|=1<<3;
        }
        int a = weight[i]+go(i+1,n|m);
        int b = go(i+1,m);
        mm[i][m]=min(a,b);
    }
    return mm[i][m];
}

class TraditionalMarriage {
public:
    int getLuckyItems(vector <string> p, vector <int> w) {
        properties.clear();
        for (int i = 0; i < p.size(); ++i)
        {
            properties.push_back(split(p[i],','));

        }
        weight=w;
        memset(mm,-1,sizeof(mm));
        int x = go(0,0);
        if((1<<30)<=x)
            return -1;
        return x;
    }

};

// BEGIN CUT HERE
int main( int argc, char* argv[] ) {
    // cout<<(1<<3);
    {
        string propertiesARRAY[] = {"blue,suede,old","red","white,borrowed","new,white,cool,good,anything","new"};
        vector <string> properties( propertiesARRAY, propertiesARRAY+ARRSIZE(propertiesARRAY) );
        int weightARRAY[] = {10,4,15,3,4};
        vector <int> weight( weightARRAY, weightARRAY+ARRSIZE(weightARRAY) );
        TraditionalMarriage theObject;
        eq(0, theObject.getLuckyItems(properties, weight),28);
    }
    {
        string propertiesARRAY[] = {"new,borrowed,blue,old,nice"};
        vector <string> properties( propertiesARRAY, propertiesARRAY+ARRSIZE(propertiesARRAY) );
        int weightARRAY[] = {1};
        vector <int> weight( weightARRAY, weightARRAY+ARRSIZE(weightARRAY) );
        TraditionalMarriage theObject;
        eq(1, theObject.getLuckyItems(properties, weight),1);
    }
    {
        string propertiesARRAY[] = {"old","new","borrowed","blue","old,new,borrowed,blue"};
        vector <string> properties( propertiesARRAY, propertiesARRAY+ARRSIZE(propertiesARRAY) );
        int weightARRAY[] = {1,1,1,1,5};
        vector <int> weight( weightARRAY, weightARRAY+ARRSIZE(weightARRAY) );
        TraditionalMarriage theObject;
        eq(2, theObject.getLuckyItems(properties, weight),4);
    }
    {
        string propertiesARRAY[] = {"new","old,red","borrowed"};
        vector <string> properties( propertiesARRAY, propertiesARRAY+ARRSIZE(propertiesARRAY) );
        int weightARRAY[] = {1,2,3};
        vector <int> weight( weightARRAY, weightARRAY+ARRSIZE(weightARRAY) );
        TraditionalMarriage theObject;
        eq(3, theObject.getLuckyItems(properties, weight),-1);
    }
}
// END CUT HERE

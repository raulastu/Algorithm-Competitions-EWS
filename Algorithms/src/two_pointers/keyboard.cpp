#include <cstring>
#include <iostream>
#include <map>
#include <sstream>

using namespace std;

void printm(map<char, int>& mapx){
    map<char, int>::iterator pos;
    for(pos = mapx.begin(); pos != mapx.end(); ++pos)
    {
        cout << pos->first << "="<<pos->second<<endl;
    }
}
int toi(string s){
    istringstream is(s);
    int x;
    is>>x;
    return x;
}

int main()
{
    int n;
    string ins;
    getline(cin,ins);
    n = toi(ins);
//    cout<<n;
    while(n!=0){
        string s;
        getline(cin,s);
//        cout<<n<<" "<<s<<endl;
        map<char,int> map;
        int j=0;
        int r=0;
        for(int i=0;i<s.length();i++){
            char thix = s[i];
            while(map.size()==n && map.find(thix)==map.end()){
                char that=s[j];
                map[that]--;
                if(map[that]==0)
                    map.erase(that);
                j++;
            }
            map[thix]++;
            r=max(r,i-j+1);
        }
        cout<<r<<endl;
//        printm(map);
        getline(cin,ins);
        n = toi(ins);
//        cout<<n<<endl;;
    }
    return 0;
}
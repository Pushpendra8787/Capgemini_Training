#include<iostream>
#include<string>
#include<vector>
using namespace std;
int main()
{
    string str="this is the sample word this is the sample word word word";
    int n=str.length();
    vector<vector<string>>s;
    string ss="";
    for(int i=0;i<n;i++)
    {
        if(str[i]!=' ')
        {
            ss+=str[i];
        }
        if(str[i]==' ')
        {
            s.push_back({ss});
        }
    }
        cout<<s[1][1]<<endl;
    
    
}
#include<iostream>
#include<cmath>
using namespace std;
int main(){
    int n=72;
    int k=sqrt(n);
    // for(int i=2;i<n/2;i++)
    for(int i=2;i<k;i++)
    {
        if(n%i==0)
        {
            cout<<"NOT Prime\n";
            return 0;
        }
    }
    cout<<"Prime\n";
    return 1;
}
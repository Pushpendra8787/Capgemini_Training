#include<iostream>
using namespace std;
int main(){
    int k=10;
    int arr[9]={1,2,5,1,1,8,2,6,7};
    int n=9;
    int stidx=0,eidx=0;
    int ans=0;
    int len=0;
    int s=0,e=0;
    for(int i=0;i<n;i++)
    {
         stidx=i;
         ans=arr[i];
         for(int j=i+1;j<n;j++)
         {
            ans+=arr[j];
            if(ans==k)
            {
                eidx=j;
                int temp=eidx-stidx;
                cout<<"length--  "<<temp<<endl;
                if(temp>len)
                {

                    s=stidx;
                    e=eidx;
                }
                ans=0;

            }
            else if(ans>k)
            {
                break;
            }
         }

    }
    
    cout<<ans<<endl;
    cout<<s<<endl<<e<<endl;

}
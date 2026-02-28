#include<iostream>
using namespace std;
int main()
{
    int arr[5]={1,12,73,4,15};
    int n=5;
      int first=arr[0],second=0;
      for(int i=1;i<n;i++)
      {
        if(arr[i]>first)
        {
            // second=first;
            
            first=arr[i];
        }
        else if(arr[i]>second&&second<first)
        {
            second=arr[i];
        }
        
      }
    
     cout<<first<<endl<<second<<endl;
}
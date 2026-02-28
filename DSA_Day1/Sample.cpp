#include<iostream>
using namespace std;
int main(){
    int arr[5]={13,3,564,6,10};
    int n=5;
    for(int i=0;i<n;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            if(arr[i]>arr[j])
            {
                swap(arr[i],arr[j]);
            }
        }
    }
    
  
     cout<<arr[n-2]<<endl;
}
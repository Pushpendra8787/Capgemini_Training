// this is the question to find the second largest element of an array using satack only 

#include<iostream>
#include<stack>
using namespace std;
int main(){

    // int arr[5]={1,2,3,4,5};
    int arr[5]={12,7,3,11,0};
    int n=5;
    stack<int>s ;
     
    cout<<"started\n"; 
    for(int i=0;i<n;i++)
    { 
        // inserting first element 
        if(s.empty())
        {
            s.push(arr[i]);
            // cout<<"First element is inserted\n";
            continue;
        }
            
        if(arr[i]>=s.top()){
            s.push(arr[i]);
            // cout<<"NO error\n";
        }

        else{
            int k=0;
            while(!s.empty()&&s.top()>arr[i]){
                int t=s.top();
                arr[k]=t;
                k++;
                s.pop();
                // cout<<"Inner loop\n";
            }
            s.push(arr[i]);
            // cout<<"now inserting into the proper posstion\n";
            for(int l=k-1;l>=0;l--)
            {
                s.push(arr[l]);
            }
            // cout<<"element is inserted\n";
        }
    }
    
cout<<"First Largest== "<<s.top()<<endl;
s.pop();
cout<<"Second Largest== "<<s.top()<<endl;
 cout<<"code done\n";
}
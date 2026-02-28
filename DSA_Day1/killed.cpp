//Q : in this question you want to kill the alternated player as per the user input 
// example if the user give 2 as input u need to kill the player in the gap of 2 . Run this until you left onnly single player
// and return that player
#include<iostream>
using namespace std;
int main(){
    int arr[6]={1,2,3,4,5,6};
    int n=6;
    int copy=n;
    int k=2;
    int idx=0;
    int count=0;
     while (n > 1) {
        if (arr[idx] != -1) {
            count++;
            if (count == k) {
                arr[idx] = -1;  
                n--;
                count = 0;
            }
        }

        idx++;
        if (idx == 6) {  
            idx = 0;
        }
    }
    cout<<"end"<<endl;
    cout<<n<<endl;
    for(int i=0;i<copy;i++)
    {
        cout<<arr[i]<<" ";
    }
}
#include<iostream>
using namespace std;
int main(){
    // int arr[4][4]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    // int n=4,m=4;

    int arr[2][4]={{1,2,3,11},{4,5,6,22}};
    int n=2,m=4;

    // int arr[3][4]={{1,2,3,11},{4,5,6,22},{7,8,9,33}};
    // int n=3,m=4;
    int sr=0,er=n-1 , sc=0,ec=m-1;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            cout<<arr[i][j]<<" ";
        }
        cout<<endl;
    }
     cout<<endl;

   while(sr<=er && sc<=ec){
// for(int i=0;i<3;i++){

    // L-R
    // cout<<" \nL-R"<<endl;
    for(int i=sc;i<=ec;i++)
    {
        cout<<arr[sr][i]<<" ";
    }
    // cout<<endl;
    //top-down
    //  cout<<" Top-Down"<<endl;
    for(int i=sr+1;i<=er;i++)
    {
        cout<<arr[i][ec]<<" ";
    }
    // cout<<endl;
    //R-L
    //  cout<<" R-L"<<endl;

    if(sr < er){
    for(int i=ec-1;i>=sc;i--)
        cout<<arr[er][i]<<" ";
     }
    // cout<<endl;
    //bottom to up
    //  cout<<" Bottom-Up"<<endl;
    if(sc < ec){
    for(int i=er-1;i>sr;i--)
        cout<<arr[i][sc]<<" ";
}


    sr++;
    sc++;
    er--;
    ec--;

// }
   }
}
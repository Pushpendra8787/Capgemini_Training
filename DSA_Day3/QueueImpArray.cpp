#include<iostream>
using namespace std;
int front=0,rare=0,size=0;
void insert(int  arr[],int val)
{   
    if(front==size)
    {
        cout<<"Queue if full\n";
        return ;
    }
    arr[front]=val;
    front++;


}
void dele (int arr[])
{
    cout<<"front== "<<front<<endl;
    cout<<"rare== "<<rare<<endl;
    if(rare==size||rare>=front)
    {
        cout<<"Queue is empty so deletion is not possible\n";
        return;
    }
    else{
        rare++;
    }
    cout<<"front== "<<front<<endl;
    
    cout<<"rare== "<<rare<<endl;

}

void display(int arr[])
{
    for(int i=rare;i<front;i++)
    {
        cout<<arr[i]<<" ";
        cout<<endl;
    }
}
int main(){
    // int n;
    cout<<"Enter the size of queue you want ot make\n";
    cin>>size;
    int arr[size]={0};
    int val=-1;

    insert(arr,val);
    insert(arr,2);
    insert(arr,3);
    display(arr);
  dele(arr);
  display(arr);



   


}
#include<iostream>
#include<stack>
using namespace std;
 stack<int>forword;
    stack<int>backword;

    void display(){
        if(forword.empty())
        {
            cout<<"You do not have any tab for go backward\n";
            return;
        }
        int t=forword.top();
        if(t==1){
            cout<<"Your are on GOOGlE\n";
            return;
        }
        else if(t==2){
                 cout<<"Your are on EMAIL\n";
            return;
        }
        else{
                 cout<<"Your are on SANDBOX\n";
            return;
        }

    }
void reset(){
    //empty both stack
    while(!forword.empty()){
        forword.pop();
    }
    while(!backword.empty())
    {
        backword.pop();
    }
    cout<<"RESET DONE\n";
    return;

}
void front()
{
    // if(forword.empty()){
    if(forword.size()<=1){
        cout<<"You can not Go back\n";
        return;
    }
    else{
        int temp=forword.top();
        backword.push(temp);
        forword.pop();
        cout<<"YOU ARE BACKED TO ---------\n";
        display();
    }

}
void back(){
     if(backword.empty())
    { 
    cout<<"Your do not have any tab to forward\n";
    return;
     }
     int temp=backword.top();
     forword.push(temp);
     backword.pop();
     // displaying which tab is opened
     cout<<"YOU ARE FORWARD TO ---------\n";
     display();

}
int main(){
     
   
    int n;
    while(true){
    cout<<"enter your choice\n";
    // cout<<" 0 = Reset \n 1 = Goggle\n 3 = Email\n 4 = Sandbox\n 5 = forword\n 6 = Backword\n ";
    cout<<"0=Reset \n 1=Google \n 2=Email \n 3=Sandbox \n 4=Back \n 5=Forward\n";

    cin>>n;
    switch (n)
    {
    case 0:
        reset();
        break;
    case 1:
        // goggle
        while(!backword.empty()) backword.pop();
        forword.push(1);
        display();
        break;
    case 2:
        // email
        while(!backword.empty()) backword.pop();
        forword.push(2);
        display();
        break;
    case 3:
        // sandbox
        while(!backword.empty()) backword.pop();
        forword.push(3);
        display();
        break;
    case 4:
        // undo
        front();
        break;
    case 5:
        // redo
        back();
        break;
    
    default:
    cout<<"INvalid input";
        break;
    }
}
        
    
}
#include<iostream>
#include<stack>
#include<string>
using namespace std;
int main(){
    stack<char>s;
    // string str="{{([{])}}";
    // string str="{{([])}}";
    string str="{{([2])}}";
    // string str="{{([2{])}}";
    for(char ch:str)
    {
        if(ch=='{'||ch=='('||ch=='['){
            s.push(ch);
        }
        else if(ch=='}'||ch==']'||ch==')'){
            char top=s.top();
            if((ch=='}'&&top=='{')||(ch==']'&&top=='[')||(ch==')'&&top=='(')){
                s.pop();
            } else{
                cout<<"invalid"<<endl; break;
            }
        }
    }
    if(s.empty()){
        cout<<"valid \n";
    }
    else{
        cout<<"Confirm invalid\n";
    }

}
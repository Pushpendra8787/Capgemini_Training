// this is the question where we want to print the stack in such a way that 
// input=1,2,3  output=1,1,2,2,3,3 into the stack  note we do can not use any auxilary space 

#include<iostream>
#include<stack>
using namespace std;
void twice(stack<int>&s){
    if(s.empty()){
        return;
    }
    int top=s.top();
    s.pop();
    twice(s);
    s.push(top);
    s.push(top);
}

int main(){
    stack<int>st;
    st.push(1);
    st.push(2);
    st.push(3);
    cout<<"--------BEFORE--------\n";
    while(!st.empty()){
        cout<<st.top()<<endl;
        st.pop();
    }
    
    twice(st);
    
    cout<<"--------AFTER--------\n";
    while(!st.empty()){
        cout<<st.top()<<endl;
        st.pop();
    }
}
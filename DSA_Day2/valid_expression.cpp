#include<iostream>
#include<stack>
#include<string>
using namespace std;
int main(){
    // string str="5/2-3*8";
    string str="2+3";
    stack<char>s;


  int n=str.length();
  bool cont=false;
  for(int i=0;i<n;i++)
  {
    char ch=str[i];
    if(i==0||i==n-1)
    {   
        // case1 
        if(ch=='/'||ch=='-'||ch=='*'||ch=='+'){
            
            cout<<"Invalid---\n";
            return 0;
        }
    }

     if(ch=='/'||ch=='-'||ch=='*'||ch=='+'){
            char nextch=str[i+1];
              if(nextch=='/'||nextch=='-'||nextch=='*'||nextch=='+'){
                cout<<"Invalid-------\n";
                return 0;

                }

                else{
                s.pop();
               }
        }

        else{
            s.push(ch);
        }

    }
     if(s.empty()){
         cout<<"Invalid expression\n"; 
        }

    else{
         // cout<<s.top()<<endl;
         cout<<"Valid Expression\n";

      }
      return 1;
  }

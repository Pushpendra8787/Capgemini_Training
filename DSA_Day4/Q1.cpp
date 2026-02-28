// Qeustion: 
// You are building a log processing system for a server.

// Each log entry is a string:
// "LEVEL:MESSAGE"
// Example: "ERROR:DiskFull"

// Rules:
// - Logs arrive in real time and must be processed in FIFO order.
// - If the log level is ERROR, it must be re-processed immediately after the current log.
// - If the same ERROR message appears 3 times consecutively, stop processing and raise an alert.
// - You must preserve original order as much as possible.

// Constraints:
// - Use only Queue, Stack, and String operations.
// - No additional data structures like Map or Set.

// Tasks:
// - Design the algorithm.
// - Explain which data structure is used at each step.
// - Analyze time and space complexity.

// Follow-up :
// - How would you modify the solution if logs arrive from multiple producers?




#include<iostream>
#include<stack>
#include<queue>
using namespace std;
int count=0;
int  process(queue<string>&q,stack<string>&s){

    while(!q.empty()){
        if(!s.empty())
        {
            cout<<"Error Processing\n";
            count++;
            s.pop();
        }

        // stack is empty
        else{
            string str=q.front();
            string sub=str.substr(0,5);

            // error occurs
            if(sub=="Error"){
                count++;
                if(count>=3)
                {
                    cout<<"ALERT\n";
                    return 0;
                }
                cout<<str<<"IS Processing----\n";
                s.push(str);
                q.pop();
                continue;

            }
            // cout<<sub<<endl;
                            cout<<str<<"IS Processing----\n";

            q.pop();
        }
    }
    return 1;
}

int addlogs(queue<string>&q)
{
    int n;
    cout<<"How many log you want to enter \n";
    cin>>n;
    cout<<"Enter your log details.  Note: add log in 'Level : Msg' in this format\n";
    for(int i=0;i<n;i++)
    {
        string temp;
        cin>>temp;
        q.push(temp);
    }
    cout<<"Isertion done Thank you! \n";
}
int main(){


    queue<string>q;
    stack<string>s;
    //Manuall logs   
    // log format ==>   Level:Msg

    
    int n;

    while(true){
        cout<<"chose Option : \n 1 = insert logs\n 2 = start 3 = exit\n";
        cin>>n;
        switch (n)
        {
        case 1:
            addlogs(q);
            break;
        
        case 2:
              process(q,s);
              break;
        
        case 3:
            cout<<"EXITING\n";
            break;
        default:
        cout<<"Invalid INput\n Printing the queue\n";
         while(!q.empty()){
            cout<<q.front()<<endl;;
            q.pop();
        }
            break;
        }
        
    }
    
    
    q.push("INFO : Fetched");
    q.push("Login : Done");
    q.push("INFO : Fetched");
    q.push("Error : Diskfull");
    q.push("INFO : Fetched");
    q.push("Error : Diskfull");
    process(q,s);
    // while(!q.empty()){
    //     cout<<q.front()<<endl;;
    //     q.pop();
    // }


}

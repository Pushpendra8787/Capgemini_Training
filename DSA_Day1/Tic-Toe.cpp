#include<iostream>
using namespace std;
void print(int arr[][3]){
    for(int i=0;i<3;i++)
    {
        for(int j=0;j<3;j++)
        {
            cout<<arr[i][j]<<" ";
        }
        cout<<endl;
    }
}
bool checkwin(int arr[][3],int player)
{
    //r c
    for(int i=0;i<3;i++)
    {
        if((arr[i][0])==player && arr[i][1]==player && arr[i][2]==player ){
            return true;
        }
    }

    // c check
    for(int i=0;i<3;i++)
    {
        if(arr[0][i]==player && arr[1][i] && arr[2][i]==player){
            return true;
        }
    }

    //diago check
    if(arr[0][0]==player && arr[1][1]==player&&  arr[2][2]==player){
        return true;
    }

    // diago2 check
    if(arr[0][2]==player && arr[1][1]==player&&  arr[2][0]==player){
        return true;
    }

    return false;
}
int main(){

    int arr[3][3]={{0}};
    int n=3,m=3;
    int occupied=9;


    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++){
            cout<<arr[i][j]<<" ";
        }
        cout<<endl;
    }
    bool gameover=false;
    bool turn=true;   //first plr
    while(gameover==false)
    {
        if(turn==true)
        {
            cout<<endl<<"-----------FIRST PLAYER TURN---------  "<<endl;
            int r,c;
            cout<<"Enter the posstion at which you want to enter your symbool----"<<endl;
            bool firstentered=false;

            while(firstentered==false){
            cin>>r;
            cin>>c;
            if(r<0||r>2||c<0||c>2)
            {
                cout<<"OUT Of range-----\n";
                continue;
            }
            if(arr[r][c]!=0){
                cout<<"This place is already filled please enter other position\n";
                continue;
               
            }
           else{
            cout<<"correct 1 "<<endl;
                firstentered=true;
                turn=false;

                occupied--;
                // break;
            } 
        }

            arr[r][c]=1;   // 1 for first player
             

            // calling print grid function
            print(arr);

           if( checkwin(arr,1)){
            cout<<"CONGRATULATION   FIRST PLAYER WINSSSSSSSSSSSSSSSSSSSSSSSSSSSS"<<endl;
            occupied=0;
           } // player 1

          //wining condition   
            
        }

         else if(turn==false){

            cout<<endl<<"-----------SECOND PLAYER TURN---------  "<<endl;
            int r,c;
            cout<<"Enter the posstion at which you want to enter your symbool----"<<endl;
            bool secondentered=false;
            while(secondentered==false){
            cin>>r;
            cin>>c;
             if(r<0||r>2||c<0||c>2)
            {
                cout<<"OUT Of range-----\n";
                continue;
            }
            if(arr[r][c]!=0){
                cout<<"This place is already filled please enter other position\n";
                continue;
               
            }
           else{
            cout<<"Correct 2"<<endl;
                secondentered=true;
                turn =true;
                occupied--;
                // break;
            } 
          }

          arr[r][c]=2;   // 2 for second player

          // printing grid function
          print(arr);
          
          //winning condition  
          if( checkwin(arr,2)){
            cout<<"CONGRATULATION   SECOND PLAYER WINSSSSSSSSSSSSSSSSSSSSSSSSSSSS"<<endl;
            occupied=0;
           }
           
          
        }



        //gameover condition
        
        cout<<occupied<<endl;
        if(occupied<=0)
        {
            gameover=true;

            break;
        }
       
        // break;
    }

     for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++){
            cout<<arr[i][j]<<" ";
        }
        cout<<endl;
    }
}
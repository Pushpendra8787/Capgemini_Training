// cow question
#include<iostream>
using namespace std;

int main(){
        int side,len;
        cout<<"enter the side of the square field\n";
        cin>>side;
        cout<<"now enter the length of rope\n";
        cin>>len;

        int fieldarea=side*side;
        double circleare=3.14*len*len;

        if(circleare>=fieldarea)
        {
            cout<<"COW Can Eat whole field\n";
        }
        else{
            cout<<"Cow can not eat whole field\n";
            int diff=fieldarea-circleare;
            cout<<"Cow can eat "<<diff<<" Area of field\n";
        }
}
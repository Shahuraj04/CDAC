//Write a program to find greatest of three numbers using nested if-else.
#include<iostream>
using namespace std;

int main(){
    int a,b,c;
    cout<<"----GRESTEST NUMBER----"<<endl;
    cout<<"ENter 3 Numbers: ";
    cin>>a>>b>>c;
    if(a>b && a>c){
        cout<<a<<" is greatest number."<<endl;
    }
    else if(b>a && b>c){
        cout<<b<<" is greatest number."<<endl;
    }
    else{
        cout<<c<<" is greatest number."<<endl;
    }

}
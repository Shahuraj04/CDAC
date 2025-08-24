#include<iostream>
using namespace std;

int main(){

    cout<<"\t\t PROGRAM TO CHECK IF NUMBER IS DIVISIBLE BY 5 & 7"<<endl;
    int num;
    cout<<"Enter Number: ";
    cin>>num;
    if(num%5==0 && num%7==0){
        cout<<num<<" is divisible by 5 & 7."<<endl;
    } 
    else if(num%5==0 && num%7!=0){
        cout<<num<<" is only divisible by 5 not by 7"<<endl;
    }
    else if(num%7==0 && num%5!=0){
        cout<<num<<" is only divisible by 7 not by 5"<<endl;

    }
    else{
        cout<<num<<" not divisible by 5 neither 7."<<endl;
    }


}
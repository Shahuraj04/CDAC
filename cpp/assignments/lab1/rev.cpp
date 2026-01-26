#include<iostream>
using namespace std;

int main(){
    int num,real,rev=0,digit;
    cout<<"Enter number you want to be reversed: ";
    cin>>num;
    real=num;
    while(num>0){
        digit=num%10;
        rev=rev*10+digit;
        num/=10;

    }
    cout<<rev<<" is reverse of your number"<<endl;
}
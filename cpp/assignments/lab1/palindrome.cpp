#include <iostream>
using namespace std;

int main(){
    int num,real,digit,reverse=0;
    cout<<"Enter number: ";
    cin>>num;
    real=num;
    while(num>0){
        digit=num%10;
        reverse=reverse*10+digit;
        num/=10;
    }
    cout<<reverse;

}
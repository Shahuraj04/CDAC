#include <iostream>
using namespace std;

int main(){

    int num,sum=0,digit,original;
    cout<<"Enter Number: ";
    cin>>num;
    original=num;
    while(num>0){
        digit=num%10;
        sum+=digit;
        num*=10;

    }
    cout<<"Sum of digits of "<<original<<" is "<<sum;
}
// Function Template – Maximum
//  Write a function template findMax() that returns the maximum of two values.
#include<iostream>
using namespace std;

template<class t>
void max_num(t a, t b){
    if(a>b){
        cout<<a<<" is greater than "<<b<<endl;
    }else{
        cout<<b<<" is greater than "<<a<<endl;
    }
}

int main(){
    max_num(5,10);
    max_num(5.7,2.0);
    max_num('a','b');
}
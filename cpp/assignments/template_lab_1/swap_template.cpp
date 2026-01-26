//  Basic Template Assignments
// Function Template – Swap
//  Write a function template swapValues() that swaps two variables of any type.


// Test with int, double, and string.


// Function Template – Maximum
//  Write a function template findMax() that returns the maximum of two values.
#include<iostream>
using namespace std;


template<class T>
void swaping(T &a,T &b){
    T temp;
    temp=a;
    a=b;
    b=temp;
}
int main(){
    int n1=10,n2=20;
    swaping(n1,n2);
    cout<<"+++++++AFTER SWAPPING+++++++"<<endl;
    cout<<n1<<" "<<n2<<endl;
    char ch1='A',ch2='B';
    swaping(ch1,ch2);
    cout<<"+++++++AFTER SWAPPING+++++++"<<endl;
    cout<<ch1<<" "<<ch2;
}
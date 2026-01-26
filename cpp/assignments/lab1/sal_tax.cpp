#include<iostream>
using namespace std;

int main(){

    cout<<"Enter Your salary: ";
    double sal;
    cin>>sal;
    if(sal<=150000){
        cout<<"\t\tno tax for you"<<endl;
    }
    else if(sal>150000 && sal<=300000){
        cout<<"\t\t20% tax on your salary"<<endl;

    }
    else if(sal>300000){
        cout<<"\t\t30% tax on salary"<<endl;
    }
}
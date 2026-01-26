#include <iostream>
using namespace std;

int main(){
    int num;
    cout<<"Enter number upto which you want sum: ";
    cin>>num;
    int sum=0;
    for(int i=1;i<=num;i++){
        sum+=i;
    }
    cout<<sum<<"\t\t is sum"<<endl;
}
#include<iostream>
using namespace std;

int main(){
    cout<<"Enter height of pattern:";
    int height;
    cin>>height;
    for(int i=1;i<=height;i++){
        for(int j=1;j<=i;j++){
        cout<<" *";
        }
        cout<<endl;   
    }

}
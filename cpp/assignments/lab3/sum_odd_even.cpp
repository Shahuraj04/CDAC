#include<iostream>
using namespace std;

int main(){
    int num,oddsum=0,evensum=0;
    cout<<"Enter numbre: ";
    cin>>num;
    for(int i=0;i<=num;i++){
        if(i%2==0){
            evensum=evensum+i;
        }
        else if(i%2!=0){
            oddsum=oddsum+i;
        }
    }
    cout<<evensum<<" is sum of even terems"<<endl;
    cout<<oddsum<<" is sum od odd terms"<<endl;

    
}
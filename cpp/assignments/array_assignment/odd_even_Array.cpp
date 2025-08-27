#include<iostream>
using namespace std;

int main(){
    int n,even=0,odd=0;
    cout<<"Enter no. of array elements: ";
    cin>>n;
    int array[n];
    for(int i=0;i<n;i++){
        cout<<"ENter element no."<<i<<": ";
        cin>>array[i];
    }
    for(int i=0;i<n;i++){
        if(array[i]%2==0){
            even++;
        }
        else{
            odd++;
        }
    }
    cout<<"No. of even elements: "<<even<<endl;
    cout<<"No. of odd elements: "<<odd<<endl;
}
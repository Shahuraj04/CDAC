#include<iostream>
using namespace std;

int main(){
    int n;
    
    cout<<"Enter number of elements in array: ";
    cin>>n;
    int arr[n];
    int max=arr[0],min=arr[0];
    for(int i=0;i<n;i++){
        cout<<"Enter elemnet no."<<i<<": ";
        cin>>arr[i];
        if(arr[i]>max){
            max=arr[i];
        }
        else if(arr[i]<min && arr[i]!=0){
            min=arr[i];
        }
    }
    cout<<"max number: "<<max<<endl;
    cout<<"min number: "<<min<<endl;

}
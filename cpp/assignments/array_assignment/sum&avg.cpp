#include<iostream>
using namespace std;

int main(){
    int n;
    cout<<"Enter number of students: ";
    cin>>n;
    int arr[n];
    int sum=0;
    double avg=0.0;
    for(int i=0;i<n;i++){
        cout<<"Enter marks of No."<<i+1<<": ";
        cin>>arr[i];
        sum=sum+arr[i];
    }
    cout<<"Total marks: "<<sum<<endl;
    avg=(double)sum/n;
    cout<<"Average marks of students: "<<avg<<endl;


}
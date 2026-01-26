//#Array Input & Output**
//* Take `n` elements from the user and display them
#include <iostream>
using namespace std;

int main(){
    int n;
    cout<<"Enter number of elemets you want in array: ";
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++){
        cout<<"Enter element no."<<i<<": ";
        cin>>arr[i];        
    }
    for(int j=0;j<n;j++){
        cout<<arr[j]<<" ";
    }

}
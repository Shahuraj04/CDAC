#include<iostream>
using namespace std;

int main(){
    int n;
    cout << "Enter number of elements: ";
    cin >> n;
    int array[n];
    for(int i=0;i<n;i++){
        cout<<"Enter element no."<<i<<": ";
        cin>>array[i];

    }
    for(int i=0;i<n-1;i++){
        for(int j=0;j<n-i-1;j++){
            if(array[j]>array[j+1]){
                int temp = array[j];
                array[j]=array[j+1];
                array[j+1]=temp;
            }

        }
    }
    cout << "\nArray in Ascending Order: ";
    for (int i = 0; i < n; i++) {
        cout << array[i] << " ";
    }
    for(int i=0;i<n-1;i++){
        for(int j=0;j<n-i-1;j++){
            if(array[j]<array[j+1]){
                int temp = array[j];
                array[j]=array[j+1];
                array[j+1]=temp;
            }

        }
    }
    cout << "\nArray in descending Order: ";

    for (int i = 0; i < n; i++) {
        cout << array[i] << " ";
    }


}
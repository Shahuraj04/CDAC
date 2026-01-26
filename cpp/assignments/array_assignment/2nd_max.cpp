/*Second Largest Element
   * Find the second largest number without sorting.*/

#include<iostream>
using namespace std;

int main(){
    int n,largest=INT_MIN,second_largest=INT_MIN;
    cout<<"Enter Size of array: ";
    cin>>n;
    int myarr[n];

    for(int i=0;i<n;i++){
        cout<<"Array Element Number"<<i<<": ";
        cin>>myarr[i];
    }
    for(int i=0;i<n;i++){
        if(myarr[i]>largest){
            second_largest=largest;
            largest=myarr[i];
        }
        else if(myarr[i] < largest && myarr[i] > second_largest){
            second_largest=myarr[i];
        }
    }
    cout<<"Second largeest: "<<second_largest<<endl;

}
#include <iostream>
using namespace std;

int main(){
    int index=0;
    int arr[10];
    int num,i,total=0;
    int choice;

    cout<<"1.Add Element in array\n2.Show Array\n3.Search Element\n4.Sum of all array elements\n5.Add 2-D array"<<endl;

    do{
        cout<<"\tEnter Choice:";
        cin>>choice;
        switch(choice){

            case 1:
                if(index<=9){
                        cout<<"\t\tEnter Value: ";
                        cin>>num;
                        arr[index]=num;
                        index++;
                        break;
                }
                else {
                    cout<<"Array is full"<<endl;
                };
            

            case 2:
                for(i = 0;i<index;i++){
                    cout<<"\t\t\t"<<arr[i]<<" "<<endl;
                    
                }
                break;
            
            case 3:
                cout<<"\t\tEnter number to search: ";
                cin>>num;
                for(i=0;i<index;i++){
                    if(arr[i]==num){
                        cout<<"\t\t\tFound at index "<<i<<endl;
                        break;
                    }
                }
                if(i==index){
                    cout<<"\t\t\tNot Found"<<endl;
                }
                break;
        };

    }
    while(choice!=0);

}
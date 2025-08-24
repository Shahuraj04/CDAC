//1:Write a program that accepts numbers continuously as long as the number is positive and prints the sum of the given numbers. 
#include <iostream>
using namespace std ;

int main(){
    int num,sum=0;
    do
    {
        cout<<"\t\tEnter number: ";
        cin>>num;
        if(num>0){
            sum+=num;
        }
        else{
            cout<<"\t\t\tSum is "<<sum<<endl;
            return 0;

        }
        


    } while (num!=0);
    
}
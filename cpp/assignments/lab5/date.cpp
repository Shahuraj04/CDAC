#include <iostream>
using namespace std;

class Date{
    private: int day;
             int month;
             int year;
    public : Date(){
             day=4;
             month=12;
             year=2025;
             }
             Date(int day,int month,int year){
                this->day=day;
                this->month=month;
                this->year=year;
             }
            void show(){
                cout<<day<<"-"<<month<<"-"<<year<<endl;
            }

            };
int main(){

    Date obj1;
    cout<<"Object Constructor without argument"<<endl;
    obj1.show();
    Date obj2(11,1,2003);

    cout<<"Object Constructor with argument"<<endl;
    obj2.show();    
    
}

#include <iostream>
using namespace std;


class Date{
    protected: int day;
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

class Employee : public Date{
    private:
        int id;
        string name;
    
        public:
           Employee(){
            id=100;
            name="aaa";
           }
           Employee(int id,string name){
            this->id=id;
            this->name=name;

           }
           void acept(){
            cout<<"\nEnter employee id :- ";
            cin>>id;
            cout<<"\nEnter employee name :- ";
            cin>>name;
            cout<<"\nEnter date :- ";
            cin>>day>>month>>year;
            
           }
           void display(){
            cout<<"\nEmployee id :- "<<id;
            cout<<"\nEnployee name :- "<<name;
            cout<<"\nDate :- "<<day<<"-"<<month<<"-"<<year;
           }

    
};

int main(){
    Employee e1;
    cout<<"Constructor created with no arguments";
    e1.display();
    Employee e2(293,"shahu");
    cout<<"\n\n\nConstructor with arguments ";
    e2.display();
    Employee e3;
    cout<<"\n\n";
    e3.acept();
    e3.display();
    
    
}
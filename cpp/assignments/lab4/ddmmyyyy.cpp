#include <iostream>
using namespace std;

class Date
{
private:
    int dd;
    int mm;
    int yyyy;

public:
    Date()
    {
        dd = 04;
        mm = 12;
        yyyy = 2003;
    }
    Date(int dd,int mm,int yyyy){
        this->dd=dd;
        this->mm=mm;
        this->yyyy=yyyy;
    }

    void setdd(int day)
    {
        dd=day;

    }
    void setmm(int month)
    {
        mm=month;

    }
    void setyy(int year)
    {
        yyyy=year;

    }
    int getdd(){
        return dd;
    }
    int getmm(){
        return mm;
    }
    int getyyyy(){
        return yyyy;
    }
    void display(){
            cout<<"DD: "<<dd;
            cout<<" MM: "<<mm;
            cout<<" YYYY: "<<yyyy<<endl;
    }
};

int main(){
    cout << "Default Constructor Object:" << endl;
    Date d1;
    d1.display();

    cout << "\nAfter using setters:" << endl;
    d1.setdd(27);
    d1.setmm(9);
    d1.setyy(2025);
    d1.display();

    cout << "\nParameterized Constructor Object:" << endl;
    Date d2(5,3,2025);
    d2.display();

    cout << "\nUsing Getters :" << endl;
    cout << "Name: " << d2.getdd() << endl;
    cout << "Age: " << d2.getmm() << endl;
    cout << "City: " << d2.getyyyy() << endl;
}
#include <iostream>
using namespace std;

class Student
{
public:
    string name;
    int rollno;
    int marks1;
    int marks2;
    int total;
    double perc = 0;
    string grade;
    Student() {}
    Student(string name, int rollno, int marks1, int marks2)
    {
        this->name = name;
        this->rollno = rollno;
        this->marks1 = marks1;
        this->marks2 = marks2;
    }
    void acceptInfo(string name, int rollno, int marks1, int marks2)
    {
        this->name = name;
        this->rollno = rollno;
        this->marks1 = marks1;
        this->marks2 = marks2;
    }
    void display()
    {
        total = marks1 + marks2;
        perc = (total / 200.0) * 100;
        cout << "\t\t\t\t+++++++REPORT CARD+++++++" << endl;
        cout << "\t\t\t\t+Student name: " << name << endl;
        cout << "\t\t\t\t+Roll No.: " << rollno << endl;
        cout << "\t\t\t\t+total marks: " << total << endl;
        cout << "\t\t\t\t+percentage marks: " << perc << endl;
    }
};

int main()
{
    Student s1;
    string sname;
    int sroll;
    int smark1, smark2;
    cout << "Enter Student name: ";
    cin >> sname;
    cout << "Enter Student roll no.: ";
    cin >> sroll;
    cout << "Enter subject1 marks out of 100: ";
    cin >> smark1;
    cout << "Enter subject2 marks out of 100: ";
    cin >> smark2;
    s1.acceptInfo(sname, sroll, smark1, smark2);
    s1.display();
}
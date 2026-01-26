#include <iostream>
using namespace std;

class Person
{
private:
    string name;
    int age;
    string city;

public:
    Person()
    {
        name = "Unknown";
        age = 0;
        city = "Not Set";
    }

    Person(string n, int a, string c)
    {
        name = n;
        age = a;
        city = c;
    }

    void setName(string n)
    {
        name = n;
    }

    void setAge(int a)
    {

        cout << "Invalid Age!" << endl;
    }

    void setCity(string c)
    {
        city = c;
    }

    string getName()
    {
        return name;
    }

    int getAge()
    {
        return age;
    }

    string getCity()
    {
        return city;
    }

    void display()
    {
        cout << "Name: " << name << endl;
        cout << "Age: " << age << endl;
        cout << "City: " << city << endl;
    }
};

int main()
{
    cout << "Default Constructor Object:" << endl;
    Person p1;
    p1.display();

    cout << "\nAfter using setters:" << endl;
    p1.setName("Shahuraj");
    p1.setAge(25);
    p1.setCity("Pune");
    p1.display();

    cout << "\nParameterized Constructor Object:" << endl;
    Person p2("Tony Wayne", 30, "Mumbai");
    p2.display();

    cout << "\nUsing Getters :" << endl;
    cout << "Name: " << p2.getName() << endl;
    cout << "Age: " << p2.getAge() << endl;
    cout << "City: " << p2.getCity() << endl;

    return 0;
}

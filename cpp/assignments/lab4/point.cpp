#include <iostream>
using namespace std;

class Point
{
private:
    int x;
    int y;

public:
    Point()
    {
        x = 0;
        y = 0;
    }

    Point(int a, int b)
    {
        x = a;
        y = b;
    }

    void setX(int a)
    {
        x = a;
    }

    void setY(int b)
    {
        y = b;
    }

    int getX()
    {
        return x;
    }

    int getY()
    {
        return y;
    }

    void display()
    {
        cout << "(" << x << ", " << y << ")" << endl;
    }
};

int main()
{
    cout << "Default Constructor Object:" << endl;
    Point p1;
    p1.display();

    cout << "\nAfter using setters:" << endl;
    p1.setX(10);
    p1.setY(20);
    p1.display();

    cout << "\nParameterized Constructor Object:" << endl;
    Point p2(5, 15);
    p2.display();

    cout << "\nUsing getters:" << endl;
    cout << "X: " << p2.getX() << endl;
    cout << "Y: " << p2.getY() << endl;
}

#include <iostream>
using namespace std;

inline int areaSquare(int side)
{
    return side * side;
}

inline int areaRectangle(int length, int breadth)
{
    return length * breadth;
}

inline double areaCircle(double r)
{
    const double PI = 3.14159;
    return PI * r * r;
}

int main()
{
    int side, length, breadth;
    double radius;

    cout << "Enter side of square: ";
    cin >> side;
    cout << "Area of Square = " << areaSquare(side) << endl;

    cout << "\nEnter length and breadth of rectangle: ";
    cin >> length >> breadth;
    cout << "Area of Rectangle = " << areaRectangle(length, breadth) << endl;

    cout << "\nEnter radius of circle: ";
    cin >> radius;
    cout << "Area of Circle = " << areaCircle(radius) << endl;

    return 0;
}

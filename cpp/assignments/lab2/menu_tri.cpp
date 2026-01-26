#include <iostream>
using namespace std;

int main()
{
    int choice;
    int rad = 0;
    double area = 0, pi = 3.14;
    int len, bre, height, base;

    do
    {
        cout << "-----------Area Calculator-----------" << endl;
        cout << "1.Find area of circle" << endl;
        cout << "2.Find area of rectangle" << endl;
        cout << "3.Find area of triangle" << endl;
        cout << "4.Exit" << endl;
        cout << "Enter choice: " << endl;
        cin >> choice;
        switch (choice)
        {
        case 1:
            cout << "Enter Radius: ";
            cin >> rad;
            area = rad * rad * pi;
            cout << "\t\t\t\tArea of circle with radius " << rad << " is:" << area << "" << "\n\n"
                 << endl;
            break;
        case 2:
            cout << "Enter length: ";
            cin >> len;
            cout << endl;
            cout << "Enter breadth: ";
            cin >> bre;
            area = len * bre;
            cout << "\t\t\t\tArea of rectangle is: " << area << "\n\n"<< endl;
            break;

        case 3:
            cout << "Enter height:";
            cin >> height;
            cout << "Enter base :";
            cin >> base;
            area = 0.5 * height * base;
            cout << "\t\t\t\tArea of triangle is: " << area << "\n\n"<< endl;

        case 4:
            cout << "Exiting the program..." << endl;
            break;

        default:
            cout << "Invalid choice. Please select again." << endl;
            break;
        }
    } while (choice != 4);
}
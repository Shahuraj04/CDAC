#include <iostream>
using namespace std;

class Math_op
{
    void virtual addition(int a, int b) = 0;
    void virtual subtraction(int a, int b) = 0;
    void virtual multiplication(int a, int b) = 0;
    void virtual division(int a, int b) = 0;
};

class Calculator : public Math_op
{
private:
    int a;
    int b;
    int add;
    int sub;
    int multi;
    double div = 0.0;

public:
    Calculator()
    {
        int a = 10;
        int b = 20;
    }
    Calculator(int a, int b)
    {
        this->a = a;
        this->b = b;
    }
    void addition(int a, int b)
    {
        add = a + b;
        cout << "\t\t\tAddition is :" << add << endl;
    }
    void subtraction(int a, int b)
    {
        sub = a - b;
        cout << "\t\t\tSubtraction is :" << sub << endl;
    }
    void multiplication(int a, int b)
    {
        multi = a * b;
        cout << "\t\t\tmultiplication is : " << multi << endl;
    }
    void division(int a, int b)
    {
        div = a / b;
        cout << "\t\t\tDivision is : " << div << endl;
    }
};

int main()
{
    Calculator c1;
    int num1, num2;
    int choice;

    do
    {

        cout << "Enter first Number: ";
        cin >> num1;
        cout << "Enter second Number: ";
        cin >> num2;
        cout << "\t\t\t\t||=========CALCULATOR==========||" << endl;
        cout << "\t\t\t\t|| 1. Addition                 ||" << endl;
        cout << "\t\t\t\t|| 2. Subtraction              ||" << endl;
        cout << "\t\t\t\t|| 3. Multiplication           ||" << endl;
        cout << "\t\t\t\t|| 4. Division                 ||" << endl;
        cout << "\t\t\t\t|| 5. Exit                     ||" << endl;
        cout << "\t\t\t\t||=============================||\n\n"
             << endl;
        cout << "Enter Choice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
            c1.addition(num1, num2);
            break;
        case 2:
            c1.subtraction(num1, num2);
            break;
        case 3:
            c1.multiplication(num1, num2);
            break;
        case 4:
            if (num2 != 0)
            {
                c1.division(num1, num2);
            }
            else
            {
                cout << "!!!!!Cannot Divide by 0!!!!!" << endl;
            }

            break;

        default:
            break;
        }

    } while (true);
}
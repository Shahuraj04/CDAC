#include <iostream>
using namespace std;

int main() {
    cout << "----- SWAPPING NUMBERS -----" << endl;

    cout << "Enter first number: ";
    int num1;
    cin >> num1;

    cout << "Enter second number: ";
    int num2;
    cin >> num2;

    int temp;
    temp = num1;   
    num1 = num2;   
    num2 = temp;   

    cout << "After swapping:" << endl;
    cout << "First number: " << num1 << endl;
    cout << "Second number: " << num2 << endl;

    return 0;
}

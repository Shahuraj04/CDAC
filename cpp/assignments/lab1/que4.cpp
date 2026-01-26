#include <iostream>
using namespace std;

int main() {
    cout << "Enter number to check if it's even or odd: ";
    int num;
    cin >> num;

    if (num % 2 == 0) {
        cout << "Number " << num << " is an even number." << endl;
    } else {
        cout << "Number " << num << " is an odd number." << endl;
    }

    return 0;
}

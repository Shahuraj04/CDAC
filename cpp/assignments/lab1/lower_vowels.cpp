#include <iostream>
using namespace std;

int main() {
    char ch;

    cout << "Enter a lowercase character: ";
    cin >> ch;

     if (ch >= 'a' && ch <= 'z') {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            cout << ch << " is a vowel." << endl;
        } else {
            cout << ch << " is a consonant." << endl;
        }
    } else {
        cout << "Invalid input! Please enter a lowercase letter." << endl;
    }

    return 0;
}

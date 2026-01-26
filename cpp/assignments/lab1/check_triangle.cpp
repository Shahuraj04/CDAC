#include <iostream>
using namespace std;

int main() {
    int a, b, c;

    cout << "Enter three angles of a triangle: ";
    cin >> a >> b >> c;

    if (a > 0 && b > 0 && c > 0 && (a + b + c == 180)) {
        cout << "The triangle is valid." << endl;
    } else {
        cout << "The triangle is NOT valid." << endl;
    }

    return 0;
}

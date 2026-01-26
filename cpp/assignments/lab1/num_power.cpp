#include <iostream>
using namespace std;

int main() {
    int m, n;
    int result = 1; 
    cout << "Enter base m: ";
    cin >> m;
    cout << "Enter exponent n: ";
    cin >> n;

     
    for (int i = 1; i <= n; i++) {
        result *= m;
    }

    cout << m << " raised to " << n << " = " << result << endl;

    return 0;
}

#include <iostream>
#include <cmath>  
using namespace std;

int main() {
    int x, n;
    cout << "Enter the base (x): ";
    cin >> x;
    cout << "Enter the exponent (n): ";
    cin >> n;

    double result = pow(x, n); 

    cout << x << " raised to the power " << n << " is " << result << endl;

    return 0;
}

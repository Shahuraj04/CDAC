#include <iostream>
using namespace std;

int main() {
    int num;
    cout << "Enter number: ";
    cin >> num;

    bool flag = true;  

    if (num <= 1) {
        flag = false;  
    } else {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
    }

    flag ? cout << num << "\t\t is a prime number"
         : cout << num << "\t\t isn't a prime number";

    return 0;
}

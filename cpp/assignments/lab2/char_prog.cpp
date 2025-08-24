#include <iostream>
using namespace std;

int main()
{
    char ch;
    int n;

    cout << "Enter a character: ";
    cin >> ch;
    cout << "Enter the number of next characters to display: ";
    cin >> n;

    cout << "Next " << n << " characters after '" << ch << "' are: ";
    for (int i = 1; i <= n; i++)
    {
        cout << static_cast<char>(ch + i) << " ";
    }
    

    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int n, f;
    cout << "Enter no. of elements for array: ";
    cin >> n;

    int arr[n];   

     for (int i = 0; i < n; i++) {
        cout << "Enter element no." << i << ": ";
        cin >> arr[i];
    }

    cout << "Enter element to find in array: ";
    cin >> f;

    bool found = false;
    for (int j = 0; j < n; j++) {
        if (arr[j] == f) {
            cout << "Gotcha! Your element is at index " << j << "!" << endl;
            found = true;
            break;    
        }
    }

    if (!found) {
        cout << "Number not found :(" << endl;
    }

   
}

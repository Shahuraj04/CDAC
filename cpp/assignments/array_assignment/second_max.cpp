#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;

    if (n < 2) {
        cout << "At least two elements are required!" << endl;
        return 0;
    }

    int arr[n];
    for (int i = 0; i < n; i++) {
        cout << "Enter element no." << i << ": ";
        cin >> arr[i];
    }

    int first = INT_MIN;    
    int second = INT_MIN;   

    for (int i = 0; i < n; i++) {
        if (arr[i] > first) {
             second = first;
            first = arr[i];
        }
        else if (arr[i] > second && arr[i] != first) {
             second = arr[i];
        }
    }

    if (second == INT_MIN)
        cout << "No second largest element (all elements are same)." << endl;
    else
        cout << "Second largest element: " << second << endl;

     
}

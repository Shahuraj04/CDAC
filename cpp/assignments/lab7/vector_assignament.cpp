#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    vector<int> nums;
    int choice, val;

    do {
        cout << "\n--- Menu ---\n";
        cout << "1.Add  2.Show All  3.Search  4.Sort  5.Reverse  6.Clear  0.Exit\n";
        cout << "Enter choice: ";
        cin >> choice;

        switch (choice) {
        case 1:
            cout << "Enter value: ";
            cin >> val;
            nums.push_back(val);
            break;
        case 2:
            cout << "Values: ";
            for (int x : nums) cout << x << " ";
            cout << endl;
            break;
        case 3:
            cout << "Enter value to search: ";
            cin >> val;
            if (find(nums.begin(), nums.end(), val) != nums.end())
                cout << "Found!\n";
            else
                cout << "Not Found!\n";
            break;
        case 4:
            sort(nums.begin(), nums.end());
            cout << "Sorted.\n";
            break;
        case 5:
            reverse(nums.begin(), nums.end());
            cout << "Reversed.\n";
            break;
        case 6:
            nums.clear();
            cout << "Vector cleared.\n";
            break;
        }
    } while (choice != 0);

    return 0;
}

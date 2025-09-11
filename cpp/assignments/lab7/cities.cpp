#include <iostream>
#include <set>
using namespace std;

int main() {
    set<string> cities;
    int choice;
    string city;

    do {
        cout << "\n1.Add City 2.Display All 3.Search City 0.Exit\nChoice: ";
        cin >> choice;

        switch (choice) {
        case 1:
            cout << "Enter city: ";
            cin >> city;
            cities.insert(city);
            break;
        case 2:
            for (auto &c : cities) cout << c << " ";
            cout << endl;
            break;
        case 3:
            cout << "Enter city to search: ";
            cin >> city;
            if (cities.find(city) != cities.end()) cout << "Found\n";
            else cout << "Not found\n";
            break;
        }
    } while (choice != 0);
}

// Create menu driven program for Pizza Shop.And display total amount
#include <iostream>
using namespace std;

int main() {
    int choice, qty;
    double total = 0;
    char ch;

    do {
        cout << "---------- PIZZA SHOP MENU ----------" << endl;
        cout << "1. Margherita     - Rs. 250" << endl;
        cout << "2. Farmhouse      - Rs. 320" << endl;
        cout << "3. Peppy Paneer   - Rs. 350" << endl;
        cout << "4. Veg Extravaganza - Rs. 400" << endl;
        cout << "5. Exit" << endl;
        cout << "Enter your choice (1-5): ";
        cin >> choice;

        switch(choice) {
            case 1:
                cout << "Enter quantity for Margherita: ";
                cin >> qty;
                total += qty * 250;
                break;
            case 2:
                cout << "Enter quantity for Farmhouse: ";
                cin >> qty;
                total += qty * 320;
                break;
            case 3:
                cout << "Enter quantity for Peppy Paneer: ";
                cin >> qty;
                total += qty * 350;
                break;
            case 4:
                cout << "Enter quantity for Veg Extravaganza: ";
                cin >> qty;
                total += qty * 400;
                break;
            case 5:
                cout << "Thank you for visiting the Pizza Shop!" << endl;
                break;
            default:
                cout << "Invalid choice. Please select again." << endl;
        }
        
        if (choice != 5) {
            cout << "Do you want to order more? (y/n): ";
            cin >> ch;
        } else {
            break;
        }
    } while (ch == 'y' || ch == 'Y');

    cout << "-------------------------------------" << endl;
    cout << "Total Amount: Rs. " << total << endl;
    cout << "-------------------------------------" << endl;

    return 0;
}

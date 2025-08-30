#include <iostream>
using namespace std;

class BankAccount {
private:
    int acctNo;
    string custName;
    double balance;

public:
     BankAccount(int acc, string name, double bal) {
        acctNo = acc;
        custName = name;
        balance = bal;
    }

     void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            cout << "Deposited: " << amt << " | New Balance: " << balance << endl;
        } else {
            cout << "Invalid deposit amount!" << endl;
        }
    }

     void withdraw(double amt) {
        if (amt <= 0) {
            cout << "Invalid withdrawal amount!" << endl;
        } else if (amt > balance) {
            cout << "Insufficient balance!" << endl;
        } else {
            balance -= amt;
            cout << "Withdrawn: " << amt << " | New Balance: " << balance << endl;
        }
    }

     void display() {
        cout << "\nAccount No: " << acctNo
             << "\nName: " << custName
             << "\nBalance: " << balance << endl;
    }
};

int main() {
     int accNo;
    string name;
    double initBal;

    cout << "Enter Account No: ";
    cin >> accNo;
    cout << "Enter Customer Name: ";
    cin >> name;
    cout << "Enter Initial Balance: ";
    cin >> initBal;

    BankAccount acc(accNo, name, initBal);

    int choice;
    do {
        cout << "\n--- Bank Menu ---\n";
        cout << "1. Display Account\n";
        cout << "2. Deposit Money\n";
        cout << "3. Withdraw Money\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
        case 1:
            acc.display();
            break;
        case 2: {
            double amt;
            cout << "Enter amount to deposit: ";
            cin >> amt;
            acc.deposit(amt);
            break;
        }
        case 3: {
            double amt;
            cout << "Enter amount to withdraw: ";
            cin >> amt;
            acc.withdraw(amt);
            break;
        }
        case 4:
             
            break;
        default:
            cout << "Invalid choice! Try again." << endl;
        }
    } while (choice != 4);

     
}

#include <iostream>
#include <map>
using namespace std;

class Account {
    int actid;
    string name;
    double balance;
public:
    Account(int id=0, string n="", double b=0) : actid(id), name(n), balance(b) {}
    int getId() { return actid; }
    void display() {
        cout << "ID:" << actid << " Name:" << name << " Balance:" << balance << endl;
    }
};

int main() {
    map<int, Account> accounts;
    int choice, id;
    string name;
    double bal;

    do {
        cout << "\n1.Add 2.Display All 3.Search 4.Remove All 0.Exit\nChoice: ";
        cin >> choice;
        switch (choice) {
        case 1:
            cout << "Enter id name balance: ";
            cin >> id >> name >> bal;
            accounts[id] = Account(id, name, bal);
            break;
        case 2:
            for (auto &p : accounts) p.second.display();
            break;
        case 3:
            cout << "Enter id: ";
            cin >> id;
            if (accounts.find(id) != accounts.end()) accounts[id].display();
            else cout << "Not Found\n";
            break;
        case 4:
            accounts.clear();
            cout << "All removed.\n";
            break;
        }
    } while (choice != 0);
}

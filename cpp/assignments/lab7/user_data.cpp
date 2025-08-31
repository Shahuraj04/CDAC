#include <iostream>
#include <vector>
#include <string>
using namespace std;

class User {
private:
    int userId;
    string name;
    string email;
    string pwd;

public:
    User() {}
    User(int id, string n, string e, string p) {
        userId = id;
        name = n;
        email = e;
        pwd = p;
    }

    int getId() { return userId; }
    string getName() { return name; }
    string getEmail() { return email; }
    string getPwd() { return pwd; }

    void setPwd(string newPwd) { pwd = newPwd; }

    void display() {
        cout << "UserID: " << userId
             << " | Name: " << name
             << " | Email: " << email
             << " | Password: " << pwd << endl;
    }
};

int main() {
    vector<User> users;
    int choice;

    do {
        cout << "\n=========== USER MANAGEMENT MENU ===========\n";
        cout << "1. Add User\n";
        cout << "2. Display All Users\n";
        cout << "3. Search User by ID\n";
        cout << "4. Change Password\n";
        cout << "5. Delete All Users\n";
        cout << "6. Exit\n";
        cout << "Enter Choice: ";
        cin >> choice;

        if (choice == 1) {
            int id;
            string name, email, pwd;
            cout << "Enter User ID: ";
            cin >> id;
            cout << "Enter Name: ";
            cin.ignore();
            getline(cin, name);
            cout << "Enter Email: ";
            getline(cin, email);
            cout << "Enter Password: ";
            getline(cin, pwd);

            users.push_back(User(id, name, email, pwd));
            cout << " User Added Successfully!\n";

        } else if (choice == 2) {
            if (users.empty()) {
                cout << " No Users Found!\n";
            } else {
                cout << "\n---- User List ----\n";
                for (auto &u : users) {
                    u.display();
                }
            }

        } else if (choice == 3) {
            int id;
            cout << "Enter User ID to Search: ";
            cin >> id;
            bool found = false;
            for (auto &u : users) {
                if (u.getId() == id) {
                    cout << " User Found:\n";
                    u.display();
                    found = true;
                    break;
                }
            }
            if (!found) cout << " User Not Found!\n";

        } else if (choice == 4) {
            int id;
            string newPwd;
            cout << "Enter User ID to Change Password: ";
            cin >> id;
            bool found = false;
            for (auto &u : users) {
                if (u.getId() == id) {
                    cout << "Enter New Password: ";
                    cin.ignore();
                    getline(cin, newPwd);
                    u.setPwd(newPwd);
                    cout << "Password Updated Successfully!\n";
                    found = true;
                    break;
                }
            }
            if (!found) cout << " User Not Found!\n";

        } else if (choice == 5) {
            users.clear();
            cout << " All Users Deleted!\n";

        } else if (choice == 6) {
            cout << " Exiting Program... Bye!\n";

        } else {
            cout << " Invalid Choice! Try Again.\n";
        }

    } while (choice != 6);

}

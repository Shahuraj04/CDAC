#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class User
{
    int userid;
    string name, email, pwd;

public:
    User(int id, string n, string e, string p) : userid(id), name(n), email(e), pwd(p) {}
    int getId() { return userid; }
    string getEmail() { return email; }
    void setPwd(string newPwd) { pwd = newPwd; }
    void display()
    {
        cout << "ID:" << userid << " Name:" << name << " Email:" << email << endl;
    }
};

int main()
{
    vector<User> users;
    int choice, id;
    string name, email, pwd;

    do
    {
        cout << "\n1.Add User 2.Display All 3.Search 4.Change Pwd 5.Delete All 0.Exit\nChoice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
            cout << "Enter id name email pwd: ";
            cin >> id >> name >> email >> pwd;
            users.push_back(User(id, name, email, pwd));
            break;
        case 2:
            for (auto &u : users)
                u.display();
            break;
        case 3:
            cout << "Enter id to search: ";
            cin >> id;
            for (auto &u : users)
                if (u.getId() == id)
                {
                    u.display();
                    break;
                }
            break;
        case 4:
            cout << "Enter id: ";
            cin >> id;
            cout << "Enter new password: ";
            cin >> pwd;
            for (auto &u : users)
                if (u.getId() == id)
                    u.setPwd(pwd);
            cout << "Password changed.\n";
            break;
        case 5:
            users.clear();
            cout << "All users deleted.\n";
            break;
        }
    } while (choice != 0);
}

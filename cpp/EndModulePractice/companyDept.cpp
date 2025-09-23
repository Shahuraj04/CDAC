#include <iostream>
#include <vector>

#include <vector>
#include <memory>
using namespace std;

// Base class
class Department {
protected:
    int dept_id;
    string dept_name;

public:
    virtual void acceptDetails() {
        cout << "Enter Department ID: ";
        cin >> dept_id;
        cout << "Enter Department Name: ";
        cin >> dept_name;
    }

    virtual void displayDetails() const {
        cout << "Department ID: " << dept_id << "\n";
        cout << "Department Name: " << dept_name << "\n";
    }

    virtual ~Department() {} // virtual destructor
};

// Derived HR Department
class HRDepartment : public Department {
    int num_recruiters;
    int open_positions;

public:
    void acceptDetails() override {
        Department::acceptDetails();
        cout << "Enter number of recruiters: ";
        cin >> num_recruiters;
        cout << "Enter open positions: ";
        cin >> open_positions;
    }

    void displayDetails() const override {
        Department::displayDetails();
        cout << "Recruiters: " << num_recruiters << "\n";
        cout << "Open Positions: " << open_positions << "\n";
    }

    void conductInterviews() {
        cout << "HR Department conducting interviews for "
             << open_positions << " positions.\n";
    }
};

// Derived Finance Department
class FinanceDepartment : public Department {
    double budget;

public:
    void acceptDetails() override {
        Department::acceptDetails();
        cout << "Enter budget: ";
        cin >> budget;
    }

    void displayDetails() const override {
        Department::displayDetails();
        cout << "Budget: " << budget << "\n";
    }

    void generateFinancialReport() {
        cout << "Finance Department generating financial report.\n";
    }
};

int main() {
    vector<unique_ptr<Department>> departments;
    int choice, n;

    cout << "How many departments you want to add? ";
    cin >> n;

    for (int i = 0; i < n; i++) {
        cout << "\n1. HR Department\n2. Finance Department\nEnter choice: ";
        cin >> choice;

        if (choice == 1) {
            auto dept = make_unique<HRDepartment>();
            dept->acceptDetails();
            departments.push_back(move(dept));
        } else if (choice == 2) {
            auto dept = make_unique<FinanceDepartment>();
            dept->acceptDetails();
            departments.push_back(move(dept));
        } else {
            cout << "Invalid choice!\n";
            i--;
        }
    }

    cout << "\n--- Department Details ---\n";
    for (auto &dept : departments) {
        dept->displayDetails();

        // RTTI usage
        if (auto hr = dynamic_cast<HRDepartment*>(dept.get())) {
            hr->conductInterviews();
        } else if (auto fin = dynamic_cast<FinanceDepartment*>(dept.get())) {
            fin->generateFinancialReport();
        }

        cout << "---------------------\n";
    }

    return 0;
}

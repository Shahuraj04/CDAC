#include <iostream>
#include <vector>
using namespace std;

 class Emp {
public:
    int empId;
    string empName;
    int deptId;
    double basic_salary;

    Emp() {
        empId = 0;
        empName = "XYZ";
        deptId = 0;
        basic_salary = 10000;
    }

    Emp(int id, string name, int dept, double basic_s) {
        this->empId = id;
        this->empName = name;
        this->deptId = dept;
        this->basic_salary = basic_s;
    }

    virtual double computeNetSalary() {
        return 0;
    }

    virtual void display() {
        cout << "ID: " << empId 
             << ", Name: " << empName 
             << ", DeptID: " << deptId 
             << ", Basic: " << basic_salary;
    }

    virtual ~Emp() {}
};

 class Mgr : public Emp {
public:
    double perfBonus;

    Mgr(int id, string name, int dept, double basic_s, double perf_B)
        : Emp(id, name, dept, basic_s), perfBonus(perf_B) {}

    double computeNetSalary() override {
        return basic_salary + perfBonus;
    }

    void display() override {
        Emp::display();
        cout << ", PerfBonus: " << perfBonus 
             << ", NetSalary: " << computeNetSalary();
    }
};

 class Worker : public Emp {
    int hours_worked;
    double hourly_rate;

public:
    Worker(int id, string name, int dept, double basic_s, int hours, double rate)
        : Emp(id, name, dept, basic_s), hours_worked(hours), hourly_rate(rate) {}

    double computeNetSalary() override {
        return basic_salary + (hours_worked * hourly_rate);
    }

    double getHrlyRate() {
        return hourly_rate;
    }

    void display() override {
        Emp::display();
        cout << ", HoursWorked: " << hours_worked 
             << ", HourlyRate: " << hourly_rate 
             << ", NetSalary: " << computeNetSalary();
    }
};

 int main() {
    vector<Emp*> org;  

    int choice;
    do {
        cout << "\n--- Organization Menu ---\n";
        cout << "1. Hire Manager\n";
        cout << "2. Hire Worker\n";
        cout << "3. Display all Employees\n";
        cout << "4. Exit\n";
        cout << "Enter choice: ";
        cin >> choice;

        if (choice == 1) {
            int id, dept;
            string name;
            double basic, bonus;
            cout << "Enter Manager ID, Name, DeptID, Basic Salary, PerfBonus:\n";
            cin >> id >> name >> dept >> basic >> bonus;
            org.push_back(new Mgr(id, name, dept, basic, bonus));
        } 
        else if (choice == 2) {
            int id, dept, hrs;
            string name;
            double basic, rate;
            cout << "Enter Worker ID, Name, DeptID, Basic Salary, HoursWorked, HourlyRate:\n";
            cin >> id >> name >> dept >> basic >> hrs >> rate;
            org.push_back(new Worker(id, name, dept, basic, hrs, rate));
        } 
        else if (choice == 3) {
            cout << "\n--- Employee Details ---\n";
            for (auto e : org) {
                e->display();
                cout << endl;
            }
        }
    } while (choice != 4);

    
}

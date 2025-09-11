#include <iostream>
#include <string>
using namespace std;

class Employee {
private:
    int emp_id;
    string emp_name;
    double basic_salary = 0;
    double hra = 0.0;
    double medical;
    double pf, pt, net_sal, gross_sal;

public:
    Employee() {
        medical = 1000;   // fixed medical allowance
        pt = 200;         // fixed professional tax
    }

    void getinfo() {
        cout << "\nEnter employee id: ";
        cin >> emp_id;
        cin.ignore(); // ignore newline before getline

        cout << "Enter employee name: ";
        getline(cin, emp_name);

        cout << "Enter basic salary: ";
        cin >> basic_salary;
    }

    void setemp() {
        hra = 0.5 * basic_salary;         // HRA = 50% of basic salary
        pf = 0.12 * basic_salary;         // PF = 12% of basic salary
        gross_sal = basic_salary + hra + medical;
        net_sal = gross_sal - (pt + pf);
    }

    void display() {
        cout << "\n-------- Employee Information --------\n";
        cout << "Employee ID      = " << emp_id;
        cout << "\nEmployee Name    = " << emp_name;
        cout << "\nBasic Salary     = " << basic_salary;
        cout << "\nHRA              = " << hra;
        cout << "\nMedical Allow.   = " << medical;
        cout << "\nPF               = " << pf;
        cout << "\nPT               = " << pt;
        cout << "\nGross Salary     = " << gross_sal;
        cout << "\nNet Salary       = " << net_sal << endl;
    }
};

int main() {
    Employee e;
    e.getinfo();
    e.setemp();
    e.display();
    return 0;
}

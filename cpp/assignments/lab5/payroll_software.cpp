// 3:Consider that payroll software needs to be developed for computerization of
// operations of an ABC organization. The organization has employees.
// 3.1. Construct a class Employee with following members using private access
// specifies:
//  Employee Id integer
//  Employee Name string
//  Basic Salary double
//  HRA double
//  Medical double=1000
//  PF double
// PT double
//  Net Salary double
//  Gross Salary double
// Please use following expressions for calculations://Note:Don't accept HRA,PF PT from user
//  * HRA = 50% of Basic Salary
// * PF = 12% of Basic Salary
// * PT = Rs. 200
#include <iostream>
using namespace std;

class Employee
{
private:
    int emp_id;
    string emp_name;
    double basic_salary=0;
    double hra=0.0;
    double medical=0.0;
    double pf, pt, net_salary,gross_sal,net_sal;

public:
    Employee()
    {
        medical = 1000;
        pt = 200;
    }

    void getinfo(){
        cout<<"\nEnter employee id, name, salary :- ";
        cin>>emp_id>>emp_name>>basic_salary;
    }
void setemp(){

    this->hra=0.5*basic_salary;
    this->pf=0.12*basic_salary;
    this->gross_sal=basic_salary+hra+medical;
    this->net_sal=gross_sal-(pt+pf);
}

void display(){
    cout<<"--------Employee Information--------";
    cout<<"Employee ID = "<<emp_id;
    cout<<"\nEmployee Name = "<<emp_name;
    cout<<"\nBasic Salary = "<<basic_salary;
    cout<<"\nHRA = "<<hra<<endl;
    cout<<"PF = "<<pf;
    cout<<"\nPT = "<<pt;
    cout<<"\nGross Salary = "<<gross_sal;
    cout<<"\nNet Salary = "<<net_sal;
}

};

int main(){
    Employee e;
    e.getinfo();
    e.setemp();
    e.display();
}
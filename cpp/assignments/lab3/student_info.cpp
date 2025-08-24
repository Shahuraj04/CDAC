#include <iostream>
using namespace std;

class Student {
private:
    int rollno;
    int mark1, mark2, mark3;
    int total;
    float percentage;
    char grade;

public:
    void acceptInfo() {
        cout << "Enter roll number: ";
        cin >> rollno;

        cout << "Enter marks for subject 1: ";
        cin >> mark1;

        cout << "Enter marks for subject 2: ";
        cin >> mark2;

        cout << "Enter marks for subject 3: ";
        cin >> mark3;

        calculateResults();
    }

    void calculateResults() {
        total = mark1 + mark2 + mark3;
        percentage = (total / 3.0f);

        if (percentage >= 90)
            grade = 'A';
        else if (percentage >= 75)
            grade = 'B';
        else if (percentage >= 60)
            grade = 'C';
        else if (percentage >= 40)
            grade = 'D';
        else
            grade = 'F';
    }

    void display() {
        cout << "\nRoll Number: " << rollno << endl;
        cout << "Marks: " << mark1 << ", " << mark2 << ", " << mark3 << endl;
        cout << "Total: " << total << endl;
        cout << "Percentage: " << percentage << "%" << endl;
        cout << "Grade: " << grade << endl;
    }
};

int main() {
    Student s;
    s.acceptInfo();    
    s.display();       

    return 0;
}

#include <iostream>
#include <fstream>
using namespace std;

int main() {
    int choice;
    string filename1 = "file1.txt", filename2 = "file2.txt", line;

    do {
        cout << "\n1.Write File 2.Read File 3.Copy File 0.Exit\nChoice: ";
        cin >> choice;
        cin.ignore();

        switch (choice) {
        case 1: {
            ofstream fout(filename1);
            cout << "Enter text (end with ~): ";
            while (getline(cin, line) && line != "~") fout << line << endl;
            fout.close();
            break;
        }
        case 2: {
            ifstream fin(filename1);
            while (getline(fin, line)) cout << line << endl;
            fin.close();
            break;
        }
        case 3: {
            ifstream fin(filename1);
            ofstream fout(filename2);
            while (getline(fin, line)) fout << line << endl;
            fin.close(); fout.close();
            cout << "Copied!\n";
            break;
        }
        }
    } while (choice != 0);
}

#include <iostream>
#include <vector>
using namespace std;

class Hotel {
public:
    int RoomNo;
    string room_type;
    double pricePerDay;
    int no_of_days;

    Hotel() {}
    Hotel(int RoomNo, string room_type, double pricePerDay, int no_of_days)
        : RoomNo(RoomNo), room_type(room_type), pricePerDay(pricePerDay), no_of_days(no_of_days) {}

    virtual double calculate_bill() {
        return pricePerDay * no_of_days;
    }

    virtual void display() {
        cout << "Room No: " << RoomNo
             << ", Type: " << room_type
             << ", Price/day: " << pricePerDay
             << ", Days: " << no_of_days
             << ", Bill: " << calculate_bill() << endl;
    }

    virtual ~Hotel() {}
};

class StandardRoom : public Hotel {
public:
    string amenities;
    StandardRoom(int RoomNo, double pricePerDay, int no_of_days, string amenities)
        : Hotel(RoomNo, "Standard", pricePerDay, no_of_days), amenities(amenities) {}

    double calculate_bill() override {
        return Hotel::calculate_bill(); // same as base
    }

    void display() override {
        Hotel::display();
        cout << "  Amenities: " << amenities << endl;
    }
};

class DeluxeRoom : public Hotel {
public:
    string services;
    DeluxeRoom(int roomno, double price, int no_days, string services = "Luxury Services")
        : Hotel(roomno, "Deluxe", price, no_days), services(services) {}

    double calculate_bill() override {
        return pricePerDay * no_of_days * 1.2; // 20% extra
    }

    void display() override {
        Hotel::display();
        cout << "  Services: " << services << endl;
    }
};

int main() {
    vector<Hotel *> myVector;
    int choice;
    do {
        cout << "\n--- Hotel Management System ---\n";
        cout << "1. Add Standard Room Details\n";
        cout << "2. Add Deluxe Room Details\n";
        cout << "3. Display all Room Details with Bill\n";
        cout << "4. Exit\n";
        cout << "Enter choice: ";
        cin >> choice;

        switch (choice) {
        case 1: {
            int roomNo, no_of_days;
            double price;
            string am;
            cout << "Enter Room Number: ";
            cin >> roomNo;
            cout << "Price of room: ";
            cin >> price;
            cout << "No of days: ";
            cin >> no_of_days;
            cin.ignore(); 
            cout << "Enter amenities: ";
            getline(cin, am);

            myVector.push_back(new StandardRoom(roomNo, price, no_of_days, am));
            break;
        }
        case 2: {
            int roomNo, no_of_days;
            double price;
            string serv;
            cout << "Enter Room Number: ";
            cin >> roomNo;
            cout << "Price of room: ";
            cin >> price;
            cout << "No of days: ";
            cin >> no_of_days;
            cin.ignore();
            cout << "Enter services: ";
            getline(cin, serv);

            myVector.push_back(new DeluxeRoom(roomNo, price, no_of_days, serv));
            break;
        }
        case 3:
            cout << "\n--- Room Details ---\n";
            for (auto room : myVector) {
                room->display();
            }
            break;
        case 4:
            cout << "Exiting...\n";
            break;
        default:
            cout << "Invalid choice!\n";
        }
    } while (choice != 4);

    
    for (auto r : myVector)
        delete r;

    return 0;
}

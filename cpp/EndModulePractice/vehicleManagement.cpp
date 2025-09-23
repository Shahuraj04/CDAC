/*2.Vehicle Management System

Design a class Vehicle representing general information about vehicles with members like vehicle_id and vehicle_type.
Derive two specialized classes:
ElectricVehicle with members battery_capacity and charging_time, and a method chargeBattery().

DieselVehicle with member fuel_capacity, and a method refuelDiesel().

The system should:
Allow dynamic addition of vehicles using polymorphism.
Accept & Display information using a virtual function.
Use RTTI (e.g., dynamic_cast or instanceof) to invoke vehicle-specific behavior.

 Note:-Create Array of Objects or Vector Or Map
*/
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
class Vehicle
{
protected:
    int vehicle_Id;
    string vehicle_type;

public:
    Vehicle()
    {
    }
    Vehicle(int id, string type)
    {
        this->vehicle_Id = id;
        this->vehicle_type = type;
    }

public:
    virtual void addVehicleDetails()
    {
        cout << "Enter vehicle id: ";
        cin >> vehicle_Id;
        cout << "Enter vehicle type: ";
        cin >> vehicle_type;
    }
    virtual void showDetails() const
    {
        cout << "Vehicle id: " << this->vehicle_Id << "\t" << "Vehicle type: " << this->vehicle_type << endl;
    }
    virtual ~Vehicle() {

    };
};

class ElectricVehicle : public Vehicle
{
public:
    int battery_capacity;
    int charging_time;

    ElectricVehicle()
    {
    }
    ElectricVehicle(int id, string type) : Vehicle(id, type), battery_capacity(0), charging_time(0)
    {
    }

    void chargeBattery()
    {
        cout << "Charge your battery!!" << endl;
    }
    void addVehicleDetails() override
    {
        Vehicle::addVehicleDetails();
        cout << "Enter battery capacity: ";
        cin >> battery_capacity;
        cout << "ENter chargging time: ";
        cin >> charging_time;
    }
    void showDetails() const override
    {
        Vehicle::showDetails();
        cout << "battery Capcity: " << this->battery_capacity << "\t" << "Charging time: " << this->charging_time << endl;
    }

    virtual ~ElectricVehicle() override {};
};

class DieselVehicle : public Vehicle
{
public:
    int fuel_capacity;

    DieselVehicle() {}
    DieselVehicle(int id, string type) : Vehicle(id, type), fuel_capacity(0)
    {
    }
    void addVehicleDetails() override
    {
        Vehicle::addVehicleDetails();
        cout << "ENter fuel capacity: ";
        cin >> fuel_capacity;
    }
    void showDetails() const override
    {
        Vehicle::showDetails();
        cout << "fuel capacity: " << this->fuel_capacity << endl;
    }
    void refuelDiesel()
    {
        cout << "refuel your diesel!!" << endl;
    }
    virtual ~DieselVehicle() override {};
};

int main()
{
    vector<Vehicle *> allVehicle;
    int choice;
    do
    {
        cout << "1. Add Electric vehicle" << "\n"
             << "2. Add diesel vehicle " << "\n"
             << "3. Show details" << "\n"
             << "0. Exit" << endl;
        cout << "ENter choice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
        {
            Vehicle *v = new ElectricVehicle();
            v->addVehicleDetails();
            allVehicle.push_back(v);
            break;
        }

        case 2:
        {
            Vehicle *v = new DieselVehicle();
            v->addVehicleDetails();
            allVehicle.push_back(v);
            break;
        }
        case 3:
        {
            for (auto &v : allVehicle)
            {
                v->showDetails();
                if (auto ev = dynamic_cast<ElectricVehicle *>(v))
                {
                    ev->chargeBattery();
                }
                else if (auto dv = dynamic_cast<DieselVehicle *>(v))
                {
                    dv->refuelDiesel();
                }
            }
            break;
        }
        }

    } while (choice != 0);
    for (auto &v : allVehicle)
    {
        delete v;
    }
    allVehicle.clear();
};

#include <iostream>
#include <vector>

using namespace std;

class Laundry
{
protected:
    int order_id;
    string customer_name;
    int quantity;

public:
    Laundry() : order_id(0), customer_name(""), quantity(0) {}
    Laundry(int id, string name, int qty) : order_id(id), customer_name(name), quantity(qty) {}

    virtual void display()
    {
        cout << "Order Id: " << order_id << endl;
        cout << "Customer name: " << customer_name << endl;
        cout << "Qty: " << quantity << endl;
    }

    virtual double calculatePrice() { return 0; } // for polymorphic billing
    virtual ~Laundry() {} // virtual destructor for proper cleanup
};

class regularLaundry : public Laundry
{
private:
    double iron_price;

public:
    regularLaundry() : iron_price(0) {};
    regularLaundry(int id, string cusName, int qty, double iron) : Laundry(id, cusName, qty), iron_price(iron) {}

    double calculatePrice() override
    {
        return quantity * iron_price;
    }

    void display() override
    {
        Laundry::display();
        cout << "Regular Laundry Price per item: " << iron_price << endl;
        cout << "Total Price: " << calculatePrice() << endl;
    }
};

class Dry_cleaning : public Laundry
{
private:
    double dry_cleaning_price;

public:
    Dry_cleaning() : dry_cleaning_price(0) {};
    Dry_cleaning(int id, string cusName, int qty, double dry_price) : Laundry(id, cusName, qty), dry_cleaning_price(dry_price) {}

    double calculatePrice() override
    {
        if (quantity > 10)
            return (dry_cleaning_price * quantity) - 10;
        else
            return dry_cleaning_price * quantity;
    }

    void display() override
    {
        Laundry::display();
        cout << "Dry Cleaning Price per item: " << dry_cleaning_price << endl;
        cout << "Total Price: " << calculatePrice() << endl;
    }
};

int main(){
    vector<Laundry*> laundryVector;
    int choice;
    bool exit = false;

    do
    {
        cout << "\n1. Add regular laundry" << endl;
        cout << "2. Add dry cleaning laundry" << endl;
        cout << "3. Show all" << endl;
        cout << "4. Exit" << endl;
        cout << "Enter choice: ";
        cin >> choice;

        switch (choice)
        {
            case 1:
            {
                int id, qty;
                string name;
                double iron_price;
                cout << "Enter Order id: ";
                cin >> id;
                cin.ignore(); // ignore newline
                cout << "Enter name: ";
                getline(cin, name);
                cout << "Enter Quantity: ";
                cin >> qty;
                cout << "Regular cleaning price: ";
                cin >> iron_price;
                laundryVector.push_back(new regularLaundry(id, name, qty, iron_price));
                break;
            }

            case 2:
            {
                int id, qty;
                string name;
                double dry_price;
                cout << "Enter Order id: ";
                cin >> id;
                cin.ignore(); // ignore newline
                cout << "Enter name: ";
                getline(cin, name);
                cout << "Enter Quantity: ";
                cin >> qty;
                cout << "Dry cleaning price: ";
                cin >> dry_price;
                laundryVector.push_back(new Dry_cleaning(id, name, qty, dry_price));
                break;
            }

            case 3:
            {
                for (auto l : laundryVector)
                    l->display();
                break;
            }

            case 4:
                exit = true;
                break;

            default:
                cout << "Invalid choice!" << endl;
                break;
        }
    } while (!exit);

    // Free allocated memory
    for (auto l : laundryVector)
        delete l;

    return 0;
}

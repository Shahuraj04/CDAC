#include <iostream>
using namespace std;

class Book
{
private:
    string bname;
    int id;
    string author;
    float price;

public:
     Book()
    {
        bname = "Unknown";
        id = 0;
        author = "Not Set";
        price = 0.0;
    }

     Book(string bn, int i, string a, float p)
    {
        bname = bn;
        id = i;
        author = a;
        price = p;
    }

     void setBname(string bn)
    {
        bname = bn;
    }

    void setId(int i)
    {
        id = i;
    }

    void setAuthor(string a)
    {
        author = a;
    }

    void setPrice(float p)
    {
        if (p >= 0)
            price = p;
        else
            cout << "Invalid Price!" << endl;
    }

     string getBname()
    {
        return bname;
    }

    int getId()
    {
        return id;
    }

    string getAuthor()
    {
        return author;
    }

    float getPrice()
    {
        return price;
    }

     void display()
    {
        cout << "Book Name: " << bname << endl;
        cout << "Book ID: " << id << endl;
        cout << "Author: " << author << endl;
        cout << "Price: " << price << endl;
    }
};

int main()
{
     cout << "Default Constructor Object:" << endl;
    Book b1; 
    b1.display();

    cout << "\nAfter using setters:" << endl;
    b1.setBname("Learning C++ with Shahu");
    b1.setId(101);
    b1.setAuthor("Shahu");
    b1.setPrice(499.50);
    b1.display();

     cout << "\nParameterized Constructor Object:" << endl;
    Book b2("My life at CDAC", 102, "Shahuraj", 599.99);
    b2.display();

     cout << "\nUsing Getters:" << endl;
    cout << "Book Name: " << b2.getBname() << endl;
    cout << "Book ID: " << b2.getId() << endl;
    cout << "Author: " << b2.getAuthor() << endl;
    cout << "Price: " << b2.getPrice() << endl;

     
}

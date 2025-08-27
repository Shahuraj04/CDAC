#include <iostream>
using namespace std;

class ComplexNumber
{
private:
    float real;
    float imaginary;

public:
    ComplexNumber()
    {
        real = 0.0;
        imaginary = 0.0;
    }

    ComplexNumber(float r, float i)
    {
        real = r;
        imaginary = i;
    }

    void setReal(float r)
    {
        real = r;
    }

    void setImaginary(float i)
    {
        imaginary = i;
    }

    float getReal()
    {
        return real;
    }

    float getImaginary()
    {
        return imaginary;
    }

    void display()
    {
        if (imaginary >= 0)
            cout << real << " + " << imaginary << "i" << endl;
        else
            cout << real << " - " << -imaginary << "i" << endl;
    }
};

int main()
{
    cout << "Default Constructor Object:" << endl;
    ComplexNumber c1;
    c1.display();

    cout << "\nAfter using setters:" << endl;
    c1.setReal(3.5);
    c1.setImaginary(-2.2);
    c1.display();

    cout << "\nParameterized Constructor Object:" << endl;
    ComplexNumber c2(4.1, 5.6);
    c2.display();

    cout << "\nUsing getters:" << endl;
    cout << "Real Part: " << c2.getReal() << endl;
    cout << "Imaginary Part: " << c2.getImaginary() << endl;
}

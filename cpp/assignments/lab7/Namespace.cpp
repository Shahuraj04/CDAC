#include <iostream>
using namespace std;

namespace CDAC {
    class Student {
    public:
        void show() { cout << "CDAC Student\n"; }
    };
}

namespace IACSD {
    class Student {
    public:
        void show() { cout << "IACSD Student\n"; }
    };
}

int main() {
    CDAC::Student s1;
    IACSD::Student s2;
    s1.show();
    s2.show();
}

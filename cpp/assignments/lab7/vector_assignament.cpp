#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{

    vector<int> array_vector;
    cout << "==========IMPLEMENTING ARRAY FUNCTIONS USING VECTOR==========" << endl;

    do
    {
        int choice;
        cout << "1.Add element to array:" << endl;
        cout << "2.Show all array elements" << endl;
        cout << "3.Search element in array" << endl;
        cout << "4.Sort array:" << endl;
        cout << "5.Reverse Array" << endl;
        cout << "6.Clear array:" << endl;
        cout << "Enter Choice: ";
        cin >> choice;
        switch (choice)
        {
        case 1:
            int ele;
            cout << "\t\t\tEnter Element to be added: ";
            cin >> ele;
            array_vector.push_back(ele);

            break;

        case 2:
            cout << "\t\t\tVector Elements: ";
            if (array_vector.empty())
            {
                cout << "Vector is empty!";
            }
            else
            {
                for (int ele : array_vector)
                {
                    cout << ele << " ";
                }
            }
            cout << endl;
            break;

        case 3:
            int search;
            cout << "\t\t\tEnter element to search: ";
            cin >> search;
            for (int ele : array_vector)
            {
                if (ele = search)
                {
                    cout << "\t\t\t\tElement found!!!!" << endl;
                }
            }
            break;

        case 4:
            if (array_vector.empty())
            {
                cout << "\t\t\tVector is empty! Cannot sort.\n";
            }
            else
            {
                sort(array_vector.begin(), array_vector.end());
                cout << "\t\t\tArray sorted successfully!\n";
            }
            break;
        case 5:
            if (array_vector.empty())
            {
                cout << "\t\t\tVector is empty! Cannot reverse.\n";
            }
            else
            {
                reverse(array_vector.begin(), array_vector.end());
                cout << "\t\t\tArray reversed successfully!\n";
            }
            break;
        
            case 6:
              array_vector.clear();

        default:
            break;
        }

    } while (true);
}

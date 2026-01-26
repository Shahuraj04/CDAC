#include <iostream>
using namespace std;

int main()
{
    int choice;
    int arr[10];
    int ele, index = 0;
    double avg, sum, size;

    do
    {
        cout << "===========ARRAY OPERATIONS PROGRAM===========" << endl;
        cout << "1.Add number to array" << endl;
        cout << "2.Sum of array elements" << endl;
        cout << "3.Average of  array elements" << endl;
        cout << "4.Find maximus number" << endl;
        cout << "5.Find minimum number" << endl;
        cout << "6.Show Array" << endl;
        cout<<"7.Search element"<<endl;
        cout << "0.Exit" << endl;
        cout << "Enter Choice: ";
        cin >> choice;
        switch (choice)
        {
        case 1:
            cout << "\t\tEnter element: ";
            cin >> ele;
            arr[index] = ele;
            index++;

            break;

        case 2:
            for (int i = 0; i < index; i++)
            {
                sum = sum + arr[i];
            }
            cout << "sum is: " << sum << endl;
            break;

        case 3:
            sum = 0;
            size = 0;
            for (int i = 0; i < index; i++)
            {
                sum = sum + arr[i];
                size++;
            }
            avg = sum / size;
            cout << "avg is:" << avg << endl;
            break;

        case 4:
            if (index == 0)
            {
                cout << "Array is empty. Cannot find maximum." << endl;
            }
            else
            {
                int maxNum = arr[0];
                for (int i = 1; i < index; i++)
                {
                    if (arr[i] > maxNum)
                    {
                        maxNum = arr[i];
                    }
                }
                cout << "Maximum number in the array is: " << maxNum << endl;
            }
            break;

        case 5:
        {
            if (index == 0)
            {
                cout << "Array is empty. Cannot find maximum." << endl;
            }
            else
            {
                int minNum = arr[0];
                for (int i = 1; i < index; i++)
                {
                    if (arr[i] < minNum)
                    {
                        minNum = arr[i];
                    }
                }
                cout << "Maximum number in the array is: " << minNum << endl;
            }
            break;
        }

        case 6:
            cout << "\t\t\t";
            for (int i = 0; i < index; i++)
            {
                cout << "" << arr[i] << " ";
            }
            cout << endl;
        
        case 7:
            int search;
            cout<<"\t\t\t\tENter element to search: ";
            cin>>search;
            for(int i=0;i<index;i++){
                if(arr[i]==search){
                    cout<<"\t\t\t\tElement found at "<<i<<" position"<<endl;
                }
                else{
                    cout<<"Number not found"<<endl;
                }
            }

        case 0:
            cout << "Exiting program." << endl;
            return 0;  

        default:
            cout << "Invalid choice. Please select again." << endl;
            break;
        }
    } while (true);
}
#include <iostream>
#include <vector>

using namespace std;

class myExcption: exception{
    protected:string message;
    public: myExcption(const char* msg):message(msg){};

    const char* what() const noexcept override{
        return message.c_str();
    };
};

class Ticket
{
protected:
    int ticked_id;
    string passengerName;

public:
    Ticket() : ticked_id(0), passengerName("") {};
    Ticket(int id, string pname) : ticked_id(id), passengerName(pname) {};

    virtual void bookTicket()
    {
        cout << "Enter Ticket id: ";
        cin >> ticked_id;
        cout << "Enter Passenger name: ";
        cin >> passengerName;
    };
    virtual void showDetails()
    {
        cout << "Ticket Id: " << ticked_id << endl;
        cout << "Passenger name: " << passengerName << endl;
    }

    virtual ~Ticket() {};
};

class TrainTicket : public Ticket
{
protected:
    string type;

public:
    TrainTicket() : type("Sleeper") {};
    TrainTicket(int id, string pname, string cType) : Ticket(id, pname), type(cType) {};

    void showCoachType()
    {
        cout << "Your coach type: " << type << endl;
    }

    void bookTicket() override
    {
        Ticket::bookTicket();
        cout << "Enter coach type: ";
        cin >> type;
    };
    void showDetails() override
    {
        Ticket::showDetails();
        cout << "Your coach type: " << type << endl;
    };
};

class BusTicket : public Ticket
{
protected:
    int seatNo;

public:
    BusTicket() : seatNo(0) {};
    BusTicket(int id, string pname, int seat) : Ticket(id, pname), seatNo(seat) {};

    void bookTicket() override
    {
        Ticket::bookTicket();
        cout << "Enter Seat NO: ";
        cin >> seatNo;
    };
    void showDetails() override
    {
        Ticket::showDetails();
        cout << "Your seat No.: " << seatNo << endl;
    };
    void showSeatInfo()
    {
        cout << "Your seatNo: " << seatNo << endl;
    }
};

int main()
{
    vector<Ticket *> ticketVector;
    int choice;
    do
    {
        cout << "1.Book train ticket." << endl;
        cout << "2.Book Bus ticket." << endl;
        cout << "3.Show All tickets." << endl;
        cout << "0.Exit." << endl;
        cout << "\tEnter choice: " << endl;
        cin >> choice;

        try{switch (choice)
        {
        case 1:
        {
            if (ticketVector.size() >= 2)
                throw myExcption("Cannot book more than 40 tickets!");

            TrainTicket *t = new TrainTicket();
            t->bookTicket();
            ticketVector.push_back(t);
            break;
        }

        case 2:
        {
            if (ticketVector.size() >= 2)
                throw myExcption("Cannot book more than 40 tickets!");

            BusTicket *b = new BusTicket();
            b->bookTicket();
            ticketVector.push_back(b);
            break;
        }
        case 3:for(auto& t:ticketVector){
                t->showDetails();
                if (auto train = dynamic_cast<TrainTicket*>(t)) {
                        train->showCoachType();
                    } else if (auto bus = dynamic_cast<BusTicket*>(t)) {
                        bus->showSeatInfo();
                    }


        }
        break;
        case 0:cout<<"Exiting!!!"<<endl;
        break;

        default:
            break;
        }
    }
    catch(const myExcption & ex){
        cout << "Ticket Error: " << ex.what() << endl;
    }

    } while (choice!=0);
    return 0;
}
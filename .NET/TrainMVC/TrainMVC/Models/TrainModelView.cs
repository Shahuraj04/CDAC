using Microsoft.Data.SqlClient;
namespace TrainMVC.Models
{
    public class TrainModelView
    {
        string connectionString = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=EndModule;Integrated Security=True;";


        public List<Train> GetTrains()
        {

            List<Train> trains = new List<Train>();
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();

            string query = "select * from Train";
            SqlCommand command = new SqlCommand(query, connection);
            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                Train train = new Train();
                train.TrainId = Convert.ToInt32(reader["TrainId"]);
                train.TrainName = reader["TrainName"].ToString();
                train.Source = reader["Source"].ToString();
                train.Destination = reader["Destination"].ToString();
                train.DepartureTime = Convert.ToDateTime(reader["DepartureTime"]);

                // FIXED LINE
                train.ArrivalTime = reader["ArrivalTime"] == DBNull.Value
                    ? DateTime.MinValue
                    : Convert.ToDateTime(reader["ArrivalTime"]);

                train.AvailableSeats = Convert.ToInt32(reader["AvailableSeats"]);
                trains.Add(train);
            }

            connection.Close();
            return trains;

        }

        public Train GetTrain(int Id)
        {

            List<Train> trains = GetTrains();

            Train filteredTrain = (from train in trains
                                   where train.TrainId == Id
                                   select train).First();

            return filteredTrain;

        }

        public int AddTrain(Train train)
        {
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();

            string query = @"INSERT INTO Train
    (TrainName, Source, Destination, DepartureTime, ArrivalTime, AvailableSeats)
    VALUES
    (@TrainName, @Source, @Destination, @DepartureTime, @ArrivalTime, @AvailableSeats)";

            SqlCommand command = new SqlCommand(query, connection);

            command.Parameters.AddWithValue("@TrainName", train.TrainName);
            command.Parameters.AddWithValue("@Source", train.Source);
            command.Parameters.AddWithValue("@Destination", train.Destination);
            command.Parameters.AddWithValue("@DepartureTime", train.DepartureTime);
            command.Parameters.AddWithValue("@ArrivalTime", train.ArrivalTime);
            command.Parameters.AddWithValue("@AvailableSeats", train.AvailableSeats);

            int rowsAffected = command.ExecuteNonQuery();
            connection.Close();

            return rowsAffected;
        }

        public int UpdateTrain(Train train)
        {
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();

            string query = @"UPDATE Train SET
        TrainName = @TrainName,
        Source = @Source,
        Destination = @Destination,
        DepartureTime = @DepartureTime,
        ArrivalTime = @ArrivalTime,
        AvailableSeats = @AvailableSeats
        WHERE TrainId = @TrainId";

            SqlCommand command = new SqlCommand(query, connection);

            command.Parameters.AddWithValue("@TrainName", train.TrainName);
            command.Parameters.AddWithValue("@Source", train.Source);
            command.Parameters.AddWithValue("@Destination", train.Destination);
            command.Parameters.AddWithValue("@DepartureTime", train.DepartureTime);
            command.Parameters.AddWithValue("@ArrivalTime", train.ArrivalTime);
            command.Parameters.AddWithValue("@AvailableSeats", train.AvailableSeats);
            command.Parameters.AddWithValue("@TrainId", train.TrainId);

            int rowsAffected = command.ExecuteNonQuery();
            connection.Close();

            return rowsAffected;
        }


        public int DeleteTrain(int Id)
        {
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();
            string query = "delete from Train where TrainId=" + Id;
            SqlCommand command = new SqlCommand(query, connection);
            int rowsAffected = command.ExecuteNonQuery();
            connection.Close();
            return rowsAffected;



        }
    }
    }

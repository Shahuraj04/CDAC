using Microsoft.Data.SqlClient;
using System.Reflection.Metadata.Ecma335;

namespace EndModulePractice.Models
{
    public class AppointmentDAL
    {
        private string connectionString = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=EndModule;Integrated Security=True";

        public List<Appointment> GetAppointments() {
            List<Appointment> appointments = new List<Appointment>();
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();

            SqlCommand command = new SqlCommand("SELECT * FROM Appointments", connection);
            SqlDataReader reader = command.ExecuteReader();

            while (reader.Read()) {
                Appointment appointment = new Appointment();
                appointment.AppointmentId = Convert.ToInt32(reader["AppointmentId"]);
                appointment.PatientName = reader["PatientName"].ToString();
                appointment.DoctorName = reader["DoctorName"].ToString();
                appointment.AppointmentDate = Convert.ToDateTime(reader["AppointmentDate"]);
                appointment.Fees = Convert.ToDecimal(reader["Fees"]);
                appointment.Status = reader["Status"].ToString();
                appointments.Add(appointment);
            }
            return appointments;
        }

        public int AddAppointment(Appointment appointment) {

            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();

            string queryFormat = "INSERT INTO APPOINTMENTS(PatientName,DoctorName,AppointmentDate,Fees,Status) values('{0}','{1}','{2}',{3},'{4}') ";
            string query = string.Format(queryFormat, appointment.PatientName, appointment.DoctorName, appointment.AppointmentDate, appointment.Fees, appointment.Status);

            SqlCommand command = new SqlCommand(query, connection);

            int RowsAffected = command.ExecuteNonQuery();

            return RowsAffected; 

        }
    }
}

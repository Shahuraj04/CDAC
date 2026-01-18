using Microsoft.Data.SqlClient;
namespace MVCDemo.Models
{
    public class StudentViewModel
    {
        string connectionString = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=EndModule;Integrated Security=True";
        public List<Student> GetStudents()
        {

            List<Student> students = new List<Student>();
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();

            SqlCommand command = new SqlCommand("Select * from Student", connection);

            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {

                Student student = new Student();
                student.No = Convert.ToInt32(reader["No"]);
                student.Name = reader["Name"].ToString();
                student.Address = reader["Address"].ToString();
                student.Email = reader["Email"].ToString();
                student.Age = Convert.ToInt32(reader["Age"]);
                students.Add(student);
            }

            connection.Close();
            return students;
        }

        public Student GetStudent(int No)
        {

            List<Student> students = GetStudents();
            Student filteredStudent = (from student in students
                                       where student.No == No
                                       select student).First();
            return filteredStudent;
        }

        public int AddStudent(Student student)
        {
            SqlConnection sqlConnection = new SqlConnection(connectionString);
            sqlConnection.Open();

            string queryFormat = "insert into Student(Name,Address,Age,Email,IsEMailValidated) values('{0}','{1}',{2},'{3}','{4}')";

            string query = string.Format(queryFormat, student.Name, student.Address, student.Age, student.Email, false);

            SqlCommand command = new SqlCommand(query, sqlConnection);
            int rowsAffected = command.ExecuteNonQuery();
            sqlConnection.Close();
            return rowsAffected;

        }

        public int UpdateStudent(Student student)
        {
            SqlConnection sqlConnection = new SqlConnection(connectionString);
            sqlConnection.Open();

            string queryFormat = "update Student set Name='{0}',Address='{1}',Age={2},Email='{3}' where No= {4}";

            string query = string.Format(queryFormat, student.Name, student.Address, student.Age, student.Email, student.No);

            SqlCommand command = new SqlCommand(query, sqlConnection);
            int rowsAffected = command.ExecuteNonQuery();
            sqlConnection.Close();
            return rowsAffected;

        }

        public int DeleteStudent(int No)
        {
            SqlConnection sqlConnection = new SqlConnection(connectionString);
            sqlConnection.Open();

            string queryFormat = "Delete from Student where No = {0}";

            string query = string.Format(queryFormat, No);

            SqlCommand command = new SqlCommand(query, sqlConnection);
            int rowsAffected = command.ExecuteNonQuery();
            sqlConnection.Close();
            return rowsAffected;

        }

    }
}

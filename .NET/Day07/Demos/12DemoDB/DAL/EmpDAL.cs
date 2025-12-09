using _12DemoDB.Model;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;

namespace _12DemoDB.DAL
{
    public class EmpDAL
    {
        private readonly string _connectionString =
            "Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=master;Integrated Security=True;Connect Timeout=30;Encrypt=False;Trust Server Certificate=False;Application Intent=ReadWrite;Multi Subnet Failover=False";

        public List<Emp> GetEmps()
        {
            List<Emp> emps = new List<Emp>();

            using (SqlConnection connection = new SqlConnection(_connectionString))
            {
                string query = "SELECT * FROM Emp";
                SqlCommand cmd = new SqlCommand(query, connection);

                connection.Open();
                using (SqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Emp emp = new Emp()
                        {
                            No = Convert.ToInt32(reader["No"]),
                            Name = reader["Name"].ToString(),
                            Address = reader["Address"].ToString()
                        };
                        emps.Add(emp);
                    }
                }
            }

            return emps;
        }

        public int AddEmp(Emp emp)
        {
            using (SqlConnection connection = new SqlConnection(_connectionString))
            {
                string query = "INSERT INTO Emp (Name, Address) VALUES (@Name, @Address)";

                SqlCommand cmd = new SqlCommand(query, connection);
                cmd.Parameters.AddWithValue("@Name", emp.Name);
                cmd.Parameters.AddWithValue("@Address", emp.Address);

                connection.Open();
                return cmd.ExecuteNonQuery();
            }
        }
    }
}

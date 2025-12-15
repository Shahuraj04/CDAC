using Microsoft.Data.SqlClient;
namespace BookMVC.Models
{
    public class BookModelView
    {
        string connectionString = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=EndModule;Integrated Security=True";

        public List<Book> GetBooks()
        {

            List<Book> books = new List<Book>();
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();

            SqlCommand command = new SqlCommand("SELECT * FROM Book", connection);
            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                Book book = new Book();
                book.BookId = Convert.ToInt32(reader["BookId"]);
                book.Title = reader["Title"].ToString();
                book.Author = reader["Author"].ToString();
                book.Category = reader["Category"].ToString();
                book.Price = Convert.ToDecimal(reader["Price"]);
                book.Quantity = Convert.ToInt32(reader["Quantity"]);
                books.Add(book);


            }

            connection.Close();
            return books;

        }

        public Book GetBookById(int Id)
        {
            List<Book> books = GetBooks();
            Book filteredBook = (from book in books
                                 where book.BookId == Id
                                 select book).First();
            return filteredBook;

        }

        public int AddBook(Book book)
        {
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();
            string queryformat = "Insert into Book(Title,Author,Category,Price,Quantity,InStock) values('{0}','{1}','{2}',{3},{4},'{5}')";
            string query = string.Format(queryformat, book.Title, book.Author, book.Category, book.Price, book.Quantity, book.InStock);
            SqlCommand command = new SqlCommand(query, connection);
            int rowsAffected = command.ExecuteNonQuery();
            connection.Close();
            return rowsAffected;

        }

        public int UpdateBook(Book book)
        {
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();

            string queryformat = "Update Book set Title='{0}',Author='{1}',Category='{2}',Price={3},Quantity={4},InStock='{5}' where BookId={6}";
            string query = string.Format(queryformat, book.Title, book.Author, book.Category, book.Price, book.Quantity, book.InStock, book.BookId);
            SqlCommand command = new SqlCommand(query, connection);
            int rowsAffected = command.ExecuteNonQuery();
            connection.Close();
            return rowsAffected;


        }

        public int DeleteBook(int Id)
        {
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();
            string queryformat = "Delete from Book where BookId={0}";
            string query = string.Format(queryformat, Id);
            SqlCommand command = new SqlCommand(query, connection);
            int rowsAffected = command.ExecuteNonQuery();
            connection.Close();
            return rowsAffected;


        }
    }
}

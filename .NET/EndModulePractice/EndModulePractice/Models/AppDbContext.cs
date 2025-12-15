using Microsoft.EntityFrameworkCore;
namespace EndModulePractice.Models
{
    public class AppDbContext: DbContext
    {
        public DbSet<Appointment> Appointments { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=EndModule;Integrated Security=True");
        }
    }
}

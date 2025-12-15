using System.ComponentModel.DataAnnotations;

namespace BookMVC.Models
{
    public class Book
    {
        [Required(ErrorMessage ="BookId Required")]
        public int BookId { get; set; }

        [Required(ErrorMessage = "Title Required")]
        public string Title { get; set; }

        [Required(ErrorMessage = "Author name Required")]
        public string  Author{ get; set; }

        [Required(ErrorMessage = "Category Required")]
        public string Category { get; set; }

        [Required(ErrorMessage = "Price Required")]
        public decimal Price { get; set; }

        [Required(ErrorMessage = "Quantity Required")]
        public int Quantity { get; set; }

        public bool InStock 
        { 
            get 
            {
                return Quantity > 0; 
            }
        }
    }
}

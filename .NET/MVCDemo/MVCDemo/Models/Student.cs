using System.ComponentModel.DataAnnotations;

namespace MVCDemo.Models
{
    public class Student
    {
        [Required(ErrorMessage ="NO required")]
        public int No { get; set; }
        [Required(ErrorMessage = "Name Required")]
        public string  Name { get; set; }
        [Required(ErrorMessage = "Address required")]
        public string Address { get; set; }
        [Required(ErrorMessage = "Email Required ")]
        public string Email { get; set; }
        public bool IsEMailValidated { get; set; }
        [Required(ErrorMessage = "Age required")]
        [Range(20,40,ErrorMessage ="Age value is incorrect")]
        public int Age { get; set; }


    }
}

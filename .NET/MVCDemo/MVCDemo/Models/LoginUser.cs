using System.ComponentModel.DataAnnotations;

namespace MVCDemo.Models
{
    public class LoginUser
    {
        [Required(ErrorMessage = "User name can't be empty")]
        public string UserName { get; set; }
        [Required(ErrorMessage = "Password can't be empty")]
        public string Password { get; set; }
    }
}

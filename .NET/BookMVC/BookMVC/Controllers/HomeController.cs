using BookMVC.Models;
using Microsoft.AspNetCore.Mvc;


namespace BookMVC.Controllers
{
    public class HomeController : Controller
    {
        BookModelView bookModelView = new BookModelView();

        public IActionResult Index()
        {
            ViewBag.Title = "Home";
            ViewBag.UserName = GetUserName();

            List<Book> books = bookModelView.GetBooks();
            return View(books);
        }

        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Create(Book book)
        {
            if (ModelState.IsValid)
            {
                bookModelView.AddBook(book);
                return Redirect("/Home/Index");
            }
            else
            {
                ViewBag.Message = "Validation Failed";
                return View(book);
            }
        }

        private string GetUserName()
        {
            if (HttpContext.Session.GetString("UserName") != null &&
                HttpContext.Session.GetString("UserName") != "")
            {
                return HttpContext.Session.GetString("UserName");
            }
            return "Guest";
        }
    }
}

using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using MVCDemo.Filters;
using MVCDemo.Models;
namespace MVCDemo.Controllers
{
    [LogFilter]
    public class HomeController : Controller
    {
        StudentViewModel studentViewModel = new StudentViewModel(); 


        [AuthFilter]
        public IActionResult Index()
        {
            ViewBag.Title = "Home";
            ViewBag.UserName= GetUserName();
            List<Student> students = studentViewModel.GetStudents();    




            return View(students);
        }

        [AuthFilter]
        public IActionResult Create() {

            return View();
        }

       
        [HttpPost]
        public IActionResult Create(Student student) {

            if (ModelState.IsValid) {
                studentViewModel.AddStudent(student);
                return Redirect("/Home/Index");

            
            }
            else {
                ViewBag.Message = "Validation Failed";
                return View(student);
                }
        }


        [AuthFilter]
        public IActionResult Edit(int Id)
        {
            Student student = studentViewModel.GetStudent(Id);

            return View(student);
        }

        [AuthFilter]
        [HttpPost]
        public IActionResult Edit(Student updatedstudent)
        {

            if (ModelState.IsValid)
            {
                int rows = studentViewModel.UpdateStudent(updatedstudent);
                if (rows > 0)
                {
                    return Redirect("/Home/Index");
                }
                else {
                    ViewBag.Message = "FAiled to update record";
                    return View(updatedstudent);
                        }
                    return Redirect("/Home/Index");


            }
            else
            {
                ViewBag.Message = "Validation Failed";
                return View(updatedstudent);
            }
        }

        [AuthFilter]
        public IActionResult Delete(int Id)
        {
            studentViewModel.DeleteStudent(Id);
            return Redirect("/Home/Index");
        
        }

        public IActionResult About()
        {
            ViewBag.Title = "About";
            return View();
        }
        public IActionResult Contact()
        {
            ViewBag.Title = "Contact Us";
            return View();
        }

        private string GetUserName() {


            if (HttpContext.Session.GetString("UserName") != null && HttpContext.Session.GetString("UserName") != "") {

                return HttpContext.Session.GetString("UserName");
            }
            return "Guest";
        }
    }
}

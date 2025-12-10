using _001DemoMVC.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;
using _001DemoMVC.Filters;
namespace _001DemoMVC.Controllers
{

    public class HomeController : BaseController
    {
        EFDBContext dbObject = new EFDBContext();
        
        public IActionResult Index()
        {
            List<Emp> emps = dbObject.Emps.ToList();
            return View("Index", emps);
        }
        public IActionResult Create()
        {
            return View();
        }
        public IActionResult AfterCreate(Emp emp)
        {
            dbObject.Emps.Add(emp);
            dbObject.SaveChanges();
            return Redirect("/Home/Index");
        }
        public IActionResult Edit(int id)
        {
            Emp emp = dbObject.Emps.Find(id);
            return View("Edit", emp);
        }
        public IActionResult AfterEdit(Emp emp)
        {
            Emp empBeingUpdated = dbObject.Emps.Find(emp.no);
            empBeingUpdated.name = emp.name;
            empBeingUpdated.address = emp.address;

            dbObject.SaveChanges();

            return Redirect("/Home/Index");
        }
        public IActionResult Delete(int id)
        {
            var emp = dbObject.Emps.Find(id);

            dbObject.Emps.Remove(emp);
            dbObject.SaveChanges();

            return Redirect("/Home/Index");
        }
    }
}

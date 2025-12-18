using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using TrainMVC.Models;
using TrainMVC.Filter;


namespace TrainMVC.Controllers
{
    [LoggerFilter]
    public class HomeController : Controller
    {
        TrainModelView trainModelView = new TrainModelView();

        public IActionResult Index()
        {
            List<Train> trains = trainModelView.GetTrains();
            return View(trains);
        }




        public IActionResult Create() { 
        
            return View();
        }





        [HttpPost]
        public IActionResult Create(Train train) {

            if (ModelState.IsValid) {
                int rowsAffected = trainModelView.AddTrain(train);
                if (rowsAffected > 0)
                {
                    return Redirect("/Home/Index");
                }
                else
                {
                    return View();
                }
            }
            return View();

            

        }



        public IActionResult Edit(int Id) { 
            Train train = trainModelView.GetTrain(Id);
            return View(train);
        }



        [HttpPost]
        public IActionResult Edit(Train train) { 
            
          if (ModelState.IsValid)
            {
                int rowsAffected = trainModelView.UpdateTrain(train);
                if (rowsAffected > 0)
                {
                    return Redirect("/Home/Index");
                }
                else
                {
                    return View();
                }
            }
            return View();

        }
        
    }
}

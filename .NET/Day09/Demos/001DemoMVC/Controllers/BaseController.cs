using _001DemoMVC.Filters;
using Microsoft.AspNetCore.Mvc;

namespace _001DemoMVC.Controllers
{
    [IACSDFilter]
    public class BaseController : Controller
    {

    }
}

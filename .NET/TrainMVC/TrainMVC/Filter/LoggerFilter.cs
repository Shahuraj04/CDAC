using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;
using TrainMVC.Filter;
using TrainMVC.Logger;

namespace TrainMVC.Filter
{
    public class LoggerFilter : ActionFilterAttribute {
        public override void OnActionExecuting(ActionExecutingContext context)
        {
            FileLogger.CurrentLogger.log("Action Method " + context.ActionDescriptor.DisplayName + " executing at " + DateTime.Now.ToString());
        }

        public override void OnActionExecuted(ActionExecutedContext context)
        {
            FileLogger.CurrentLogger.log("Action Method " + context.ActionDescriptor.DisplayName + " executed at " + DateTime.Now.ToString());
        }


    }
    
}

using Microsoft.AspNetCore.Mvc.Filters;
using MVCDemo.Logger;
namespace MVCDemo.Filters
{
    public class LogFilter:ActionFilterAttribute
    {
        public override void OnActionExecuting(ActionExecutingContext context)
        {
            FileLogger.CurrentLogger.Log("Action Method " + context.HttpContext.Request.Path);

        }
        public override void OnActionExecuted(ActionExecutedContext context)
        {
            FileLogger.CurrentLogger.Log("Action Method executed " + context.HttpContext.Request.Path);
        }

    }
}

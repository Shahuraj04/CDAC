using Microsoft.AspNetCore.Mvc;
using MVCDemo.Logger; 
using MVCDemo.Models;

namespace MVCDemo.Controllers
{
    [ApiController]
    [Route("api/logs")]
    public class LogsController : ControllerBase
    {
       
        [HttpPost]
        public IActionResult ReceiveRemoteLog([FromBody] LogRequest request)
        {
            if (request == null || string.IsNullOrEmpty(request.Message))
            {
                return BadRequest("Log message cannot be empty.");
            }

            try
            {
                 
                FileLogger.CurrentLogger.Log(request.Message);

                
                return Ok(new { status = "Success", receivedAt = DateTime.Now });
            }
            catch (Exception ex)
            {
               
                return StatusCode(500, $"Internal Server Error: {ex.Message}");
            }
        }
    }
}
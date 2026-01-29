using Microsoft.AspNetCore.Mvc;
using MVCDemo.Logger; // Ensure this matches your FileLogger namespace
using MVCDemo.Models;

namespace MVCDemo.Controllers
{
    [ApiController]
    [Route("api/logs")]
    public class LogsController : ControllerBase
    {
        // POST: api/logs
        [HttpPost]
        public IActionResult ReceiveRemoteLog([FromBody] LogRequest request)
        {
            if (request == null || string.IsNullOrEmpty(request.Message))
            {
                return BadRequest("Log message cannot be empty.");
            }

            try
            {
                // Calling your existing Singleton FileLogger
                FileLogger.CurrentLogger.Log(request.Message);

                // Return a success status to Spring Boot
                return Ok(new { status = "Success", receivedAt = DateTime.Now });
            }
            catch (Exception ex)
            {
                // If writing to the D: drive fails, return a 500 error
                return StatusCode(500, $"Internal Server Error: {ex.Message}");
            }
        }
    }
}
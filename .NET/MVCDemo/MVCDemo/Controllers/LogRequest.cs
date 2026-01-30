namespace MVCDemo.Models
{
    public class LogRequest
    {
        // This matches the "message" key in the Spring Boot Map.of("message", ...)
        public string Message { get; set; }
    }
}
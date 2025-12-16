using System.ComponentModel.DataAnnotations;

namespace TrainMVC.Models
{
    public class Train
    {
        [Required(ErrorMessage ="TrainID cant be null")]
        public int  TrainId{ get; set; }

        [Required(ErrorMessage = "Train Name cant be null")]

        public string TrainName { get; set; }
        [Required(ErrorMessage = "Source cant be null")]

        public string Source{ get; set; }
        [Required(ErrorMessage = "Destination cant be null")]

        public string Destination { get; set; }

        [Required(ErrorMessage = "DeptTime  cant be null")]

        public DateTime DepartureTime { get; set; }

        [Required(ErrorMessage = "ArrivalTime cant be null")]

        public DateTime ArrivalTime { get; set; }

        public int AvailableSeats{ get; set; }


    }
}

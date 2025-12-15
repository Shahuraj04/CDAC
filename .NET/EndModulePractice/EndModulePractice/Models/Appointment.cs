using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace EndModulePractice.Models
{
    [Table("Appointments")]
    public class Appointment
    {
        [Key]
        public int AppointmentId { get; set; }

        [Required]
        [MaxLength(100)]
        [Column("PatientName", TypeName = "nvarchar(100)")]
        public string PatientName { get; set; }

        [Required]
        [MaxLength(100)]
        [Column("DoctorName", TypeName = "nvarchar(100)")]
        public string DoctorName { get; set; }

        [Required]
        [Column("AppointmentDate", TypeName = "datetime")]
        public DateTime AppointmentDate { get; set; }

        [Range(1, double.MaxValue)]
        [Column("Fees", TypeName = "decimal(18,2)")]
        public decimal Fees { get; set; }

        [Required]
        [Column("Status", TypeName = "nvarchar(20)")]
        public string Status { get; set; }
    }
}

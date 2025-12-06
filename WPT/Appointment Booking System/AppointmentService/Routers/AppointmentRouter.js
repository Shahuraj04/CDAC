const express = require("express")
const router = express.Router();
const controller  = require("../Controller/AppointmentController")

router.post("/addappoinntment",controller.createAppointment);
router.put("/edit/:id",controller.editAppointment);
router.delete("/delete/:id",controller.deleteAppointment);
router.get("/getall",controller.showall)


module.exports=router;
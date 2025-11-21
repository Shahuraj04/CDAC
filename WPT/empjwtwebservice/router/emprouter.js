const express  = require("express")
const router = express.Router()
const empcontroller = require("../controller/empcontroller")
const {authenticateToken} = require("../middleware/jwtInfo") 

{/*authenticateToken*/}
router.get("/employee",empcontroller.getAllEmployees)

router.get("/employee/:id",empcontroller.getEmpbyId)

router.post("/employee/addemp",empcontroller.addEmployee)

router.put("/employee/:id",empcontroller.updateEmp)

router.delete("/employee/:id",empcontroller.deleteByid)

module.exports=router;
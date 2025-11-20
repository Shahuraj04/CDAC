const express  = require("express")
const router = express.Router()
const empcontroller = require("../controller/empcontroller")
const {authenticateToken} = require("../middleware/jwtInfo") 

router.get("/employee",authenticateToken,empcontroller.getAllEmployees)

router.get("/employee/:id",authenticateToken,empcontroller.getEmpbyId)

router.post("/employee/addemp",authenticateToken,empcontroller.addEmployee)

router.put("/employee/:id",authenticateToken,empcontroller.updateEmp)

router.delete("/employee/:id",authenticateToken,empcontroller.deleteByid)

module.exports=router;
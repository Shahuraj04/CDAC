const express = require("express")
const router = express.Router();
const loginc = require("../controller/logincontroller")

router.post("/loginemp",loginc.validateuser)
module.exports=router;
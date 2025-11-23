const express = require('express')
const router   = express.Router();
const loginC = require('../controller/loginController')

router.post("/loginadmin",loginC.validateUser);

module.exports=router;
const express = require("express")
const router = express.Router();
const trainController = require("../controller/trainController")

router.post("/addtrain",trainController.addtrain)
router.get("/showtrains",trainController.showtrains)
router.put("/updatetrain/:train_number",trainController.update)
router.delete("/deletetrain/:train_number",trainController.deleteTrain)

module.exports=router;
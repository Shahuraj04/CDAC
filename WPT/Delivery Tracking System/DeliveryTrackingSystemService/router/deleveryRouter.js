const express = require("express")
const router = express.Router();

const deleveryController = require("../controller/DeliveryController")

router.post("/deliveries",deleveryController.addnewDelivery);
router.get("/showall",deleveryController.showAllDeliveries);

module.exports=router;

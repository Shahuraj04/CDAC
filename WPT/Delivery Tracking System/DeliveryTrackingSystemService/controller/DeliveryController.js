const express = require("express")
const connection = require("../Dbconfig/DBconfig")

exports.addnewDelivery = (req, resp) => {

    const { customerName, address, phone, status } = req.body;

    connection.query("Insert into deliveries(customerName, address, phone, status) values(?,?,?,?)", [customerName, address, phone, status], (err, result, fieds) => {
        if (err) {

            console.log(err);
            resp.status(500).json({ message: "err" + err })

        }
        else {
            resp.json({ message: "Delivery added", data: result })
        }
    })
}

exports.showAllDeliveries=(req,resp)=>{

    connection.query("select * from deliveries",(err,result,field)=>{
        if(err){
            resp.status(500).json({message:err})
        }
        else{
            console.log("Data:"+result)
            resp.json({data:result})
        }

    })

}


const express = require("express")
const connection = require("../DBconfig/DBconnection")

exports.showtrains = (req, resp) => {

    connection.query("select * from trains", (err, result, field) => {
        if (err) {
            resp.status(404).json({ message: "error occured" + JSON.stringify(err) });

        }
        else {
            console.log(result);
            resp.json({ data: result })
        }

    })

}
exports.addtrain = (req, resp) => {

    const { train_name, train_number, source, destination } = req.body;

    connection.query("insert into trains (train_name,train_number,source,destination) values(?,?,?,?)", [train_name, train_number, source, destination], (err, result, fields) => {
        if (err) {
            console.log(err)
            resp.status(500).JSON({ message: "error" + err })
        }
        else {
            resp.json({ message: "train added", data: result });

        }
    })
}

exports.update=(req,resp)=>{
    const {train_name,source, destination } = req.body;

    connection.query("update trains set train_name=?,source=?,destination=?  where train_number=?",[train_name,source,destination,req.params.train_number],(err,result,field)=>{
        if(err){
            console.log(err)
            resp.status(500).JSON({"message":"err: "+err})
        }
        else{
            console.log(req.params.train_number)
            resp.status(200).json({
                message: "Train with train_number " + req.params.train_number + " updated successfully"
            });
        }


    })

}

exports.deleteTrain=(req,resp)=>{

    connection.query("delete from trains where train_number=?",[req.params.train_number],(err,result,fields)=>{

        if(err){
        resp.status(500).json({"message":"error:" + err})

        }
        else{
            resp.status(200).json({message:"train deleted with id: "+req.params.train_number})
        }

    })

}

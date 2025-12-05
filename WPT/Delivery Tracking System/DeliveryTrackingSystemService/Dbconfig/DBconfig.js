const mysql = require("mysql2")

const db = mysql.createConnection({

    host:'localhost',
    user:'root',
    password:'root123',
    database:"deliverydb"

})

db.connect((err)=>{

    if(err){
        console.log("error: "+err)
    }
    console.log("Connection done")

})

module.exports= db;
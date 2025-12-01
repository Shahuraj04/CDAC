const mysql = require("mysql2")

const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'root123',
    database: 'trainDB'


})

db.connect((err)=>{
    if(err){
        console.log(err)
    }
    else{
        console.log("Connection done")
    }

})

module.exports = db;
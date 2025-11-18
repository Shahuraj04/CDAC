const mysql=require('mysql2')


//created a connection configuration
const db=mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'root123',
    database:"express_emp"
})

db.connect((err)=>{
    if(err){
        console.log(err);
    }else{
        console.log("connection done")
    }
})

module.exports=db;
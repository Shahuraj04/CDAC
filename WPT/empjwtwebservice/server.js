const express = require('express')
const app = express()
const bodyParser=require('body-parser')
const loginrouter  = require("./router/loginrouter")



app.use(bodyParser.json())

app.use("/login",loginrouter)

app.listen(7777,()=>{

    console.log("connection on 7777 port")
})
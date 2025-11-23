const express = require('express')
const app = express();
const bodyParser = require('body-parser')
const cors = require('cors')
const loginrouter  = require("./router/loginRouter") 

app.use(cors())
app.use(bodyParser.json())

app.use("/",loginrouter)

app.listen(3435,()=>{

    console.log("connection on 3435 port")
})  
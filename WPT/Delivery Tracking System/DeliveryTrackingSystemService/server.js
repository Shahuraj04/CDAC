const express = require("express")
const app = express()
const bodyparser= require("body-parser")
const cors  = require("cors")
const deliverieRouter= require("./router/deleveryRouter")

app.use(cors())

app.use(bodyparser.json())

app.use("/delivery",deliverieRouter)

app.listen(5151,()=>{
    console.log("connection on 5151")
})
const express= require("express")
const app = express()
const bodyParser = require("body-parser")
const cors = require("cors")

const trainRouter= require("./Router/trainRouter")


app.use(cors());

app.use(bodyParser.json())

app.use("/train",trainRouter)

app.listen(3435,()=>{
        console.log("connection on 3435 port")
})
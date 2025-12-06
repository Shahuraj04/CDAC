const express  = require("express")
const app = express();
const bodyparser = require("body-parser")

const cors = require("cors")

const router = require("./Routers/AppointmentRouter")

app.use(cors())
app.use(bodyparser.json())
app.use("/appointments",router)



app.listen(5000,()=>{
    console.log("Connection done on 5000")
})
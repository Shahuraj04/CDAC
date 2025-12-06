const connection = require("../DBconfig/Dbconfig")

exports.createAppointment = (req, resp) => {

    const { clientname, date, time, purpose } = req.body;
    connection.query("insert into appointments(clientname,date,time,purpose) values(?,?,?,?)", [clientname, date, time, purpose], (err, result, fields) => {
        if (err) {
            console.log(err);
            resp.status(500).json({ message: err })
        }
        else {
            resp.status(200).json({ message: "Appointment Added", data: result })
        }
    })


}

exports.editAppointment = (req, resp) => {

    const { clientname, date, time, purpose } = req.body;



    connection.query("update appointments set clientname=?,date=?,time=?,purpose=? where id=?", [clientname, date, time, purpose, req.params.id], (err, result, fields) => {
        if (err) {
            resp.status(500).json({ message: err })
        }
        else {
            resp.status(200).json({ data: result, message: "Updated" })
        }


    })

}

exports.deleteAppointment = (req, resp) => {

    connection.query("delete from appointments where id=?", [req.params.id], (err, result, fields) => {

        if (err) {
            resp.status(500).json({ message: err })
        }
        else {
            resp.status(200).json({ message: "Appoitment deleted with id" + req.params.id })
        }

    })

}

exports.showall = (req, resp) => {

    connection.query("select * from appointments", (err, result, fields) => {
        if (err) {
            resp.status(500).json({ error: err })
        }
        else {
            resp.status(200).json({ data: result })
        }

    })


}
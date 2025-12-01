const connection = require("../databaseconfig/databaseconfig")

exports.getAllEmployees = (req, resp) => {

    connection.query("select * from emp_data", (err, result, field) => {
        if (err) {
            resp.status(404).json({ message: "error occured" + JSON.stringify(err) });

        }
        else {
            console.log(result);
            resp.json({ data: result })
        }
    })

}

exports.getEmpbyId = (req, resp) => {
    connection.query("select * from emp_data where empId=?", [req.params.id], (err, result, fields) => {
        if (err) {
            resp.status(500).json({ message: "emp not found" })
        }
        else {
            console.log(result);
            resp.json({ data: result[0] })
        }

    })

}

exports.addEmployee = (req, resp) => {
    const { empname, email, password, role } = req.body;

    connection.query(
        "INSERT INTO emp_data (empname, email, password, role) VALUES (?, ?, ?, ?)",
        [empname, email, password, role],
        (err, result, field) => {

            if (err) {
                console.log(err);
                resp.status(500).json({ message: "error " + err });
            } else {
                    resp.json({ message: "Employee added", data: result });
            }

        }
    );
}

exports.updateEmp = (req, resp) => {

    const { empname, email, password, role } = req.body;
    connection.query("update emp_data set empname=?,email=?,password=?,role=? where empId=?", [empname, email, password, role, req.params.id], (err, result, fields) => {
        if (err) {
            resp.status(500).json({ message: err })
        }
        else {

            console.log(req.body)
            resp.json({ data: result })
        }

    })
}

exports.deleteByid=(req,resp)=>{
    connection.query("delete from emp_data where empId=?",[req.params.id],(err,result,fields)=>{
        if(err){
            resp.status(500).json({message:err})
        }else{
            resp.json({data:result})
        }

    })

}



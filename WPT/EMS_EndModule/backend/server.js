const express = require("express");
const cors = require("cors");
const mysql = require("mysql2");

const app = express();
app.use(cors());
app.use(express.json());

// Root route (Fix 403 Error)
app.get("/", (req, res) => {
    res.send("Server is running...");
});

// DB Connection
const db = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "root123",
    database: "employee_db"
});

// Add employee
app.post("/add", (req, res) => {
    const { emp_name, emp_id, joining_date, designation } = req.body;

    const sql = "INSERT INTO employees (emp_name, emp_id, joining_date, designation) VALUES (?, ?, ?, ?)";
    db.query(sql, [emp_name, emp_id, joining_date, designation], (err, result) => {
        if (err) return res.json({ error: err });
        res.json({ message: "Employee Added!" });
    });
});

// Get employees
app.get("/employees", (req, res) => {
    db.query("SELECT * FROM employees", (err, result) => {
        if (err) return res.json({ error: err });
        res.json(result);
    });
});

// Delete employee
app.delete("/delete/:id", (req, res) => {
    db.query("DELETE FROM employees WHERE id=?", [req.params.id], (err, result) => {
        if (err) return res.json({ error: err });
        res.json({ message: "Deleted!" });
    });
});

// Server
app.listen(5001, () => console.log("Backend running on port 5001"));

import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import EmpService from "../service/EmpService"
 
export default function EmployeeAddForm() {

    const navigate = useNavigate();
    const [form, setForm] = useState({ empId: "", empname: "", email: "", password: "", role: "" });

    const handleChange = (event) => {
        var { name, value } = event.target;
        setForm({ ...form, [name]: value });
    };

    const addEmployee = (e) => {
        e.preventDefault();
        EmpService.addEmployee(form).then((result)=>{
            navigate("/emptable")
        }).catch((err)=>{
            console.log(err)
        })


        console.log("Form Submitted:", form);

    };

    return (
        <div className="container mt-4">
            <h3 className="text-center mb-4">Add Employee</h3>

            <form className="card p-4 shadow" onSubmit={addEmployee}>

                <div className="mb-3">
                    <label className="form-label">Employee ID</label>
                    <input type="number" className="form-control" name="empId" value={form.empId} onChange={handleChange} placeholder="Enter Employee ID"
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label">Employee Name</label>
                    <input type="text" className="form-control" name="empname" value={form.empName} onChange={handleChange} placeholder="Enter Employee Name"
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label">Email</label>
                    <input type="email" className="form-control" name="email" value={form.email} onChange={handleChange} placeholder="Enter Email"
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label">Password</label>
                    <input type="password" className="form-control" name="password" value={form.password} onChange={handleChange} placeholder="Enter Password"
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label">Role</label>
                    <select
                        className="form-select"
                        name="role"
                        value={form.role}
                        onChange={handleChange}
                    > <option value="">Select Role</option> <option value="ADMIN">ADMIN</option> <option value="MANAGER">MANAGER</option> <option value="EMPLOYEE">EMPLOYEE</option>
                    </select>
                </div>

                <button type="submit" className="btn btn-primary w-100">
                    Add Employee
                </button>
            </form>
        </div>
    );
}

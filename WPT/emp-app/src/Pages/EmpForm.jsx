import React, { useState } from "react";

export default function EmployeeAddForm() {

    const [form, setForm] = useState({
        empId: "",
        empName: "",
        email: "",
        password: "",
        role: ""
    });

    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("Form Submitted:", form);

        // API call example:
        // axios.post("http://localhost:8080/employee/add", form)
    };

    return (
        <div className="container mt-4">
            <h3 className="text-center mb-4">Add Employee</h3>

            <form className="card p-4 shadow" onSubmit={handleSubmit}>

                <div className="mb-3">
                    <label className="form-label">Employee ID</label>
                    <input
                        type="number"
                        className="form-control"
                        name="empId"
                        value={form.empId}
                        onChange={handleChange}
                        placeholder="Enter Employee ID"
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label">Employee Name</label>
                    <input
                        type="text"
                        className="form-control"
                        name="empName"
                        value={form.empName}
                        onChange={handleChange}
                        placeholder="Enter Employee Name"
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label">Email</label>
                    <input
                        type="email"
                        className="form-control"
                        name="email"
                        value={form.email}
                        onChange={handleChange}
                        placeholder="Enter Email"
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label">Password</label>
                    <input
                        type="password"
                        className="form-control"
                        name="password"
                        value={form.password}
                        onChange={handleChange}
                        placeholder="Enter Password"
                    />
                </div>

                <div className="mb-3">
                    <label className="form-label">Role</label>
                    <select
                        className="form-select"
                        name="role"
                        value={form.role}
                        onChange={handleChange}
                    >
                        <option value="">Select Role</option>
                        <option value="ADMIN">ADMIN</option>
                        <option value="MANAGER">MANAGER</option>
                        <option value="EMPLOYEE">EMPLOYEE</option>
                    </select>
                </div>

                <button type="submit" className="btn btn-primary w-100">
                    Add Employee
                </button>
            </form>
        </div>
    );
}

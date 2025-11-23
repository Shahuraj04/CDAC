import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import EmpService from "../service/EmpService";

export default function EditForm() {
  const navigate = useNavigate();
  const location = useLocation();

  const [formData, setFormData] = useState(null);

  useEffect(() => {
    console.log("Location state:", location.state);

    if (location.state && location.state.empData) {
      setFormData(location.state.empData);
    }
  }, []);

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const updateEmployee = async (e) => {
    e.preventDefault();
    await EmpService.updateEmp(formData);
    navigate("/emptable");
  };

  if (!formData) return <h3 className="text-center mt-5">Loading...</h3>;

  return (
    <div className="container mt-4">
      <div className="card shadow p-4">
        <h3 className="text-center mb-4">Edit Employee</h3>

        <form onSubmit={updateEmployee}>

          <div className="mb-3">
            <label className="form-label">Employee Name</label>
            <input
              type="text"
              className="form-control"
              name="empname"
              value={formData.empname}
              onChange={handleChange}
            />
          </div>


          <div className="mb-3">
            <label className="form-label">Email</label>
            <input
              type="email"
              className="form-control"
              name="email"
              value={formData.email}
              onChange={handleChange}
            />
          </div>

          <div className="mb-3">
            <label className="form-label">Password</label>
            <input
              type="password"
              className="form-control"
              name="password"
              value={formData.password}
              onChange={handleChange}
            />
          </div>


          <div className="mb-3">
            <label className="form-label">Role</label>
            <select
              className="form-select"
              name="role"
              value={formData.role}
              onChange={handleChange}
            >
              <option value="">Select Role</option>
              <option value="ADMIN">ADMIN</option>
              <option value="MANAGER">MANAGER</option>
              <option value="EMPLOYEE">EMPLOYEE</option>
            </select>
          </div>


          <div className="d-flex justify-content-between">
            <button
              type="button"
              className="btn btn-secondary"
              onClick={() => navigate("/emptable")}
            >
              Back
            </button>

            <button type="submit" className="btn btn-success">
              Update Employee
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

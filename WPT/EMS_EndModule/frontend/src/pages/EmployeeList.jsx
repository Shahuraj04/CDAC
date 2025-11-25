import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api";

export default function EmployeeList() {
    const [list, setList] = useState([]);
    const navigate = useNavigate();

    const loadData = async () => {
        try {
            const res = await api.get("/employees");
            setList(res.data);
        } catch (error) {
            console.log(error);
        }
    };

    const deleteEmp = async (id) => {
        try {
            await api.delete(`/delete/${id}`);
            loadData();
        } catch (error) {
            console.log(error);
        }
    };

    useEffect(() => {
        loadData();
    }, []);

    return (
        <div className="mt-4 container">
            <div className="d-flex justify-content-between align-items-center">
                <h3>Employee List</h3>

                {/* Add Employee Button */}
                <button
                    className="btn btn-primary"
                    onClick={() => navigate("/")}
                >
                    Add Employee
                </button>
            </div>

            <table className="table table-bordered mt-3">
                <thead className="table-dark">
                    <tr>
                        <th>Name</th>
                        <th>Emp ID</th>
                        <th>Joining Date</th>
                        <th>Designation</th>
                        <th>Delete</th>
                    </tr>
                </thead>

                <tbody>
                    {list.map((e) => (
                        <tr key={e.id}>
                            <td>{e.emp_name}</td>
                            <td>{e.emp_id}</td>
                            <td>{e.joining_date}</td>
                            <td>{e.designation}</td>
                            <td>
                                <button
                                    className="btn btn-danger btn-sm"
                                    onClick={() => deleteEmp(e.id)}
                                >
                                    Delete
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

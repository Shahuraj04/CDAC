import React, { useEffect, useState } from 'react'
import EmpService from "../service/EmpService"
import { Link, useNavigate } from 'react-router-dom';


export default function EmployeeTable() {
    const navigate = useNavigate();
    const [earr, setearr] = useState([]);

    useEffect(() => {
        fetchdata()
    }, [])

    const fetchdata = async () => {
        var result = await EmpService.getAllEmployees();
        console.log(result.data.data)
        setearr(result.data.data)
    }

    const deleteEmployee = async (id) => {
        
        await EmpService.deleteEmp(id);
        fetchdata(); // refresh table
    }

    return (
        <div>
            <Link to="/form">
                <button type="button" className="btn btn-primary" name="add" id="add">Add new Employee</button>
            </Link>
            <br /><br />
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">EmpID</th>
                        <th scope="col">EmpName</th>
                        <th scope="col">Email</th>
                        <th scope="col">password</th>
                        <th scope="col">role</th>
                        <th>action</th>

                    </tr>
                </thead>
                <tbody>
                    {earr.map(emp => <tr key={emp.empId}>
                        <th scope='row'>{emp.empId}</th>
                        <td>{emp.empname}</td>
                        <td>{emp.email}</td>
                        <td>{emp.password}</td>
                        <td>{emp.role}</td>
                        <td>
                            <Link to={`/edit/${emp.empId}`} state={{ empData: emp }}>
                                <button type='button' name='edit' className='btn btn-info'>Edit</button>&nbsp;&nbsp;
                            </Link>
                            
                                <button type='button' name='delete' className='btn btn-danger' onClick={()=>deleteEmployee(emp.empId)}>Delete</button>
                        </td>

                    </tr>)
                    }

                </tbody>
            </table>
        </div>
    )
}

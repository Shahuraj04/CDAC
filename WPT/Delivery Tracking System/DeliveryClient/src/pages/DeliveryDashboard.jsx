import React, { useEffect, useState } from 'react'
import DeliveryService from "../service/DeliveryService"
import { Link, Navigate } from 'react-router-dom';

export default function DeliveryDashboard() {

    const [deliveryarr, setArr] = useState([]);

    useEffect(() => {
        fetchdata();
    }, []);

    const fetchdata = async () => {
        const result = await DeliveryService.getAllDeliveries();
        console.log("API Result:", result.data);
        setArr(result.data.data);
    };

    return (
        <div>
            <Link to="/newdelivery">
                <button type='button' className="btn btn-primary" >Add new Delivery</button>
            </Link>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Customer</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>Status</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {deliveryarr.map((d, index) =>  (<tr key={index}>
                        <td>{d.id}</td>
                        <td>{d.customerName}</td>
                        <td>{d.address}</td>
                        <td>{d.phone}</td>
                        <td>{d.status}</td>
                        <td >
                            <Link to={`/edit/${d.id}`} state={{ deliveryarr: d }}>
                                <button>Edit</button>
                            </Link>

                        </td>

                    </tr>))}

                </tbody>
            </table>
        </div>
    );
}

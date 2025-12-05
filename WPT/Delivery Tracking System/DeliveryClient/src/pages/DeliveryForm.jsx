import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import DeliveryService from '../service/DeliveryService';

export default function DeliveryForm() {

    const navigate = useNavigate();
    const [formdata, setForm] = useState({ customerName: " ", address: " ", phone: " ", status: " " });

    const handleChange = (event) => {
        var { name, value } = event.target;
        setForm({ ...formdata, [name]: value })

    }

    const addDelivery = (e) => {
        e.preventDefault();
        DeliveryService.addnewDelivery(formdata).then((result) => {
            navigate("/deliveries")

        }).catch((err) => {
            console.log("err" + err)
        })
    }


    return (
        <div>
            <form onSubmit={addDelivery}>
                <div className="form-group">
                    <label>Customer Name</label>
                    <input
                        type="text"
                        className="form-control"
                        name="customerName"
                        value={formdata.customerName}
                        onChange={handleChange}
                    />
                </div>

                <div className="form-group">
                    <label>Address</label>
                    <input
                        type="text"
                        className="form-control"
                        name="address"
                        value={formdata.address}
                        onChange={handleChange}
                    />
                </div>

                <div className="form-group">
                    <label>Phone</label>
                    <input
                        type="text"
                        className="form-control"
                        name="phone"
                        value={formdata.phone}
                        onChange={handleChange}
                    />
                </div>

                <div className="form-group">
                    <label>Status</label>
                    <input
                        type="text"
                        className="form-control"
                        name="status"
                        value={formdata.status}
                        onChange={handleChange}
                    />
                </div>

                <button type="submit" className="btn btn-primary w-100">
                    Add Delivery
                </button>
            </form>


        </div>
    )
}

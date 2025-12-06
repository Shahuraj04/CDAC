import React, { useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import Appointment from '../Service/Appointment';

export default function EditForm() {

    const navigate = useNavigate();
    const { id } = useParams();

    const [editArr, setArr] = useState({
        clientname: "",
        date: "",
        time: "",
        purpose: ""
    });

    const handleChange = (e) => {
        setArr({
            ...editArr,
            [e.target.name]: e.target.value
        });
    };

    const update = async (e) => {
        e.preventDefault();

        // ------------------ VALIDATION ------------------

        // 1️⃣ Name cannot be empty
        if (!editArr.clientname.trim()) {
            alert("Client name cannot be empty");
            return;
        }

        // 2️⃣ Name should contain only letters
        if (!/^[A-Za-z ]+$/.test(editArr.clientname)) {
            alert("Client name must contain only letters");
            return;
        }

        // 3️⃣ Date cannot be empty
        if (!editArr.date) {
            alert("Date is required");
            return;
        }

        // 4️⃣ Time cannot be empty
        if (!editArr.time) {
            alert("Time is required");
            return;
        }

        // 5️⃣ Purpose cannot be empty
        if (!editArr.purpose.trim()) {
            alert("Purpose cannot be empty");
            return;
        }

        // --------------------------------------------------

        Appointment.updateAppointment(id, editArr)
            .then(() => navigate('/'))
            .catch(err => console.log(err));
    };

    return (
        <div>
            <input
                type="text"
                name="clientname"
                placeholder="clientname"
                value={editArr.clientname}
                onChange={handleChange}
            />
            <br />

            <input
                type="date"
                name="date"
                value={editArr.date}
                onChange={handleChange}
            />
            <br />

            <input
                type="time"
                name="time"
                value={editArr.time}
                onChange={handleChange}
            />
            <br />

            <input
                type="text"
                name="purpose"
                placeholder="purpose"
                value={editArr.purpose}
                onChange={handleChange}
            />
            <br />

            <button onClick={update}>Update</button>
        </div>
    );
}

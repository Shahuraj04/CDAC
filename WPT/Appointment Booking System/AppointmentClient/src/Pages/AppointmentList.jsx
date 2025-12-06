import React, { useEffect, useState } from 'react'
import Appointment from '../Service/Appointment';
import { Link } from 'react-router-dom';

export default function AppointmentList() {

    const [apptArr, setArr] = useState([]);

    useEffect(() => {
        fetchData();
    }, []);

    const fetchData = async () => {
        try {
            const result = await Appointment.getAllAppointments();
            console.log(result);
            setArr(result.data.data);
        } catch (err) {
            console.error("Error loading appointments", err);
        }
    };

const deleteAppointment=async(id)=>{
    await Appointment.deleteAppointment(id);
    fetchData();


}


    return (
        <div>
            <Link to="/addnew"><button>Add new Appointment</button></Link>

            {(
                apptArr.map(appt => (
                    <div key={appt.id}>
                        <p><b>Name:</b> {appt.clientname}</p>
                        <p><b>Date:</b> {appt.date}</p>
                        <p><b>Time:</b> {appt.time}</p>
                        <p><b>Purpose:</b> {appt.purpose}</p>
                        <Link to={`/edit/${appt.id}`}>
                            <button>edit</button>
                        </Link>

                        <button onClick={()=>deleteAppointment(appt.id)}>delete</button>

                        <hr />
                    </div>
                ))
            )}
        </div>
    );
}

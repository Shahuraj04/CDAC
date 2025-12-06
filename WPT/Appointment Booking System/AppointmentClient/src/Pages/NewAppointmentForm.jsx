import React, { useEffect, useState } from 'react'
import Appointment from '../Service/Appointment';
import { useNavigate } from 'react-router-dom';

export default function NewAppointmentForm() {

    const navigate = useNavigate();
    const [formdata,setForm] = useState({clientname:"", date:"", time:"", purpose:""})

    const handleChange=(event)=>{
        var{name,value}=event.target;
        setForm({...formdata,[name]:value})
    }

    const addAppointment=(e)=>{
        e.preventDefault();
        Appointment.addnewAppointment(formdata).then((result)=>{
            navigate("/")
        }).catch((err)=>{
            console.log(err)
        })
    }

  return (

    <div>
        <input type="text" placeholder='Client Name' name='clientname' value={formdata.clientname} onChange={handleChange}/>
        <br />
        <input type="date" placeholder='Client Name' name='date' value={formdata.date} onChange={handleChange}/>
        <br />
        <input type="time" placeholder='Client Name'name='time' value={formdata.time}onChange={handleChange}/>
        <br />
        <input type="text" placeholder='Purpose' name='purpose' value={formdata.purpose} onChange={handleChange}/>
        <br />
        <button onClick={addAppointment}>Add Appointment</button>


    </div>
  )
}

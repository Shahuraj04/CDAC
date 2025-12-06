import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Router,Route, Routes  } from 'react-router-dom'
import AppointmentList from './Pages/AppointmentList'
import NewAppointmentForm from './Pages/NewAppointmentForm'
import EditForm from './Pages/EditForm'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Routes>
        <Route path='/' element={<AppointmentList/>}></Route>
        <Route path='/addnew' element={<NewAppointmentForm/>}></Route>
        <Route path="/edit/:id" element={<EditForm/>}></Route>
      </Routes>
    </>
  )
}

export default App

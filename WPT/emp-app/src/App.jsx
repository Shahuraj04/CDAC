import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import { Routes, Route, Navigate } from 'react-router-dom'
import "bootstrap/dist/css/bootstrap.css"
import TitleBar from './components/TitleBar'
import NavBar from './components/NavBar'
import EmployeeTable from './Pages/EmployeeTable'
import LandingPage from './Pages/LandingPage'
import EmpForm from './Pages/EmpForm'
import './App.css'
import EditForm from './Pages/EditForm'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
        <TitleBar />
        <NavBar />
        <Routes>
          <Route path="/" element={<Navigate replace to="/home"></Navigate>}></Route>
          
          <Route path="/home" element={<LandingPage />}></Route>

          <Route path="/emptable" element={<EmployeeTable/>}></Route>

          <Route path='/form' element={<EmpForm/>}></Route>

          <Route path="/edit/:id" element={<EditForm />} />


        </Routes>
      </div>
    </>
  )
}

export default App

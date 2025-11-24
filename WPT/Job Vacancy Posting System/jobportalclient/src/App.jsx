import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
// import './App.css'
import { Routes, Route, Navigate } from 'react-router-dom'
import LoginPage from './Pages/LoginPage'
import EmpTable from './Pages/empTable'
function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <Routes>
      <Route path="/login" element={<LoginPage/>}></Route>
      <Route path="emptable" element={<EmpTable/>}></Route>

    </Routes>
      
    </>
  )
}

export default App

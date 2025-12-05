import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import { Routes,Route } from 'react-router-dom'
import DeliveryDashboard from './pages/DeliveryDashboard'
import DeliveryForm from './pages/DeliveryForm'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Routes>
        <Route path='/deliveries' element={<DeliveryDashboard/>}></Route>
      <Route path='/newdelivery' element={<DeliveryForm/>}></Route>
      </Routes>
    </>
  )
}

export default App

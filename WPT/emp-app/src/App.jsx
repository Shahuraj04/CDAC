import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import { Routes, Route, Navigate } from 'react-router-dom'
import "bootstrap/dist/css/bootstrap.css"
import TitleBar from './components/TitleBar'
import NavBar from './components/NavBar'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      

      <div>
        <TitleBar/>
        <NavBar/>
        <Routes>
          <Route>
            
          </Route>


        </Routes>
        



      </div>
    </>
  )
}

export default App

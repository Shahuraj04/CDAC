import React from 'react'
import { NavLink } from 'react-router-dom'

export default function NavBar() {
  return (
    <div>
        
      <ul className="nav justify-content-center">
        <li className="nav-item">
          <NavLink className="nav-link" to="/emptable">Employee</NavLink>
        </li>
        <li className="nav-item">
          <NavLink className="nav-link" to="/emptable">Employee Names</NavLink>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Performance</a>
        </li>
        <li className="nav-item">
          <a className="nav-link disabled" href="#">Status</a>
        </li>
      </ul>
    </div>
  )
}

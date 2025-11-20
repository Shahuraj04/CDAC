import React from 'react'

export default function NavBar() {
  return (
    <div>
        
      <ul className="nav justify-content-center">
        <li className="nav-item">
          <a className="nav-link active" href="#">Employee Data</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Employee Names</a>
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

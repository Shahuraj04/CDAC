import React from "react";
import icon from "../assets/web-link.png";

export default function EmpTable() {
  return (
    <>
      <nav className="navbar navbar-light bg-light shadow-sm fixed-top px-3">
        <a className="navbar-brand d-flex align-items-center" href="#">
          <img src={icon} width="30" height="30" alt="icon" />
          <span className="ms-2 fw-bold">Employee Table</span>&nbsp;&nbsp;&nbsp;&nbsp;<button >Add Employee</button>
        </a>
      </nav>

      <div style={{ marginTop: "80px" }} className="container">
        <h2></h2>
      </div>
    </>
  );
}

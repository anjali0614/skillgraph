import React from "react";
import { Link } from "react-router-dom";
import "../styles/style.css"; 

function Navbar() {
  return (
    <nav className="navbar">
      <h1>SkillGraph</h1>
      <div className="nav-links">
        <Link to="/">Home</Link>
        <Link to="/login">Login</Link>
        <Link to="/register">Register</Link> 
      </div>
    </nav>
  );
}

export default Navbar;






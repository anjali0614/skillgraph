import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar"; 
import Login from "./pages/Login"; 
import Home from "./pages/Home"; 

function App() {
  return (
    <Router>
      <Navbar />  {/* Navbar component ab title + links dono dikhaayega */}
      <div>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;




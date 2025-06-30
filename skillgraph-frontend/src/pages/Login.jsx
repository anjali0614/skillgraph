import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {
  const [identifier, setIdentifier] = useState("");  
  const [password, setPassword] = useState("");  
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
   if (!identifier || !password) {
      alert("Please fill in both fields.");
      return;
    }

    try {
      const response = await fetch("http://localhost:8080/users/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" }, 
        body: JSON.stringify({ identifier, password }),
      });
      if (response.ok) {
        const message = await response.text();
        alert(message);
        navigate("/dashboard");
      } else {
        const errorText = await response.text();
        setError(errorText || "Invalid username or password");
      }
    } catch (err) {
      console.error("Login error:", err);
      setError("Something went wrong. Try again later.");
    }
  };
  
  
  return (
    <div style={styles.container}>
      <h2>Login</h2>
      <form onSubmit={handleLogin} style={styles.form}>
        <input
          type="text"
          placeholder="Enter your username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          required
          style={styles.input}
        />
        <input
          type="password"
          placeholder="Enter your password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
          style={styles.input}
        />
        <button type="submit" style={styles.button}>
          Login
        </button>
      </form>
    </div>
  );
}

const styles = {
  container: {
    textAlign: "center",
    padding: "40px",
  },
  form: {
    display: "inline-block",
    textAlign: "left",
    padding: "20px",
    backgroundColor: "#f9f9f9",
    borderRadius: "8px",
    boxShadow: "0px 0px 8px rgba(0,0,0,0.1)",
  },
  input: {
    display: "block",
    marginBottom: "15px",
    padding: "8px",
    fontSize: "16px",
    width: "250px",
  },
  button: {
    padding: "10px",
    fontSize: "16px",
    cursor: "pointer",
    borderRadius: "5px",
    border: "none",
    backgroundColor: "#007BFF",
    color: "white",
  },
};

export default Login;

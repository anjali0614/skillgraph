import React, { useState } from "react";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = (e) => {
    e.preventDefault();
    alert(`Logging in with ${username}`);
    // yaha backend call karenge baad me
  };
  
  return (
    <div style={{ textAlign: "center", padding: "40px" }}>
      <h2>Login</h2>
      <form onSubmit={handleLogin}>
        <div style={{ margin: "10px" }}>
          <input
            type="text"
            placeholder="Username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
            style={{ padding: "8px", width: "200px" }}
          />
        </div>
        <div style={{ margin: "10px" }}>
          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
            style={{ padding: "8px", width: "200px" }}
          />
        </div>
        <button type="submit" style={{ padding: "10px 20px" }}>Login</button>
      </form>
    </div>
  );
}

export default Login;

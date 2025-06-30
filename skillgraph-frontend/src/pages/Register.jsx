import React, { useState } from "react";

function Register() {
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [fullName, setFullName] = useState("");
    const [error, setError] = useState(null);
    const [success, setSuccess] = useState(false);

    const handleRegister = async (e) => {
        e.preventDefault();
       console.log("Register Button Clicked!"); 
        if (!username || !email || !password || !fullName) {
            alert("Please fill in all fields.");
            return;
        }

        try {
            const response = await fetch("http://localhost:8080/users/register", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ username, email, password, fullName }),
            });
            if (response.ok) {
                setSuccess(true);
                alert("Registration successful! You can now log in.");
            } else {
                const errorData = await response.text();
                setError(errorData || "Registration failed.");
            }
        } catch (err) {
            console.error("Register error:", err);
            setError("Something went wrong. Try again later.");
        }
    };

    return (
        <div style={styles.container}>
            <h2>Register</h2>
            <form onSubmit={handleRegister} style={styles.form}>
                <input
                    type="text"
                    placeholder="Enter your username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    required
                    style={styles.input}
                />
                <input
                    type="email"
                    placeholder="Enter your email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
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
                <input
                    type="text"
                    placeholder="Enter your full name"
                    value={fullName}
                    onChange={(e) => setFullName(e.target.value)}
                    required
                    style={styles.input}
                />
                <button type="submit" style={styles.button}>
                    Register
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

export default Register;

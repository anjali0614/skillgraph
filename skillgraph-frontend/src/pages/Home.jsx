import React from "react";

function Home() {
  return (
     <div style={styles.container}>
      <h1>Welcome to SkillGraph</h1>
      <p>This is the Home Page of your SkillGraph app!</p>
    </div>
  );
}
const styles = {
  container: {
    textAlign: "center",
    padding: "40px",
  },
};

export default Home;

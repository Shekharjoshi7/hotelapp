import React from "react";
import Rooms from "./Rooms";
import Navbar from "./components/Navbar";
import Login from "./Login"
import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";
import Signup from "./Signup";

function App() {
  return (

    <div className="App">
      <Router>

        <Navbar />
        <Routes>

          <Route path="/Rooms" element={ <Rooms />}/>


          <Route path="/Login" element={<Login/>}/>
          <Route path="/Signup" element={<Signup/>}/>
          <Route path="/" element={<Rooms/>} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;

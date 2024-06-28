import React ,{useState}from "react";
import Rooms from "./Rooms";
import Navbar from "./components/Navbar";
import Login from "./Login"
import {
  BrowserRouter as Router,
  Routes,
  Route
} from "react-router-dom";
import Signup from "./Signup";
import Contact from "./Contact";
import Book from "./Book";
import Room from "./Room";

function App() {
  const [isLogin ,setIsLogin]=useState(false);
  return (

    <div className="App  dark:bg-gray-900">
      <Router>

        <Navbar isLogin={isLogin} />
        <Routes>

          <Route path="/Rooms" element={ <Rooms />}/>
          <Route path="/Room" element={ <Room />}/>

          <Route path="/Book" element={ <Book />}/>
          <Route path="/Login" element={<Login setIsLogin ={setIsLogin} />}/>
          <Route path="/Signup" element={<Signup/>}/>
          <Route path="/" element={<Rooms/>} />
          <Route path="/Contact" element={<Contact/>} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;

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
import Home from "./Home";
import About from "./About";

function App() {
  const [isLogin ,setIsLogin]=useState(false); 
   const [checkInDate, setCheckInDate] = useState('');
  const [checkOutDate, setCheckOutDate] = useState('');
  const [diffDays, setDiffDays] = useState(0);
  return (

    <div className="App  dark:bg-gray-900">
      <Router>

        <Navbar isLogin={isLogin} />
        <Routes>

          <Route path="/Rooms" element={ <Rooms />}/>
          <Route path="/Room" element={ <Room  
          checkInDate={checkInDate} 
          checkOutDate={checkOutDate} 
          setCheckInDate={setCheckInDate}
          setCheckOutDate={setCheckOutDate}  
          diffDays={diffDays}  
          setDiffDays={setDiffDays}  />}/>

          <Route path="/Book" element={ <Book    diffDays={diffDays}checkInDate={checkInDate} checkOutDate={checkOutDate} />}/>
          <Route path="/Login" element={<Login setIsLogin ={setIsLogin} />}/>
          <Route path="/Signup" element={<Signup/>}/>
          <Route path="/" element={<Home/>} />
          <Route path="/About" element={<About/>} />
          <Route path="/Contact" element={<Contact/>} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;

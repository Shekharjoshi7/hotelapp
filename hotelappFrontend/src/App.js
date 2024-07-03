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
  const [customerId ,setCustomerId]=useState(); 
   const [checkInDate, setCheckInDate] = useState('');
  const [checkOutDate, setCheckOutDate] = useState('');
  const [diffDays, setDiffDays] = useState(1);
  return (

    <div className="App  dark:bg-gray-900">
      <Router>

        <Navbar isLogin={isLogin}  />
        <Routes>

          <Route path="/Rooms" element={ <Rooms />}/>
          <Route path="/Room/:id" element={ <Room  
          checkInDate={checkInDate} 
          checkOutDate={checkOutDate} 
          setCheckInDate={setCheckInDate}
          setCheckOutDate={setCheckOutDate}  
          diffDays={diffDays}  
          setDiffDays={setDiffDays}
          isLogin={isLogin}
          customerId={customerId}  />}/>

          <Route path="/Book/:id" element={ <Book    diffDays={diffDays}checkInDate={checkInDate} checkOutDate={checkOutDate} />}/>
          <Route path="/Login" element={<Login setIsLogin ={setIsLogin} setCustomerId={setCustomerId} />}/>
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

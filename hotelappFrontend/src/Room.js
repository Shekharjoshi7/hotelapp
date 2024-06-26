import React,{useState,useEffect} from 'react'
import {Link } from "react-router-dom";
const Room = () => {
    const [product, setProduct] = useState([]);
    let day =5;
    useEffect(() => {
        const fetchRooms = async () => {
                const response = await fetch("http://localhost:8080/getSingleRoom/101");
                const data = await response.json();
                setProduct(data);
        };

        fetchRooms();

    }, []);
  return (
    <div>
      <section className="text-gray-600 body-font overflow-hidden h-screen">
        <div className="container px-5 py-16 mx-auto">
          <div className="lg:w-4/5 mx-auto flex flex-wrap">
            <img alt="ecommerce" className="lg:w-1/2 w-full lg:h-auto px-14 object-cover object-top rounded" src="https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg" />
            <div className="lg:w-1/2 w-full lg:pl-10 lg:py-6 mt-6 lg:mt-0">
              <h2 className="text-sm title-font text-gray-500 tracking-widest">HotelApp</h2>
              <h1 className="text-gray-100 text-3xl title-font font-medium my-2">{product.roomType}</h1>
              <p className="leading-relaxed mt-6">Lorem ipsum dolor sit amet consectetur adipisicing elit. Officiis, incidunt autem nisi impedit facere voluptas eveniet officia earum, harum atque corrupti accusamus dolorum accusantium laudantium, quibusdam consequatur omnis sapiente neque ducimus consectetur eum natus laboriosam fuga cumque? Facere odit, quaerat rerum quidem accusantium rem aperiam vel sapiente? Atque unde amet nesciunt natus, sapiente libero asperiores, repellat inventore dolor, recusandae odio.</p>
              <div className="flex my-7">
                <span className="title-font font-medium text-2xl text-gray-100">₹{product.price}</span>
                <Link to="/Book" className='ml-auto'>
                 <button className="flex  text-white bg-cyan-600 border-0 py-2 px-2 md:px-6 focus:outline-none hover:bg-cyan-700 rounded">Booking</button>
                </Link>
 
              </div>
            </div>
          </div>
        </div>
      </section>   </div>
  )
}

export default Room

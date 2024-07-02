import React,{useState,useEffect} from 'react'

const Book = ({ diffDays ,checkInDate ,checkOutDate}) => {
    const [products, setProducts] = useState([]);
    useEffect(() => {
        const fetchRooms = async () => {
                const response = await fetch("http://localhost:8080/getSingleRoom/101");
                const data = await response.json();
                setProducts(data);
        };

        fetchRooms();

    }, []);
 
  return (
    <section className="text-gray-600 body-font overflow-hidden h-screen">
    <div className="container px-5 py-24 mx-auto">
     <div className="lg:w-4/5 mx-auto flex flex-wrap">

        <div className="lg:w-1/2 w-full lg:pr-10 lg:py-6 mb-6 lg:mb-0">
          <h2 className="text-sm title-font text-gray-500 tracking-widest">{products.roomType}</h2>
          <p className="leading-relaxed mb-4">Your room has been successfully booked</p>
          <div className="flex mb-4">
            <p className="flex-grow text-center py-2 text-lg px-1">Check in time</p>
            <p className="flex-grow  text-center py-2 text-lg px-1">Check out time</p>
          </div>
          <div className="flex justify-around border-t border-gray-200 py-2">
            <span className="text-gray-500">{checkInDate}</span>
            <span className=" text-gray-500">{checkOutDate}</span>
          </div>
    
          <div className="flex flex-col">
            <span className="title-font font-medium text-2xl text-gray-500"><span className='text-gray-300 font-semibold'>Total Price : </span>₹{products.price* diffDays}</span>
          </div>
        </div>
        <img alt="ecommerce" className="lg:w-1/2 w-full lg:h-auto h-64 object-cover object-center rounded" src="https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg"/>
      </div>
    </div>
  </section>
  )
}

export default Book

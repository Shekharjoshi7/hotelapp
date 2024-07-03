import React, { useEffect, useState } from 'react';
import {Link } from "react-router-dom";


const Rooms = () => {
    const [products, setProducts] = useState([]);
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        const fetchRooms = async () => {
            setIsLoading(true);
            try {
                const response = await fetch("http://localhost:8080/getAllRooms");
                if (!response.ok) {
                    throw new Error('Network response was not ok.');
                }
                const data = await response.json();
                setProducts(data);
            } catch (error) {
                console.error('Error fetching data:', error);
            } finally {
                setIsLoading(false);
            }
        };

        fetchRooms();

    }, []);

    return (
        <div>
            {isLoading ? (
                <div className="text-center">Loading...</div>
            ) : (
                <section className="text-gray-600 body-font h-screen ">
                    <div className="container px-5 py-24 mx-auto">
                        <div className="flex flex-wrap -m-4 justify-center">
                            {products.length === 0 && <div className='my-4 font-semibold'>We are adding Rooms soon.</div>}
                            {products.map((item, index) => (
                                <div key={index} className="lg:w-1/5 md:w-1/2 p-4 w-full shadow-lg m-7  bg-gray-100 dark:bg-gray-800 dark:border-gray-700">
                                    <Link className="block relative rounded overflow-hidden" to={`/Room/${item.roomId}`} passhref="true">
                                        <div className='flex justify-center'>
                                            <img alt="Rooms img" className="m-auto md:mx-0 h-[25vh] md:h-[30vh] block" src="https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg" />
                                        </div>
                                        <div className="mt-4 text-center md:text-left">
                                            <h2 className="text-gray-900 dark:text-gray-50 title-font text-lg font-medium">{item.roomType}</h2>
                                            <p className="mt-1 dark:text-white">₹{item.price}</p>
                                        </div>
                                    </Link>
                                </div>
                            ))}
                        </div>
                    </div>
                </section>
            )}
        </div>
    );
};

export default Rooms;

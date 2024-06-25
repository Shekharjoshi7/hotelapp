import React, { useEffect, useState } from 'react';

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

    console.log(products)
    return (
        <div>
            {isLoading ? (
                <div className="text-center">Loading...</div>
            ) : (
                <section className="text-gray-600 body-font">
                    <div className="container px-5 py-24 mx-auto">
                        <div className="flex flex-wrap -m-4 justify-center">
                            {products.length === 0 && <div className='my-4 font-semibold'>We are adding Rooms soon.</div>}
                            {products.map((item, index) => (
                                <div key={index} className="lg:w-1/5 md:w-1/2 p-4 w-full shadow-lg m-7">
                                    <a className="block relative rounded overflow-hidden" href={`/product/${item.roomId}`} passHref={true}>
                                        <div className='flex justify-center'>
                                            <img alt="Rooms img" className="m-auto md:mx-0 h-[25vh] md:h-[30vh] block" src="https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg" />
                                        </div>
                                        <div className="mt-4 text-center md:text-left">
                                            <h2 className="text-gray-900 title-font text-lg font-medium">{item.roomType}</h2>
                                            <p className="mt-1">₹{item.price}</p>
                                        </div>
                                    </a>
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

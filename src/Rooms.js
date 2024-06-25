
import React from 'react'


const Rooms =() => {
    const products=[
        {
          roomid: '1',
          roomtype: 'SingleRoom',
          price:'2999'
     
        }];
  return (
        <div>
            <section className="text-gray-600 body-font">
                <div className="container px-5 py-24 mx-auto">
                    <div className="flex flex-wrap -m-4 justify-center">
                    { products.length===0 && <div className='my-4 font-semibold'>We are adding Rooms soon.</div>}
                        {products.map((item, index) => {
                            return (
                                <div key={index} className="lg:w-1/5 md:w-1/2 p-4 w-full shadow-lg m-7">
                                    <a className="block relative rounded overflow-hidden" passHref={true} href={`/product/${item.roomid}`}>
                                    <div className='flex justify-center'>
                                        <img alt="Rooms img" className="m-auto  md:mx-0 h-[25vh] md:h-[30vh] block" src="https://static01.nyt.com/images/2019/03/24/travel/24trending-shophotels1/24trending-shophotels1-superJumbo.jpg" />
                                        </div>
                                        <div className="mt-4 text-center md:text-left">
                                            {/* <h3 className="text-gray-500 text-xs tracking-widest title-font mb-1">{item.roomid}</h3> */}
                                            <h2 className="text-gray-900 title-font text-lg font-medium">{item.roomtype}</h2>
                                            <p className="mt-1">₹{item.price}</p>
                                        </div>
                                    </a>
                                 </div>
                            )
                        })}
                    </div>
                </div>
            </section>

        </div>
    )
}



export default Rooms;
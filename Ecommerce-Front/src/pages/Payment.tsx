import { useContext, useEffect, useState } from "react";
import { Footer } from "../components/footer/footer";
import Header from "../components/header/header";
import { CartContext } from "../context/cartContext";
import { AxiosPromise } from "axios";

export function Payment(){
    const { updateOrder } = useContext(CartContext)

    const [ pix, setPix ] = useState<any>(null);
    
    useEffect(() => {
        const fetchData = async () : AxiosPromise => {
            const response = await updateOrder();
            setPix(response.data)
            return response.data;
        }
        fetchData();
        
    }, []);
    return (
        <>
        <Header></Header>
        <section id="section-principal">
            <h1>Pix : </h1>
            <img src={pix?.QRCode}></img>
            <p>{pix?.valor.original}</p>
            <p>{pix?.Chave}</p>
        </section>
        <Footer></Footer>
        </>
    );
}
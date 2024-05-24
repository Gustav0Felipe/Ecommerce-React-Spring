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
            <div className="pagamento">
            <h1>Pix : </h1>
            <img src={pix?.QRCode}></img>
            <p>Preço: {pix?.valor.original}</p>
            <p>Chave: {pix?.Chave}</p>
            </div>
        </section>
        <Footer></Footer>
        </>
    );
}
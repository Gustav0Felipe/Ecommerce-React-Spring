import { useContext, useEffect, useState } from "react";
import { Footer } from "../components/footer/footer";
import Header from "../components/header/header";
import { CartContext } from "../context/cartContext";
import { AxiosPromise } from "axios";
import { UserContext } from "../context/userContext";
import { Navigate } from "react-router-dom";

export function Payment(){
    const { updateOrder } = useContext(CartContext)
    const { user } = useContext(UserContext);
    const [ pix, setPix ] = useState<any>(null);
    const [ emptyCart, setEmptyCartHandle ] = useState<any>(false);

    useEffect(() => {
        const fetchData = async () => {
            const response = await updateOrder();
            if(!response){
                setEmptyCartHandle(true);
            }else{
                setPix(response.data)
                return response.data;
            }
        }
        fetchData();
        
    }, []);

    const copyButton = (valor : string)=> {
        navigator.clipboard.writeText(valor);
      };
    return (
        <>
        {(user == null || !user.id_cliente) && <Navigate to="/loja/login"></Navigate>}
        {emptyCart && <Navigate to="/loja/cart"></Navigate>}
        <Header></Header>
        <section id="section-principal">
            <div className="pagamento">
            <h1>Pix : </h1>
            <img src={pix?.QRCode}></img>
            <ol>
            <li>
                <p>Preço: {pix?.valor.original}</p>
            </li>
            <li>   
                <p>Chave: {pix?.Chave}</p> 
                <button onClick={() => {copyButton(pix?.Chave)}} id="copiar" className="material-symbols-outlined">
                    content_copy
                </button>
            </li>
            </ol>
            </div>
        </section>
        <Footer></Footer>
        </>
    );
}
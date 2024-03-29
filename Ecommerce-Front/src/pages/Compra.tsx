import { useContext, useEffect, useState } from "react";
import { Footer } from "../components/footer/footer";
import Header from "../components/header/header"
import { ProductData } from "../interface/ProductData";
import { Link, useParams } from "react-router-dom";
import { CartContext } from "../context/cartContext";
import axios, { AxiosPromise } from "axios";

const API_URL = 'http://localhost:8080';

function Compra(){
    var { id } = useParams();

    const [openDesc, setOpenDesc] = useState(false);
    const [ produto, setProduto ] = useState<any>(null);
    const { addToCart } = useContext(CartContext);

    const handleOpenDesc = () =>{
        setOpenDesc(prev => !prev);
    }

    useEffect(() => {
        const fetchData = async () : AxiosPromise<ProductData> => {
            const response = await axios.get(API_URL + "/loja/produto?id=" + id)
            setProduto(response.data);
            return response;
        }
        fetchData();
      }, []);
   
    return(
        <>
    <Header></Header>
    <section id="section-principal">
    <div id="comprar">
        <div id="detalhes">
            <img src={produto?.image} alt="Produto"/>	
            <p id="preco">Preço: {produto?.val_prod}</p>
            <Link to="/loja/cart" id="comprar" onClick={() => addToCart(produto)}><span className="material-symbols-outlined" >shopping_cart</span> Comprar</Link>
        </div>
        <ol id="descricao_bar" onClick={handleOpenDesc}>
            <li>Descrição do produto</li>
            <li id="dropdown" className="material-symbols-outlined">expand_more</li>
        </ol>
        {openDesc && <div id="descricao">{produto?.desc_prod}</div>}
    </div>
    </section>
    <Footer></Footer>
    </>
    )
}
export default Compra;


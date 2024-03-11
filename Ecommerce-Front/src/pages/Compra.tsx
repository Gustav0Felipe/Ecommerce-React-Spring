import { useContext, useState } from "react";
import { Footer } from "../components/footer/footer";
import Header from "../components/header/header"
import { ProductData } from "../interface/ProductData";
import { Link, useParams } from "react-router-dom";
import { CartContext } from "../context/cartContext";
import { useProductData } from "../hooks/useProductData";

function Compra(){
    const { data } = useProductData(); 
    var { id } = useParams();

    const [openDesc, setOpenDesc] = useState(false);
    const { addToCart } = useContext(CartContext);

    const handleOpenDesc = () =>{
        setOpenDesc(prev => !prev);
    }

    var produto : ProductData | null = null;
    if(data != undefined && id != undefined){
        var itemIndex = Number.parseInt(id) - 1;
        produto = data[itemIndex];
    }
    console.log(produto);
    return(
        <>
    <Header></Header>
    <div id="comprar">
        <div id="detalhes">
            <img src="imagens/${produto.getId()}.png" alt="Produto"/>	
        <p id="preco">Preço: {produto?.val_prod}</p>
            <Link to="/loja/cart" id="comprar" onClick={() => addToCart(produto)}><span className="material-symbols-outlined" >shopping_cart</span> Comprar</Link>
        </div>
        <ol id="descricao_bar" onClick={handleOpenDesc}>
            <li>Descrição do produto</li>
            <li id="dropdown" className="material-symbols-outlined">expand_more</li>
        </ol>
        
        {openDesc && <div id="descricao">{produto?.desc_prod}</div>}
        
    </div>
    <Footer></Footer>
    </>
    );
}
export default Compra;


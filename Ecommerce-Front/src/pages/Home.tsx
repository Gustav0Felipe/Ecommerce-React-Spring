import { Key } from "react";
import { Catalog } from "../components/catalog/catalog";
import { Footer } from "../components/footer/footer";
import Header from "../components/header/header"
import { Link } from "react-router-dom";
import { useProductData } from "../hooks/useProductData";

function Home(){
    const { data } = useProductData(); 

    return(
    <>
 
    <Header></Header>
    <section id="section-principal">
        {
        //<h1>Produtos do dia</h1>
        }
        <ol className="produtos">  
        {
            
        data?.map((productData: { id_prod: Key | null | undefined; nome_prod: string; image: string; val_prod: number; }) => 
        <li className="produto" key={productData.id_prod }> 
            <Catalog
            nome={productData.nome_prod} 
            image={productData.image}  
            val_prod={productData.val_prod}/>
            <Link to={"/comprar" + "/" + productData.id_prod } >Aqui</Link>
        </li>
            )
        } 
        </ol>
      </section>
      <Footer></Footer>
      
    </>
    )
}

export default Home;
